package Problems;

/**
 * Created by shobhitagarwal on 2/15/16.
 */
public class LinkedListTest1 {

}


class LinkedListNode<T> {

    private LinkedListNode<T> next;
    private T data;

    public LinkedListNode(T value) {
        data = value;
        next = null;
    }


    public T getData() {
        return data;
    }


    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }


}
