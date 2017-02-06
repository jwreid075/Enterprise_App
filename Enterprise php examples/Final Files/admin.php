<?php
session_start();
?><!doctype html>
<html lang="en">
<head>
	<title>Administrator</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
    <body class="body">
     <?php 
        //echo 'msg1';
            //bring in the connection code from an external file:
            include('connstring.php');

            /*begin PREPARE QUERY CLAUSES */
            $chosenCOLUMN = '';
            if(isset($_GET['sort_col'])){
                $chosenCOLUMN = ' ORDER BY '.$_GET['sort_col'];
            }
            /*end PREPARE QUERY CLAUSES */

            //parse the query
            try {
				$query = "SELECT * FROM TEMP_BOOKS".$orderClause;
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
	
    <p><form action""><input type="radio"  name="box" value="Books">Books&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="box" value="Members">Members</form>
    
	<?php
		if ($selected_radio == "Books" && $selected_radio == "box") {
			while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
				echo '<article class="topcontent"><h2>'.$row['Title'].'</h2>';
				echo '<h4>'.$row['AUTHOR1_FNAME'].'&nbsp;'.$row['Authors'].'</h4>';
				echo '<p><b>ISBN:</b> '.$row['ISBN'].'</p><p><b>Edition:</b> '.$row['Edition'].'</p><p><b>Genre:</b> '.$row['Genre'].'</p></article>';
			}
		}
		if ($selected_radio == "Members" && $selected_radio == "box") {
			try {
				$query = "SELECT MEM_ID, MEM_FNAME, MEM_LNAME FROM MEMBERS";
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
		}
		?>
		 
           
	<?php include('footer.php'); ?>
    </body>
</html>