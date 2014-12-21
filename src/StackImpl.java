/**
 * Created by PierreM on 05/12/2014.
 */
public class StackImpl extends AbstractStack {

    public StackImpl(List list) {
        super(list);
    }

    @Override
    public int size() {
        return(internalList.size());
    }

    @Override
    public boolean isEmpty() {
        if(internalList.isEmpty())
            return(true);
        else
            return(false);
    }

    @Override
    public void push(Object item) {
        if(internalList.isEmpty())
            internalList.add(item);
        else
            internalList.add(0,item);
    }

    @Override
    public ReturnObject top() {
        if(internalList.isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(internalList.get(0));
    }

    @Override
    public ReturnObject pop() {
        if(internalList.isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(internalList.remove(0));
    }

}
