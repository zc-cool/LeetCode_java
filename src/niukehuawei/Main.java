/**
 * @author zhucheng
 * @create 2021-04-07-16:19
 */
package niukehuawei;

public class Main{
    public static void main(String[] args) {
        Link link = new Link();
        link.insertHead(1);
        link.insertHead(3);
        link.insertHead(8);
        link.insertHead(6);
        link.insertHead(5);
        System.out.println(link.read());
        System.out.println(link.head.data);
        //System.out.println(link.delete(8));
    }
}

class Node{
    int data;
    Node next;
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    public int get(){
        return data;
    }
}

class Link{
    Node head;
    int size;

    //1.插入(尾插法)  需要找到当前链表最末尾节点，进行插入
    public void insert(int data){
        if(head == null){
            head = new Node(data,null);
        }else{
            Node currentNode = findLast(head);
            currentNode.next = new Node(data,null);
        }
        size++;
    }
    //找到链表最末尾节点
    private Node findLast(Node node){
        if(node.next == null) return node;
        return findLast(node.next);
    }

    //2.插入(头插法)  不需要找到当前链表的最开始节点，因为head就是当前头节点
    public void insertHead(int data){
        if(head == null){
            head = new Node(data,null);
        }else{
            Node newNode = new Node(data,null);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    //3.删除元素，返回下标
    public int delete(int data){
        int index = 0;
        //if(head == null) return -1;
        if(head.data == data){
            head = head.next;
            size--;
            return index;
        }

        Node temNode = head;
        while(temNode.next.data != data){
            temNode = temNode.next;
            index++;
        }
        temNode.next = temNode.next.next;
        size--;
        return index;
    }
    //4.删除指定下标的元素，返回删除的元素


    //5.遍历链表
    public String read(){
        StringBuilder sb = new StringBuilder();
        if(head == null) return sb.toString();
        while(head != null){
            sb.append(head.data);
            sb.append(" ");
            head = head.next;
        }
        return sb.toString();
    }

}
