<?php
$x = $_GET["x"];
$y = $_GET["y"];
$r = $_GET["r"];
$time_offset = $_GET["time"];
$timestart = microtime(true);
$answers_count = count($x);

function validating($x, $y, $r)
{
    return valid_x($x) && valid_y($y) && valid_r($r);
}

function valid_x($x)
{
    foreach ($x as $value) {
        if (!($value == -5 || $value == -4 || $value == -3 || $value == -2 || $value == -1 || $value == 0 || $value == 1 || $value == 2 || $value == 3)) {
            return false;
        }
    }
    return true;
}

function valid_y($y)
{
    $round_y = substr($y, 0, 3);
    return ($round_y > -5 && $round_y < 3);
}

function valid_r($r)
{
    return ($r == 1 || $r == 2 || $r == 3 || $r == 4 || $r == 5);
}

function check_matching($x, $y, $R): bool
{
    if ($x == 0) {
        return check_in_zero($y, $R);
    }
    if ($x > 0 && $x <= ($R / 2)) {
        return (check_circle($x, $y, $R) || check_triangle($x, $y, $R));
    }
    if ($x < 0 && $x >= - ($R / 2)) {
        return check_square($y, $R);
    }
    return false;
}

function check_square($y, $R): bool
{
    return ($y <= 0 && $y >= - ($R));
}
$current_time = date('H:i:s', time() - $t * 60);;

function check_triangle($x, $y, $R): bool
{
    return ($y >= 0 && $y <= - ($x) + ($R / 2));
}

function check_circle($x, $y, $R): bool
{
    return ($y <= 0 && $y >= -sqrt(($R / 2) - ($x) * ($x)));
}

function check_in_zero($y, $R): bool
{
    return ($y <= $R / 2 && $y >= - ($R));
}

if (validating($x, $y, $r)) {

    $answer = [];
    for ($i = 0; $i < $answers_count; $i++) {


        if (check_matching($x[$i], $y, $r)) {
            $result = "Match";
        } else {
            $result = "Miss";
        }

        $worktime = microtime(true) - $timestart;
        $current_time = date('H:i:s', time()
            // - 180 * 60 
            - $time_offset * 60);

        if ($time_offset > 0) {
            $timezone_info = " (GMT " . $time_offset / -60 . ")";
        } else {
            $timezone_info = " (GMT +" . $time_offset / -60 . ")";
        }
        $tr = [$x[$i], $y, $r, $result, round($worktime, 6) . " s", $current_time . $timezone_info];
        array_push($answer, $tr);
    }

    print_r(json_encode($answer));

} else {

    http_response_code(400);

    if (!valid_x($x)) {
        echo "X is invalid value.\n";
    }
    if (!valid_y($y)) {
        echo "Y is invalid value.\n";
    }
    if (!valid_r($r)) {
        echo "R is invalid value.\n";
    }
}
