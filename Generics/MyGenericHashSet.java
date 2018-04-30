/*
Stephen Makowski
MyGenericHashSet.java
April 26, 2018
Week 7 Discussion (Generics vs non Generics)
*/

import java.util.HashSet;

public class MyGenericHashSet {
    public static void main(String[] args) {
	// create generic instance
	HashSet<String> genericHashSet = new HashSet<String>();
	// add to sets
	genericHashSet.add("abc1");
	genericHashSet.add("1af2");
	genericHashSet.add("8dn3");
	genericHashSet.add(2700);
	genericHashSet.add("2911a");
	//print contents
	System.out.println("NonGeneric HashSet");
	System.out.println(genericHashSet);

    }
}
