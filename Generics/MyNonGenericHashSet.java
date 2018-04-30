/*
Stephen Makowski
MyGenericHashSet.java
April 26, 2018
Week 7 Discussion (Generics vs non Generics)
*/

import java.util.HashSet;

public class MyNonGenericHashSet {
    public static void main(String[] args) {
	// create non generic instance
	HashSet nonGenericHashSet = new HashSet();
	// add to set
	nonGenericHashSet.add("abc1");
	nonGenericHashSet.add("1af2");
	nonGenericHashSet.add("8dn3");
	nonGenericHashSet.add(2700);
	nonGenericHashSet.add("2911a");
	
	//print contents
	System.out.println("Generic HashSet");
	System.out.println(nonGenericHashSet);
    }
}

