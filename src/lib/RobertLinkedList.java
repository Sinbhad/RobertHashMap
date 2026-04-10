package lib;

public class RobertLinkedList {
    Node head;

    public void add(String key, String value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while(tempNode.getNextNode() != null){
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(newNode);
            newNode.setLastNode(tempNode);
        }
    }



    public void printAll(){
        Node tempNode = head;
        while(tempNode != null){
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNextNode();
        }
    }

    public void printReverse(){
        Node tempNode = head.getLast();
        while(tempNode != null){
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getLastNode();
        }
    }


    public void removeAt(int index) {
        Node tempNode = head;

        if (index == 0) {
            Node newNextNode = tempNode.getNextNode();
            if (newNextNode != null) {
                newNextNode.setLastNode(null);
            }
            head = newNextNode;
        } else {
                for (int i = 0; i < index; i++) {
                    tempNode = tempNode.getNextNode();
                }
                Node newNode = new Node();
                tempNode.setNextNode(newNode);
                tempNode.setLastNode(tempNode);
        }
    }

    public Boolean findKey(String key) {
        Node tempNode = head;
        if(tempNode.getKey().equals(key)){
            return true;
        }else{
            while(tempNode.checkIfNextExists() && !tempNode.getKey().equals(key)){
                tempNode = tempNode.getNextNode();
                if(tempNode.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean findValue(String value) {
        Node tempNode = head;
        if(tempNode.getValue().equals(value)){
            return true;
        }else{
            while(tempNode.checkIfNextExists() && !tempNode.getValue().equals(value)){
                tempNode = tempNode.getNextNode();
                if(tempNode.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public void remove(String value) {
        Node tempNode = head;
        boolean found = false;

        if (head.getValue().equalsIgnoreCase(value)) {
            Node newNextNode = tempNode.getNextNode();

            if (newNextNode != null) {
                newNextNode.setLastNode(null);
            }
            head = newNextNode;

        } else {
            while (tempNode != null && !found) {
                if (tempNode.getValue().equalsIgnoreCase(value)) {
                    Node newNode = new Node();
                    tempNode.setNextNode(newNode);
                    tempNode.setLastNode(tempNode);
                    found = true;
                } else {
                    tempNode = tempNode.getNextNode();
                }
            }
        }
        if(!found){
            System.out.println("The given value '" + value + "' does not exist in the linked list\n\n");
        }
    }
}
