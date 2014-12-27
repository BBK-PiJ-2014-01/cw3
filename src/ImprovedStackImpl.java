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
        if (this.isEmpty())
            return(newStack);
        else {
            for (int i=0;i<this.size();i++)
                newStack.push(this.internalStack.internalList.get(i).getReturnValue());
            return(newStack);
        }
    }

    @Override
    public void remove(Object object) {
        for (int i=size()-1;i>=0;i--)
            if (this.internalStack.internalList.get(i).getReturnValue().equals(object))
                this.internalStack.internalList.remove(i);
    }

}
