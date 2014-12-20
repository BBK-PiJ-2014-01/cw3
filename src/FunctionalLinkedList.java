/**
 * Created by PierreM on 05/12/2014.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    @Override
    public ReturnObject head() {
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        else
            return(get(0));
    }

    @Override
    public FunctionalList rest() {
        FunctionalList newList = this;
        if(!newList.isEmpty())
            newList.remove(0);
        return(newList);
    }

}
