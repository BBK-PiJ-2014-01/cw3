/**
 * Created by PierreM on 17/12/2014.
 * Testing the implementation of Interface ReturnObject
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestReturnObjectImpl {

    @Test
    public void tests_hasError_ReturnsTrueWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",true);
        assertTrue(o.hasError());
    }

    @Test
    public void tests_hasError_ReturnsFalseWhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",false);
        assertFalse(o.hasError());
    }

    @Test
    public void tests_getError_Returns_NO_ERROR_WhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,false);
        ErrorMessage expected = ErrorMessage.NO_ERROR;
        assertEquals(o.getError(), expected);
    }

    @Test
    public void tests_getError_ReturnsErrorMessageWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true);
        ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
        assertEquals(o.getError(), expected);
    }

    @Test
    public void tests_getReturnValue_ReturnsNullWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true);
        assertEquals(o.getReturnValue(), null);
    }

    @Test
    public void tests_getReturnValue_ReturnsObjectWhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",false);
        Object expected = "String";
        assertEquals(o.getReturnValue(), expected);
    }

}
