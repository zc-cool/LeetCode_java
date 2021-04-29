/**
 * @author zhucheng
 * @create 2021-04-29-10:56
 */
package easy.link;
//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//
//
//
// 示例：
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
//
// Related Topics 链表
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 面试题0203_删除中间节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
