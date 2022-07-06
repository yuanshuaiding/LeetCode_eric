package com.eric.leetcode.array

/**
给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

示例 1：

输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.

示例2：

输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/middle-of-the-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun main() {
    //构造单链表
    val head = ListNode(1)
    var temp = head
    for (i in 1..5) {
        val next = ListNode(i + 1)
        temp.next = next
        temp = next
    }

    temp = head

    while (temp.next != null) {
        println(temp.value)
        temp = temp.next!!
        if (temp.next == null) {
            println(temp.value)
        }
    }

    /*
        虑借助快慢双指针 fast, slow ，「快指针 fast」每轮走 2 步，「慢指针 slow」每轮走 1 步。fast 的步数恒为 slow 的 2 倍，因此当快指针遍历完链表时，慢指针就指向链表中间节点。而由于长度为偶数的链表有两个中间节点，因此需要分两种情况考虑：

        链表长度为奇数： 当 fast 走到链表「尾节点」时，slow 正好走到「中间节点」。
        链表长度为偶数： 当 fast 走到「null」时（越过「尾节点」后），slow 正好走到「第二个中间节点」。
        总结以上规律，应在当 fast 遇到或越过尾节点 时跳出循环，并返回 slow 即可。

        作者：jyd
        链接：https://leetcode.cn/problems/middle-of-the-linked-list/solution/by-jyd-aphd/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    println(slow?.value)
}