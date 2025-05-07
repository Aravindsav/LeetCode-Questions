class Solution {
    public char findTheDifference(String s, String t) {
        int ans =0;

        for(int i =0;i<s.length();i++){
            ans^= s.charAt(i);
            ans^=t.charAt(i);
        }

        return (char)(ans^t.charAt(s.length()));
        
    }
// Whenever we are given two substrings adn we need to find the different element among them ,just do xor of all the characters and then you will get the ans .
}