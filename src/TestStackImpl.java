/**
 * Created by Pierre on 20/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestStackImpl {

    Stack stack;

    @Before
    public void buildUp() {
        stack = new StackImpl(new LinkedList());
    }

    @Test
    public void tests_Stack() {
        System.out.println(stack.size());
        stack.push("Bob");
        System.out.println(stack.size());
        stack.push("Mary");
        System.out.println(stack.size());
        System.out.println(stack.top().getReturnValue());
        System.out.println(stack.pop().getReturnValue());
        System.out.println(stack.size());
        System.out.println(stack.pop().getReturnValue());
        System.out.println(stack.size());
        System.out.println(stack.pop().getReturnValue());
        System.out.println(stack.size());
    }
}
