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
        $('#sign-up')
            .form({
                fields: {
                    email: {
                        identifier  : 'email',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter your e-mail'
                            },
                            {
                                type   : 'email',
                                prompt : 'Please enter a valid e-mail'
                            }
                        ]
                    },
                    password: {
                        identifier  : 'password',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : 'Please enter your password'
                            },
                            {
                                type   : 'length[8]',
                                prompt : 'Your password must be at least 8 characters'
                            }
                        ]
                    },
                    password2:{
                        identifier:'password2',
                        rules :[
                            {
                                type:'match[password]',
                                prompt:'Passwords do not match'
                            }
                        ]

                    },
                    fname:{
                        identifier: 'fname',
                        rules:[
                            {
                                type:'empty',
                                prompt:'First Name cannot be null'
                            },
                            {
                                type:'length[2]',
                                prompt:'Name should greater than two characters'
                            }
                        ]
                    },
                    lname:{
                        identifier: 'lname',
                        rules:[
                            {
                                type:'empty',
                                prompt:'Last Name cannot be null'
                            },
                            {
                                type:'length[2]',
                                prompt:'Name should greater than two characters'
                            }
                        ]
                    },
                    gender:{
                        identifier:'gender',
                        rules:[
                            {
                                type:'empty',
                                prompt:'Gender required'
                            }
                        ]
                    },
                    terms:{
                        identifier:'terms',
                        rules:[
                            {
                            type:'checked',
                            prompt:"You must agree to terms of service to continue!"
                            }
                        ]
                    },
                    profile:{
                        identifier:'profile',
                        rules:[
                            {
                                type:'empty',
                                prompt:'You must provide a profile picture!'
                            }
                        ]
                    }

                }
            });
    });
})(jQuery);
