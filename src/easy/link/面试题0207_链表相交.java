/**
 * @author zhucheng
 * @create 2021-04-29-17:06
 */
package easy.link;
//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个
//节点是同一节点（引用完全相同），则这两个链表相交。 示例 1： 输入：intersectVal = 8, listA = [4,1,8,4,5], listB
//= [5,0,1,8,4,5], skipA = 2, skipB = 3 输出：Reference of the node with value = 8 输入
//解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4
//,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。 示例 2： 输入：intersectVal = 2, listA = [0
//,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with v
//alue = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
// [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。 示例 3： 输入：intersectVal = 0, listA
// = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [
//2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。 解释：
//这两个链表不相交，因此返回 null。 注意： 如果两个链表没有交点，返回 null 。 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循
//环。 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 Related Topics 链表
// 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 面试题0207_链表相交 {
    /*
    创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
    当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，
    当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
    若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
    想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11}
    和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，
    pB 比 pA 少经过 22 个结点，会先到达尾部。将 pB 重定向到 A 的头结点，
    pA 重定向到 B 的头结点后，pB 要比 pA 多走 2 个结点。因此，它们会同时到达交点。
    如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB 到达链表结尾时，
    记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
    */
    /*
    初看很难理解，但是细想就会发现很简单很巧妙 A和B两个链表长度可能不同，
    但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
    如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点
    如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode node1 = headA, node2 = headB;
        while(node1 != node2){
            if(node1 != null){
                node1 = node1.next;
            }else{
                node1 = headB;
            }

            if(node2 != null){
                node2 = node2.next;
            }else{
                node2 = headA;
            }
        }
        return node1;
    }
}
