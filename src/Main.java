void main(){
    System.out.println("Using dumb hash function\n");
    RobertHashMap rib = new RobertHashMap(10, 0);
    testHash(rib);

    System.out.println("Using division hash function\n");
    RobertHashMap rib2 = new RobertHashMap(10, 1);
    testHash(rib2);

    System.out.println("Using moving hash function\n");
    RobertHashMap rib3 = new RobertHashMap(10, 2);
    testHash(rib3);

    System.out.println("Using fake FNV hash function\n");
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
    hashMap.put("Byron", "Hoy");
    hashMap.put("Robert", "Poley");
    hashMap.put("Westley", "Ney");
    hashMap.put("Jeremiah", "Bullfrog");
    hashMap.put("Andrew", "Discord");

    System.out.println("\nCurrent size of HashMap " + hashMap.getSize() + "\n");

    hashMap.put("Jenna", "Miller");
    hashMap.put("Joegre", "Mezzatesta");
    hashMap.put("Marc", "Motta");
    hashMap.put("Timothy", "Le");
    hashMap.put("Pekhed", "22");
    hashMap.put("Burger", "King");
    hashMap.put("Tim", "Scott");
    hashMap.put("Steven", "Morris");

    System.out.println("\nCurrent size of HashMap " + hashMap.getSize() + "\n");

    System.out.println("Checking if key 'Jenna' exists");
    if(hashMap.containsKey("Jenna")) System.out.println("Key 'Jenna' exists");

    System.out.println("Removing key 'Jenna'\n");
    hashMap.removeKey("Jenna");

    System.out.println("Checking if key 'Jenna' exists");
    if(hashMap.containsKey("Jenna")) System.out.println("Key 'Jenna' exists\n");
    else System.out.println("Key 'Jenna' exist\n");

    System.out.println("Checking if value 'Miller' exists");
    if(hashMap.containsValue("Miller")) System.out.println("Value 'Miller' exists\n");
    else System.out.println("Value 'Miller' does not exist\n");

    System.out.println("Removing key 'Byron'\n");
    hashMap.removeKey("Byron");

    System.out.println("Checking if value 'Byron' exists");
    if(hashMap.containsValue("Byron")) System.out.println("value exists\n");
    else System.out.println("Value Byron does not exist\n");

    System.out.println("Size of HashMap " + hashMap.getSize());

    System.out.println("Number of Collisions " + hashMap.getCollisions() + "\n\n\n\n");
}
