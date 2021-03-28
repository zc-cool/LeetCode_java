/**
 * @author zhucheng
 * @create 2021-03-25-10:07
 */
package easy.array;

import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String sNum = scanner.nextLine();  //n为行数
        int row = Integer.parseInt(sNum);

        while(scanner.hasNext()) {
            for (int i = 0; i < row; i++) {
                String str = scanner.nextLine();
                String[] s = str.split(" ");
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j < s.length; j++) {
                    int ele = Integer.parseInt(s[j]);
                    list.add(ele);
                }

                List<Integer> list1 = list;

                int tem = list.get(0);
                for(int j=0; j<list.size(); j++){
                    int element = list.get(j);
                    if(tem >= element){
                        list.add(element);
                        list.remove(j);
                        tem = element;
                        continue;
                    }else{
                        break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for(int k=0; k<list.size(); k++){
                    sb.append(list.get(k));
                }

                Collections.sort(list1);
                Collections.reverse(list1);
                StringBuilder sb1 = new StringBuilder();
                for(int n=0 ; n<list1.size(); n++){
                    sb1.append(list.get(n));
                }


                if(sb.toString().equals(sb1.toString())){
                    System.out.println("Y");
                }else {
                    System.out.println("N");
                }
            }
        }
    }
}
