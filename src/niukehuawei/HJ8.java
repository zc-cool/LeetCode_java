/**
 * @author zhucheng
 * @create 2021-03-19-22:05
 */
package niukehuawei;

import java.util.*;

/*
题目描述
数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

输入描述:
先输入键值对的个数
然后输入成对的index和value值，以空格隔开

输出描述:
输出合并后的键值对（多行）

示例1
输入
4
0 1
0 2
1 2
3 4
输出
0 3
1 2
3 4
 */
public class HJ8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  //获取键盘输入
        Map<Integer,Integer> map = new TreeMap<>();  //利用TreeMap实现排序

        int num = scanner.nextInt();   //获取输入的行数
        while(scanner.hasNext()){      //一直输入
            for(int i=0; i<num; i++){
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if(map.containsKey(key)){
                    value = map.get(key) + value;
                    map.put(key,value);
                }else{
                    map.put(key,value);
                }
            }

            Set<Map.Entry<Integer,Integer>> set = map.entrySet();
            Iterator<Map.Entry<Integer,Integer>> it = set.iterator();
            while(it.hasNext()){
                Map.Entry<Integer,Integer> entry = it.next();
                System.out.println(entry.getKey()+" "+entry.getValue());
            }

            scanner.close();
        }
    }
}
