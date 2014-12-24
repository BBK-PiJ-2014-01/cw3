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
    public void tests_Stack() {
        System.out.println(stack.size());
        stack.push("Bob");
        System.out.println(stack.size());
        stack.push("Mary");
        System.out.println(stack.size());
        stack.push("Pierre");
        System.out.println(stack);
        System.out.println(stack.reverse());

    }

}
