package com.eric.leetcode.array

/**
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。


示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/ransom-note
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (ransomNote.length > magazine.length) {
        return false
    }
    val ra = ransomNote.toCharArray().toMutableList()
    val ma = magazine.toCharArray()
    for (s in ma) {
        val it = ra.iterator()
        while (it.hasNext()) {
            val rc = it.next()
            if (s == rc) {
                it.remove()
                break
            }
        }
    }
    if (ra.isEmpty()) {
        return true
    }
    return false
}

fun canConstruct2(ransomNote: String, magazine: String): Boolean {
    //统计ransomNote里每个相同字符的出现次数,如果都<=magazine里的同样字符,则true
    val arr = IntArray(26)
    for (c in magazine) {
        arr[c - 'a']++
    }

    for (c in ransomNote) {
        arr[c - 'a']--
        if (arr[c - 'a'] < 0) {
            return false
        }
    }

    return true
}

fun main() {
    println(canConstruct("af", "adfadfa"))
    println(canConstruct2("af", "adfadfa"))
}