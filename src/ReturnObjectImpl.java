/**
 * Created by PierreM on 05/12/2014.
 */
public class ReturnObjectImpl implements ReturnObject {

    private Object item;
    private boolean errorFlag;

    public ReturnObjectImpl(Object item, boolean errorFlag) {
        this.item = item;
        this.errorFlag = errorFlag;
    }

    @Override
    public boolean hasError() {
        if (errorFlag)
            return(true);
        else
            return(false);
    }

    @Override
    public ErrorMessage getError() {
        if(hasError())
            return((ErrorMessage) item);
        else
            return(ErrorMessage.NO_ERROR);
    }

    @Override
    public Object getReturnValue() {
        if(hasError())
            return(null);
        else
            return(item);
    }
}
