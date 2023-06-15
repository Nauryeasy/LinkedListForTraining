
import java.util.Objects;

public class MyLinkedList<T> {
    private ListNode<T> head = null;
    private int size = 0;

    public MyLinkedList() {}
    public MyLinkedList(T[] array) {
        this.head = new ListNode<>(array[0]);
        this.size++;
        ListNode<T> lastNode = this.head;
        for (int i = 1; i < array.length; i++) {
            lastNode.next = new ListNode<>(array[i]);
            lastNode = lastNode.next;
            this.size++;
        }
    }
    public void add(T value) {
        if (this.head == null) {
            this.head = new ListNode<>(value);
            this.size++;
            return;
        }
        ListNode<T> check = this.head;
        while (check.next != null) {
            check = check.next;
        }
        check.next = new ListNode<>(value);
        this.size++;
    }
    /*
    Метод не копирует список в тот, в который он добавляется. Вместо этого список, в который добавили
    становиться ссылкой на тот, который добавили. Ну, на его голову. Почему? Потому, что я не подумал
    об этом. Когда-нибудь он будет работать нормально :3
     */
    public void addAll(MyLinkedList<T> list) {
        if (this.head == null) {
            this.head = list.head;
            this.size += list.size();
            return;
        }
        ListNode<T> check = this.head;
        while (check.next != null) {
            check = check.next;
        }
        check.next = list.head;
        this.size += list.size();
    }
    public void addAll(T[] array) {
        boolean flagIsNullHead = false;
        if(this.head == null) {
            this.head = new ListNode<>(array[0]);
            this.size++;
            flagIsNullHead = true;
        }
        ListNode<T> check = this.head;
        while (check.next != null) {
            check = check.next;
        }
        if (!flagIsNullHead) {
            for (int i = 0; i < array.length; i++) {
                check.next = new ListNode<>(array[i]);
                check = check.next;
                this.size++;
            }
        } else {
            for (int i = 1; i < array.length; i++) {
                check.next = new ListNode<>(array[i]);
                check = check.next;
                this.size++;
            }
        }
    }
    public void insert(T value) throws ListIsEmptyException{
        if(isEmpty()) throw new ListIsEmptyException("List is empty");
        ListNode<T> newHead = new ListNode<>(value);
        newHead.next = this.head;
        this.head = newHead;
        this.size++;
    }
    public void insert(int index, T value) throws IndexOutOfBoundsException{
        if(index < 0 & index > this.size - 1) throw new IndexOutOfBoundsException(
                "Index " + index + " is outside the boundaries for size " + this.size
        );
        int count = 0;
        ListNode<T> check = this.head;
        if (index == count) {
            ListNode<T> newHead = new ListNode<>(value);
            newHead.next = this.head;
            this.head = newHead;
            this.size++;
        }
        while (count != index - 1) {
            check = check.next;
            count++;
        }
        ListNode<T> newNode = new ListNode<>(value, check.next);
        check.next = newNode;
        this.size++;
    }
    public T get(int index) throws IndexOutOfBoundsException{
        if(index < 0 & index > this.size - 1) throw new IndexOutOfBoundsException(
                "Index " + index + " is outside the boundaries for size " + this.size
        );
        ListNode<T> check = this.head;
        int count = 0;
        while (count != index) {
            check = check.next;
            count ++;
        }
        return check.value;
    }
    public T remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 & index > this.size - 1) throw new IndexOutOfBoundsException(
                "Index " + index + " is outside the boundaries for size " + this.size
        );
        if (index == 0) {
            T value = this.head.value;
            this.head = this.head.next;
            this.size--;
            return value;
        }
        int count = 0;
        ListNode<T> check = this.head;
        if (count == index) this.head = check.next;
        while (count != index - 1) {
            check = check.next;
            count++;
        }
        T value = check.next.value;
        check.next = check.next.next;
        this.size--;
        return value;
    }
    public void remove(T value) throws ValueNotFoundException{
        ListNode<T> check = this.head;
        if (check.value == value) this.head = check.next;
        boolean flagIsFind = false;
        do {
            if (Objects.equals(check.next.value, value)) {
                flagIsFind = true;
                break;
            }
            check = check.next;
        } while (check.next.next != null);
        if(!flagIsFind) throw new ValueNotFoundException("The value was not found in the list");
        check.next = check.next.next;
        this.size--;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        if(this.size == 1) return "[" + this.head.value + "]";
        StringBuilder result = new StringBuilder("[");
        ListNode<T> check = this.head;
        result.append(check.value.toString()).append(", ");
        while (check.next.next != null) {
            check = check.next;
            result.append(check.value.toString()).append(", ");
        }
        result.append(check.next.value.toString()).append("]");
        return result.toString();
    }
}