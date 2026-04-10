package lib;

public class RobertLinkedList {
    Node head;

    public void add(String key, String value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.getNextNode() != null) {
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(newNode);
            newNode.setLastNode(tempNode);
        }
    }

    public void printAll() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNextNode();
        }
    }

    public boolean findKey(String key) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                return true;
            }
            tempNode = tempNode.getNextNode();
        }
        return false;
    }

    public boolean findValue(String value) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.getValue().equals(value)) {
                return true;
            }
            tempNode = tempNode.getNextNode();
        }
        return false;
    }

    public Node getHead() {
        return head;
    }

    public void remove(String key) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                Node prev = tempNode.getLastNode();
                Node next = tempNode.getNextNode();

                if (prev != null) {
                    prev.setNextNode(next);
                } else {
                    head = next;
                }

                if (next != null) {
                    next.setLastNode(prev);
                }
                return;
            }
            tempNode = tempNode.getNextNode();
        }
    }
}