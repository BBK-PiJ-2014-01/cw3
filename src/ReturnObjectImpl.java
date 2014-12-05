/**
 * Created by PierreM on 05/12/2014.
 */
public class ReturnObjectImpl implements ReturnObject {

    @Override
    public boolean hasError() {
        return false;
    }

    @Override
    public ErrorMessage getError() {
        return null;
    }

    @Override
    public Object getReturnValue() {
        return null;
    }

}
