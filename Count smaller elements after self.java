class Solution {
    int arr[] ;
    public void merge(int nums[][],int start,int mid,int end){
// what we are basically doing here is that we are appliying mergeSort and trackiing how many  right elements by now have went so far and when the chance for the left el arises ,we are simply adding the right count , whcihgives us the number of elements less than the current element
        int i = start;
        int j = mid+1;
        int temp[][] = new int[end-start+1][2];
        int k =0;
        int rightCount =0;

        while(i<=mid && j<=end){
           if(nums[i][0]<=nums[j][0]){
               arr[nums[i][1]]+=rightCount;
           temp[k][0] = nums[i][0];
           temp[k][1] = nums[i][1];
           k++;
           i++;
           }
           else{
           rightCount++;
             temp[k][0] = nums[j][0];
             temp[k][1] = nums[j][1];
             j++;
             k++;
           }
          
        }

        while(i<=mid){
            arr[nums[i][1]] += rightCount;
          temp[k][0] = nums[i][0];
          temp[k][1] = nums[i][1];
          k++;
          i++;
        }

        while(j<=end){
           temp[k][0] = nums[j][0];
          temp[k][1] = nums[j][1];
          k++;
          j++;
        }

       i = start;
       for( k =0;k<temp.length;k++){
       nums[i][0] = temp[k][0];
       nums[i][1] =temp[k][1];
       i++;
       }

        }

    

    public void mergeSort(int nums[][] ,int start,int end){

        if(start<end){
            int mid = start + (end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }

        return;
    }


    public List<Integer> countSmaller(int[] nums) {

        arr = new int[nums.length];
        int num[][] = new int[nums.length][2];
            for(int i =0;i<nums.length;i++){
                num[i][0] = nums[i];
                num[i][1] = i;
            }
      mergeSort(num,0,nums.length-1);
         List<Integer> list = new ArrayList<>();

         for(int n : arr){
            list.add(n);
         }

        return list;
        
    }
}
