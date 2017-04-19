/**
 * 
 */
package com.teste;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author froseno
 *
 */
public class ConvertArray4Set {
	
	public static void main(String[] args) {
		
		String[] keys = {"blah", "blahblah", "blah", "blahblah"};
		Set<String> myEmptySet = new HashSet<String>();
		Collections.addAll(myEmptySet, keys);
		
		for (String string : myEmptySet) {
			System.out.println(string);
		}
		
	}

}
