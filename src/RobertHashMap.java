import lib.RobertLinkedList;
import lib.Node;

public class RobertHashMap {
    private RobertLinkedList[] data;
    private int size, collisions, choice;
    private int smallPrime = 31;
    private int largePrime = 29791;

    public RobertHashMap() {
        data = new RobertLinkedList[10];
        this.size = 0;
        this.collisions = 0;
        this.choice = 0;
    }

    public RobertHashMap(int capacity, int choice){
        this.data = new RobertLinkedList[capacity];
        this.choice = choice;
        this.size = 0;
        this.collisions = 0;
    }

    private void setHashChoice(int choice){
        this.choice = choice;
    }

    private int getHashChoice(){
        return this.choice;
    }


    private int dumbHash(String key) {
        return key.length();
    }

    private int divisionHash(String key){
        return key.length() % this.data.length;
    }

    int movingHash(String key){
        int hash = 0;

        for(int i = 0; i < key.length(); i++){
            hash += smallPrime * i + (int) key.charAt(i);
        }
        return (hash % largePrime) % this.data.length;
    }

    int fakeFNV(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
            hash ^= ((int) key.charAt(i) * smallPrime);
            hash *= largePrime;
        }
        return Math.abs(hash % this.data.length);
    }


    public void put(String key, String value) {
        int hashIndex = hashSwap(key);
        System.out.println("Adding Key Value pair " + key + ": " + value + " at index " + hashIndex);
        if (data[hashIndex] == null) {
            data[hashIndex] = new RobertLinkedList();
        } else {
            this.collisions++;
            if(this.collisions >= 5){
                dynamicResize();
            }
        }
        data[hashIndex].add(key, value);
        size++;
    }

    private int hashSwap(String key) {
        int hashIndex;
        if(this.choice == 0){
            hashIndex = dumbHash(key);
        }else if(this.choice == 1){
            hashIndex = divisionHash(key);
        }else if(this.choice == 2){
            hashIndex = movingHash(key);
        }else{
            hashIndex = fakeFNV(key);
        }
        return hashIndex;
    }

    public void removeKey(String key) {
        int hashIndex = hashSwap(key);
        RobertLinkedList list = data[hashIndex];
        if (list != null && list.findKey(key)) {
            list.remove(key);
            size--;
        }
    }

    public boolean containsKey(String key) {
        int hashIndex = hashSwap(key);
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
        int newIndex;
        for (RobertLinkedList list : data) {
            if (list != null) {
                Node current = list.getHead();
                while (current != null) {
                    newIndex = hashSwap(current.getKey());
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