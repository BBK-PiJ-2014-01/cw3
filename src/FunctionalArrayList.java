/**
 * Created by PierreM on 05/12/2014.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    public FunctionalArrayList(int size) {
        super(size);
    }

    @Override
    public ReturnObject head() {
        return(get(0));
    }

    @Override
    public FunctionalList rest() {
        FunctionalList newList = new FunctionalArrayList(size()-1);
        for (int i=1;i<size();i++)
            newList.add(get(i).getReturnValue());
        return(newList);
    }
    
}
