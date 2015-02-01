/**
 * Created by PierreM on 17/12/2014.
 * Testing the implementation of Interface ReturnObject
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class TestReturnObjectImpl {

    @Test
    public void tests_hasError_ReturnsTrueWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",true);
        assertTrue("'hasError' should return TRUE when error",o.hasError());
    }

    @Test
    public void tests_hasError_ReturnsFalseWhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",false);
        assertFalse("'hasError' should return FALSE when no error",o.hasError());
    }

    @Test
    public void tests_getError_Returns_NO_ERROR_WhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,false);
        ErrorMessage expected = ErrorMessage.NO_ERROR;
        assertEquals("Should return NO_ERROR message when no error",expected, o.getError());
    }

    @Test
    public void tests_getError_ReturnsErrorMessageWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true);
        ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
        assertEquals("Should return EMPTY_STRUCTURE message",expected, o.getError());
    }

    @Test
    public void tests_getReturnValue_ReturnsNullWhenError() {
        ReturnObjectImpl o = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, true);
        assertNull("Should return null value",o.getReturnValue());
    }

    @Test
    public void tests_getReturnValue_ReturnsObjectWhenNoError() {
        ReturnObjectImpl o = new ReturnObjectImpl("String",false);
        Object expected = "String";
        assertEquals("Returned value should be 'String'",expected, o.getReturnValue());
    }

}
