$(document).ready(
    function loading(ClassName, display) {
        var getDiv = "$" + ClassName;
        if (display == "show") {
            $(getDiv).delay(350).fadeOut(function () {
                $('body').delay(350).css({
                    'overflow': 'visible'
                });
            });
        } else if (display == "hidden") {
            $('.preloader').css("display", "block");
        }
        ;
    });


/*

 ;(function($){
 $.fn.extend({
 "color":function(value){
 if(value==undefined){
 return this.css("color");
 }
 else{
 return this.css("color",value);
 }
 }
 });
 })(jQuery);*/