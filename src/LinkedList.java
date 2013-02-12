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
}
