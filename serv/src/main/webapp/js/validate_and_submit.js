let x = [], y, r;


function validatingAndSend() {
    try {
        getXes();
        getY();
        getR();
        console.log("Xes: " + x + "; y: " + y + "; r: " + r);
        if (validate()) {
            sendData();
        }
    } catch (error) {
        alert("Ошибка HTTP. Повторите попытку позже." + error)
    }
}

function sendData() {
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


function onAnswer(ans) {
    document.getElementById("outputContainer").innerHTML = ans;
}


function validate() {
    console.log("validX: " + valid_x() + "\nvalidY: " + valid_y() + "\nvalidR: " + valid_R());
    return (valid_x() && valid_y() && valid_R());
}

function valid_y() {
    let ymin = -5;
    let ymax = 3;
    try {
        y = parseFloat(y);
        if (y > ymin && y < ymax) return true;
        else { alert("Укажите значении координаты Y числом в интервале (-5;3)"); return false; }
    } catch (error) {
        alert("Укажите значении координаты Y числом в интервале (-5;3)")
        return false;
    }
}

function getY(){
    y = document.getElementById('y_value').value;

}

function valid_x() {
    let x_Min=-3;
    let x_Max=5
    if (x.length === 0) { alert("Выберите координату X!"); return false; }
    x.forEach( (x_value) => { if (x_value>x_Max || x_value<x_Min) { alert("Выбрано неподходящее значение X!"); return false; } } );
    return true;
}


function getXes() {
    let markedBoxes = getMarkedXBoxes();
    markedBoxes.forEach((xBox) => x.push(parseFloat(xBox.value)));
}

function valid_R() {
    return r == 1 || r == 1.5 || r == 2 || r == 2.5 || r == 3;

}

function getR(){
    r = document.getElementById("RvalueSelector").value;
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

$(document).ready(function () {
    $(document.getElementById("area")).on("click", function (event) {
        let rawX = event.pageX - this.offsetLeft;
        let rawY = event.pageY - this.offsetTop;
        r = document.getElementById("RvalueSelector").value;
        let trueX = r * (rawX - 510) / 80;
        let trueY = r * -((rawY - 340)) / 80;

        x.push(trueX);
        y = trueY;

        if (valid_x() && valid_y()) sendData();
    });
});