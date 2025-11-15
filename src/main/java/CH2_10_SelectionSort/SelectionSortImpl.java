package CH2_10_SelectionSort;

public class SelectionSortImpl {

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = i;
            //確保至少有兩個數能做比較
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }

            }
            swap(nums, i, maxIndex);
        }
    }

    private static void swap(int[] nums, int iLeft, int iRight) {
        int temp = nums[iLeft];
        nums[iLeft] = nums[iRight];
        nums[iRight] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 6, 10, 12};
        selectionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
