/**
 * https://leetcode.com/problems/4sum/
 */
class 4Sum {
    // -2 -1 0 0 1 2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int m = nums.length - 1;
                while (k < nums.length && k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    
                    if (sum == target) {
                        result.add(packQuadruplets(nums[i], nums[j], nums[k], nums[m]));
                    }
                    
                    if (sum < target) {
                        k++;
                        while (k < nums.length && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else {
                        m--;
                        while (m > 0 && nums[m] == nums[m + 1]) {
                            m--;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private List<Integer> packQuadruplets(int q1, int q2, int q3, int q4) {
        List<Integer> result = new ArrayList<>();
        result.add(q1);
        result.add(q2);
        result.add(q3);
        result.add(q4);
        return result;
    }
}