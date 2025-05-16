class Solution {

public class Info{
    char ch;
    int freq;
    Info(char ch ,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}


    public String removeDuplicates(String str, int k) {
        
       
       Stack<Info> s = new Stack<>();
       int i =0;
       while(i<str.length()){
        char ch = str.charAt(i);
        if(s.isEmpty() || (s.peek().ch != ch)){
            s.push(new Info(ch,1));
        }
        else if(s.peek().ch==ch){
            s.peek().freq++;
            if(s.peek().freq == k){
                s.pop();
            }
        }
      i++;
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            char ch  = s.peek().ch;
            int  freq = s.peek().freq;
            s.pop();
            for( i =0;i<freq;i++){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}
