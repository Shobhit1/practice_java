package Problems;

public class LinkedListHeadMerge {

    private static NodeList insert(NodeList head, int data) {

        NodeList node1 = new NodeList();
        node1.data = data;
        node1.next = null;

        // System.out.println(node1);

        NodeList headTemp = head;

        if (head == null) {
            head = node1;
            return head;
        } else {
            while (head != null) {
                if (head.next == null) {
                    head.next = node1;
                    return headTemp;
                }
                head = head.next;
            }
            return headTemp;
        }
    }

    public static int findMiddleElement(NodeList head) {

        NodeList temp = head;
        // System.out.println("**"+head.data);
        while (temp != null && temp.next != null) {
            head = head.next;
            temp = temp.next.next;
            // System.out.println(head.data);
        }
        return head.data;
    }

    public static NodeList insertAtStart(NodeList head, int data) {

        NodeList node = new NodeList(data);

        if (head == null) {
            head = node;
            return head;
        } else {
            // System.out.println("=="+head);
            // System.out.println("==" + node);
            node.next = head;
            // System.out.println("--><><" + node);
            return node;

        }

    }

    static NodeList reverseLinkedList(NodeList head){
        NodeList prev = null;
        NodeList current = head;
        NodeList next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    static int getNth(NodeList head, int n) {
        int count = 0;
        while (head != null && head.next != null) {
            if(count == n){
                return head.data;
            }
            head = head.next;
            count++;
        }
        return -1;
    }
    
    /**
     *  find kth list node
     * @param head
     * @return
     */
    
    static NodeList nthToList(NodeList head, int k){
        if(k<=0) return null;
        
        NodeList pointer1 = head;
        NodeList pointer2 = head;
        
        for(int i=0; i<k-1; i++){
            if(pointer2 == null) {
                return null;
            }
            pointer2 = pointer2.next;
        }
        
         if(pointer2 == null) return null;
         
         while(pointer2.next != null){
             pointer1 = pointer1.next;
             pointer2 = pointer2.next;
         }
         
         return pointer1;
    }
    
    
    
    // Partition the linked list at pivot x
    
//    static NodeList partition(NodeList head, int x){
//        NodeList firstStart = null;
//        NodeList firstEnd = null;
//        
//        NodeList secondfirst = null;
//        NodeList secondEnd = null;
//        
//        while(head != null){
//            NodeList next = head.next;
//            
//            head.next = null;
//            
//        }
//    }
    
    
    public static NodeList insertNth(NodeList head, int data, int position) {

        NodeList node1 = new NodeList();
        node1.data = data;
        node1.next = null;

        NodeList prev=null;   //Pointer to the previous node
        NodeList curr = head;
        int count = 0;
        while (curr.next != null) {
            count++;
            prev = curr;
            curr = curr.next;
            if (prev.next == null) {
                node1.next = head;
                head = node1;
            } else {
                node1.next = curr;
                prev.next = node1;
            }
        }
        return head;
    }

    public static NodeList delete(NodeList head, int position) {

        // System.out.println("---->>>"+ position);
        if (position == 0) {
            head = head.next;
            return head;
        } else {
            // System.out.println("Outside 0");

            int count = 1;
            NodeList previous = head;

            while (head != null) {
                if (count == position) {
                    // NodeList previous = head;
                    NodeList next = head.next.next;

                    previous.next = next;
                    return head;

                }
                count++;
                head = head.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        NodeList head = new NodeList();
        insert(head, 1);
        insert(head, 2);
        insert(head, 3);
        insert(head, 4);
        insert(head, 5);
        insert(head, 6);
        insert(head, 7);
        insert(head, 8);
        insert(head, 9);

        System.out.println(head);

//        System.out.println(reverseLinkedList(head));
        System.out.println(nthToList(head, 3));
    }

}

class NodeList {
    int data;
    NodeList next;

    public NodeList() {

        this.data = 0;
        this.next = null;
    }
    public NodeList(int data) {

        this.data = data;
        this.next = null;
    }

    public NodeList(int data, NodeList next) {

        this.data = data;
        this.next = next;
    }

    public int getData() {

        return data;
    }

    public void setData(int data) {

        this.data = data;
    }

    public NodeList getNext() {

        return next;
    }

    public void setNext(NodeList next) {

        this.next = next;
    }

    @Override
    public String toString() {

        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        NodeList head = this;
        while (head != null) {
            sb.append(head.data + "-->");
            head = head.next;
        }
        return sb.toString();
    }
}
