/**
 * @Author linzs
 * @Description 一些字符串常用操作函数
 * */
define(function() {
    var stringUtil = {
        /**
         * 判断有效值
         * null 或 undefined 或 NaN 或 空字符 或布尔的"false" 或 数组的长度小等于0 都返回true
         */
        isNull: function (val) {
            var result = true;

            if (typeof(val) == "undefined") {
                result = false;
            } else if (val == null) {
                result = false;
            } else if (typeof(val) == "number" && isNaN(val)) {
                result = false;
            } else if (typeof(val) == "string") {
                var str = val.replace(/(^\s*)|(\s*$)/g, "");
                if (str == "") {
                    result = false;
                }
            } else if (typeof(val) == "boolean") {
                result = val;
            } else if (val instanceof Array && val.length <= 0) {
                result = false;
            } else if (typeof(val) == "object") {
                for (var key in val) {
                    break;
                }
            }

            return !result;
        },

        /**
         * 去掉数组或Object的value字符串值前后空格
         * */
        trimString: function (obj) {
            if (!stringUtil.isNull(obj)) {
                for (var key in obj) {
                    var value = obj[key];
                    if (typeof(value) == "string") {
                        var str = value.replace(/(^\s*)|(\s*$)/g, "");
                        obj[key] = str;
                    }
                }
            }
        }
    };

    return stringUtil;

});