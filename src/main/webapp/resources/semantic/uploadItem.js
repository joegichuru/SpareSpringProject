/**
 * Created by joseph on 4/6/17.
 */
(function () {
    $(function () {
        $('.dropdown')
            .dropdown({
                // you can use any ui transition
                transition: 'slide down'
            });

    });
    $(function () {
        $('.ui.form')
            .form({
                fields: {
                    iname: {
                        identifier  : 'iname',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter a descriptive title for the item'
                            },
                            {
                                type:'length[10]',
                                prompt: 'Title should be at least 10 characters'
                            }
                        ]
                    },
                    description: {
                        identifier  : 'description',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Enter a short description of the item'
                            },
                            {
                                type   : 'length[40]',
                                prompt : 'Description must be atleast 40 characters'
                            }
                        ]
                    }
                }
            });
    });
})(jQuery);
