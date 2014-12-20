/**
 * Created by PierreM on 17/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestList {
    List list;

    @Before
    public void buildUp() {
        list = new LinkedList();
    }
    @Test
    /*
     * When the list is empty, tests that:
     *  - isEmpty() returns true
     *  - size() returns 0
     */
    public void tests_list_1() {
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
    }

    @Test
    /*
     * When the list has one element, tests that:
     *  - isEmpty() returns false
     *  - size() returns 1
     *
     * When the list has two element, tests that:
     *  - isEmpty() returns false
     *  - size() returns 2
     */

    public void tests_list_2() {
        list.add("String");
        assertFalse(list.isEmpty());
        assertEquals(1,list.size());
        list.add(7);
        assertFalse(list.isEmpty());
        assertEquals(2,list.size());
    }
}
