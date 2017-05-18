/**
 * Created by joseph on 5/8/17.
 */
$(document).ready(function() {
    $('.modal').modal();
    $('.carousel.carousel-slider').carousel({fullWidth: true});
    autoplay();
    function autoplay() {
        $('.carousel.carousel-slider').carousel('next');
        setTimeout(autoplay,4500);
    }
   $('#test').click(function () {
       $.ajax({
           url:'error/test',
           success:function (result) {
               console.log(result);

               $('#datatest').html(result);
           }
       })
   });
    /**using ajax to get filtered items in the explore view**/

    $('#filter-btn').click(function () {
        var city=$('#city').find(":selected").val();
        var category=$('#category').find(":selected").val();
        if(city===''){
         city='nairobi';
        }
        if(category===''){
            category='apartment';
        }
        var slider = document.getElementById('price-slider');
        var price=slider.noUiSlider.get();
        $.ajax({
            url:'explore/sort/city='+city+'&&category='+category+'&&priceHigh='+price[1]+'&&priceLow='+price[0],
            success:function (result) {
                console.log(result);
            }
        });
        console.log(city);
        console.log(category);
        console.log("Low"+price[0]);
        console.log("High"+price[1]);
        console.log("Now do ajax request");
    });
    //send review
    $('#review').click(function () {
        //end ajax request to update
        var messageBody=document.getElementById('review-message').value;
        var ratingValue=document.getElementById('rating').value;
        var userEmail=document.getElementById('userId').value;
        var itemId=document.getElementById('itemId').value;
        $.ajax({
            url:'ratings?itemId='+itemId+'&&userEmail='+userEmail+'&&ratingValue='+ratingValue+'&&messageBody='+messageBody,
            success:function (result) {
                console.log(result);
                $('#reviews').modal('close');
            }

        });


    });
    //send Message
    $('#send-message').click(function () {
        var senderEmail=document.getElementById("senderEmail").value;
        var subject=document.getElementById("subject").value;
        var body=document.getElementById("message-body").value;
        var recipientEmail=document.getElementById("recipientEmail").value;
        //do ajax get submission
        $.ajax({
            url:'message?senderEmail='+senderEmail+'&&subject='+subject+'&&body='+body+'&&recipientEmail='+recipientEmail,
            success:function (results) {
                console.log(results);
                $("#message").modal("close");
            }
        })
    });
});
