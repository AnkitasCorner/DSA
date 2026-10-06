class Solution {
    public int minAddToMakeValid(String s) {
        int openNeed = 0;
        int closeNeed = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                closeNeed++;
            } else {
                if (closeNeed > 0) {
                    closeNeed--;
                } else {
                    openNeed++;  
                }
            }
        }
        return openNeed + closeNeed;
    }
}