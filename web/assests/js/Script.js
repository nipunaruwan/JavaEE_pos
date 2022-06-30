





/*document.getElementById("Customerpage").style.display="none";
document.getElementById("itempage").style.display="none";
//First Btn Func
document.getElementById("Home").addEventListener("click",function () {
    document.getElementById("Homepage").style.display="block";
    document.getElementById("Customerpage").style.display="none";
    document.getElementById("itempage").style.display="none";
});
//Sec Btn Func
document.getElementById("Customer").addEventListener("click",function () {
    document.getElementById("Customerpage").style.display="block";
    document.getElementById("itempage").style.display="none";
    document.getElementById("Homepage").style.display="none";
});

document.getElementById("item").addEventListener("click",function () {
    document.getElementById("Homepage").style.display="none";
    document.getElementById("itempage").style.display="block";
    document.getElementById("Customerpage").style.display="none";
});*/




$("#Customerpage").css("display","none");
$("#itempage").css("display","none");

$("#Home").click(function () {
    $("#Homepage").css("display","block");
    $("#Customerpage").css("display","none");
    $("#itempage").css("display","none");


});
$("#Customer").click(function () {
    $("#Homepage").css("display","none");
    $("#Customerpage").css("display","block");
    $("#itempage").css("display","none");
});
$("#item").click(function () {
    $("#Homepage").css("display","none");
    $("#Customerpage").css("display","none");
    $("#itempage").css("display","block");
});

//Customer funtion
$("#btn").click(function () {
   /* const customerdata=$("#Customerform").serialize()
    $.ajax({
        url:"Customer",
        method:"POST",
        data:customerdata,
        success: function (resp) {
            alert(resp)
        }*/
    console.log("hello")
});











