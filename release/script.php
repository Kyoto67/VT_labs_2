<?php
$y = $_GET["y"];
$R = $_GET["R"];
$history_filename = "history";
$timestart = microtime(true);

if ($_GET["x_-5"]) $x=-5;
if ($_GET["x_-4"]) $x=-4;
if ($_GET["x_-3"]) $x=-3;
if ($_GET["x_-2"]) $x=-2;
if ($_GET["x_-1"]) $x=-1;
if ($_GET["x_0"]) $x=0;
if ($_GET["x_1"]) $x=1;
if ($_GET["x_2"]) $x=2;
if ($_GET["x_3"]) $x=3;

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
    $result = "TRUE";    
} else {
    $result = "FALSE";
}

$finish = microtime(true)-$timestart;
$current_time = date('H:i:s', time()-$t*60);

$data = "
<table>
<tr><td>X: </td><td>$x</td></tr>
<tr><td>Y: </td><td>$y</td></tr>
<tr><td>R: </td><td>$R</td></tr>
<tr><td>Matching? </td><td>$result</td></tr>
<tr><td>Time script working: </td><td>$finish sec</td></tr>
<tr><td>Current time: </td><td>$current_time</td></tr>
</table>
<hr>
";

if (file_exists($history_filename)){
    $data = $data . file_get_contents($history_filename);
}

file_put_contents($history_filename, $data);

echo "<hr>" . $data;



?>
