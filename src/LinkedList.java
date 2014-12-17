/**
 * Created by PierreM on 05/12/2014.
 */
public class LinkedList implements List {

    private class Node {
        private Object item;
        private int index;
        private Node nNode;

        public Node(Object item, int index) {
            this.item = item;
            this.index = index;
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
    }

    private Node head;
    private int lastIndex;

    public LinkedList() {
        head = new Node(null, -1);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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

}
