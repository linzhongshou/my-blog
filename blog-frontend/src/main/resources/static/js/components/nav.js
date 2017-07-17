define(['vue'], function(Vue){
    //数据
    var data = {
        nav_list: [{
            name: "主页",
            url: "/www/index.html",
        },{
            name: "关于我",
            url: "",
        }, {
            name: "留言板",
            url: ""
        }],
    };

    var template = '<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">\
                        <div class="container">\
                            <div class="navbar-header">\
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">\
                                    <span class="sr-only"></span>\
                                    <span class="icon-bar"></span>\
                                    <span class="icon-bar"></span>\
                                    <span class="icon-bar"></span>\
                                    <span class="icon-bar"></span>\
                                </button>\
                                <a class="navbar-brand">Blog</a>\
                            </div>\
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">\
                                <ul class="nav navbar-nav">\
                                    <li v-for="nav in nav_list"><a v-bind:href="nav.url">{{ nav.name }}</a></li>\
                                </ul>\
                            </div>\
                        </div>\
                    </nav>';

    var navigation = Vue.extend({
        template: template,
        data: function() {
            return data;
        }
    });

    return navigation;
});