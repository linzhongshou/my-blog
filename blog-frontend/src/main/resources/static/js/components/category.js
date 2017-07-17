define(['vue'], function(Vue){
    var template = '<div class="col-lg-6">\
                        <ul class="list-unstyled">\
                            <li v-for="category in categories"><a :href="\'/www/index.html?categoryId=\' + category.id">{{ category.name }}</a></li>\
                        </ul>\
                    </div>';

    //定义组件 模板 数据 方法
    var categoryComponent = Vue.extend({
        template:  template,
        props: ['categories']
    });

    return categoryComponent;
});