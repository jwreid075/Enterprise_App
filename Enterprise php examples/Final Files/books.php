<?php
session_start();
?><!doctype html>
<html lang="en">
<head>
<title>The Great Book Exchange</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body class="body">
<?php 
//echo 'msg1';
    //bring in the connection code from an external file:
    include('connstring.php');
    
    /* PREPARE QUERY */
     $likeclause = "";              
    if(isset($_POST['submit'])){
        if(isset($_GET['go'])){
            $title=$_POST['title'];
                $likeclause = " AND (Title LIKE \"%$title%\" OR Authors LIKE \"%$title%\" OR AUTHOR1_FNAME LIKE \"%$title%\" OR AUTHOR2_LNAME LIKE \"%$title%\" OR AUTHOR2_FNAME LIKE \"%$title%\")";                
        }
    }
                
    /*end PREPARE QUERY CLAUSES */
    //parse the query
    try {
        $query = "SELECT * from TEMP_BOOKS WHERE BOOK_STATUS = 1".$likeclause;
        $stmt = $conn->prepare($query);
    } catch (Exception $e) {
        echo 'Caught exception: ',  $e->getMessage(), "\n";
        die('query prepare error'); 
						}

    //execute the query												
    try {
        $stmt->execute();
    } catch (Exception $e) {
        echo 'Caught exception: ',  $e->getMessage(), "\n";
        die('query execute error'); 
    }

?>

<?php include('header.php'); ?>
    
    <div class="mainContent">
		<div class="content">
			<article class="topcontent">
				<header class="title">
					<h2>Search Books</h2>
				</header>
				<footer>
					<p class="post-info">You may search books by title or author here</p>
				</footer>
				<content>
					<form  method="post" action="books.php?go"  id="searchform"> 
	                   <input  type="text" name="title" class="mytext"> 
	                   <input  type="submit" name="submit" value="Search"> 
	               </form>
				</content>
			</article>
            <article class="bottomcontent">
				<header class="title">
					<h2>Available Books</h2>
				</header>
				<content>
				    <div class="row-container">
                        <?php while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
                            echo '<div class="gridcell"><a href=details.php?id='.$row['ISBN'].'><img src=img/cover.jpg></a>';
                            echo '<h3><a href=details.php?id='.$row['ISBN'].'>'.$row['Title'].'</a></h3>';
							echo '<h5>'.$row['AUTHOR1_FNAME'].'&nbsp;'.$row['Authors'].'</h5></div>';
                        }?>
                    </div>
				</content>
			</article>
		</div>
	</div>
    <?php include('footer.php'); ?>
</body>

</html>