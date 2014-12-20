/**
 * Created by PierreM on 05/12/2014.
 */
public class LinkedList implements List {

    private class Node {
        private int index;
        private Object item;
        private Node nNode;

        public Node(int index, Object item) {
            this.index = index;
            this.item = item;
            nNode = null;
        }

        public Object getItem() {
            return(item);
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public Node getNextNode(){
            return(nNode);
        }

        public void setNextNode(Node node) {
            nNode = node;
        }

        public int getIndex() {
            return(index);
        }

        public void addNode (Node node) {
            if (this.getNextNode() == null)
                this.setNextNode(node);
            else
                this.getNextNode().addNode(node);
        }

        public void addNode (int index, Node node) {
            if (this.getNextNode().getIndex() == index) {
                Node temp = this.getNextNode();
                this.setNextNode(node);
                node.setNextNode(temp);
            } else
                this.getNextNode().addNode(index, node);
        }
        
    }

    private Node head;
    private int currentIndex;

    public LinkedList() {
        head = new Node(-1, null);
        currentIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        if (currentIndex == 0)
            return(true);
        else
            return(false);
    }

    @Override
    public int size() {
        return(currentIndex);
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null)
            return(new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT,true));
        else {
            if ((index < 0) || (index >= currentIndex))
                return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
            else {
                Node newNode = new Node(index, item);
                head.addNode(index, newNode);
                currentIndex++;
                return(null);
            }
        }
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null)
            return(new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT,true));
        else {
            Node newNode = new Node(currentIndex, item);
            head.addNode(newNode);
            currentIndex++;
            return(null);
        }
    }

    @Override
    public ReturnObject get(int index) {
        return null;
    }

    @Override
    public ReturnObject remove(int index) {
        return null;
    }

}
