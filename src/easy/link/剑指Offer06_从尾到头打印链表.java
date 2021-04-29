/**
 * @author zhucheng
 * @create 2021-04-29-11:16
 */
package easy.link;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 剑指Offer06_从尾到头打印链表 {
    //使用栈，将遍历的链表值存储在栈内
    //再将栈的元素pop出，存在数组中即可。
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            ans[index] = stack.pop();
            index++;
        }
        return ans;
    }
}
