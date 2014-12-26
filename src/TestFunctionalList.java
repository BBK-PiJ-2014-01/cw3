/**
 * Created by Pierre on 20/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestFunctionalList {

    FunctionalList list;
    FunctionalList emptyList;

    @Before
    public void buildUp() {
        list = new FunctionalLinkedList();
        emptyList = list;
    }

    /*
    * Testing that the head() method returns:
    * - the "EMPTY_STRUCTURE" error message, if trying to call the first element on an empty list
    * - the first element of a non-empty list without affecting the list
    */
    @Test
    public void tests_functionalListInterfaceImplementation_headMethod() {
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,list.head().getError());
        list.add(1);
        list.add(2);
        assertEquals(1,list.head().getReturnValue());
        assertEquals(1,list.get(0).getReturnValue());
        assertEquals(1,list.remove(0).getReturnValue());
        assertEquals(2,list.head().getReturnValue());
        assertEquals(2,list.get(0).getReturnValue());
        assertEquals(2,list.remove(0).getReturnValue());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,list.head().getError());
    }

    /*
    * Testing that the rest() method returns:
    * - a list without the first element of the original list
    * - en empty list, if the original list is empty
    * - the order of the elements is unchanged in both lists
    */
    @Test
    public void tests_functionalListInterfaceImplementation_restMethod() {
        // checking it returns an empty list if the original list is empty or has only one element
        assertEquals(emptyList,list.rest());
        list.add("String1");
        assertEquals(emptyList,list.rest());
        // checking it returns a list without the first element of the original list
        FunctionalList list1 = list;
        list.add("String2");
        System.out.println(list.size());
        assertEquals(list1,list.rest());
        System.out.println(list.size());
        // checking the order of the elements in both lists is unchanged
        list.add("String3");
        System.out.println(list.size());
        list.add(0,"String4");
        list.add(2,"String5");
        FunctionalList list2 = list;
        System.out.println(list2.size());
        list2.remove(0);
        assertEquals(list2, list.rest());
        assertEquals(list.get(1).getReturnValue(), list2.get(0).getReturnValue());
        assertEquals("String5",list2.get(0).getError());
        assertEquals(list.get(2).getReturnValue(),list2.get(1).getReturnValue());
        assertEquals(list.get(4).getReturnValue(),list2.get(3).getReturnValue());
        assertEquals(list.get(5).getReturnValue(),list2.get(4).getReturnValue());

    }
}
