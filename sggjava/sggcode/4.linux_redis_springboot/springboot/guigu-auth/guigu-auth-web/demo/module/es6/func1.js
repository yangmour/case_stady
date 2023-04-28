
//方式1
//声明一个求和的函数
export function sum(a, b) {
    return parseInt(a) + parseInt(b)
}
//声明一个求差的函数
export function sub(a, b) {
    return parseInt(a) - parseInt(b)
}

//方式2
export default {
    sum2(a, b) {
        return parseInt(a) + parseInt(b)
    },
    sub2(a, b) {
        return parseInt(a) - parseInt(b)
    }
}

