$(function () {
    var contentBox = $("#content-box");
    var windowHeight = $(window).height();


    $(".main-content").css("min-height", windowHeight);
    var theFirst = true;
    $(window).hashchange(function () {
        var hash = location.hash.replace("#", "");
        $(contentBox).load(hash + ".html");
        $(".sub-menu-list li").removeClass("active");
        var herfName = "#" + hash;
        $('a[href=' + herfName + ']').parent().addClass("active");
        /*$(".sticky-header").mask("hidden");*/
    });
    //窗口改变执行的方法
    $(window).resize(function () {
        windowHeight = $(window).height();
        $(".main-content").css("height", windowHeight);
    });
    //URL改变执行的函数
    $(window).hashchange();
    $(".sub-menu-list li").on("click", function () {
        $(window).hashchange();
    });
    var myBarChart = "";
    var myBarChart02 = "";
});
window.onload = function () {
    $("#preloader").mask("hidden");
    $("#preloader").remove();
}
