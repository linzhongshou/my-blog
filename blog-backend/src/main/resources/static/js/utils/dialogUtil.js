/**
 * The dialog js is necessary sweetalert2 support!
 *
 * Created by linzs
 * */

var dialogUtil = (function() {

    var alert = function(params) {
        if(typeof(params) != 'object' || params == null) {
            params = { 'title': '提示' };
        } else if(typeof(params.title) == 'undefined' || params.title == null) {
            params.title = '提示';
        }

        swal({
            title: params.title,
            text: params.content,
            confirmButtonText: '确定'
        }).then(function() {}, function() {});
    };

    var confirm = function(params) {
        if(typeof(params) != 'object' || params == null) {
            params = { 'title': '提示' };
        } else if(typeof(params.title) == 'undefined' || params.title == null) {
            params.title = '提示';
        }

        swal({
            title: params.title,
            text: params.content,
            // type: 'warning',
            showCancelButton: true,
            confirmButtonText: '确定',
            cancelButtonText: '取消',
        }).then(function() {
            if(typeof(params.confirm) == 'function') {
                params.confirm.call();
            }
        }, function(dismiss) {
            if(dismiss == 'cancel' && typeof(params.cancel) == 'function') {
                params.cancel.call();
            }
        });
    };

    return {
        alert: alert,
        confirm: confirm
    }

})();