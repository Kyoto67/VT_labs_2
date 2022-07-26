<?php
$x = $_POST["x"];
$y = $_POST["y"];
$R = $_POST["R"];

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
}

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
    echo "yes";
} else {
    echo "no";
}
?>
