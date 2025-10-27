package CH2_6_InsertionSort;

public class InsertionSortImpl {
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

    private static void swap(int[] nums, int iLeft, int iRight) {
        int temp = nums[iLeft];
        nums[iLeft] = nums[iRight];
        nums[iRight] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,2,3,4,15,6,37,9};
        insertionSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
