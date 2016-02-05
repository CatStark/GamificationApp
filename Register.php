<?php
    $con=mysqli_connect("mysql.hostinger.in","u640683613_nisha","sunny6121986","u640683613_data");
    
    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];
	$knowlanguage = $_POST["knowlanguage"];
	$wantlanguage = $_POST["wantlanguage"];
	$interests = $_POST["interests"];
	
    
    $statement = mysqli_prepare($con, "INSERT INTO datatable (name, age, username, password, knowlanguage, wantlanguage, interests) VALUES (?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sisssss", $name, $age, $username, $password, $knowlanguage, $wantlanguage, $interests);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_close($statement);
    
    mysqli_close($con);
?>


