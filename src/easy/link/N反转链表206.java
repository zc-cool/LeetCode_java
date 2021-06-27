/**
 * @author zhucheng
 * @create 2021-04-29-14:48
 */
package easy.link;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 链表
// 👍 1713 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class N反转链表206 {
    //方法1：相当于将原链表的每个节点都复制一遍，进行头插法 （有待改进）
    //必须使用ListNode ans = new ListNode(head.val);
    //而不能使用ListNode ans = head;
    //防止存在环
    public ListNode reverseList1(ListNode head) {
        if(head == null) return head;

        ListNode ans = new ListNode(head.val);

        head = head.next;
        while(head != null){
            ListNode tem = new ListNode(head.val);
            tem.next = ans;
            ans = tem;
            head = head.next;
        }
        return ans;
    }

    //方法2：直接在原链表上进行反转，注意，没有出现环（原来的指针全部反转）
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }
}
