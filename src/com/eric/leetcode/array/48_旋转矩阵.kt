package com.eric.leetcode.array

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？



示例 1:

给定 matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

原地旋转输入矩阵，使其变为:
[
[7,4,1],
[8,5,2],
[9,6,3]
]
示例 2:

给定 matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]

作者：力扣 (LeetCode)
链接：https://leetcode.cn/leetbook/read/array-and-string/clpgd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

fun rotate(matrix: Array<IntArray>): Array<IntArray> {
    /*
     *思路：
     * 1.从矩阵最后一行往第一行取值，取值为每一行的第x列，组成新的数组
     * 2.新的数组添加到列表，列表转数组，得到新的矩阵
     * 3.对原矩阵重新赋值
     */
    val rotateList = mutableListOf<IntArray>()
    val size = matrix.size
    val n = size - 1

    for (i in 0..n) {
        val r = IntArray(size)
        for (j in n downTo 0) {
            r[n - j] = matrix[j][i]
        }
        rotateList.add(r)
    }
    val newMatrix = rotateList.toTypedArray()
    //重新赋值
    for (i in 0..n) {
        for (j in 0..n) {
            matrix[i][j] = newMatrix[i][j]
        }
    }
    return matrix
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    val newIntervals = rotate(intervals)
    printArr(newIntervals.asList())
}