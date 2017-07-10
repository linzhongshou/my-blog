require.config({
    baseUrl: "/js",
    paths: {
        "jquery": "jquery",
        "bootstrap": "bootstrap",
        "vue": "vue/vue.min",
        "nav": "components/nav"
    },

    shim: {
        jquery: {
            exports: 'jquery'
        },
        bootstrap: {
            deps: ['jquery']
        }
    }
});

require(['jquery', 'bootstrap', 'vue', 'nav'], function(jquery, bootstrap, Vue, nav) {
    new Vue({
        el: '#nav',
        components: {
            navigation: nav
        }
    });
});