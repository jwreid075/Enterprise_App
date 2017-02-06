<?php
session_start();

include('connstring.php');

if(isset($_POST['email'])) {
	try {
		$query = "SELECT * FROM MEMBERS WHERE MEM_EMAIL = '".$_POST['email']."' AND MEM_PASSWORD = '".$_POST['password']."'";
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
	if ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		//storing any session variables we choose to create:
		$_SESSION['logged'] = true;
		$_SESSION['priv'] = $row['IS_ADMIN']; //pull this in from SELECTED rows
        $_SESSION['name'] = $row['MEM_FNAME'].'&nbsp;'.$row['MEM_LNAME'];
        $_SESSION['email'] = $row['MEM_EMAIL'];
        $_SESSION['phone'] = $row['MEM_PHONE'];
        $_SESSION['address'] = $row['MEM_ADDRESS'].'&nbsp;'.$row['MEM_CITY'].', '.$row['MEM_STATE'].'&nbsp;'.$row['MEM_ZIPCODE'];
        $_SESSION['id'] = $row['MEM_ID'];
        
        header('Location:profile.php');
	}
}
?>
<html lang="en">
<head>
	<title>SignIn/SignUp</title>
	<meta charset="utf-8" />

	<link rel="stylesheet" href="style.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="body">
	
	<?php	
	if(isset($_POST['newemail'])) {
		$query = 'INSERT INTO MEMBERS (MEM_LNAME, MEM_FNAME, MEM_EMAIL, MEM_PASSWORD, MEM_PHONE, MEM_ADDRESS, MEM_CITY, MEM_STATE, MEM_ZIPCODE)
		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)';
		$stmt = $conn->prepare($query);
		$stmt->bindParam(1, $_POST['newlastname']);
		$stmt->bindParam(2, $_POST['newfirstname']);
		$stmt->bindParam(3, $_POST['newemail']);
		$stmt->bindParam(4, $_POST['newpassword']);
		$stmt->bindParam(5, $_POST['newphone']);
		$stmt->bindParam(6, $_POST['newaddress']);
		$stmt->bindParam(7, $_POST['newcity']);
		$stmt->bindParam(8, $_POST['State']);
		$stmt->bindParam(9, $_POST['newzipcode']);
		try{
			//run the query
			$stmt->execute();
			} catch (Exception $e){
			die('query execution error');
			}
	}	
	?>

	<?php include ("header.php");?>
	<div class="mainContent">
		<div class="content">
			<article class="topcontent">
				<header class="title">
					<h1>Member Login</h1>
				</header>
				<content>
                <form action="signin.php" method="post">
					<p><label for="Email">Email:</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label for="Password">Password:</label>
					</p>
					<input name="email" id="Email" type="text" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="password" id="Password" type="password" />
					<a href="profile.php"><input type="submit" value="Login"></a>
				</p>
				</form>
                </content>
			</article>
			<article class="bottomcontent">
				<header>
					<h2>Not a Member? Sign up here!</h2>
				</header>
				<content>
				 <form action="signin.php" method="post">
					<input type="text" name="newfirstname" placeholder="First name"/>
					<input type="text" name="newlastname" placeholder="Last name"/>
					<p>
					<input type="text" name="newphone" placeholder="Phone Number"/>
                    <p>
                    <input type="text" name="newaddress" placeholder="Address"/>
					<input type="type" name="newcity" placeholder="City"/>
                    <select id="State" name="State">
						<option value="none" disabled selected>Select a State</option>
						<option value="PA">PA</option>
						<option value="OH">OH</option>
						<option value="WV">WV</option>
					</select>
                    
					<input type="text" name="newzipcode" placeholder="Zipcode"/>
					</p>
					<input type="text" name="newemail" id="email_id" placeholder="Email"/>
					<p>
					<input type="password" name="newpassword" placeholder="New Password"/>
					</p>
					<p>Please be aware that by signing up you are only creating a profile. 
					<p>To become a member you must donate 20 books and be approved by the Administrator. 
					<p>After pressing the sign up button, you will be taken to your profile page. 
					<p>You can enter the information of the books you wish to donate there. 
					<p>
					<a href="profile.php"><input type="submit" value="Sign-Up"></a>
				</form>
			</content>
			</article>
		</div>
	</div>
	<?php include("footer.php"); ?>
</body>

</html>	