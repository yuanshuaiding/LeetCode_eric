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

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/zero-matrix-lcci/solution/ling-ju-zhen-by-leetcode-solution-7ogg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
            if(rows[i]||cols[j]){
                matrix[i][j]=0
            }
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
    setZeros(intervals)
    printArr(intervals.toList())

    setZeros2(intervals2)
    printArr(intervals2.toList())
}