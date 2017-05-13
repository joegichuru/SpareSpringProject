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
});
