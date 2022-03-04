package models;
import lombok.ToString;
@ToString
public class PersonalizedQueue{
    Node queue = null;
    int size;
    @ToString
    private class Node {
        Customer value;
        Node next;
    }

    private boolean shouldComeInFront(Node a, Node b){
        var customer1product = a.value.getMyCart();
        var customer2product = b.value.getMyCart();
        return customer1product.getProductName().equals(customer2product.getProductName()) &&
                customer1product.getProductQuantity() > customer2product.getProductQuantity();
    }

    public void add(Customer e){
        Node newNode = new Node();
        newNode.value = e;
        Node previous = null;
        Node current = queue;
        if (size == 0) {
            queue = newNode;}
        else if (size == 1){
            if (shouldComeInFront(queue, newNode)){
                newNode.next = queue;
                queue = newNode;
            } else {
                newNode.next = null;
                queue.next = newNode;
            }
        } else {
            for (int i = 0; i < size; i++){
                if (shouldComeInFront(current, newNode)){
                    if (i == 0){
                        newNode.next = queue;
                        queue = newNode;
                    } else {
                        newNode.next = current;
                        previous.next = newNode;
                    }
                    break;
                } else if (current.next == null){
                    current.next = newNode;
                    newNode.next = null;
                }

                previous = current;
                current = current.next;
            }
        }
        size++;
    }

    public Customer poll(){
        Customer e = queue.value;
        queue = queue.next;
        size--;
        return e;
    }

    public boolean hasNext(){
        return size > 0;
    }

    public boolean contains (Customer e){
        Node current = queue;
        for (int i = 0; i < size; i++){
            if (current.value.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
