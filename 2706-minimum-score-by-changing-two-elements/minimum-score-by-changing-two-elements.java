class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
    // Can always change the number to any other number in `nums`, so `low` becomes 0.
    // Thus, rephrase the problem as finding the minimum `high`.
    int n = nums.length;
     int highOfChangingTwoMins = nums[n - 1] - nums[2];
     int highOfChangingTwoMaxs = nums[n - 3] - nums[0];
     int highOfChangingMinAndMax = nums[n - 2] - nums[1];
    return Math.min(Math.min(highOfChangingTwoMins, highOfChangingTwoMaxs),
                    highOfChangingMinAndMax);
    }
}