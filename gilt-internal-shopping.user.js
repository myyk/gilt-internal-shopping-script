// ==UserScript==
// @name       Gilt Internal Shopping
// @namespace  http://www.gilt.com/
// @version    0.1
// @description  Displays prices for employee discount to employees.
// @match      http://www.gilt.com/sale/*
// @copyright  2013+, Apache License v2 (http://www.apache.org/licenses/)
// ==/UserScript==

// a function that loads jQuery and calls a callback function when jQuery has finished loading
function addJQuery(callback) {
    var script = document.createElement("script");
    script.setAttribute("src", "//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js");
    script.addEventListener('load', function() {
        var script = document.createElement("script");
        script.textContent = "window.jQ=jQuery.noConflict(true);(" + callback.toString() + ")();";
        document.body.appendChild(script);
    }, false);
    document.body.appendChild(script);
}

function main() {
    //product-look look product for_sale
    $(function() {
        window.alert($(".product-look").text());
    });
}

// load jQuery and execute the main function
addJQuery(main);