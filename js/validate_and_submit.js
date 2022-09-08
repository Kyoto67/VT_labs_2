let x = new Array, y, r, dataStorage = new Array;


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
    x = new Array;
    let parsedAns = JSON.parse(ans);
    parsedAns.forEach(element => {
        dataStorage.push(element);
    });
    let output = "<table border=\"1\" class=\"resultTable\"><tr><td class=\"cellNum\">№</td><td class=\"cellNum\">X</td><td class=\"cellNum\">Y</td><td class=\"cellNum\">R</td><td class=\"cellRes\">Result</td><td class=\"cellTime\">Working time</td><td class=\"cellTime\">Current time</td></tr>\n";
    for (let i = 0; i < dataStorage.length; i++) {
        let num = i + 1;
        output += "<tr><td>" + num + "</td>";
        let m = dataStorage[i];
        for (let j = 0; j < m.length; j++) {
            output += "<td>" + m[j] + "</td>";
        }
        output += "</tr>\n";
    }
    output += "</table>"
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
    let markedBoxes = getMarkedXBoxes();
    if (markedBoxes.length > 0) {
        for (let i = 0; i < markedBoxes.length; i++) {
            switch (markedBoxes[i].name) {

                case "x_-5":
                    x.push(-5);
                    break;
                case "x_-4":
                    x.push(-4);
                    break;
                case "x_-3":
                    x.push(-3);
                    break;
                case "x_-2":
                    x.push(-2);
                    break;
                case "x_-1":
                    x.push(-1);
                    break;
                case "x_0":
                    x.push(0);
                    break;
                case "x_1":
                    x.push(1);
                    break;
                case "x_2":
                    x.push(2);
                    break;
                case "x_3":
                    x.push(3);
                    break;
            }
        }

        return true;
    } else {
        alert("Выберите координату X!");
        return false;
    }
}

function valid_R() {
    let valueR = document.getElementById("valueR").value;
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
    let allCheckboxes = document.querySelectorAll('input[type="checkbox"]');
    let markedBoxes = [];
    for (let i = 0; i < allCheckboxes.length; i++) {
        if (allCheckboxes[i].checked) {
            markedBoxes.push(allCheckboxes[i]);
        }
    }
    return markedBoxes;
}