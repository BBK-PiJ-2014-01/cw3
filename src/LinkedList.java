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
         * Adds a node at the end of the list.
         *
         * @param node the node to add to the list
         */
        public void addNode (Node node) {
            if (getNextNode() == null)
                setNextNode(node);
            else
                getNextNode().addNode(node);
        }

        /**
         * Adds a node at a set position in the list.
         *
         * @param node the node to add to the list
         * @param index the position at which the node should be inserted in the list
         */
        public void addNode(int index, Node node) {
            if (getNextNode().getIndex() == index) {
                Node temp = getNextNode();
                setNextNode(node);
                node.setNextNode(temp);
                node.getNextNode().updateNodeIndex(1);
            } else
                getNextNode().addNode(index, node);
        }

        /**
         * Finds the node at the requested position in the list.
         *
         * @param index the position at which the node should be found in the list
         * @return the node found at the requested position
         */
        public Node findNode(int index) {
            if (getNextNode().getIndex() == index)
                return(getNextNode());
            else
                return(getNextNode().findNode(index));
        }

        /**
         * Removes the node at the requested position in the list.
         *
         * @param index the position at which the node should be removed from the list
         * @return the node removed at the requested position
         */
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

        /**
         * Updates subsequent node indices when a node has been added or removed
         *
         * @param delta the increment to apply to indices (+1 after node added, -1 after node removed)
         */
        public void updateNodeIndex(int delta) {
            setIndex(getIndex() + delta);
            if (getNextNode() != null)
                getNextNode().updateNodeIndex(delta);
        }
    }

    private Node head;
    private int currentIndex;

    /**
     * Constructor for the class LinkedList
     * Sets up a head node pointing to null, with an index set to -1
     * Stores the index value of the next added node, set to 0 for the first one.
     */
    public LinkedList() {
        head = new Node(-1, null);
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
                Node newNode = new Node(index, item);
                head.addNode(index, newNode);
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
            Node newNode = new Node(currentIndex, item);
            head.addNode(newNode);
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
            return(new ReturnObjectImpl(head.findNode(index).getItem(),false));
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
