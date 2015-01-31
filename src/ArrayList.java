/**
 * Created by PierreM on 05/12/2014.
 */
public class ArrayList implements List {

    private Object[] objectArray;
    private int currentIndex;


    public ArrayList(int size) {
        objectArray = new Object[size];
        currentIndex = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (currentIndex == 0)
            return(true);
        else
            return(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return(currentIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null)
            return(new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT,true));
        else {
            if ((index < 0) || (index >= size()))
                return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
            else {
                if (objectArray.length - size() == 0)
                    arrayResize();
                for (int i=currentIndex ;i>index;i--)
                    objectArray[i] = objectArray[i-1];
                objectArray[index] = item;
                currentIndex++;
                return(null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject add(Object item) {
        if (item == null)
            return(new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT,true));
        else {
            if (objectArray.length - size() == 0)
                arrayResize();
            objectArray[currentIndex] = item;
            currentIndex++;
            return(null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject get(int index) {
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        if ((index < 0) || (index >= size()))
            return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
        else
            return(new ReturnObjectImpl(objectArray[index],false));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject remove(int index) {
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        if ((index < 0) || (index >= size()))
            return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
        else {
            Object temp = objectArray[index];
            for (int i=index ;i<size()-1;i++)
                objectArray[i] = objectArray[i+1];
            currentIndex--;
            return(new ReturnObjectImpl(temp,false));
        }
    }

    public void arrayResize() {
        Object[] newArray = new Object[objectArray.length * 2];
        for (int i = 0;i<objectArray.length;i++)
            newArray[i] = objectArray[i];
        objectArray = newArray;
    }

    public void printList() {
        for (int i=0;i<size();i++) {
            System.out.println("Item: "+objectArray[i]+" Index: "+i);
        }
    }

}
