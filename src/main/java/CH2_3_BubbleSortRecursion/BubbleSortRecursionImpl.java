package CH2_3_BubbleSortRecursion;

import CH2_2_BubbleSort.BubbleSortImpl;

public class BubbleSortRecursionImpl {
    public static void bubbleSortRecursion(int[] arr) {
        //每次遞迴要減少的是循環檢查的次數
        int round = 0;
        //bubbleSortRecursionMethod01替換外層迴圈, 內層遞迴需要 round 參數優化每一輪需要遞迴的次數
        bubbleSortRecursionMethod01(arr, round);


    }

    public static void bubbleSortRecursionMethod01(int[] arr, int round){

        if(round > arr.length - 1){
            return;
        }

        /*
        bubbleSortRecursionMethod02(arr, len, i_left)取代:
        for (int i_left = 0; i_left < arr.length - round - 1; i_left++) {
            if (arr[i_left] > arr[i_left + 1]) {
                swap(arr, i_left, i_left + 1);
            }
        }
        */
        int i_left = 0;
        int len = arr.length - round -1;
        //進入外層一次, 跑完所有的內層再跑下一次外層
        //bubbleSortRecursionMethod02替代原本的內層for迴圈, 內層for迴圈需要len優化不同輪需要遞迴的次數
        bubbleSortRecursionMethod02(arr, len, i_left);

        bubbleSortRecursionMethod01(arr, round + 1);
    }

    public static void bubbleSortRecursionMethod02(int[] arr, int length, int i_left){

        if(i_left >= length){
            return;
        }

        if (arr[i_left] > arr[i_left + 1]) {
            swap(arr, i_left, i_left + 1);
        }

        bubbleSortRecursionMethod02(arr, length, i_left + 1);

    }

    private static void swap(int[] arr, int i_left, int i_right) {
        int temp = arr[i_left];
        arr[i_left] = arr[i_right];
        arr[i_right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 6, 10, 4};
        BubbleSortRecursionImpl.bubbleSortRecursion(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
