//引入模块，注意：当前路径必须写 ./
// const m = required("./func1.js");
const m = require("./func1");
console.log(m.sum(10,20));
console.log(m.sub(10,20));