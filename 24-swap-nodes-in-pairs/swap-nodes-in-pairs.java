class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        int size=2;
        ListNode left=head;
        ListNode res=null;
        ListNode prevLeft=null;
        ListNode right=null;
        while(true){
            right=left;
            for(int i=0;i<size-1;i++){
                if(right==null){
                    break;
                }
                right=right.next;

            }
            if(right!=null){
                ListNode nextLeft=right.next;
                reverse(left,2);
                if(prevLeft!=null){
                    prevLeft.next=right;
                }
                prevLeft=left;
                if(res==null){
                    res=right;
                }
                left=nextLeft;
            }
            else{
                if(prevLeft!=null){
                    prevLeft.next=left;
                }
                if(res==null){
                    res=left;
                }
                break;
            }
        }
        return res;
    }
    private void reverse(ListNode head, int size) {

        ListNode prev = null;
        ListNode curr = head;

        while (size > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size--;
        }

        head.next = curr;
    }
}
