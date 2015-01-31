/**
 * Created by PierreM on 05/12/2014.
 * Implementation of the Interface ReturnObject
 */
public class ReturnObjectImpl implements ReturnObject {

    private Object item;
    private boolean errorFlag;

    /**
     * Constructor for the class ReturnObjectImpl
     *
     * @param item
     * @param errorFlag
     */
    public ReturnObjectImpl(Object item, boolean errorFlag) {
        this.item = item;
        this.errorFlag = errorFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasError() {
        if (errorFlag)
            return(true);
        else
            return(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ErrorMessage getError() {
        if(hasError())
            return((ErrorMessage) item);
        else
            return(ErrorMessage.NO_ERROR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getReturnValue() {
        if(hasError())
            return(null);
        else
            return(item);
    }
}
