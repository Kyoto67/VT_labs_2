function setTheme() {
    if (document.cookie.split(';').filter(function (item) {
        return item.trim().indexOf('Theme=') == 0
    }).length) {
        if (document.cookie.split(';').filter(function (item) {
            return item.indexOf('Theme=Dark') >= 0
        }).length) {
            changeOnDark();
        }
    }
}

function changeOnLight() {
    document.cookie = "Theme=Light; path=/; expires=Tue, 19 Jan 2038 03:14:07 GMT";
    document.querySelector("#css_main").setAttribute("href", "css/light/main.css");
    document.querySelector("#css_checkboxes").setAttribute("href", "css/light/custom-checkboxes.css");
    document.querySelector("#css_buttons").setAttribute("href", "css/light/buttons.css");
    document.querySelector("#area").setAttribute("src", "img/areas.png");
    document.querySelector("#themebutton").setAttribute("onclick", "changeOnDark()");
    document.querySelector("#lgbt").setAttribute("src", "img/anim.gif");
}

function changeOnDark() {
    document.cookie = "Theme=Dark; path=/; expires=Tue, 19 Jan 2038 03:14:07 GMT";
    document.querySelector("#css_main").setAttribute("href", "css/dark/main.css");
    document.querySelector("#css_checkboxes").setAttribute("href", "css/dark/custom-checkboxes.css");
    document.querySelector("#css_buttons").setAttribute("href", "css/dark/buttons.css");
    document.querySelector("#area").setAttribute("src", "img/areas_dark.png");
    document.querySelector("#themebutton").setAttribute("onclick", "changeOnLight()");
    document.querySelector("#lgbt").setAttribute("src", "img/anim_dark.gif");
}