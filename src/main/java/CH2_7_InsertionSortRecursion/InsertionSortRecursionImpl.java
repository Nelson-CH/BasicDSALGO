package CH2_7_InsertionSortRecursion;

public class InsertionSortRecursionImpl {
    /*
    public static  void insertionSort(int[] nums) {
        //外層是要比幾輪
        for (int iStart = 0; iStart < nums.length ; iStart++) {
            //內層是每一輪的元素要往左比直到最左邊一位
            for (int jStart = iStart - 1; jStart >= 0; jStart--) {
                if (nums[jStart + 1] > nums[jStart]) {
                    swap(nums, jStart+1, jStart);
                }else{
                    //左側都是比好大小的, 如果比較的過程中當前元素沒有比左邊一個元素大就可以直接跳出內層迴圈, 就不用比到左邊最後一個元素了
                    break;
                }
            }
        }
    }
    */

    public static  void insertionSortRecurSion(int[] nums) {

        int iStart = 0;

        insertionSortRecurSionHelp01(nums, iStart);

    }

    private static void insertionSortRecurSionHelp01(int[] nums, int iStart) {

        if (iStart > nums.length - 1) {
            return;
        }

        int jStart = iStart - 1;

        insertionSortRecurSionHelp02(nums, jStart);

        insertionSortRecurSionHelp01(nums, iStart+1);

    }

    private static void insertionSortRecurSionHelp02(int[] nums, int jStart) {

        if (jStart < 0) {
            return;
        }

        if (nums[jStart + 1] > nums[jStart]) {
            swap(nums, jStart+1, jStart);
        }else{
            //省下交換成本
            return;
        }

        insertionSortRecurSionHelp02(nums, jStart - 1);

    }

    private static void swap(int[] nums, int iLeft, int iRight) {

        int tmp = nums[iLeft];
        nums[iLeft] = nums[iRight];
        nums[iRight] = tmp;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{8, 2, 6, 1, 4};
        insertionSortRecurSion(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
