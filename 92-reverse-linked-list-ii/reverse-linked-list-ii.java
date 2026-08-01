class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        ListNode t=head;
        ListNode before=null;
        int pos=1;
        //Move to left
        while(pos<left){
            before=t;
            t=t.next;
            pos++;
            continue;
        }
        ListNode curr=t;
        ListNode prev=null;
        int times=right-left+1;
        //reverse nodes
        while(times-->0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //connect last part
        t.next=curr;
        //connect first part
        if(before!=null){
            before.next=prev;
            return head;
        }
        return prev;
    }
}