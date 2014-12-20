/**
 * Created by PierreM on 05/12/2014.
 */
public class ArrayList implements List {

    private Object[] objectArray;

    public ArrayList(int size) {
        objectArray = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        if (objectArray.length == 0)
            return(true);
        else
            return(false);
    }

    @Override
    public int size() {
        return(objectArray.length);
    }

    @Override
    public ReturnObject add(int index, Object item) {
        return null;
    }

    @Override
    public ReturnObject add(Object item) {
        return null;
    }

    @Override
    public ReturnObject get(int index) {
        return null;
    }

    @Override
    public ReturnObject remove(int index) {
        return null;
    }

    public void arrayResize() {
        Object[] newArray = new Object[objectArray.length * 2];
        for (int i = 0;i<objectArray.length;i++)
            newArray[i] = objectArray[i];
        objectArray = newArray;
    }
}
