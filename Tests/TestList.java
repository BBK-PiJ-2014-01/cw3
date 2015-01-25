/**
 * Created by PierreM on 17/12/2014.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestList {
    List list;

    @Before
    public void buildUp() {
        list = new ArrayList(2);
    }

    @Test
    public void tests_listInterfaceImplementation() {
    /*
     * When the list is empty, tests that:
     *  - isEmpty() returns true
     *  - size() returns 0
     */
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());

    /*
     * When the first element is added to an empty list, using add(object), tests that:
     *  - the list is not empty, the list size is 1, the value stored is correct.
     * When the first and only element is removed, tests that:
     *  - the list is empty, the list size is 0.
     */
        assertEquals(null,list.add("String1"));
        assertEquals(ErrorMessage.NO_ERROR,list.get(0).getError());
        assertFalse(list.isEmpty());
        assertEquals(1,list.size());
        assertEquals("String1",list.get(0).getReturnValue());
        assertEquals("String1",list.remove(0).getReturnValue());
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,list.get(0).getError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,list.remove(0).getError());
    /*
     * Testing edge cases
     */
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.add(0,"String1").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.add(-1,"String1").getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.add(2,"String1").getError());
        assertEquals(null,list.add("String1"));
        assertEquals(null,list.add(0,"String2"));
        assertFalse(list.isEmpty());
        assertEquals(2,list.size());
        assertEquals(ErrorMessage.INVALID_ARGUMENT,list.add(null).getError());
        assertEquals(ErrorMessage.INVALID_ARGUMENT,list.add(1,null).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.get(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.remove(2).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.get(-1).getError());
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,list.remove(-1).getError());
        assertEquals("String1",list.get(1).getReturnValue());
        assertFalse(list.isEmpty());
        assertEquals(2,list.size());
        assertEquals("String1",list.remove(1).getReturnValue());
        assertFalse(list.isEmpty());
        assertEquals(1,list.size());
        assertEquals("String2",list.get(0).getReturnValue());
        assertFalse(list.isEmpty());
        assertEquals(1,list.size());
        assertEquals("String2",list.remove(0).getReturnValue());
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
    /*
     * Further tests to validate that adding and removing using indexes work correctly
     */
        assertEquals(null,list.add("String1"));
        assertEquals("String1",list.get(0).getReturnValue());
        assertEquals(null,list.add("String2"));
        assertEquals("String2",list.get(1).getReturnValue());
        assertEquals(null,list.add("String3"));
        assertEquals("String3",list.get(2).getReturnValue());
        assertEquals(null,list.add("String4"));
        assertEquals("String4",list.get(3).getReturnValue());
        // Checking that indexes are updated accordingly after adding an element in position 2
        assertEquals(null,list.add(2,"String5"));
        assertEquals("String1",list.get(0).getReturnValue());
        assertEquals("String2",list.get(1).getReturnValue());
        assertEquals("String5",list.get(2).getReturnValue());
        assertEquals("String3",list.get(3).getReturnValue());
        assertEquals("String4",list.get(4).getReturnValue());
        // Checking that indexes are updated accordingly after removing an element in position 0
        assertEquals("String1",list.remove(0).getReturnValue());
        assertEquals("String2",list.get(0).getReturnValue());
        assertEquals("String5",list.get(1).getReturnValue());
        assertEquals("String3",list.get(2).getReturnValue());
        assertEquals("String4",list.get(3).getReturnValue());
        // Further checks removing all elements 1 by 1
        assertEquals("String4",list.remove(list.size()-1).getReturnValue());
        assertEquals("String3",list.remove(list.size()-1).getReturnValue());
        assertEquals("String5",list.remove(list.size()-1).getReturnValue());
        assertEquals("String2",list.remove(list.size()-1).getReturnValue());
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
    }

}
