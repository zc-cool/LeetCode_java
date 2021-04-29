/**
 * @author zhucheng
 * @create 2021-04-27-17:13
 */
package easy.link;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1687 👎 0
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
public class 合并两个有序链表21 {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode tail = header;
        ListNode tem = null;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tem = l1;
                l1 = l1.next;
            }else{
                tem = l2;
                l2 = l2.next;
            }
            tail.next = tem;
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return header.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode tail = header;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return header.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode header = l1.val <= l2.val ? l1 : l2;
        ListNode node1 = header.next;
        ListNode node2 = header == l1 ? l2 : l1;
        ListNode index = header;

        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                index.next = node1;
                node1 = node1.next;
            }else{
                index.next = node2;
                node2 = node2.next;
            }
            index = index.next;
        }
        index.next = node1 == null ? node2 : node1;
        return header;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果一个链表为空，返回另外一个
        if(l1 != null || l2 != null){
            return l1 == null ? l2 : l1;
        }
        //小的成为头节点
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

