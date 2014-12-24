/**
 * Created by PierreM on 05/12/2014.
 */
public class ImprovedStackImpl implements ImprovedStack {

    private StackImpl internalStack;

    public ImprovedStackImpl() {
        internalStack = new StackImpl(new LinkedList());
    }

    @Override
    public int size() {
        return(internalStack.size());
    }

    @Override
    public boolean isEmpty() {
        return(internalStack.isEmpty());
    }

    @Override
    public void push(Object item) {
        internalStack.push(item);
    }

    @Override
    public ReturnObject top() {
        return(internalStack.top());
    }

    @Override
    public ReturnObject pop() {
        return(internalStack.pop());
    }

    @Override
    public ImprovedStack reverse() {
        ImprovedStack newStack = new ImprovedStackImpl();
        if (internalStack.isEmpty())
            return(newStack);
        else {
            while(!internalStack.isEmpty())
                newStack.push(internalStack.pop().getReturnValue());
            return(newStack);
        }
    }

    @Override
    public void remove(Object object) {
        ImprovedStack newStack = new ImprovedStackImpl();
        while (!internalStack.isEmpty())
            if (!internalStack.pop().getReturnValue().equals(object))
                newStack.push(object);
        internalStack = (StackImpl) newStack.reverse();
    }

}
