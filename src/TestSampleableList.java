/**
 * Created by Pierre on 24/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

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
        assertTrue(list.sample().isEmpty());
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
        list.add("Item5");
        list.add("Item6");
        SampleableList newList = list.sample();
        assertEquals(3,newList.size());
        assertEquals(list.get(0).getReturnValue(),newList.get(0).getReturnValue());
        assertEquals(list.get(2).getReturnValue(),newList.get(1).getReturnValue());
        assertEquals(list.get(4).getReturnValue(),newList.get(2).getReturnValue());
    }

}
