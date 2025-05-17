class Solution {
    public int minimumSum(int[] nums) {

        int min =Integer.MAX_VALUE;
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for(int i =1;i<nums.length;i++){
            left[i] = Math.min(nums[i],left[i-1]);
        }
        for(int j =nums.length-2;j>=0;j--){
            right[j] = Math.min(nums[j],right[j+1]);
        }

        for(int i =1; i<nums.length-1;i++){
            if(nums[i]>left[i-1] && nums[i] > right[i+1]){
                min = Math.min(min,left[i]+right[i]+nums[i]);
            }
        }

        return min==Integer.MAX_VALUE? -1:min;
    }
}
