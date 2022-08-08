
function validate(){
    return (valid_x && valid_y && valid_R);
}

function valid_y(){
    let y = document.forms["mainForm"]["y"].value;
    try {
        let value_y = parseFloat(y);
        if(value_y>-5 && value_y<3){
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

function valid_x(){
    var countMarkedBoxes = getCountMarkedXBoxes;
    if(countMarkedBoxes==1){
        return true;
    } else {
        if(countMarkedBoxes==0){
            alert("Выберите координату X!");
        } else {
            alert("Выберите одно значение X.");
        }
        return false;
    }
}

function valid_R(){
    var valueR = document.querySelector('.valueR');
    return ( valueR == 1 || valueR == 2 || valueR == 3 || valueR == 4 || valueR == 5 );
}

function getCountMarkedXBoxes(){
    var allCheckboxes = document.getElementsByClassName('checkbox');
    var countMarkedBoxes = 0;
    for (var i = 0; i < allCheckboxes.length; i++){
        if (allCheckboxes[i].checked){
            countMarkedBoxes++;
        }
    }
    return countMarkedBoxes;
}