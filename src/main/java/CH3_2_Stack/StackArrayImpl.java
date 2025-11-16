package CH3_2_Stack;

public class StackArrayImpl {

    Integer[] stack;
    //紀錄陣列索引號, 必須以 null 表示沒有值才用 Integer
    int iTop = -1; // LIFO

    public StackArrayImpl() {
        this.stack = new Integer[10];
    }

    public StackArrayImpl(Integer[] array) {
        this.stack = new Integer[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            this.stack[i] = array[i];
            this.iTop++;
        }
    }

    public void push(Integer integer) {
        if (size() == stack.length) {
            expandSpace();
        }

        iTop ++;
        stack[iTop] = integer;
    }

    private void expandSpace() {
        Integer[] stack_new = new Integer[stack.length * 2];
        System.arraycopy(stack, 0, stack_new, 0, stack.length);
        this.stack = stack_new;
    }
    //陣列中元素個數
    public int size() {
        return iTop + 1;
    }

    public Integer pop() {
        if (size() == 0) {
            return null;
        }

        Integer val = stack[iTop];
        stack[iTop] = null;

        iTop--;

        return val;
    }

    public Integer get(int index) {
        if (index < 0 || index > iTop) {
            return null;
        }
        return stack[index];
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        StackArrayImpl stackArray = new StackArrayImpl(nums);
        for (int i = 0; i < stackArray.size(); i++) {
            System.out.println(stackArray.get(i));
        }
        System.out.println("---------------------------------------------");
        // full - extend the storage size
        stackArray.push(6);

        for (int i = 0; i < stackArray.size(); i++) {
            System.out.println(stackArray.get(i));
        }

        System.out.println("---------------------------------------------");

        while (stackArray.size() > 0) {
            System.out.println(stackArray.pop());
        }
    }

}
