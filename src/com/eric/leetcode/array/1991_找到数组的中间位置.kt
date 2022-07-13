package com.eric.leetcode.array

/**
给你一个下标从 0开始的整数数组nums，请你找到 最左边的中间位置middleIndex（也就是所有可能中间位置下标最小的一个）。

中间位置middleIndex是满足nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1]的数组下标。

如果middleIndex == 0，左边部分的和定义为 0。类似的，如果middleIndex == nums.length - 1，右边部分的和定义为0。

请你返回满足上述条件 最左边的middleIndex，如果不存在这样的中间位置，请你返回-1。



示例 1：

输入：nums = [2,3,-1,8,4]
输出：3
解释：
下标 3 之前的数字和为：2 + 3 + -1 = 4
下标 3 之后的数字和为：4 = 4
示例 2：

输入：nums = [1,-1,4]
输出：2
解释：
下标 2 之前的数字和为：1 + -1 = 0
下标 2 之后的数字和为：0
示例 3：

输入：nums = [2,5]
输出：-1
解释：
不存在符合要求的 middleIndex 。
示例 4：

输入：nums = [1]
输出：0
解释：
下标 0 之前的数字和为：0
下标 0 之后的数字和为：0

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-the-middle-index-in-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun pivotIndex(nums: IntArray): Int {
    var total = 0
    var left = 0
    for (num in nums) {
        total += num
    }

    nums.forEachIndexed { index, num ->
        if (left == (total - left - num)) return index
        left += num
    }


    return -1
}

fun main() {
    val nums = intArrayOf(2, 3, -1, 8, 4)
    val nums2 = intArrayOf(1,-1,4)
    println(pivotIndex(nums))
    println(pivotIndex(nums2))
}