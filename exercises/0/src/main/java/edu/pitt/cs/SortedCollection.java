package edu.pitt.cs;

//TODO: Import libraries as needed
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;

public class SortedCollection {
	// TODO: Add member variables or methods as needed
	ArrayList<Integer> numbers = new ArrayList<Integer>();

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement

		numbers.add(n); // and n to arrayList
		
		return true;
	} // end add

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement

		if(numbers.size() == 0) {
			throw new NoSuchElementException();
		}

		Collections.sort(numbers); // sort the arraylist
		int small = numbers.get(0); // first element will be the smallest

		numbers.remove(0); // remove the smallest

		return small; // return the smallest
	} // end remove

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	public static boolean isInt(String x) {
		try{
			Integer.parseInt(x);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.

		// If any commandline argument is not a number, call showUsage() and return.
		for(int i = 0; i < args.length; i++) {
			if(!isInt(args[0])) {
				showUsage();
				return;
			}
		}
		// add all command ints to collection
		for(int i = 0; i < args.length; i++) {
			collection.add(Integer.parseInt(args[i]));
		}

		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	} // end main

} // end file
