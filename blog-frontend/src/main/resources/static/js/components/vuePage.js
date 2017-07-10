define(['vue'], function(Vue){
    var template = '<div class="post_box" v-for="data in pagedata">\
                        <div class="row">\
                            <div class="post_title">\
                                <h2> <a href="#">{{ data.title }}</a> </h2>\
                            </div>\
                            <div class="col-md-4">\
                                <img class="img-responsive center-block" src="http://placehold.it/900x300" alt="img">\
                            </div>\
                            <div class="col-md-8">\
                                <p class="post_text">{{ data.content }}</p>\
                                <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>\
                            </div>\
                        </div>\
                        <div class="row">\
                            <div class="col-md-12"><p class="post_footer"><span class="glyphicon glyphicon-time"></span>{{ data.date }}</p></div>\
                        </div>\
                    </div>';

    template = '<div style="color:red;">{{ pagedata }}</div>';

    //定义组件 模板 数据 方法
    var pagination = Vue.extend({
        template:  template,
        props: ['pagedata']
    });

    return pagination;
});