require.config({
    paths: {
        "jq_datatables": "/plugins/DataTables-1.10.15/media/js/jquery.dataTables.min",
        "bootstrap_datatables": "/plugins/DataTables-1.10.15/media/js/dataTables.bootstrap.min",
        "page": "/js/page",
        "vue": "vue/vue.min",
        "vuePage": "/js/components/vuePage"
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

require(['page', 'vue', 'vuePage'], function(page, Vue, vuePage) {
    var dataTable = null;

    $(function() {
        dataTable = $("#dataTable").datatable({
            "id": "dataTable",
            "url": "/blog/page",
            "columns": initColumn(),
            "ajaxCallBack": ajaxCallBack
        });
    });

    function initColumn() {
        return [ { data: null } ];
    }

    function ajaxCallBack(ajaxData) {
        new Vue({
            el: '#page',
            data: {
                ajaxData: ajaxData.aaData
            },
            components: {
                vuePage: vuePage
            }
        });
    }
});