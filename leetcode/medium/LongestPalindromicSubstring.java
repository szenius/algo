/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandFromCenter(s, i, i);
            int length2 = expandFromCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - ((length - 1) / 2);
                end = i + (length / 2);
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}