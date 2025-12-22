package CH3_4_StackList;

public class StackListImpl {
    static class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }

    Integer[] ary;
    Node node_top;

    public StackListImpl() {}

    public StackListImpl(Integer[] ary) {
        this.ary = ary;
    }

    public void buildStack() {
        for (int i = 0; i < ary.length; i++) {
            push(ary[i]);
        }
    }

    public void push(Integer value) {
        if (node_top == null) {
            node_top = new Node(value);
        }else {
            Node newNode = new Node(value);
            newNode.next = node_top;
            node_top = newNode;
        }
    }

    public Integer pop() {
        if (node_top == null) {
            return null;
        }

        Integer val = node_top.val;
        node_top = node_top.next;
        return val;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        StackListImpl stack = new StackListImpl(nums);
        stack.buildStack();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(stack.pop());
            System.out.println("-------------------------");
        }
    }
}
