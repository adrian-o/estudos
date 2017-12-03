<?php

$db = new \PDO("mysql:host=localhost;dbname=php-tests", "root", "root");

$query = "SELECT * FROM produtos";

$stmt = $db->prepare($query);

$stmt->execute();

$list = $stmt->fetchAll(\PDO::FETCH_ASSOC);

var_dump($list);