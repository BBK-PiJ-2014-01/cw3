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
     *
     */
    @Test
    public void tests_sampleable_list_1() {
        assertTrue(list.sample().isEmpty());
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
        list.add("Item5");
        list.add("Item6");
        assertEquals(3,list.sample().size());
    }

}
