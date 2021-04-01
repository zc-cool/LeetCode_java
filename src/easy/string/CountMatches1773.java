/**
 * @author zhucheng
 * @create 2021-03-31-9:33
 */
package easy.string;

import java.util.List;

//给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
//
// 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
//
// 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
//
//
// ruleKey == "type" 且 ruleValue == typei 。
// ruleKey == "color" 且 ruleValue == colori 。
// ruleKey == "name" 且 ruleValue == namei 。
//
//
// 统计并返回 匹配检索规则的物品数量 。
//
//
//
// 示例 1：
//
//
//输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","
//gold","iphone"]], ruleKey = "color", ruleValue = "silver"
//输出：1
//解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
//
//
// 示例 2：
//
//
//输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","g
//old","iphone"]], ruleKey = "type", ruleValue = "phone"
////输出：2
//解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"]
//。注意，["computer","silver","phone"] 未匹配检索规则。
//
//
//
// 提示：
//
//
// 1 <= items.length <= 104
// 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
// ruleKey 等于 "type"、"color" 或 "name"
// 所有字符串仅由小写字母组成
//
// Related Topics 数组 字符串
// 👍 7 👎 0
public class CountMatches1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            List<String> eleList = items.get(i);
            if(ruleKey.equals("type") && eleList.get(0).equals(ruleValue)) count++;
            if(ruleKey.equals("color") && eleList.get(1).equals(ruleValue)) count++;
            if(ruleKey.equals("name") && eleList.get(2).equals(ruleValue)) count++;
        }
        return count;
    }
}
