import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Pierre on 25/01/2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({   TestReturnObjectImpl.class,
                        TestList.class,
                        TestFunctionalList.class,
                        TestSampleableList.class,
                        TestStackImpl.class,
                        TestImprovedStack.class
})

public class AllTests {

}
