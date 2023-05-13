function redrawPoints() {
    let points = document.getElementsByClassName("point")
    let newR = document.getElementById("form:r").value;
    let oldR = document.getElementById("form:r-value_fixator").value;
    for (let i = 0; i < points.length; i++) {
        let oldXpos = parseFloat(points[i].style.left);
        let oldYpos = parseFloat(points[i].style.top);
        let rawX = (oldXpos-94.5)/80*(oldR);
        let rawY = (oldYpos-135)*(oldR)/(-80);
        let newX = rawX/newR*80+94.5;
        let newY = rawY/newR*(-80)+135;
        points[i].style.left = newX+"px";
        points[i].style.top = newY+"px";
        console.log("oldx: "+oldXpos+"; newx: "+ points[i].style.left)
        console.log("oldy: "+oldYpos+"; newy: "+ points[i].style.top)
    }
    document.getElementById("form:r-value_fixator").value = newR;
}