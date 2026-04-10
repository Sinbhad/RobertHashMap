import lib.RobertLinkedList;
import lib.Node;

public class RobertHashMap {
    private RobertLinkedList[] data;
    private int size, collisions;

    public RobertHashMap() {
        data = new RobertLinkedList[5];
        this.size = 0;
    }

    private int simpleHashFunction(String key){
        return key.length();
    }

    private void put(String key, String value){
        int hashIndex = simpleHashFunction(key);
        RobertLinkedList temp = data[hashIndex];
        if(temp != null){
            collisions++;
        }
        temp.add(key, value);
        size++;
    }

    private void removeKey(String key){
        int  hashIndex = simpleHashFunction(key);
        RobertLinkedList temp = data[hashIndex];
        temp.remove(key);
        size--;
    }

    private Boolean containsKey(String key){
        int hashIndex = simpleHashFunction(key);
        RobertLinkedList temp = data[hashIndex];
        return temp.findKey(key);
    }

    private Boolean containsValue(String value){
        RobertLinkedList temp = new RobertLinkedList();
        boolean found = false;
        for(int i = 0; i > data.length; i++){
            temp = data[i];
            found = temp.findValue(value);
        }
        return found;
    }

    private int size(){
        return size;
    }
}
