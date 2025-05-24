class Solution {

    int max = 0;
    int mod = 1000000007;

public void dfs(int curr, ArrayList<Integer> graph[],boolean vist[],int wid){

    vist[curr] = true;
    for(int i =0;i<graph[curr].size();i++){
        if(!vist[graph[curr].get(i)]){
            dfs(graph[curr].get(i),graph,vist,wid+1);
        }
    }
    max = Math.max(max,wid);
}

 public int pow(int base,int exp){
     int res =1;
     while(exp>0){
         if((exp & 1)!=0){
             res =  (int)((1L*res*base)%mod);        
         }
          exp = exp>>1;
           base = (int)((1L*base*base)%mod);
     }
     return res;
 }

    
    public int assignEdgeWeights(int[][] edges) {


    ArrayList<Integer> graph[] = new ArrayList[edges.length+2];
        for(int i =0;i<edges.length+2;i++){
            graph[i] = new ArrayList<>();
        }


        for(int i =0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(dest);
        
        }
    
   boolean vist[] = new boolean[edges.length+2];
        dfs(1,graph,vist,0);
        System.out.println(max);

return pow(2,max-1);        
    }
}
