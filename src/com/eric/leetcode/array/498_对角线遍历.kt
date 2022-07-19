package com.eric.leetcode.array

/**
给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。


示例 1：
输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,4,7,5,3,6,8,9]

示例 2：
输入：mat = [[1,2],[3,4]]
输出：[1,2,3,4]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/diagonal-traverse
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 解题思路：
 */
fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    //1.一共需要遍历的元素数量
    val row = mat.size
    val col = mat[0].size
    val all = row * col
    //2.遍历后存储的一维数组
    val orders = IntArray(all)
    //3.遍历从坐标【0,0】开始，偶数次遍历（右上）时x++，y--，奇数次遍历（左下），x--，y++，注意特殊处理第一列，和最后一列
    var x = 0
    var y = 0
    for (i in 0 until all) {
        orders[i] = mat[x][y]
        //偶数次
        if ((x + y) % 2 == 0) {
            if (y == col - 1) {
                x++
            } else if (x == 0) {
                y++
            } else {
                x--
                y++
            }
        } else {
            //奇数次
            if (x == row - 1) {
                y++
            } else if (y == 0) {
                x++
            } else {
                x++
                y--
            }
        }
    }

    return orders
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )
    val oders = findDiagonalOrder(intervals)
    for (oder in oders) {
        print("$oder,")
    }
    println()
}