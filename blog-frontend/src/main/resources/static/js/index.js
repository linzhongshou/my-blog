require.config({
    paths: {
        "jq_datatables": "/plugins/DataTables-1.10.15/media/js/jquery.dataTables.min",
        "bootstrap_datatables": "/plugins/DataTables-1.10.15/media/js/dataTables.bootstrap.min",
        "page": "/js/page",
        "categorycomponent": "components/category",
        "requestUtil": "utils/requestUtil"
    },

    shim: {
        bootstrap_datatables: {
            exports: 'bootstrap_datatables',
            deps: ['jq_datatables']
        },
        page: {
            exports: 'page',
            deps: ['bootstrap_datatables']
        }
    }
});

require(['main'], function() {
    require(['page', 'vue', 'categorycomponent', 'stringUtil', 'dateUtil', 'requestUtil'], function(page, Vue, categorycomponent, stringUtil, dateUtil, requestUtil) {
        var dataTable = null;

        $(function() {
            initPost();
            initCategory();
        });

        function initPost() {
            dataTable = $("#dataTable").datatable({
                "url": "/blog/page",
                "columns": initColumn(),
                "search": searchParams,
                "ajaxCallBack": ajaxCallBack
            });
        }

        function initColumn() {
            return [ { data: null } ];
        }

        function searchParams() {
            var params = {};
            var requestParams = requestUtil.getRequestParameters();
            if(!stringUtil.isNull(requestParams.categoryId)) {
                params['categoryId'] = requestParams.categoryId;
            }
            return params;
        }

        function ajaxCallBack(ajaxData) {
            new Vue({
                el: '#page_container',
                data: {
                    ajaxData: ajaxData.aaData
                },
                methods: {
                    toPostPage: function(id) {
                        window.open('/www/post.html?id=' + id);
                    }
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