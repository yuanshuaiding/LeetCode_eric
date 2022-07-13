package com.eric.leetcode.array

/**
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。



示例 1:

输入: nums = [1,3,5,6], target = 5
输出: 2
示例2:

输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:

输入: nums = [1,3,5,6], target = 7
输出: 4


提示:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为无重复元素的升序排列数组
-104 <= target <= 104

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/array-and-string/cxqdh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//暴力遍历的方法
fun searchIndex(nums: IntArray, target: Int): Int {
    var insertIndex = nums.size
    nums.forEachIndexed { index, i ->
        if (target == i) return index
        if (i > target) {
            insertIndex = index
            return index
        }
    }
    return insertIndex
}

//二分查找法
fun searchIndex2(nums: IntArray, target: Int): Int {
    val size = nums.size
    var left = 0
    var right = size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main() {
    val nums = intArrayOf(1, 3, 5, 6)
    var start = System.currentTimeMillis()
    val index = searchIndex(nums, 5)
    var end = System.currentTimeMillis()
    println("索引：$index,耗时：${end - start}")

    start = System.currentTimeMillis()
    val index2 = searchIndex2(nums, 5)
    end = System.currentTimeMillis()
    println("索引：$index2,耗时：${end - start}")
}