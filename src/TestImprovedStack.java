/**
 * Created by Pierre on 24/12/2014.
 */


import org.junit.*;
import static org.junit.Assert.*;


public class TestImprovedStack {

    ImprovedStackImpl stack;

    @Before
    public void buildUp() {
        stack = new ImprovedStackImpl();
    }

    @Test
    public void tests_ImprovedStack_reverseMethod() {
        // checking that the reversed list is empty, when the original list is empty
        assertTrue(stack.reverse().isEmpty());
        assertEquals(0, stack.reverse().size());

        // checking that the reversed list contains all elements in the right order, when the original list is not empty
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");

        assertEquals(3,stack.size());
        ImprovedStack newStack = stack.reverse();

        assertFalse(newStack.isEmpty());
        assertEquals(3,newStack.size());
        assertEquals(3,stack.size());

        assertEquals("Item1", newStack.top().getReturnValue());
        assertEquals("Item1",newStack.pop().getReturnValue());
        assertFalse(newStack.isEmpty());
        assertEquals(2,newStack.size());

        assertEquals("Item2", newStack.top().getReturnValue());
        assertEquals("Item2",newStack.pop().getReturnValue());
        assertFalse(newStack.isEmpty());
        assertEquals(1,newStack.size());

        assertEquals("Item3", newStack.top().getReturnValue());
        assertEquals("Item3",newStack.pop().getReturnValue());
        assertTrue(newStack.isEmpty());
        assertEquals(0,newStack.size());

    }
    @Test
    public void tests_ImprovedStack_removeMethod() {

        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        stack.push("Item1");
        stack.push("Item3");
        stack.push("Item4");
        stack.push("Item1");
        assertEquals(7,stack.size());

        stack.remove("Item1");
        assertEquals(4,stack.size());

        assertEquals("Item4", stack.top().getReturnValue());
        assertEquals("Item4",stack.pop().getReturnValue());
        assertEquals(3,stack.size());
        assertEquals("Item3", stack.top().getReturnValue());
        assertEquals("Item3",stack.pop().getReturnValue());
        assertEquals(2,stack.size());
        assertEquals("Item3", stack.top().getReturnValue());
        assertEquals("Item3",stack.pop().getReturnValue());
        assertEquals(1,stack.size());
        assertEquals("Item2", stack.top().getReturnValue());
        assertEquals("Item2",stack.pop().getReturnValue());
        assertTrue(stack.isEmpty());

    }
}
