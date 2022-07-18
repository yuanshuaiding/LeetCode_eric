package com.eric.leetcode.array

/**
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

 

示例 1：

输入：
[
[1,1,1],
[1,0,1],
[1,1,1]
]
输出：
[
[1,0,1],
[0,0,0],
[1,0,1]
]
示例 2：

输入：
[
[0,1,2,0],
[3,4,5,2],
[1,3,1,5]
]
输出：
[
[0,0,0,0],
[0,4,5,0],
[0,3,1,0]
]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/zero-matrix-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
解题思路：使用数组记录0所在的坐标

复杂度分析

时间复杂度：O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。我们至多只需要遍历该矩阵两次。

空间复杂度：O(m+n)，其中 mm 是矩阵的行数，nn 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。
 */
fun setZeros(matrix: Array<IntArray>) {
    val list0 = mutableListOf<IntArray>()
    //1. 遍历矩阵，找到所有0所在的坐标，记录的集合中
    matrix.forEachIndexed { i, arr ->
        arr.forEachIndexed { j, num ->
            if (num == 0) {
                list0.add(intArrayOf(i, j))
            }
        }
    }
    println("0所在的坐标：")
    printArr(list0)

    //再次遍历0的坐标集合，将与坐标x，y轴的所有数据置为0
    for (ints in list0) {
        matrix.forEachIndexed { x, arr ->
            arr.forEachIndexed { y, _ ->
                if (ints[0] == x || ints[1] == y) {
                    matrix[x][y] = 0
                }
            }
        }
    }
}

/**
解题思路，是用两个标记数组，符合标记的置为0
时间、空间复杂度同setZeros
 */
fun setZeros2(matrix: Array<IntArray>) {
    val rows = BooleanArray(matrix.size)
    val cols = BooleanArray(matrix[0].size)
    //1. 遍历矩阵，找到所有0所在的坐标，记录到标记列表中
    matrix.forEachIndexed { i, arr ->
        arr.forEachIndexed { j, num ->
            if (num == 0) {
                rows[i] = true
                cols[j] = true
            }
        }
    }
    //2.再次遍历矩阵，标记列表为true的置为0
    matrix.forEachIndexed { i, arr ->
        arr.forEachIndexed { j, _ ->
            if (rows[i] || cols[j]) {
                matrix[i][j] = 0
            }
        }
    }
}

/**
解题思路：同setZeros2，但不使用额外的数组标记，而是巧妙的利用矩阵的第一行，第一列来代替二维数组，只需要对第一行，第一列是否有0提供简单的记录即可，这样可以减少空间复杂度至O（1）
 */
fun setZeros3(matrix: Array<IntArray>) {
    var flagRow0 = false//第一行是否有0
    var flagCol0 = false//第一列是否有0

    for (i in matrix[0]) {
        if (i == 0) {
            flagRow0 = true
            break
        }
    }

    for (row in matrix) {
        if (row[0] == 0) {
            flagCol0 = true
            break
        }
    }

    //直接从第二行，第二列开始遍历，并列表原矩阵的第一行，第一列记录标识
    for (i in 1 until matrix.size) {
        for (j in 1 until  matrix[0].size) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    //直接从第二行，第二列开始遍历，第一行，第一列记录标识为0的则置为0
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][0] == 0||matrix[0][j]==0) {
                matrix[i][j] = 0
            }
        }
    }

    //单独处理第一行
    if(flagRow0){
        for (i in 0 until matrix[0].size){
            matrix[0][i]=0
        }
    }
    //单独处理第一列
    if(flagCol0){
        for (i in 0 until matrix.size){
            matrix[i][0]=0
        }
    }
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )

    val intervals2 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )

    val intervals3 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )
    setZeros(intervals)
    printArr(intervals.toList())

    setZeros2(intervals2)
    printArr(intervals2.toList())

    setZeros3(intervals3)
    printArr(intervals3.toList())
}