class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        boolean started=false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) != ' '){
                count++;
                started=true;
            }
            else if(started){
                break;
            }
        }
        return count;
    }
}