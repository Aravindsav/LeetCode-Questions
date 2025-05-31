class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        int max =1;
    HashSet<Integer> set = new HashSet<>();
    for(int num : nums){
        set.add(num);
    }
    for(int i =0;i<nums.length;i++){
        int num = nums[i];
        int count =1;
        while(set.contains(--num)){
            count++;
            set.remove(num);
        }
        num = nums[i];
        while(set.contains(++num)){
            count++;
            set.remove(num);
        }

        max = Math.max(count,max);
    }

        return max;
    }
}
