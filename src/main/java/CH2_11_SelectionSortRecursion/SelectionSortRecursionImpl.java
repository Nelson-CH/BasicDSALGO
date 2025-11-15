package CH2_11_SelectionSortRecursion;

public class SelectionSortRecursionImpl {

    public static void selectionSortRecursion(int[] nums){
        int i = 0;
        selectionSortRecursionHelp1(nums, i);
    }

    private static void selectionSortRecursionHelp1(int[] nums, int i) {

        if(i >= nums.length - 1){
            return;
        }

        int maxIndex = i;
        int j = i + 1;
        maxIndex = selectionSortRecursionHelp2(nums, maxIndex, j);
        swap(nums, i, maxIndex);
        selectionSortRecursionHelp1(nums, i + 1);
    }

    private static int selectionSortRecursionHelp2(int[] nums, int maxIndex, int j) {

        if(j >= nums.length){
            return maxIndex;
        }

        if (nums[j] > nums[maxIndex]) {
            maxIndex = j;
        }

        return selectionSortRecursionHelp2(nums, maxIndex, j+1);
    }

    private static void swap(int[] nums, int iLeft, int iRight) {
        int temp = nums[iLeft];
        nums[iLeft] = nums[iRight];
        nums[iRight] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 6, 10, 12};
        selectionSortRecursion(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
