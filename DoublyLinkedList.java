
public class DoublyLinkedList {
    private static class Node{
        private String data;
        private Node next;
        private Node prev;

        public Node(String s){
            this(s,null,null);
        }

        public Node(String s, Node n, Node p){
            data = s;
            next = n;
            prev = p;
        }
        @Override
        public String toString(){
            return data;
        }
    }
    private Node first;
    private Node last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    public void add(int i, String s){
        if (i<0){
            throw new IndexOutOfBoundsException();
        } else {
            if (i== 0){
                Node n = first;
                first = new Node(s,n,null);
                if (n != null){
                    n.prev = first;
                }
                if (last == null){
                    last = first;
                }
            } else {
                Node p = first;
                if (p == null){
                    throw new IndexOutOfBoundsException();
                }
                for (int j = 1; j < i; j++){
                    p = p.next;
                    if (p == null){
                        throw new IndexOutOfBoundsException();
                    }
                }
                Node n = p.next;
                p.next = new Node(s,n,p);
                if (n == null){
                    last = p.next;
                } else {
                    n.prev = p.next;
                }
            }
        }
    }
}

