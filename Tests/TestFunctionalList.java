/**
 * Created by Pierre on 20/12/2014.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFunctionalList {

    FunctionalList list;

    @Before
    public void buildUp() {
        list = new FunctionalArrayList(2);
    }

    /*
    * Testing that the head() method returns:
    * - the "EMPTY_STRUCTURE" error message, if trying to call the first element on an empty list
    * - the first element of a non-empty list without affecting the list
    */
    @Test
    public void tests_functionalListInterfaceImplementation_headMethod() {
        assertEquals("Error message should be 'EMPTY_STRUCTURE'",ErrorMessage.EMPTY_STRUCTURE,list.head().getError());
        list.add(1);
        list.add(2);
        assertEquals("Returned value should be 1",1,list.head().getReturnValue());
        assertEquals("Returned value should be 1",1,list.get(0).getReturnValue());
        assertEquals("Returned value should be 1",1,list.remove(0).getReturnValue());
        assertEquals("Returned value should be 2",2,list.head().getReturnValue());
        assertEquals("Returned value should be 2",2,list.get(0).getReturnValue());
        assertEquals("Returned value should be 2",2,list.remove(0).getReturnValue());
        assertEquals("Error message should be 'EMPTY_STRUCTURE'",ErrorMessage.EMPTY_STRUCTURE,list.head().getError());
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
        assertTrue("List should be empty",list.rest().isEmpty());
        list.add("String1");
        assertTrue("List should be empty",list.rest().isEmpty());
        // checking it returns a list without the first element of the original list
        list.add("String2");
        FunctionalList list1 = list.rest();
        assertEquals("Values between the two lists should match",list.get(1).getReturnValue(),list1.get(0).getReturnValue());
        assertEquals("Value should be 'String2'","String2",list1.get(0).getReturnValue());
        // checking the order of the elements in both lists is unchanged
        list.add("String3");
        list.add(0,"String4");
        list.add(2,"String5");
        FunctionalList list2 = list.rest();
        assertEquals("List size should be 5",5,list.size());
        assertEquals("List size should be 4",4,list2.size());
        assertEquals("Values between the two lists should match",list.get(1).getReturnValue(), list2.get(0).getReturnValue());
        assertEquals("Value should be 'String1'","String1",list2.get(0).getReturnValue());
        assertEquals("Values between the two lists should match",list.get(2).getReturnValue(),list2.get(1).getReturnValue());
        assertEquals("Value should be 'String5'","String5",list2.get(1).getReturnValue());
        assertEquals("Values between the two lists should match",list.get(3).getReturnValue(),list2.get(2).getReturnValue());
        assertEquals("Value should be 'String2'","String2",list2.get(2).getReturnValue());
        assertEquals("Values between the two lists should match",list.get(4).getReturnValue(),list2.get(3).getReturnValue());
        assertEquals("Value should be 'String3'","String3",list2.get(3).getReturnValue());
    }
}
