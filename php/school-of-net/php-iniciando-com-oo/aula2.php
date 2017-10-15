<?php

$input = array(22,14,23,17,20,18,16);

// $filter = function(int $age) {
//     return ($age >= 18);
// };
//
// $output = array_filter($input, $filter);

$output = array_filter($input, function(int $age) {
    return ($age >= 18);
});

print_r($output);
