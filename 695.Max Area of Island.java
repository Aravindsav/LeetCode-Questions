class Solution {

    int max =0;

    public int dfs(int arr[][],int row,int col){

        if(  row<0 || col<0 || row==arr.length || col==arr[0].length|| arr[row][col]==0 ){
            return 0;
        }
        arr[row][col]=0;
     return  1+ dfs(arr,row+1,col)+ dfs(arr,row-1,col)+ dfs(arr,row,col+1)+ dfs(arr,row,col-1);

    }

    public int maxAreaOfIsland(int[][] grid) {
        

        for(int i=0;i<grid.length;i++){

            for(int j =0;j<grid[0].length;j++){

                    if(grid[i][j]==1){
                        int count = dfs(grid,i,j);
                        max = Math.max(max,count);
                    }

            }
        }

return max;
    }
}
