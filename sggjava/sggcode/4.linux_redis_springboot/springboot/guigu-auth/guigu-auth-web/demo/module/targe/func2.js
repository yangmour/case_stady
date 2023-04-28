'use strict';

var _func = require('./func1');

var _func2 = _interopRequireDefault(_func);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

//调用func.js中的两个函数
console.log((0, _func.sum)(10, 2));
console.log((0, _func.sub)(10, 2));

//调用func.js中的两个函数
console.log(_func2.default.sum2(10, 2));
console.log(_func2.default.sub2(10, 2));