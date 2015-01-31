/**
 * Created by PierreM on 05/12/2014.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    public FunctionalArrayList(int size) {
        super(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject head() {
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FunctionalList rest() {
        FunctionalList newList = new FunctionalArrayList(size());
        for (int i=1;i<size();i++)
            newList.add(get(i).getReturnValue());
        return(newList);
    }
    
}
