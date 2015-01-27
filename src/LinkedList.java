/**
 * Created by PierreM on 05/12/2014.
 */
public class LinkedList implements List {

    private class Node {
        private int index;
        private Object item;
        private Node nNode;

        /**
         * Constructor for the class Node
         *
         * @param item the value stored in the node
         * @param index the index set for the node
         */
        public Node(int index, Object item) {
            this.index = index;
            this.item = item;
            nNode = null;
        }

        /**
         * Returns the value in the node.
         *
         * @return the value in the node
         */
        public Object getItem() {
            return(item);
        }

        /**
         * Sets the value stored in the node.
         *
         * @param item the value to be stored in the node
         */
        public void setItem(Object item) {
            this.item = item;
        }

        /**
         * Returns the address of the next node.
         *
         * @return the address of the next node
         */
        public Node getNextNode(){
            return(nNode);
        }

        /**
         * Sets the address of the next node.
         *
         * @param node the address of the next node
         */
        public void setNextNode(Node node) {
            nNode = node;
        }

        /**
         * Returns the index of the node.
         *
         * @return the index of the node
         */
        public int getIndex() {
            return(index);
        }

        /**
         * Sets the index of the node.
         *
         * @param index the index to set for the node
         */
        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * Adds the index of the node.
         *
         * @param index the index to set for the node
         */
        public void addNode (Node node) {
            if (getNextNode() == null)
                setNextNode(node);
            else
                getNextNode().addNode(node);
        }

        public void addNode(int index, Node node) {
            if (getNextNode().getIndex() == index) {
                Node temp = getNextNode();
                setNextNode(node);
                node.setNextNode(temp);
                node.getNextNode().updateNodeIndex(1);
            } else
                getNextNode().addNode(index, node);
        }

        public Node findNode(int index) {
            if (getNextNode().getIndex() == index)
                return(getNextNode());
            else
                return(getNextNode().findNode(index));
        }

        public Node removeNode(int index) {
            if (getNextNode().getIndex() == index) {
                Node temp = getNextNode();
                if (getNextNode().getNextNode() != null) {
                    setNextNode(getNextNode().getNextNode());
                    getNextNode().updateNodeIndex(-1);
                } else {
                    setNextNode(null);
                }
                return(temp);
            } else
                return(getNextNode().removeNode(index));
        }

        public void updateNodeIndex(int delta) {
            setIndex(getIndex() + delta);
            if (getNextNode() != null)
                getNextNode().updateNodeIndex(delta);
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
            if ((index < 0) || (index >= size()))
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
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        if ((index < 0) || (index >= size()))
            return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
        else
            return(new ReturnObjectImpl(head.findNode(index).getItem(),false));
    }

    @Override
    public ReturnObject remove(int index) {
        if (isEmpty())
            return(new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE,true));
        if ((index < 0) || (index >= size()))
            return(new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS,true));
        else {
            currentIndex--;
            return(new ReturnObjectImpl(head.removeNode(index).getItem(),false));
        }
    }

    public void printList() {
        Node current = head.getNextNode();
        while (current != null) {
            System.out.println("Item: "+current.getItem()+" Index: "+current.getIndex());
            current = current.getNextNode();
        }
    }
}
