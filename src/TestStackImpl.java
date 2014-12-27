/**
 * Created by Pierre on 20/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {

    Stack stack;

    @Before
    public void buildUp() {
        // stack = new StackImpl(new LinkedList());
        stack = new ImprovedStackImpl();
    }

    @Test
    public void tests_StackInterfaceImplementation() {
    /*
     * When the stack is empty, tests that:
     *  - isEmpty() returns true
     *  - size() returns 0
     */
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
    /*
     * When the first element is added to a stack, using push(object), tests that:
     *  - the stack is not empty, the stack size is 1, the value stored is correct.
     * When the first and only element is removed, tests that:
     *  - the stack is empty, the stack size is 0.
     */
        stack.push("Item1");
        assertEquals(ErrorMessage.NO_ERROR,stack.top().getError());
        assertFalse(stack.isEmpty());
        assertEquals(1,stack.size());
        assertEquals("Item1",stack.top().getReturnValue());
        assertEquals("Item1",stack.pop().getReturnValue());
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.top().getError());
        assertEquals(ErrorMessage.EMPTY_STRUCTURE,stack.pop().getError());
    /*
     * Testing the stack does not accept null elements
     */

        stack.push(null);
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());

    /*
     * Testing the stack returns the appropriate elements
     */
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        assertFalse(stack.isEmpty());
        assertEquals(3,stack.size());

        assertEquals("Item3", stack.top().getReturnValue());
        assertEquals("Item3",stack.pop().getReturnValue());
        assertFalse(stack.isEmpty());
        assertEquals(2,stack.size());

        stack.push("Item4");
        assertFalse(stack.isEmpty());
        assertEquals(3,stack.size());

        assertEquals("Item4", stack.top().getReturnValue());
        assertEquals("Item4",stack.pop().getReturnValue());
        assertFalse(stack.isEmpty());
        assertEquals(2,stack.size());

        assertEquals("Item2", stack.top().getReturnValue());
        assertEquals("Item2",stack.pop().getReturnValue());
        assertFalse(stack.isEmpty());
        assertEquals(1,stack.size());

        assertEquals("Item1", stack.top().getReturnValue());
        assertEquals("Item1",stack.pop().getReturnValue());
        assertTrue(stack.isEmpty());
        assertEquals(0,stack.size());
    }
}
