/**
 * Created by PierreM on 05/12/2014.
 */
public class SampleableListImpl extends LinkedList implements SampleableList {

    /**
     * {@inheritDoc}
     */
    @Override
    public SampleableList sample() {
        SampleableList newList = new SampleableListImpl();
        if (this.isEmpty())
            return(newList);
        else {
            for (int i = 0;i<this.size();i += 2)
                newList.add(this.get(i).getReturnValue());
            return(newList);
        }
    }

}
