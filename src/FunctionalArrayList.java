/**
 * Created by PierreM on 05/12/2014.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    public FunctionalArrayList(int size) {
        super(size);
    }

    @Override
    public ReturnObject head() {
        return null;
    }

    @Override
    public FunctionalList rest() {
        return null;
    }
    
}
