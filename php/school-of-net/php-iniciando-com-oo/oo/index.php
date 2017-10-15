<?php

require_once("Car.php");
require_once("Motorcycle.php");

$ferrari = new Car("Ferrari","Red");
$ferrari->engine = 488;

$mustang = new Car("Mustang","Yellow");
$mustang->engine = 300;

$moto = new Motorcycle("Honda","Blue");
$moto->engine = 150;

//var_dump($mustang);

echo $moto->color;
