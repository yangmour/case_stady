"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.sum = sum;
exports.sub = sub;

//方式1
//声明一个求和的函数
function sum(a, b) {
    return parseInt(a) + parseInt(b);
}
//声明一个求差的函数
function sub(a, b) {
    return parseInt(a) - parseInt(b);
}

//方式2
exports.default = {
    sum2: function sum2(a, b) {
        return parseInt(a) + parseInt(b);
    },
    sub2: function sub2(a, b) {
        return parseInt(a) - parseInt(b);
    }
};