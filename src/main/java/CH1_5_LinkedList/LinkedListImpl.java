package CH1_5_LinkedList;

public class LinkedListImpl {

    static class Node {
        Integer value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //指標, 開始位置
    private Node head;
    //指標, 結束位置
    private Node tail;

    public LinkedListImpl() {}

    public void add(int value) {
        if (head == null) {
            //目前鍊表為空, 開始位置跟結束位置都是新增的 node
            head = new Node(value);
            tail = head;
        }else {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    public Integer search(int value) {
        if (head == null) return null;

        Node current = head;
        while(true){
            if(current.value == value) return current.value;
            current = current.next;
        }

    }

    public void remove(int value) {
        //鍊表起始節點
        Node node = head;
        //要被刪除的節點
        Node target = null;
        //當要刪除的節點是中間的節點時, 用來記錄被刪除的節點的前一個節點
        Node prev = null;
        //尋找節點
        while(true){
            //如果是空串列
            if(node == null) break;
            //如果要刪除的是第一個節點
            if(node.value == value) {
                target = node;
                break;
            }

            prev = node;
            node = node.next;
        }
        //刪除節點
        if(target == null) return;
        if(target == head){
            head = head.next;
            if(head == null) tail = null;
        }else {
            prev.next = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        System.out.println("-------");
        for (Node i = list.head; i != null; i = i.next) {
            System.out.println(i.value);
        }
        System.out.println("-------");
        System.out.println(list.search(5));
        System.out.println("-------");
        list.remove(5);

        for (Node i = list.head; i != null; i = i.next) {
            System.out.println(i.value);
        }
    }
}
