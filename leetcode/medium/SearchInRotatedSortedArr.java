/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class SearchInRotatedSortedArr {
    public int search(int[] nums, int target) {
        // Empty array
        if (nums.length == 0) {
            return -1;
        }
        
        int pivot = findPivot(nums);
                
        // Target is the inflection point
        if (target == nums[pivot]) {
            return pivot;
        }
        
        // Try to find start and end of array to do search on
        int start = 0; 
        int end = nums.length - 1;
        if (target <= nums[end]) {
            start = pivot;
        } else if (target >= nums[start]) {
            end = pivot - 1;
        }
        
        // Do binary search for target
        while (end >= start) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) { // Found target
                return mid;
            } else if (nums[mid] > target) { // Move left
                end = mid - 1;
            } else { // Move right
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int findPivot(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (end >= start) {
            int mid = (end + start) / 2;
            
            if (mid - 1 > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            
            if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                return mid + 1;
            }
            
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return 0;
    }
}