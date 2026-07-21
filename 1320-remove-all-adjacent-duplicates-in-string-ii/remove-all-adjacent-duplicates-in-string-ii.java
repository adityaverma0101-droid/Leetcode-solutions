class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(ch,1));
                continue;
            }
            else if(st.peek().ch!=ch){
                st.push(new Pair(ch,1));
                continue;
            }
            else if(st.peek().count<k-1){
                Pair p=st.pop();
                st.push(new Pair(p.ch,p.count+1));
                continue;
            }
            st.pop();
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            Pair p=st.pop();
            while(p.count-- >0){
                res.append(p.ch);
            }
        }
        return res.reverse().toString();

    }
}