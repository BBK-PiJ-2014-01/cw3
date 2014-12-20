/**
 * Created by Pierre on 20/12/2014.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestFunctionalList {

    FunctionalList list;

    @Before
    public void buildUp() {
        list = new FunctionalLinkedList();
        list.add("Abba");
        list.add("Beatrice");
        list.add("Carole");
        list.add("David");
    }

    /*
    *
    */
    @Test
    public void tests_FunctionalList_1() {
        System.out.println(list.head().getReturnValue());
    }

    /*
     *
     */
    @Test
    public void tests_FunctionalList_2() {
        FunctionalList newList = list.rest();
        for (int i=0;i<newList.size();i++)
            System.out.println(i+" "+newList.get(i).getReturnValue());
    }

}
