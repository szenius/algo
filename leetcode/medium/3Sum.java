/**
 * https://leetcode.com/problems/3sum/
 */
class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort nums
        Arrays.sort(nums);
        
        // For each element in nums, treat as the first number in triplet
        // Do a bi-directional sweep from the index after first and the last index to find
        //      second and third such that second + third = 0 - first
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            
            int target = 0 - nums[first];
            int second = first + 1;
            int third = nums.length - 1;
            
            while (second < third) {
                int attempt = nums[third] + nums[second];
                if (attempt == target) {
                    addResult(result, nums[first], nums[second], nums[third]);
                    second++;
                    third--;
                    while(third > second && nums[third] == nums[third + 1]) {
                        third--;
                    }
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                } else if (attempt > target) {
                    third--;
                } else {
                    second++;
                }
            }  
        }
        
        return result;    
    }
    
    private void addResult(List<List<Integer>> result, int first, int second, int third) {
        List<Integer> newResult = new ArrayList<>();
        newResult.add(first);
        newResult.add(second);
        newResult.add(third);
        result.add(newResult);
    }
}