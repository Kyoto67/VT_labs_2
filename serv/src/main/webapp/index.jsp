<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">

<link id="css_main" rel="stylesheet" type="text/css" href="css/light/main.css">
<link id="css_buttons" rel="stylesheet" type="text/css" href="css/light/buttons.css">
<link id="css_checkboxes" rel="stylesheet" type="text/css" href="css/light/custom-checkboxes.css">

<head>
    <meta charset="UTF-8">
    <title>Laba var. 3016</title>
</head>

<!-- import jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- theme_changer script -->
<script type="text/javascript" src="js/theme_changer.js"></script>

<!-- validate & ajax script -->
<script type="text/javascript" src="js/validate_and_submit.js"></script>

<body class="body" onload="setTheme()">

<div class="hat">
    <img id="lgbt" src="img/anim.gif" width="20%" height="20%">
    Лабораторная работа
    <br>
    по Веб-Программированию №1
    <br>
    вариант: 3016
    <br>
    выполнил: Птицын Максим Евгеньевич
    <br>
    группа: P32301
</div>

<div class="Input_Block">

    <div class="area">
        <div class="label">График:<br><br></div><img id="area" src="img/areas.png">
    </div>

    <div class="data">
        <div class="label">Введите данные:</div>
        <!-- X block -->
        <p><br>
            x:
            <br>
            <input type="checkbox" id="x_-3" class="x_checkboxes-negative" value="-3">
            <label for="x_-3" class="checkbox-custom-label">-3</label>

            <input type="checkbox" class="x_checkboxes-negative" value="-2" id="x_-2">
            <label for="x_-2" class="checkbox-custom-label">-2</label>

            <input type="checkbox" class="x_checkboxes-negative" value="-1" id="x_-1">
            <label for="x_-1" class="checkbox-custom-label">-1</label>

            <br>

            <input type="checkbox" class="x_checkboxes" value="0" id="x_0">
            <label for="x_0" class="checkbox-custom-label">0</label>

            <input type="checkbox" class="x_checkboxes" value="1" id="x_1">
            <label for="x_1" class="checkbox-custom-label">1</label>

            <input type="checkbox" class="x_checkboxes" value="2" id="x_2">
            <label for="x_2" class="checkbox-custom-label">2</label>

            <br>

            <input type="checkbox" class="x_checkboxes" value="3" id="x_3">
            <label for="x_3" class="checkbox-custom-label">3</label>

            <input type="checkbox" class="x_checkboxes" value="4" id="x_4">
            <label for="x_4" class="checkbox-custom-label">4</label>

            <input type="checkbox" class="x_checkboxes" value="5" id="x_5">
            <label for="x_5" class="checkbox-custom-label">5</label>

            <br>

            <!-- &nbsp  -->
        </p>

        <!-- Y block -->
        <p>y: &nbsp <input type="text" size="4" maxlength="8" name="y" id="y_value">
        </p>

        <!-- R block -->
        <p>R: <span class="valueR" name="R"></span><select name="R_value" id="RvalueSelector">
        <option disabled>Выберите значение</option>
        <option value="1">1</option>
        <option value="1.5">1.5</option>
        <option value="3">2</option>
        <option value="2.5">2.5</option>
        <option value="3">3</option>
        </select></p>
        <br>
        <button class="submitButton" type="button" onclick="validatingAndSend()">Send</button>
    </div>
</div>
<div><button type="button" id="themebutton" onclick="changeOnDark()"></button></div>

<div class="resultbody" id="outputContainer">
    <table border="1" class="resultTable">
        <tr>
            <td class="cellNum">№</td>
            <td class="cellNum">X</td>
            <td class="cellNum">Y</td>
            <td class="cellNum">R</td>
            <td class="cellRes">Result</td>
            <td class="cellTime">Working time</td>
            <td class="cellTime">Current time</td>
        </tr>
    </table>
</div>


</body>


</html>