/**
 * @Author linzs
 * @Description 系统常量工具，大部分与Java的SystemConstants类相呼应
 * */
var constants = (function() {
    var PROCESS_RESULT_CODE = {
        SUCCESS: function() { return 1; },
        ERROR: function() { return 0; },
        EXCEPTION: function() { return -1; }
    };

    return {
        PROCESS_RESULT_CODE: PROCESS_RESULT_CODE
    }
})();