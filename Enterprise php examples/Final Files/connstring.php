<?php 
	/**
	* Connections are established by creating instances of the PDO base class
	* It doesn't matter which DB driver you want to use; you always use the PDO class name.
	* NOTE: to close the connection, simply set it to null
	*
	* Param 1) the DB source (known as the DSN)- type of DB; name of DB
	* Param 2) login name
	* Param 3) password
	*/
	//echo 'before connstring...'; 
	//connect to server and DB with username and password

	try {
		//WORKING MS SQL Server connection
		//$conn = new PDO('dblib:host=STUSQL;dbname=DBNAMEHERE', 'ssd751', 'ssd751');

		//WORKING MySQL connection
		$conn = new PDO('mysql:host=localhost;dbname=kmg22;port=3306;', 'kmg22', 'XBJaEu2j');
	} catch (PDOException $pdoe){echo 'msg3';
		echo $pdoe;
		die('no connection');   
	} catch (Exception $e) {
		echo 'Caught exception: ',  $e->getMessage(), "\n";
		die('connection error'); 
	}
	//echo ' After try catch on connection';
?>