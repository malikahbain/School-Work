import java.util.HashSet;
import java.util.Set;

public class A5Q3 {
//Student ID: 101240163
//Student Name: Malikah Bain

/*/
Student Comments:


*/

    //calling this function should remove all duplicates in the list
    public static void removeDups(LinkedList lst)
    {
        HashSet<Integer> someSet = new HashSet<>();
        LinkedList noDups = new LinkedList();

        Node someNode = lst.head;

        while(someNode.next != null){
            someSet.add(someNode.data);
            someNode = someNode.next;
        }

        for(int x: someSet){
            noDups.addNode(x);
        }

        lst.head = noDups.head;


    }


    //you may use this for testin purposes
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();
        myList.addNode(5);
        myList.addNode(4);
        myList.addNode(4); // here 4 is duplicated
        myList.addNode(2);
        myList.addNode(1);
        myList.addNode(1); // here 1 is duplicated

        myList.print();

        removeDups(myList);

        System.out.println("");

        myList.print();
    

    }

}
