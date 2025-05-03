class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i =0;i<Math.min(k,matrix.length);i++){
            pq.add(new int[]{matrix[i][0],i,0});
        }
        int count =0;
        while(!pq.isEmpty()){
            int curr[] = pq.remove();
            int row = curr[1];
            int col = curr[2];
            count++;
            if(count==k){
                return curr[0];
            }
            if(curr[2]<matrix.length-1){
                pq.add(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return -1;
    }
}