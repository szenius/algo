/**
 * https://leetcode.com/problems/generate-parentheses/
 */
class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    
    private void generate(List<String> result, String s, int open, int close, int n) {
        if (open + close == n * 2) {
            result.add(s);
            return;
        }
        
        if (open < n) {
            generate(result, s + "(", open + 1, close, n);
        }
        
        if (close < open) {
            generate(result, s + ")", open, close + 1, n);
        }
    }
}