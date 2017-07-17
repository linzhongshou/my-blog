require.config({
    paths: {
        "categorycomponent": "components/category",
        "requestUtil": "utils/requestUtil"
    }
});

require(['main'], function() {
    require(['jquery', 'vue', 'categorycomponent', 'stringUtil', 'dateUtil', 'requestUtil'], function ($, Vue, categorycomponent, stringUtil, dateUtil, requestUtil) {
        $(function() {
            initPost();
            initCategory();
        });

        function initPost() {
            var requestParams = requestUtil.getRequestParameters();
            $.ajax({
                url: '/blog/getPost?id=' + requestParams.id,
                type: 'GET',
                success: function(article) {
                    if(!stringUtil.isNull(article)) {
                        new Vue({
                            el: '#article_container',
                            data: {
                                article: article
                            },
                            filters: {
                                formatDate: function(time) {
                                    if(!stringUtil.isNull(time)) {
                                        return new Date(time).pattern('yyyy-MM-dd HH:mm');
                                    } else {
                                        return '';
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }

        function initCategory() {
            $.ajax({
                url: '/blog/getCategories',
                type: 'GET',
                success: function(categories) {
                    if(!stringUtil.isNull(categories)) {
                        new Vue({
                            el: '#category_container',
                            data: {
                                categories: categories
                            },
                            components: {
                                categorycomponent: categorycomponent
                            }
                        });
                    }
                }
            });
        }
    });
});