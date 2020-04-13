/**
 * https://leetcode.com/problems/combination-sum/
 * TODO: Optimize with DP
 */

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        generateSolutions(candidates, target, result, new ArrayList<>());
        return new ArrayList<>(result);
    }
    
    private void generateSolutions(int[] candidates, int target, Set<List<Integer>> result, List<Integer> curr) {
        if (target == 0) {
            Collections.sort(curr);
            result.add(curr);
            return;
        }
        
        if (target < candidates[0]) {
            return;
        }
        
        for (int i = 0; i < candidates.length && target >= candidates[i]; i++) {
            List<Integer> newCurr = new ArrayList<>();
            newCurr.addAll(curr);
            newCurr.add(candidates[i]);
            generateSolutions(candidates, target - candidates[i], result, newCurr);
        }
    }
}