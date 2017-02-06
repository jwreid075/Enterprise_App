<?php
session_start();
?><!doctype html>
<html lang="en">
<head>
	<title>Selected Book Details</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
    <body class="body">
        <?php 
        //echo 'msg1';
            //bring in the connection code from an external file:
            include('connstring.php');
           
            $chosenISBN = '0130571610';
                if(isset($_GET['id'])){
                    $chosenISBN = $_GET['id'];
                }

            if(isset($_POST['submit'])){
                try {
                    $query = "UPDATE TEMP_BOOKS SET BOOK_STATUS = 2 WHERE ISBN = '".$chosenISBN."'";
                    $stmt = $conn->prepare($query);
                } 
                catch (Exception $e) {
                    echo 'Caught exception: ',  $e->getMessage(), "\n";
                    die('query prepare error'); 
                }
                //execute the query
                try {
                    $stmt->execute();
                }
                catch (Exception $e)
                {
                    echo 'Caught exception: ',  $e->getMessage(), "\n";
                    die('query execute error'); 
                }
                header('Location:books.php');
            }

            //parse the query
            try {
				$query = "SELECT * FROM TEMP_BOOKS WHERE ISBN = '".$chosenISBN."'";
				$stmt = $conn->prepare($query);
            } 
            catch (Exception $e) {
				echo 'Caught exception: ',  $e->getMessage(), "\n";
				die('query prepare error'); 
            }
            //execute the query
            try {
				$stmt->execute();
            }
            catch (Exception $e)
            {
				echo 'Caught exception: ',  $e->getMessage(), "\n";
				die('query execute error'); 
            }
        ?>
        
	<?php include('header.php'); ?>
		<?php
			while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
				echo '<article class="topcontent"><center name="center"><h2>'.$row['Title'].'</h2>';
				echo '<h4>'.$row['AUTHOR1_FNAME'].'&nbsp;'.$row['Authors'].'</h4>';
				echo '<img src="img/cover.jpg"></center></article>';
				echo ' <article class="bottomcontent"><p><b>ISBN:</b> '.$row['ISBN'].'</p><p><b>Edition:</b> '.$row['Edition'].'</p><p><b>Number of Pages:</b> '.$row['Number_Pages'].'</p><p><b>Genre:</b> '.$row['Genre'].'</p>';
				echo '<p><b>Description:</b> '.$row['Description'].'</p>';
			}
		?>
        <?php if($_SESSION['logged'] == true && $_SESSION['priv'] == 1) {?>
            <form method="post" action="details.php">
                <p><button type="submit">Check Out</button></p>
            </form></article>
        <?php }?>
	<?php include('footer.php'); ?>
        
    </body>
</html>