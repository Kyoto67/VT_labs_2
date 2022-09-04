let x , y , r, dataStorage=new Array;


function valAndSub() {
    try {
        if (validate()) {

            $.ajax({
                type: "GET",
                url: "php/script.php",
                data: {
                    "x": x,
                    "y": y,
                    "r": r,
                    "time": (new Date()).getTimezoneOffset()
                },
                success: onAnswer,
                dataType: "text"
            });

        }
    } catch (error) {
        alert("Ошибка HTTP. Повторите попытку позже." + error)
    }
}


function onAnswer(ans) {
    var parsedAns = JSON.parse(ans);
    dataStorage.push(parsedAns);
    var output = "<table border=\"1\" class=\"resultTable\"><tr><td class=\"cellNum\">№</td><td class=\"cellNum\">X</td><td class=\"cellNum\">Y</td><td class=\"cellNum\">R</td><td class=\"cellRes\">Result</td><td class=\"cellTime\">Working time</td><td class=\"cellTime\">Current time</td></tr>\n";
    for (var i = 0; i<dataStorage.length; i++){
        var num = i+1;
        output+= "<tr><td>"+num+"</td>";
        var m = dataStorage[i];
        for(var j=0; j<m.length; j++){
            output+= "<td>"+m[j]+"</td>";
        }
        output+="</tr>\n";
    }
    output+="</table>"
    document.getElementById("outputContainer").innerHTML = output;
}



function validate() {
    return (valid_x() && valid_y() && valid_R());
}

function valid_y() {
    let rawY = document.getElementById('y_value').value;
    let ymin = -5;
    let ymax = 3;
    try {
        let value_y = parseFloat(rawY);
        if (value_y > ymin && value_y < ymax) {
            y = value_y;
            return true;
        } else {
            alert("Укажите значении координаты Y числом в интервале (-5;3)")
            return false;
        }
    } catch (error) {
        alert("Укажите значении координаты Y числом в интервале (-5;3)")
        return false;
    }
}

function valid_x() {
    var markedBoxes = getMarkedXBoxes();
    if (markedBoxes.length == 1) {
        switch (markedBoxes[0].name) {

            case "x_-5":
                x = -5;
                return true;
            case "x_-4":
                x = -4;
                return true;
            case "x_-3":
                x = -3;
                return true;
            case "x_-2":
                x = -2;
                return true;
            case "x_-1":
                x = -1;
                return true;
            case "x_0":
                x = 0;
                return true;
            case "x_1":
                x = 1;
                return true;
            case "x_2":
                x = 2;
                return true;
            case "x_3":
                x = 3;
                return true;
            default:
                return false;
        }


    } else {

        if (markedBoxes.length == 0) {
            alert("Выберите координату X!");
        } else {
            alert("Выберите одно значение X.");
        }

        return false;
    }
}

function valid_R() {
    var valueR = document.getElementById("valueR").value;
    switch (valueR) {

        case ("1"):
            r = 1;
            return true;
        case ("2"):
            r = 2;
            return true;
        case ("3"):
            r = 3;
            return true;
        case ("4"):
            r = 4;
            return true;
        case ("5"):
            r = 5;
            return true;
        default:
            return false;
    }

}

function getMarkedXBoxes() {
    var allCheckboxes = document.querySelectorAll('input[type="checkbox"]');
    var markedBoxes = [];
    for (var i = 0; i < allCheckboxes.length; i++) {
        if (allCheckboxes[i].checked) {
            markedBoxes.push(allCheckboxes[i]);
        }
    }
    return markedBoxes;
}