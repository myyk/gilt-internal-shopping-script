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
    function usePriceFromAdmin(element, productId) {
        console.log("created usePriceFromAdmin with " + productId);
        return function(data) {
            console.log("doing the thing with " + productId);
            element.append("<p> productId = " + productId + "</p>");
        };
    }

    function internalPrice(productId) {
        return function(index, element) {
            $.get({
                url: "http://www.google.com", //"https://admin.gilt.com/admin/product/show/" + productId,
                success: usePriceFromAdmin(element, productId),
                error: function() {console.log("fuck!")}
            });
        };
    }

    function addInternalPrice(index, element) {
        var productId = $(this).find(".sku-selection").attr("data-gilt-product-id");
        $(this).find(".pricing").each(internalPrice(productId));
    }

    //product-look look product for_sale
    $(function() {
        $(".product-look").each(addInternalPrice);
        //$(".pricing").append(internalPrice);
        //window.alert($(".sku-selection").attr("data-gilt-product-id").text());
    });
}

// load jQuery and execute the main function
addJQuery(main);