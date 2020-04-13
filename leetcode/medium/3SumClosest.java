/**
 * https://leetcode.com/problems/3sum-closest/
 */
class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closestSum = 0;
        boolean updated = false;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < nums.length && j < k) {
                int sum = nums[i]+ nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (!updated || Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                    updated = true;
                }
                if (sum > target) {
                    k--;
                    while (k >= 0 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        
        return closestSum;
    }
}