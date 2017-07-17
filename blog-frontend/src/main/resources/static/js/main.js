require.config({
    baseUrl: "/js",
    paths: {
        "jquery": "jquery",
        "bootstrap": "bootstrap",
        "vue": "vue/vue.min",
        "nav": "components/nav",
        "stringUtil": "utils/stringUtil",
        "dateUtil": "utils/dateUtil",
        "dialogUtil": "utils/dialogUtil"
    },

    shim: {
        jquery: {
            exports: 'jquery'
        },
        bootstrap: {
            deps: ['jquery']
        }
    },

    waitSeconds: 0
});

require(['jquery', 'bootstrap', 'vue', 'nav'], function(jquery, bootstrap, Vue, nav) {
    // initial navigation
    new Vue({
        el: '#nav',
        components: {
            navigation: nav
        }
    });

    // call target module
    // var targetModule = $("#requirejs").attr("currjs");
    // $(function() {
    //     require([targetModule], function(targetModule) {
    //         targetModule.init();
    //     });
    // });
});