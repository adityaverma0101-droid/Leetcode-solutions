class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> f=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            f.put(ch,f.getOrDefault(ch,0)+1);
        }
        boolean odd=false;
        int res=0;
        for(Map.Entry<Character,Integer> entry:f.entrySet()){
            int value=entry.getValue();
            if(value%2==0){
                res+=value;
            }
            else{
                res+=value-1;
                odd=true;
            }
        }
        if(odd){
            return res+1;
        }
        return res;
    }
}