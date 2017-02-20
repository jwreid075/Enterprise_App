<?php    
echo "<p>Howdy</p>";
echo "Howdy";

//variables are not strongly typed
$userName = 'Jeremiah';
$var2 = 69;
$var3 = true;

?><!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>

<h1>This is a Heading</h1>
<p>This is a paragraph.</p>
<p>His name is <?php echo $userName; ?>, guys!</p>
<?php    
	echo '<p>His name is $userName, guys!</p>';
	echo '<p>His name is '.$userName.', guys!</p>';
	echo "<p>Member ID $var2 has the name of $userName, guys!</p>";
	//Same statement, but broken down with for each line
	echo '<p>';
	echo 'His name is';
	echo $userName;
	echo ', guys!';
	echo '</p>';
?>

</body>
</html>
