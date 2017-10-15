<?php
class People
{
    public function helloName($name)
    {
        return "Hello {$name}!!!";
    }
}

$p = new People;

echo $p->helloName("Adriano");
