class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
// The map is used for storing the neighbours of each number
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i =0;i<adjacentPairs.length;i++){
            int num1 = adjacentPairs[i][0];
            int num2 = adjacentPairs[i][1];
            if(!map.containsKey(num1)){
                map.put(num1,new ArrayList<>());
            }
            if(!map.containsKey(num2)){
                map.put(num2,new ArrayList<>());
            }
            map.get(num1).add(num2);
            map.get(num2).add(num1);
        }
        int start =0;
        // Findign the start of the array;
       for(Integer key : map.keySet()){
        if(map.get(key).size()==1){
            start = key;
            break;
        }
       }
       int arr[] = new int[map.size()];
       arr[0]= start;
       // Apply dfs to the array;
       for(int i =1;i<arr.length;i++){
        int prev = arr[i-1];
        List<Integer> list = map.get(prev);
        
        arr[i] = list.size()==1? list.get(0): arr[i-2] == list.get(0)? list.get(1):list.get(0);
       }

       return arr;
    }
}
