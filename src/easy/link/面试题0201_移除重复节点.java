/**
 * @author zhucheng
 * @create 2021-04-29-10:40
 */
package easy.link;
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 链表
// 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 面试题0201_移除重复节点 {
    //解答成功: 使用数组标记元素的值是否出现过
    //执行耗时:2 ms,击败了98.47% 的Java用户
    //内存消耗:41.2 MB,击败了5.02% 的Java用户
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) return head;

        boolean[] flag = new boolean[20001];
        flag[head.val] = true;

        ListNode ans = head, cur = head.next;
        while(head != null && cur != null){
            if(flag[cur.val]){
                head.next = cur.next;
            }else{
                flag[cur.val] = true;
                head = head.next;
            }
            cur = cur.next;
        }
        return ans;
    }

    //解答成功: 使用集合
    //执行耗时:847 ms,击败了5.15% 的Java用户
    //内存消耗:40.2 MB,击败了10.65% 的Java用户
    public ListNode removeDuplicateNodes2(ListNode head) {
        if(head == null) return head;

        List<Integer> list = new ArrayList<>();
        list.add(head.val);

        ListNode ans = head, cur = head.next;
        while(head != null && cur != null){
            if(list.contains(cur.val)){
                head.next = cur.next;
                cur = cur.next;
            }else{
                list.add(cur.val);
                head = head.next;
                cur = cur.next;
            }
        }
        return ans;
    }
}
