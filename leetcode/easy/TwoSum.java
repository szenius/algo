/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementsToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementsToIndices.containsKey(complement)) {
                return new int[]{complementsToIndices.get(complement), i};
            } else {
                complementsToIndices.put(nums[i], i);
            }
        }
        return null;
    }
}