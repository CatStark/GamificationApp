<?php
	$con=mysqli_connect("mysql.hostinger.in","u640683613_nisha","sunny6121986","u640683613_data");
	
      
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM datatable WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $name, $age, $username, $password, $knowlanguage, $wantlanguage, $interests);
    
    $user = array();
    
    while(mysqli_stmt_fetch($statement)){
        $user["name"] = $name;
        $user["age"] = $age;
        $user["username"] = $username;
        $user["password"] = $password;
		$user["knowlanguage"] = $knowlanguage;
		$user["wantlanguage"] = $wantlanguage;
		$user["interests"] = $interests;
    }
    
    echo json_encode($user);
    mysqli_close($con);
?>
