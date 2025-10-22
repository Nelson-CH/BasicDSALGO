package CH2_2_BubbleSort;

public class BubbleSortImpl {
    //接收要傳入進行氣泡排序的陣列
    public static void bubbleSort(int[] arr) {
        //總共要跑的輪數, 就是元素個數
        for (int i_round = 0; i_round < arr.length - 1; i_round++) {
            //每輪從第一個開始往後比, 每跑過一輪都可以確定一個位子, 避免重複的比較
            for (int j_left = 0; j_left < arr.length - i_round - 1; j_left++) {
                if (arr[j_left] > arr[j_left + 1]) {
                    swap(arr, j_left, j_left + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i_left, int i_right) {
        int temp = arr[i_left];
        arr[i_left] = arr[i_right];
        arr[i_right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 6, 10, 4};
        BubbleSortImpl.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
