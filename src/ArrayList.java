/**
 * Created by PierreM on 05/12/2014.
 * Array based implementation of the Interface List
 * - The initial size of the array is set by a parameter in the constructor.
 * This potentially minimises the need of re-sizing the array,
 * if the approximate size required is known at the time the list is created.
 * - Creating a list generates:
 *      . an array of Objects
 *      . an index reference storing the index value of the object that will be inserted next in the array.
 */
public class ArrayList implements List {

    private Object[] objectArray;
    private int currentIndex;

    /**
     * Constructor for the class ArrayList
     * - Creates an array of Objects of size 'size'
     * - Sets the index reference to 0, the index value of the first object that will be inserted in the array
     *
     * @param size size set for the array
     */
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

    /**
     * Doubles the size of an array, keeping all the original content
     */
    public void arrayResize() {
        Object[] newArray = new Object[objectArray.length * 2];
        for (int i = 0;i<objectArray.length;i++)
            newArray[i] = objectArray[i];
        objectArray = newArray;
    }
}
