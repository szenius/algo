/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}