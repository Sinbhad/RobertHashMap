void main(){
    RobertHashMap rib = new RobertHashMap(10, 0);
    testHash(rib);

    RobertHashMap rib2 = new RobertHashMap(10, 1);
    testHash(rib2);

    RobertHashMap rib3 = new RobertHashMap(10, 2);
    testHash(rib3);

    RobertHashMap rib4 = new RobertHashMap(10, 3);
    testHash(rib4);



    System.out.println("\n\n\nExclusive or of a and b :"+ xor('a','b'));
    System.out.println("And of a and b :" + and('a','b'));
    System.out.println("Or of a and b :" + or('a','b'));


    }

private int xor(char x, char y){
    return (int)x ^ (int)y;
}

private int and(char x, char y){
    return (int) x & (int) y;
}

private int or(char x, char y){
    return  (int) x | (int) y;
}

private void testHash(RobertHashMap hashMap){
    hashMap.put("key1", "value1");
    hashMap.put("key2", "value2");
    hashMap.put("key3", "value3");
    hashMap.put("key4", "value4");
    hashMap.put("key5", "value5");

    System.out.println("Current size of HashMap " + hashMap.getSize());

    hashMap.put("key6", "value6");
    hashMap.put("key7", "value7");
    hashMap.put("key8", "value8");
    hashMap.put("key9", "value9");
    hashMap.put("key10", "value10");
    hashMap.put("key11", "value11");
    hashMap.put("key12", "value12");
    hashMap.put("key13", "value13");

    System.out.println("Current size of HashMap " + hashMap.getSize());

    if(hashMap.containsKey("key13")) System.out.println("Key exists");

    hashMap.removeKey("key13");

    if(hashMap.containsKey("key13")) System.out.println("Key exists");
    else System.out.println("Key does not exist");

    if(hashMap.containsValue("value")) System.out.println("Value exists");

    hashMap.removeKey("key1");

    if(hashMap.containsValue("value1")) System.out.println("value exists");
    else System.out.println("value does not exist");

    System.out.println("Size of HashMap " + hashMap.getSize());

    System.out.println("Number of Collisions " + hashMap.getCollisions() + "\n\n\n\n");
}
