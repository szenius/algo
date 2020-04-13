/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> lastSeenIndexOfChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int lastSeenIndex = lastSeenIndexOfChar.getOrDefault(s.charAt(i), -1);
            if (lastSeenIndex >= start) {
                maxLength = Math.max(end - start, maxLength);
                start = lastSeenIndex + 1;
            }
            lastSeenIndexOfChar.put(s.charAt(i), i);
            end++;
        }
        return Math.max(maxLength, end - start);
    }
}