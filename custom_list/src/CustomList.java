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
    public T removeFirst(){
        if(head==null){
            return null;
        }else{
            T removed = head.value;
            if(head==tail){
                head=null;
                tail=null;
            }else{
                head=head.next;
            }
            return removed;
        }
    }
    public T removeLast(){
        if(head==null){
            return null;
        }else{
            T removed = tail.value;
            if(head==tail){
                head=null;
                tail=null;
            }else{
                Node<T> current = head;
                while(current.next!=tail){
                    current = current.next;
                }
                current.next=null;
                tail=current;
            }
            return removed;
        }
    }

}

