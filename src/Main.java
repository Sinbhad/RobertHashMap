void main(){
    RobertHashMap rib = new RobertHashMap();

    rib.put("key", "value");
    rib.put("key2", "value2");
    rib.put("key3", "value3");
    rib.put("key4", "value4");
    rib.put("key5", "value5");

    System.out.println(rib.getSize());

    rib.put("key6", "value6");
    rib.put("key7", "value7");
    rib.put("key8", "value8");
    rib.put("key9", "value9");
    rib.put("key10", "value10");
    rib.put("key11", "value11");
    rib.put("key12", "value12");
    rib.put("key13", "value13");

    System.out.println(rib.getSize());

    if(rib.containsKey("key13")) System.out.println("Key exists");

    rib.removeKey("key13");

    if(rib.containsKey("key13")) System.out.println("Key exists");
    else System.out.println("Key does not exist");

    if(rib.containsValue("value")) System.out.println("value exists");

    rib.removeKey("key");

    if(rib.containsValue("value")) System.out.println("value exists");
    else System.out.println("value does not exist");

    System.out.println(rib.getSize());

    System.out.println(rib.getCollisions());
}