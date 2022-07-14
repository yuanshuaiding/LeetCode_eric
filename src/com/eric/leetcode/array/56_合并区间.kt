package com.eric.leetcode.array

import java.util.*
import kotlin.math.max

/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。



示例1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//方法一：数组排序，再对数组进行合并操作，逐步减少数组直至没有可以合并项
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    //先排序
    Arrays.sort(intervals) { t1, t2 -> t1[0] - t2[0] }
    //或
//    intervals.sortBy {
//        it[0]
//    }
    val newIntervals = intervals.toMutableList()
    while (reduce(newIntervals)) {
        printArr(newIntervals)
    }
    return newIntervals.toTypedArray()
}

//判断是否存在可以合并项，并返回合并后的数组
fun reduce(intervals: MutableList<IntArray>): Boolean {
    //每次取出第一个元素跟全部元素对比，合并后生成合并后的新列表
    if (intervals.size <= 1) {
        return false
    }
    var first: IntArray? = null
    val it = intervals.iterator()
    var index = 0
    while (it.hasNext()) {
        val other = it.next()
        if (first != null) {
            if (first[1] >= other[0] && first[1] <= other[1]) {
                intervals[index - 1] = intArrayOf(first[0], other[1])
                it.remove()
                return true
            } else if (first[0] <= other[0] && first[1] >= other[1]) {
                intervals[index] = intArrayOf(first[0], first[1])
                it.remove()
                return true
            }
        }
        first = other
        index++
    }
    return false
}

fun printArr(intervals: List<IntArray>) {
    println("-------------------------------------")
    for (interval in intervals) {
        print("[${interval[0]},${interval[1]}]")
    }
    println("")
    println("-------------------------------------")
}

//方法二：对原始数组排序，新建空列表，第一个数组直接添加只空列表，后续数组添加时跟列表最后一个元素比较，如果存在合并区间，则修改列表最后一个元素，如果不存在合并区间，则直接添加到列表
fun merge2(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val merged = mutableListOf<IntArray>()
    for (interval in intervals) {
        if (merged.size == 0) {
            merged.add(interval)
        } else {
            if (merged.last()[1] < interval[0]) {
                //不存在合并区间，直接添加
                merged.add(interval)
            } else {
                //存在合并区间，则列表最后一个数组替换为合并后的值
                merged[merged.lastIndex][1] = Math.max(merged.last()[1], interval[1])
            }
        }
    }

    return merged.toTypedArray()
}

fun main() {
    //[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
    val intervals = arrayOf(
        intArrayOf(2, 3),
        intArrayOf(2, 2),
        intArrayOf(3, 3),
        intArrayOf(1, 3),
        intArrayOf(5, 7),
        intArrayOf(2, 2),
        intArrayOf(4, 6)
    )
    val newIntervals = merge(intervals)
    printArr(newIntervals.toList())

    val newIntervals2 = merge2(intervals)
    printArr(newIntervals2.toList())
}