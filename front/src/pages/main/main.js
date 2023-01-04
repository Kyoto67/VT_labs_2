import React from 'react';
import mainAPI from "../../scripts/main";
import area from "../../img/areas.png";
import $ from 'jquery';
import {useNavigate} from "react-router-dom";

var data = [];
var lastAdekvatRValue = 2;
let tableHat = "<table border={\"1\"}>\n" +
    "        <tr>\n" +
    "            <td>№</td>\n" +
    "            <td>X</td>\n" +
    "            <td>Y</td>\n" +
    "            <td>R</td>\n" +
    "            <td>Result</td>\n" +
    "            <td>Working time</td>\n" +
    "            <td>Current time</td>\n" +
    "        </tr>\n"

let tableFoot = "</table>"

function Main() {

    getMyData();

    const navigate = useNavigate();
    const myNavigate = () => {
        navigate("/");
    };

    function logout() {
        localStorage.removeItem("token");
        myNavigate();
    }

    if (localStorage.getItem("token") == null) {
        return "ohuel? samiy umniy tipa?";
    }

    return (
        <div>
            <div className={"hat"}>
                Лабораторная работа
                по Веб-Программированию №4
                вариант: 1488
                выполнил: Птицын Максим Евгеньевич
                группа: P32311
            </div>
            <div className={"Input_Block"}>
                <div className={"area"}>
                    <div className={"label"}>График:</div>
                    <div id={"plot"}></div>
                    <img id={"area"} src={area} alt={"CLICK ME"}/>
                </div>

                <div className={"data"}>
                    <div className={"label"}>Введите данные:</div>
                    <div id={"sosi"}></div>
                    <p>x:
                        <input id={"x"} value={0} type={"hidden"}/>
                        <button onClick={() => change("x", -3)}>-3</button>
                        <button onClick={() => change("x", -2)}>-2</button>
                        <button onClick={() => change("x", -1)}>-1</button>
                        <button onClick={() => change("x", 0)}>0</button>
                        <button onClick={() => change("x", 1)}>1</button>
                        <button onClick={() => change("x", 2)}>2</button>
                        <button onClick={() => change("x", 3)}>3</button>
                        <button onClick={() => change("x", 4)}>4</button>
                        <button onClick={() => change("x", 5)}>5</button>
                    </p>
                    <p>y:
                        <input id={"y"} type={"text"}/>
                    </p>
                    <p>r:
                        <input id={"r"} value={2} type={"hidden"}/>
                        <button onClick={() => redrawPlotsAndChangeRadius( -3)}>-3</button>
                        <button onClick={() => redrawPlotsAndChangeRadius(-2)}>-2</button>
                        <button onClick={() => redrawPlotsAndChangeRadius( -1)}>-1</button>
                        <button onClick={() => redrawPlotsAndChangeRadius( 0)}>0</button>
                        <button onClick={() => redrawPlotsAndChangeRadius( 1)}>1</button>
                        <button onClick={() => redrawPlotsAndChangeRadius( 2)}>2</button>
                        <button onClick={() => redrawPlotsAndChangeRadius(3)}>3</button>
                        <button onClick={() => redrawPlotsAndChangeRadius(4)}>4</button>
                        <button onClick={() => redrawPlotsAndChangeRadius(5)}>5</button>
                    </p>
                    <p>
                        <button id={"submitButton"} onClick={submit}>Submit</button>
                    </p>
                    <br/>
                    <br/>
                    <p>
                        <button onClick={logout}>Logout</button>
                    </p>
                </div>
            </div>

            <div className={"resultbody"} id={"outputContainer"}>
                <table border={1}>
                    <tr>
                        <td>№</td>
                        <td>X</td>
                        <td>Y</td>
                        <td>R</td>
                        <td>Result</td>
                        <td>Working time</td>
                        <td>Current time</td>
                    </tr>
                </table>
            </div>
        </div>

    );
}

function submit() {
    let x = document.getElementById("x").value;
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;
    mainAPI.hit(x, y, r, localStorage.getItem("token")).then(response => {
        if (response.status === 200){
            data.push(response.data);
            drawHits();
        } else {
            console.log(response);
        }
    }).catch( (error) => {
        if ( error.response.data.status === 400) {
            alert("Wrong data.");
        } else {
            console.log(error);
        }
    });
    return true;
}
function getMyData( ) {
    mainAPI.getData(localStorage.getItem("token")).then(response => {
        data = response.data;
        drawHits();
    });
}

function change(id, value) {
    document.getElementById(id).value = value;
}

function redrawPlotsAndChangeRadius(newRValue) {
    let points = document.getElementsByClassName("point")
    let oldR = lastAdekvatRValue;
    for (let i = 0; i < points.length; i++) {
        if (newRValue <= 0) {
            points[i].style.visibility = "hidden";
        } else {
            let oldXpos = parseFloat(points[i].style.left);
            let oldYpos = parseFloat(points[i].style.top);
            let rawX = (oldXpos - 108) / 80 * (oldR);
            let rawY = (oldYpos - 125) * (oldR) / (-80);
            let newX = rawX / newRValue * 80 + 108;
            let newY = rawY / newRValue * (-80) + 125;
            points[i].style.left = newX + "px";
            points[i].style.top = newY + "px";
            points[i].style.visibility = "visible";
            lastAdekvatRValue = newRValue
        }
    }
    change("r", newRValue);
}

$(document).ready(function () {

    $(document.getElementById("area")).on("click", function (event) {
        let rawX = event.pageX - this.offsetLeft;
        let rawY = event.pageY - this.offsetTop;
        let r = document.getElementById("r").value;
        let trueX = r * ((rawX - 1120) / 80 + 0.13);
        let trueY = r * (-((rawY - 450)) / 80 - 1);
        console.log("x: " + rawX + "\ny: " + rawY);
        console.log("x: " + trueX + "\ny: " + trueY);

        document.getElementById("x").value = trueX.toFixed(2);
        document.getElementById("y").value = trueY.toFixed(2);

        document.getElementById("submitButton").click();
    });
});

function drawHits() {
    let table = tableHat
    let plots = "";
    let sequence = 1
    data.forEach(obj => {
        table += "<tr>\n" +
            "        <td className=\"cellNum\">" + sequence + "</td>\n" +
            "        <td className=\"cellNum\">" + obj.x + "</td>\n" +
            "        <td className=\"cellNum\">" + obj.y + "</td>\n" +
            "        <td className=\"cellNum\">" + obj.r + "</td>\n" +
            "        <td className=\"cellRes\">" + obj.match + "</td>\n" +
            "        <td className=\"cellTime\">" + obj.workingTime + "</td>\n" +
            "        <td className=\"cellCurTime\">" + obj.currentDateandTime + "</td>\n" +
            "    </tr>"
        plots +=
            "<span class=\"point\" id=\"" +
            obj.match.toString() +
            "\" style=\"left:" +
            (108+obj.x/obj.r*80).toString() +
            "px; top:" +
            (125+obj.y/obj.r*-80).toString() +
            "px\"></span>\n";
        sequence++;
    });
    table += tableFoot
    console.log(plots)
    document.getElementById("outputContainer").innerHTML = table;
    document.getElementById("plot").innerHTML = plots;
}

export default Main