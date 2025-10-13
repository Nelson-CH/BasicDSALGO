package CH1_4_Array;

import java.util.Arrays;

public class Array_Impl1 {
    private Integer[] array;
    private Integer i_end;

    public Array_Impl1(int size) {
        array = new Integer[size];
        i_end = -1;
    }

    public void add_by_index(int i_add, int value) {
        if (i_end +1 == array.length) expand_space();

        if (i_add > i_end + 1 || i_add < 0) return;

        for (int i = i_end; i >= i_add; i--) {
            array[i + 1] = array[i];
            array[i] = null;
        }

        array[i_add] = value;
        i_end++;
    }

    public void add_by_value(int value) {
        add_by_index(i_end + 1, value);
    }

    public Integer search_by_index(int index) {
        if (index > i_end || index < 0) return null;
        return array[index];
    }

    public Integer search_by_value(int value) {
        for (int i = 0; i <= i_end; i++) {
            if(array[i].equals(value)) return i;
        }
        return null;
    }

    public void remove_by_index(int index) {
        if (index > i_end || index < 0) return;
        array[index] = null;

        for (int i = index + 1; i <= i_end; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }

        i_end--;
    }

    public void remove_by_value(int value) {
        for (int i = 0; i <= i_end; i++) {
            if(array[i] == value) {
                remove_by_index(i);
                return;
            }
        }
    }

    private void expand_space(){
        Integer[] array_new = new Integer[array.length * 2];
        for(int i = 0 ; i < array.length ; i++){
            array_new[i] = array[i];
        }
        this.array = array_new;
    }

    @Override
    public String toString() {
        return "Array_Impl3{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        Array_Impl1 myarray = new Array_Impl1(5);

        myarray.add_by_value(9);
        myarray.add_by_value(11);
        myarray.add_by_value(2);
        myarray.add_by_value(98);
        myarray.add_by_value(35);
        myarray.add_by_value(66);
        System.out.println(myarray);
        myarray.add_by_index(2, 6);
        System.out.println(myarray);
        System.out.println(myarray.search_by_index(2));
        System.out.println(myarray.search_by_value(2));
        myarray.remove_by_index(2);
        System.out.println(myarray);
        myarray.remove_by_value(2);
        System.out.println(myarray);
    }
}
