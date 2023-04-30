$(document).ready(function () {
    $(document.getElementById("area")).on("click", function (event) {
        let rawX = event.pageX - this.offsetLeft;
        let rawY = event.pageY - this.offsetTop;
        console.log("x: " + rawX + "\ny: " + rawY);
        let r = document.getElementById("form:r").value;
        let trueX = r * ( (rawX - 1120) / 80 - 0.05 );
        let trueY = r * ( -((rawY - 450)) / 80 );

        document.getElementById("form:x").value = trueX.toFixed(2);
        document.getElementById("form:y").value = trueY.toFixed(2);

        document.getElementById("form:submitButton").click();
    });
});
