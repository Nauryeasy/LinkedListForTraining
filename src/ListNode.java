public class ListNode<T> {
    T value;
    ListNode<T> next = null;

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
