/**
 * Created by Pierre on 24/12/2014.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestImprovedStack {

    ImprovedStackImpl stack;

    @Before
    public void buildUp() {
        stack = new ImprovedStackImpl();
    }

    @Test
    public void tests_ImprovedStack_reverseMethod() {
        // checking that the reversed list is empty, when the original list is empty
        assertTrue("Stack should be empty",stack.reverse().isEmpty());
        assertEquals("Stack size should be 0", 0, stack.reverse().size());

        // checking that the reversed list contains all elements in the right order, when the original list is not empty
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");

        assertEquals("Stack size should be 3",3,stack.size());
        ImprovedStack newStack = stack.reverse();

        assertFalse("Stack should not be empty",newStack.isEmpty());
        assertEquals("Stack size should be 3",3,newStack.size());
        assertEquals("Stack size should be 3",3,stack.size());

        assertEquals("Value should be 'Item1'","Item1", newStack.top().getReturnValue());
        assertEquals("Value should be 'Item1'","Item1",newStack.pop().getReturnValue());
        assertFalse("Stack should not be empty",newStack.isEmpty());
        assertEquals("Stack size should be 2",2,newStack.size());

        assertEquals("Value should be 'Item2'","Item2", newStack.top().getReturnValue());
        assertEquals("Value should be 'Item2'","Item2",newStack.pop().getReturnValue());
        assertFalse("Stack should not be empty",newStack.isEmpty());
        assertEquals("Stack size should be 1",1,newStack.size());

        assertEquals("Value should be 'Item3'","Item3", newStack.top().getReturnValue());
        assertEquals("Value should be 'Item3'","Item3",newStack.pop().getReturnValue());
        assertTrue("Stack should be empty",newStack.isEmpty());
        assertEquals("Stack size should be 0",0,newStack.size());

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
        assertEquals("Stack size should be 7",7,stack.size());

        stack.remove("Item1");
        assertEquals("Stack size should be 4",4,stack.size());

        assertEquals("Value should be 'Item4'","Item4", stack.top().getReturnValue());
        assertEquals("Value should be 'Item4'","Item4",stack.pop().getReturnValue());
        assertEquals("Stack size should be 3",3,stack.size());
        assertEquals("Value should be 'Item3'","Item3", stack.top().getReturnValue());
        assertEquals("Value should be 'Item3'","Item3",stack.pop().getReturnValue());
        assertEquals("Stack size should be 2",2,stack.size());
        assertEquals("Value should be 'Item3'","Item3", stack.top().getReturnValue());
        assertEquals("Value should be 'Item3'","Item3",stack.pop().getReturnValue());
        assertEquals("Stack size should be 1",1,stack.size());
        assertEquals("Value should be 'Item2'","Item2", stack.top().getReturnValue());
        assertEquals("Value should be 'Item2'","Item2",stack.pop().getReturnValue());
        assertTrue("Stack should be empty",stack.isEmpty());

    }
}
