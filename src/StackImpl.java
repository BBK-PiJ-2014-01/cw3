/**
 * Created by PierreM on 05/12/2014.
 */
public class StackImpl extends AbstractStack {

    /**
     * Constructor for the class StackImpl
     *
     * @param list underlying structure storing the elements in the stack
     */
    public StackImpl(List list) {
        super(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return(internalList.size());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if(internalList.isEmpty())
            return(true);
        else
            return(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(Object item) {
        if(internalList.isEmpty())
            internalList.add(item);
        else
            internalList.add(0,item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject top() {
        if(internalList.isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(internalList.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject pop() {
        if(internalList.isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(internalList.remove(0));
    }

}
