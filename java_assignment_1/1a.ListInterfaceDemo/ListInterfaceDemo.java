
/*1.a Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList
and a LinkedList to perform the following operations with different functions directed as
follows
1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4.
Accessing elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List
size, 9. Iterating over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list
*/


import java.util.*;

public class ListInterfaceDemo {

    public static void main(String[] args) {
        // 1. Initialize ArrayList and LinkedList
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        // 2. Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");

        System.out.print("1. Initial Lists:  ");
        System.out.print("ArrayList: " + arrayList +"   ");
        System.out.print("LinkedList: " + linkedList);
        // 2. Adding element at specific index
        arrayList.add(1, "Grapes");
        linkedList.add(1, "Grapes");
        System.out.println("\n2. After adding 'Grapes' at index 1:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 3. Adding multiple elements
        List<String> moreFruits = Arrays.asList("Mango", "Papaya");
        arrayList.addAll(moreFruits);
        linkedList.addAll(moreFruits);

        System.out.println("\n3. After adding multiple elements:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 4. Accessing elements
        System.out.println("\n4. Accessing element at index 2:");
        System.out.println("ArrayList: " + arrayList.get(2));
        System.out.println("LinkedList: " + linkedList.get(2));

        // 5. Updating elements
        arrayList.set(2, "Kiwi");
        linkedList.set(2, "Kiwi");

        System.out.println("\n5. After updating element at index 2 to 'Kiwi':");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 6. Removing elements
        arrayList.remove("Banana");
        linkedList.remove("Banana");

        System.out.println("\n6. After removing 'Banana':");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 7. Searching elements
        System.out.println("\n7. Searching for 'Mango':");
        System.out.println("ArrayList contains 'Mango': " + arrayList.contains("Mango"));
        System.out.println("LinkedList contains 'Mango': " + linkedList.contains("Mango"));

        // 8. List size
        System.out.println("\n8. List size:");
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("LinkedList size: " + linkedList.size());

        // 9. Iterating over list
        System.out.println("\n9. Iterating using for-each loop:");
        System.out.print("ArrayList: ");
        for (String fruit : arrayList) System.out.print(fruit + " ");
        System.out.print("\nLinkedList: ");
        for (String fruit : linkedList) System.out.print(fruit + " ");

        // 10. Using Iterator
        System.out.println("\n\n10. Iterating using Iterator:");
        System.out.print("ArrayList: ");
        Iterator<String> itr1 = arrayList.iterator();
        while (itr1.hasNext()) System.out.print(itr1.next() + " ");

        System.out.print("\nLinkedList: ");
        Iterator<String> itr2 = linkedList.iterator();
        while (itr2.hasNext()) System.out.print(itr2.next() + " ");

        // 11. Sorting
        Collections.sort(arrayList);
        Collections.sort(linkedList);

        System.out.println("\n\n11. After sorting:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // 12. Sublist
        List<String> arraySub = arrayList.subList(1, 3);
        List<String> linkedSub = linkedList.subList(1, 3);

        System.out.print("\n12. Sublist from index 1 to 3:   ");
        System.out.print("ArrayList sublist: " + arraySub+"   ");
        System.out.print("LinkedList sublist: " + linkedSub);

        // 13. Clearing the list
        arrayList.clear();
        linkedList.clear();

        System.out.print("\n13. After clearing lists:   ");
        System.out.print("ArrayList: " + arrayList+"   ");
        System.out.print("LinkedList: " + linkedList);
    }
}
