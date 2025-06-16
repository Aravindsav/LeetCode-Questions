class Solution {
    public int minInsertions(String s) {
        
        int dp[][] = new int[s.length()][s.length()];
     

        for(int i=0;i<s.length()-1;i++){
            int j =i+1;
            if(s.charAt(i)!=s.charAt(j)){
                dp[i][j]=1;
            }
        }
        for(int len =3;len<=s.length();len++){
            for(int i =0;i<=s.length()-len;i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]= dp[i+1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
