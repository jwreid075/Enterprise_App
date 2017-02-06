<?php
session_start()
?>
<!doctype html>
<html lang="en">
<head>
<title>The PTC Book Exchange</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body class="body">
	<?php include('connstring.php');
	include("header.php"); ?>
	<p>
<div class="mainContent">
	<div class="content">
		<article class="topcontent">
			<content>
				<p><a href="donate.php"><input type="button" value="Go To Donate"/></a>
				<?php if($_SESSION['logged']== true)
				{
						echo '<p><b>Member Name:</b> '.$_SESSION['name'].'</p>';
                        echo '<p><b>Member Phone:</b> '.$_SESSION['phone'].'</p>';
                        echo '<p><b>Member Address:</b> '.$_SESSION['address'].'</p>';
                        echo '<p><b>Member Email:</b> '.$_SESSION['email'].'</p>';
                        try {
					       $query = "SELECT Title, Authors, AUTHOR1_FNAME FROM TEMP_BOOKS JOIN MEMBERS ON TEMP_BOOKS.MEM_ID = MEMBERS.MEM_ID WHERE MEMBERS.MEM_ID = ".$_SESSION['id'];
                            echo $query;
					       $stmt = $conn->prepare($query);
				        } 
				        catch (Exception $e) {
					       echo 'Caught exception: ',  $e->getMessage(), "\n";
					       die('query prepare error'); 
				        }
                        try {
					       $stmt->execute();
				        }
				        catch (Exception $e){
					       echo 'Caught exception: ',  
                           $e->getMessage(), "\n";
					       die('query execute error'); 
				        }
                        echo '<p><b>Donated Books:</b></p>';
                        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){                
                            echo '<p>'.$row['Title'].' by '.$row['AUTHOR1_FNAME'].'&nbsp;'.$row['Authors'].'</p>';
                        }
				}?>
			</content>
		</article>
	</div>
</div>

<?php include("footer.php"); ?>
</body>
</html>