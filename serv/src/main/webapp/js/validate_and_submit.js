let x = [], y, r;


function validatingAndSend() {
    try {
        if (validate()) {
            $.ajax({
                type: "GET",
                url: "app",
                data: {
                    "x": JSON.stringify(x),
                    "y": y,
                    "r": r,
                    "time": (new Date()).getTimezoneOffset()
                },
                success: onAnswer,
                dataType: "text"
            });
            x = [];
        }
    } catch (error) {
        alert("Ошибка HTTP. Повторите попытку позже." + error)
    }
}


function onAnswer(ans) {
    document.getElementById("outputContainer").innerHTML = ans;
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
            x.push(markedBoxes[i].value);
        }
        return true;
    } else {
        alert("Выберите координату X!");
        return false;
    }
}

function valid_R() {
    let valueR = document.getElementById("RvalueSelector").value;
    if (valueR == 1 || valueR == 1.5 || valueR == 2 || valueR == 2.5 || valueR == 3) {
        r = valueR;
        return true;
    }
    return false;
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