/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinations {
    public static final List<String> buttons = new ArrayList<>(
        Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    );
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        generate(digits, "", result);
        return result;
    }
    
    private void generate(String digits, String curr, List<String> result) {
        if (digits.length() == 0) {
            if (!curr.isEmpty()) {
                result.add(curr);
            }
            return;
        }
       
        int currDigit = Integer.parseInt(digits.substring(0, 1));
        String buttonString = buttons.get(currDigit - 2);
        for (int i = 0; i < buttonString.length(); i++) {
            String newString = curr + buttonString.substring(i, i + 1);
            generate(digits.substring(1), newString, result);
        }
    }
}