class Solution {


    int max =0;
    public void maximumRecatanglein1D(int arr[]){
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
      
        for(int i =0;i<arr.length;i++){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
            s.pop();
            }
            if(s.isEmpty()){
                left[i] =-1;
            }
            else{
                left[i] = s.peek();
            }
            s.push(i);
        }
  s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i]= arr.length;
            }
            else{
                right[i] = s.peek();
            }
            s.push(i);
        }
        int m =0;
     
        for(int i =0;i<arr.length;i++){
            int height= arr[i];
            int width = right[i]-left[i]-1;
            m = Math.max(m,height*width);
        }

max = Math.max(max,m);


    }

    public int maximalRectangle(char[][] matrix) {
 
int arr[] = new int[matrix[0].length];
for(int j =0;j<matrix[0].length;j++){
    arr[j]= matrix[0][j] -'0';
}

    maximumRecatanglein1D(arr);

    for(int i=1;i<matrix.length;i++){
        for(int j =0;j<matrix[0].length;j++){
            if(matrix[i][j]=='0'){
                arr[j]=0;
            }
            else{
                arr[j]+=1;
            }
        }
        
          maximumRecatanglein1D(arr);
    }
        return max;
    }
}
