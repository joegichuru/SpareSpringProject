(function ($) {
    $(function () {


    });
    $(function () {
        $('.dropdown').dropdown();
    });
    $(function () {
        $('.right.menu.open').on("click",function (e) {
            e.preventDefault();
            $('.ui.vertical.menu').toggle();
        });

    });
    $(function () {
        $('.ui.item.account')
            .popup({
                popup : $('.accountpopup'),
                on    : 'click'
            })
        ;

    });
    $(function () {
        $('#sidebar-toggle').click(function () {
            $('.ui.sidebar')
                .sidebar('setting','transition','overlay')
                .sidebar('toggle');
        });

        }

    );
    $(function () {
        $('.cookie.nag').nag({
            key:'accepts-cookies',value:true
        })

    });
})(jQuery);
