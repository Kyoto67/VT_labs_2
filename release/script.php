<?php
$x = $_GET["x"];
$y = $_GET["y"];
$r = $_GET["r"];
$timestart = microtime(true);

function check_matching($x, $y, $R): bool
{
    if ($x == 0) {
        return check_in_zero($y, $R);
    }
    if ($x > 0 && $x <= ($R / 2)) {
        return (check_circle($x, $y, $R) || check_triangle($x, $y, $R));
    }
    if ($x < 0 && $x >= -($R / 2)) {
        return check_square($y, $R);
    }
    return false;
}

function check_square($y, $R): bool
{
    return ($y <= 0 && $y >= -($R));
}$current_time = date('H:i:s', time()-$t*60);;

function check_triangle($x, $y, $R): bool
{
    return ($y >= 0 && $y <= -($x) + ($R / 2));
}

function check_circle($x, $y, $R): bool
{
    return ($y <= 0 && $y >= -sqrt(($R / 2) - ($x) * ($x)));
}

function check_in_zero($y, $R): bool
{
    return ($y <= $R / 2 && $y >= -($R));
}

if (check_matching($x, $y, $R)){
    $result = "Match";    
} else {
    $result = "Miss";
}

$worktime = microtime(true)-$timestart;
$current_time = date('H:i:s', time()-$t*60);

$answer = [$x,$y,$r,$result,$worktime,$current_time];


// header('Access-Control-Allow-Origin: *');

print_r(json_encode($answer));

?>
