public class Main {
    public static void main(String[] args) throws ListIsEmptyException, ValueNotFoundException {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        System.out.println(myList + " size: " + myList.size());
        myList.add(3);
        myList.insert(90);
        System.out.println(myList.toString() + " size: " + myList.size());

        String[] array = {"Bob", "Sam", "Jon"};
        MyLinkedList<String> myList2 = new MyLinkedList<>(array);
        myList2.addAll(array);
        System.out.println(myList2 + " size: " + myList2.size());

        MyLinkedList<Integer> myList3 = new MyLinkedList<>();
        myList3.add(80);
        myList3.addAll(myList);
        System.out.println(myList3 + " size: " + myList3.size());
        System.out.println(myList3.get(2));

        myList3.insert(2, 888);
        System.out.println(myList3 + " size: " + myList3.size());

        myList3.remove(0);
        System.out.println(myList3 + " size: " + myList3.size());
        myList3.remove(2);
        System.out.println(myList3 + " size: " + myList3.size());
        myList3.remove((Integer) 888);
        System.out.println(myList3 + " size: " + myList3.size());
        myList3.clear();
        System.out.println(myList3 + " size: " + myList3.size());
    }
}
