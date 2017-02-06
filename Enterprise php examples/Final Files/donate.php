<?php
session_start();
?><!doctype html>
<html lang="en">
<head>
	<title>Donate Book Page</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
    <body class="body">
        <?php 
        //echo 'msg1';
            //parse the query
            if($_POST) {
                
				echo '<p>You submitted: '.$_POST['title'].'</p>';
				//bring in the connection code from an external file:
				include('connstring.php');
				
				$query = 'INSERT INTO TEMP_BOOKS
					(ISBN,Authors,Edition,Description, Genre, Publicate_Date, Number_Pages, Title, AUTHOR1_FNAME, QOH, BOOK_STATUS, MEM_ID, APPROV)
					VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1, 1, 1, 0)';
				$stmt = $conn->prepare($query);
				$stmt->bindParam(1, $_POST['isbn']);
				$stmt->bindParam(2, $_POST['authors']);
				$stmt->bindParam(3, $_POST['edition']);
				$stmt->bindParam(4, $_POST['description']);
				$stmt->bindParam(5, $_POST['genre']);
				$stmt->bindParam(6, $_POST['publicatedate']);
				$stmt->bindParam(7, $_POST['numberpages']);
				$stmt->bindParam(8, $_POST['title']);
				$stmt->bindParam(9, $_POST['author1fname']);

				try{
				//run the query
				$stmt->execute();
				} catch (Exception $e){
					die('query execution error');
				}
				//redirects user to whatever page
				//header('Location:donate.php'); 
			}
        ?>

	<?php include('header.php'); ?>

		<div class="content">
			<article class="infocontent">
				<header class="title">
					<h2>Donate Books Here</h2>
                </header>
				<content>
				<p>Please be aware that your membership must be approved by an administrator and is contingent upon you donating a minimum of 20 books to the exchange. Once you have finished the sign up sheet, you may enter the information of the books you wish to donate on the donate page. There is no limit to how many books you may donate and all books are accepted provided they are P or PG in content.  Once you have finished submitting the book information, you may send the books to:</p>
	
	<p><b>Pittsburgh Technical College<br>
	℅ Mr. Roger Van Scoy<br>
	1111 McKee Rd.<br>
	Oakdale, PA 15071</b></p>

<p>Or you may drop of the books in person to Mr. VanScoy at the above address. Once you have donated 20 books and your membership has been approved, then you may check out a total of 5 books at a time for as long as you wish. Each additional donation of 5 books makes you eligible to check out 1 additional book. (For example, if you donate 25 books, you can check out a total of 6 books at a time.) Please be aware though, if you do not return a book to the exchange after a year, and we have had no contact from you, you will be banned.</p>

<p>If you have any questions you can contact us at:</p>

	<p>(412) 809-5100</p> 
	<p>vanscoy@ptcollege.edu</p>
</p>
				</content>
			</article>
			<article class="topcontent">
				<header class="title">
					<h2>Donate Book</h2>
				</header>
				<footer>
					<p class="post-info">Enter book information.</p>
				</footer>
				<content>
					<div name="row-container">
						<form action="donate.php" method="post">
							<p>
							<label for="Title">Book Title:</label>
								<input type="text" name="title" id="title-id"/>
							
							
							
							<label for="ISBN">Book ISBN (Near barcode):</label>
								<input type="text" name="isbn" id="isb-id"/>
							
							
							
							<label for="Genre">Genre:</label>
								<select name="genre" id="genre-id" >
									<option value="Textbook">Textbook</option>
									<option value="Historical Ficiton">Historical Ficiton</option>
									<option value="Young Adult">Young Adult</option>
									<option value="Science Fiction">Science Fiction</option>
									<option value="Childrens">Childrens</option>
									<option value="Fiction">Fiction</option>
									<option value="Mystery">Mystery</option>
									<option value="NonFiction">NonFiction</option>
									<option value="Fantasy">Fantasy</option>
									<option value="Comic/Manga">Comic/Manga</option>
								</select>
							</p>
							
							<p>
							<label for="AUTHOR1_FNAME">Author First name:</label>
								<input type="text" name="author1fname" id="author1fname-id"/>
							
							
							
							<label for="AUTHORS">Author Last name:</label>
								<input type="text" name="authors" id="authors-id"/>
							</p>
							
							<p>
							<label for="Edition">Edition:</label>
								<input type="text" name="edition" id="edition-id"/>
							
							
							
							<label for="PUB_DATE">Publishing date:</label>
								<input type="date" name="publicatedate" id="publicatedate-id"/>
							
						
							
							<label for="Num_Pages">Number of pages:</label>
								<input type="text" name="numberpages" id="numberpages-id"/>
							</p>
							
							<p>
							<label for="Description">Description:</label>
								<input type="text" name="description" class="mydescription" id="description-id"/>
							</p>

							<p align="center"><button type="submit">Add book</button></p>
						</form>
					</div>
				</content>
			</article>
		</div>      
	<?php include('footer.php'); ?>
    </body>
</html>