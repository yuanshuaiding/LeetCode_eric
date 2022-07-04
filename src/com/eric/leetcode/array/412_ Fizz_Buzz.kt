package com.eric.leetcode.array

/**
给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：

answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
answer[i] == "Fizz" 如果 i 是 3 的倍数。
answer[i] == "Buzz" 如果 i 是 5 的倍数。
answer[i] == i （以字符串形式）如果上述条件全不满足。

示例 1：

输入：n = 3
输出：["1","2","Fizz"]
示例 2：

输入：n = 5
输出：["1","2","Fizz","4","Buzz"]
示例 3：

输入：n = 15
输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/fizz-buzz
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun fizzBuzz(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 1..n) {
        list.add(
            when {
                i % 3 % 5 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> i.toString()
            }
        )
    }
    return list
}

fun fizzBuzz2(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 1..n) {
        var s=""
        if(i%3==0){
            s+="Fizz"
        }

        if(i%5==0){
            s+="Buzz"
        }
        if(s.isEmpty()){
            s+=i.toString()
        }
        list.add(s)
    }
    return list
}

fun main() {
    for (fizzBuzz in fizzBuzz(15)) {
        println(fizzBuzz)
    }

    for (fizzBuzz in fizzBuzz2(15)) {
        println(fizzBuzz)
    }
}