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
        FunctionalList newList = new FunctionalLinkedList();
        for (int i=1;i<this.size();i++)
            newList.add(this.get(i).getReturnValue());
        return(newList);
    }

}
