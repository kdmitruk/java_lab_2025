public class CustomList <T>{

    private Node <T> head,tail;
    public void addLast(T value){
        Node <T> created = new Node<>(value);
        if(tail == null){
            head = created;
        }else{
            tail.next = created;
        }
        tail = created;
    }
    public T getLast(){
        return tail.value;
    }
    public T getFirst(){
        return head.value;
    }
    public void addFirst(T value){
        Node<T> created = new Node<>(value);
        if(head == null){
            tail = created;
        }else{
            created.next = head;
        }
        head=created;
    }
}

