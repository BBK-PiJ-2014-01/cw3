/**
 * Created by Pierre on 24/12/2014.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSampleableList {
    SampleableList list;

    @Before
    public void buildUp() {
        list = new SampleableListImpl();
    }

    /*
     * Tests that the method sample() returns:
     * - a list with the 1st, 3rd, 5th... element of the original list
     * - an empty list, if the original list is empty
     */
    @Test
    public void tests_sampleableListInterfaceImplementation() {
        // checking the sampleable list is empty, if the original list is empty
        assertTrue("List should be empty",list.sample().isEmpty());
        // checking the sampleable list is correct (order of elements and value), if the original list is not empty
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
        list.add("Item5");
        list.add("Item6");
        SampleableList newList = list.sample();
        assertEquals("List size should be 6",6,list.size());
        assertEquals("List size should be 3",3, newList.size());
        assertEquals("Values between the two lists should match",list.get(0).getReturnValue(),newList.get(0).getReturnValue());
        assertEquals("Value should be 'Item1'","Item1",newList.get(0).getReturnValue());
        assertEquals("Values between the two lists should match",list.get(2).getReturnValue(),newList.get(1).getReturnValue());
        assertEquals("Value should be 'Item3'","Item3",newList.get(1).getReturnValue());
        assertEquals("Values between the two lists should match",list.get(4).getReturnValue(),newList.get(2).getReturnValue());
        assertEquals("Value should be 'Item5'","Item5",newList.get(2).getReturnValue());
    }
}
