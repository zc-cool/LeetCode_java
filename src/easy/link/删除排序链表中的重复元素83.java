/**
 * @author zhucheng
 * @create 2021-04-28-14:20
 */
package easy.link;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序排列
//
// Related Topics 链表
// 👍 567 👎 0
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
public class 删除排序链表中的重复元素83 {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while(current != null){
            while(current.next != null && current.val == current.next.val){
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }

    /*
     *双指针比较
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head, q=head;
        while(p != null && q != null){
            if(p.val == q.val){
                p.next = q.next;
            }else{
                p=p.next;
            }
            q=q.next;
        }
        return head;
    }
}
