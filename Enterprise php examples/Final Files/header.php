<?php
    if(isset($_GET['log'])) {
        session_destroy();
        header('Location:index.php');
    }
?> 
<header class="mainHeader">
		<img src="img/header.jpg" alt="header">
		
		<nav><ul>
			<li><a href="index.php">Home</a></li>
			<li><a href="books.php">Books</a></li> 
            <?php
                if($_SESSION['logged'] == false) {
                    echo '<li><a href="signin.php">Login/Sign Up</a></li>';
                }?>
            <?php
                if($_SESSION['logged'] == true) {
                    echo '<li><a href="index.php?log=out">Logout</a></li>';
                }?>
            <?php
                if($_SESSION['logged'] == true) {
                    echo '<li><a href="profile.php">Profile</a></li>';
                }?>
            <?php
                if($_SESSION['priv'] == 1){
                    echo '<li><a href="admin.php">Admin</a></li>';
                }?>
		</ul></nav>
	</header>