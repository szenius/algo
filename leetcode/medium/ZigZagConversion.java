/**
 * https://leetcode.com/problems/zigzag-conversion/
 */

class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= 1) {
            return s;
        }
        
        List<StringBuilder> zigZagLines = new ArrayList<>();
        boolean isDown = true;
        int lineIndex = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String currCharString = String.valueOf(s.charAt(i));
            
            if (i < numRows) {
                StringBuilder sb = new StringBuilder();
                sb.append(currCharString);
                zigZagLines.add(lineIndex, sb);
            } else {
                zigZagLines.get(lineIndex).append(currCharString);
            }
            
            if (lineIndex == 0) {
                isDown = true;
            } else if (lineIndex == numRows - 1) {
                isDown = false;
            }
            
            if (isDown) {
                lineIndex++;
            } else {
                lineIndex--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zigZagLines.size(); i++) {
            sb.append(zigZagLines.get(i).toString());
        }
        return sb.toString();
    }
}