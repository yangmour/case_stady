
var sum = function (a, b) {
    return parseInt(a) + parseInt(b);
}

var sub = function (a, b) {
    return parseInt(a) - parseInt(b);
}

// 导出成员：
module.exports = {
    sum: sum,
    sub: sub
}

//简写
module.exports = {
    sum,
    sub
}