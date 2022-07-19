package com.eric.leetcode.array

/**
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
解题思路【双重遍历，动态匹配】：
取数组中第一个字符串，使用双层遍历，外层遍历第一个字符串长度，内层遍历整个数组【除第一个】，直到没有与做一个字符串当前截取字符相同的为止

复杂度分析：
时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
空间复杂度：O(1)。使用的额外空间复杂度为常数。

 */

fun longestCommonPrefix(strs: Array<String>): String {
    var pre = ""
    if (strs.size == 1) {
        return strs[0]
    }
    val first = strs[0]
    for (i in 1..first.length) {
        val temp = first.substring(0, i)
        for (j in 1 until strs.size) {
            if (i > strs[j].length || strs[j].substring(0, i) != temp) {
                return pre
            }
        }
        pre = temp
    }

    return pre
}

/**
 思路2【横向扫描】：
 从头开始，两两求最长前缀，将求出的结果继续与数组后面的匹配

 复杂度分析：
 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
 空间复杂度：O(1)。使用的额外空间复杂度为常数。
 */
fun longestCommonPrefix2(strs: Array<String>): String {
    var pre = ""
    if (strs.size == 1) {
        return strs[0]
    }
    var resutl = strs[0]
    for (i in 1 until strs.size) {
        resutl = getPre(resutl, strs[i])
        if (resutl.isNotEmpty()) {
            pre = resutl
        } else {
            return ""
        }
    }
    return pre
}

fun getPre(str1: String, str2: String): String {
    val length = str1.length.coerceAtMost(str2.length)
    var index = 0
    while (index < length) {
        if (str1[index] != str2[index]) {
            break
        } else {
            index++
        }
    }
    return str1.substring(0, index)
}

fun main() {
    val arr = arrayOf("flower", "flow", "flight")
    val arr2 = arrayOf("dog", "racecar", "car")
    println(longestCommonPrefix(arr))
    println(longestCommonPrefix(arr2))

    println(longestCommonPrefix2(arr))
    println(longestCommonPrefix2(arr2))
}