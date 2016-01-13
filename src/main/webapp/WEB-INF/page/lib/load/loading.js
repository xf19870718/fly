;
(function ($) {

    var maskHtml = $('<div id="preloader"><div id="status"><i class="fa fa-spinner fa-spin"></i></div> </div>');
    $.fn.extend({
        "mask": function (display) {
            var _this = this;
            if (display == undefined) {
                console.info("show/hidden");
            } else {
                if (display == "hidden") {
                    $("#preloader").fadeOut(function () {
                        $(_this).css({
                            'overflow': 'visible'
                        });
                    });
                } else if (display == "show") {
                    $(_this).append(maskHtml);
                    /*	top=$(_this).offset().top;*/
                    var ftop = $(_this).offset().top;
                    var fleft = $(_this).offset().left;
                    var fwidth = $(_this).width();
                    var fheight = $(_this).height();
                    $(_this).find("#preloader").css({"left": fleft, "top": ftop, "width": fwidth, "height": fheight});
                    $('#preloader').css("display", "block");
                } else {
                    console.info("show/hidden");
                }
                ;
            }
        }
    });
})(jQuery);