package lib;

public class Node {
    private Node prev;
    private Node nextNode;
    private String key;
    private String value;

    public Node(){
        this.nextNode = null;
        this.prev = null;
        this.key = null;
        this.value = "";
    }

    public Node(String key, String value){
        this.nextNode = null;
        this.prev = null;
        this.key = key;
        this.value = value;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public void setLastNode(Node prev){
        this.prev = prev;
    }

    public Node getLastNode(){
        return prev;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }

    public void setNodeValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public Boolean checkIfNextExists(){
        return this.getNextNode() != null;
    }

    public Node getLast() {
        Node nextNode;
        Node tempNode = this;
        while (tempNode.checkIfNextExists()) {
            nextNode = tempNode.getNextNode();
            tempNode = nextNode;
        }
        return tempNode;
    }
}
