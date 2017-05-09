/**
 * Created by joseph on 5/6/17.
 */
(function($){
    $(function(){
        $('#cookie-modal').modal('open');
        $(".button-collapse").sideNav();
        $(".slide-out-collapse").sideNav({
            menuWidth: 300, // Default is 300
            edge: 'right', // Choose the horizontal origin
            closeOnClick: true
        });
        $('select').material_select();
        $('.collapsible').collapsible();
        //price range slider
        var slider = document.getElementById('price-slider');
        noUiSlider.create(slider, {
            start: [20000, 80000],
            connect: true,
            step: 500,
            range: {
                'min': 1000,
                'max': 100000
            },
            format: wNumb({
                decimals: 0
            })
        });
        //validator for registration page plug in
        $('#sign-up').validate({
            rules:{
                fname:{
                    required:true,
                    minlength:2
                },
                lname:{
                    required:true,
                    minlength:2
                },
                email:{
                    required:true,
                    email:true
                },
                password:{
                    required:true,
                    minlength:8
                },
                password2:{
                    required:true,
                    minlength:8,
                    equalTo:'#password'
                },
                gender:{
                    required:true
                }
            },
            messages:{
                fname:{
                    required:'First Name Required!',
                    minlength:'First name must be at least 2 characters!'
                },
                lname:{
                    required:'Last Name Required!',
                    minlength:'Last name must be at least 2 characters!'
                },
                email:{
                    required:'Email Required!',
                    email:'Invalid email address!'
                },
                password:{
                    required:'Password Required!',
                    minlength:'First name must be at least 8 characters!'
                },
                password2:{
                    required:'Password Required!',
                    minlength:'First name must be at least 8 characters!'
                },
                gender:{
                    required:'Specify Gender'
                }
            }
            ,errorElement:'div',
            errorPlacement:function (error, element) {
                var placement=$(element).data('error');
                if(placement){
                    $(placement).append(error)
                }else {
                    error.insertAfter(element);
                }
            }
        });
        $('.modal').modal();

    }); // end of document ready
})(jQuery); // end of jQuery name space
