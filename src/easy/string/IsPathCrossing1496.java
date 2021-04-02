/**
 * @author zhucheng
 * @create 2021-04-01-13:09
 */
package easy.string;

import java.util.ArrayList;
import java.util.List;

//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
//
// 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
//
// 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
//
//
//
// 示例 1：
//
//
//
// 输入：path = "NES"
//输出：false
//解释：该路径没有在任何位置相交。
//
// 示例 2：
//
//
//
// 输入：path = "NESWW"
//输出：true
//解释：该路径经过原点两次。
//
//
//
// 提示：
//
//
// 1 <= path.length <= 10^4
// path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
//
// Related Topics 字符串
// 👍 21 👎 0
public class IsPathCrossing1496 {
    /*
    思路：
        使用list集合记录走过的路程。每次存储都判断，如果集合中存在，说明走到重复地点。否则添加进集合
     */
    public boolean isPathCrossing(String path) {
        int[] start = new int[2];
        List<String> list = new ArrayList<>();
        list.add("00");  //走过的位置以"start[0]start[1]"形式字符串记录。原点位置加到集合中
        //遍历字符串路径指令
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c){
                case 'N':
                    start[1]++;
                    break;
                case 'S':
                    start[1]--;
                    break;
                case 'E':
                    start[0]++;
                    break;
                case 'W':
                    start[0]--;
                    break;
            }
            String s = String.valueOf(start[0]) + String.valueOf(start[1]);
            if(list.contains(s)){
                return true;
            }else{
                list.add(s);
            }
        }
        return false;
    }
}
