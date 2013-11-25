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

    function addMainScript() {
        
    };

    script.addEventListener('load', function() {
        var cookieScript = document.createElement("script");
        cookieScript.setAttribute("src", "//localhost:9000/assets/javascripts/jquery.cookies.2.2.0.min.js");
        cookieScript.addEventListener('load', function() {
            //var guid = $.cookies.get('guid');
            var script = document.createElement("script");
            script.textContent = "window.jQ=jQuery.noConflict(true);(" + callback.toString() + ")();";
            document.body.appendChild(script);
        }, false);
        document.body.appendChild(cookieScript);
    }, false);
    
    document.body.appendChild(script);
}

function main() {
    function usePriceFromAdmin(element, productId) {
        console.log("created usePriceFromAdmin with " + productId);
        return function(data, foo, bar) {
            //TODO THIS IS WHERE YOU SHOULD START
            var adminHtml = $.parseHTML(data.html);
            debugger;
            //var evenAndOdd = $(".odd,.even", adminHtml);
            //debugger;
            //console.log("the data = " + evenAndOdd);
            //element.append("<p> productId = " + productId + "</p>");
        };
    }

    function internalPrice(productId) {
        return function(index, element) {
            //console.log("here cookie = " + guid);
            $.ajax({
                url: "http://localhost:9000/" + productId, //'proxies as jsonp': "/admin/product/show/" + productId,
                crossDomain: true,
                data: {"guid":"todo-remove"},
                dataType: "jsonp",
                success: usePriceFromAdmin(element, productId),
                error: function( jqXHR, textStatus, errorThrown) {
                    console.log("Error!!!! " + jqXHR + textStatus + errorThrown)
                }
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