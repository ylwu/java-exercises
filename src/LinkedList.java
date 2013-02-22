public class LinkedList<T> {
    Node<T> first;
    
    public LinkedList(){
        first = null;
    }
    
   /*
    * inserts a Node at the beginning of the list
    */
    public void insert(Node<T> n){
        n.next = first;
        first = n;
    }
    
    /*
     * delete the first Node in the LinkedList, return the first Node.
     */
    public Node<T> delete() {
        Node<T> temp = first;
        first = first.next;
        return temp;
    }

    static class Node<T> {
        Node<T> next = null;
        T data;
        
        public Node(T data){
            this.data = data;
        }
    }
    
    /*
     * Reverse the linked List.
     * TripAdvisor Interview Question
     */
    public void reverse(){
        if (first == null){
            return;
        }
        Node curNode = first;
        Node preNode = null;
        while (curNode.next != null){
            Node save = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = save;
        }
        first = curNode;
        curNode.next = preNode;
    }
}
