<?php
  define('HOST','mysql.hostinger.in');
  define('USER','u640683613_user');
  define('PASS','sunny6121986');
  define('DB','u640683613_db');
  $con = mysqli_connect(HOST,USER,PASS,DB);
  
    $name = $_POST['name'];
  $address = $_POST['address'];
  
    $sql = "insert into Persons (name,address) values ('$name','$address')";
  if(mysqli_query($con,$sql)){
    echo 'success';
  }
  else{
    echo 'failure';
  }
  mysqli_close($con);
?>