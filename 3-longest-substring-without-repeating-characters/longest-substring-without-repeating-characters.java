class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] lastSeen = new int [128];
        java.util.Arrays.fill(lastSeen,-1);
        int maxLength = 0;
        int left = 0;

        for(int r=0; r<s.length(); r++){
            char currChar= s.charAt(r);
            if(lastSeen[currChar]>=left){
                left = lastSeen[currChar]+1;
            }
            lastSeen[currChar] = r;
            maxLength =Math.max(maxLength, r-left+1);
        }
        return maxLength;
    }
}