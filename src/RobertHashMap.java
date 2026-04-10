import lib.RobertLinkedList;
import lib.Node;

public class RobertHashMap {
    private RobertLinkedList[] data;
    private int size, collisions;

    public RobertHashMap() {
        data = new RobertLinkedList[5];
        this.size = 0;
        this.collisions = 0;
    }

    private int simpleHashFunction(String key, int capacity) {
        return key.length() % capacity;
    }

    public void put(String key, String value) {
        if ((double) size / data.length >= 0.75) {
            dynamicResize();
        }

        int hashIndex = simpleHashFunction(key, data.length);
        if (data[hashIndex] == null) {
            data[hashIndex] = new RobertLinkedList();
        } else {
            this.collisions++;
        }
        data[hashIndex].add(key, value);
        size++;
    }

    public void removeKey(String key) {
        int hashIndex = simpleHashFunction(key, data.length);
        RobertLinkedList list = data[hashIndex];
        if (list != null && list.findKey(key)) {
            list.remove(key);
            size--;
        }
    }

    public boolean containsKey(String key) {
        int hashIndex = simpleHashFunction(key, data.length);
        RobertLinkedList list = data[hashIndex];
        return list != null && list.findKey(key);
    }

    public boolean containsValue(String value) {
        for (RobertLinkedList list : data) {
            if (list != null && list.findValue(value)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCollisions() {
        return collisions;
    }

    private void dynamicResize() {
        int newCapacity = data.length * 2;
        RobertLinkedList[] newData = new RobertLinkedList[newCapacity];
        this.collisions = 0;

        for (RobertLinkedList list : data) {
            if (list != null) {
                Node current = list.getHead();
                while (current != null) {
                    int newIndex = simpleHashFunction(current.getKey(), newCapacity);
                    if (newData[newIndex] == null) {
                        newData[newIndex] = new RobertLinkedList();
                    } else {
                        this.collisions++;
                    }
                    newData[newIndex].add(current.getKey(), current.getValue());
                    current = current.getNextNode();
                }
            }
        }
        this.data = newData;
    }
}