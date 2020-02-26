package cse360assign2;

/*Name: Evan Garvey
 * Student ID: 18600511
 * Class ID: 143 (?)
 * Assignment #: 1
 * 
 * 
 * */
// This class represent a SimpleList of flexible size, with up to 10 integers contained within.
// The list works like a stack= the most recent item added is in position zero, with items added later being placed further back.
import java.util.Arrays;
public class SimpleList {
		private int[] list;
	    private int count;

	    public SimpleList() 
	    { //contains an array of variable size, with up to 10 integers
	    	list = new int[10];
	    	count = 0; //items past this are effectively nonexistent- data is here, but it won't be used for anything
	    }

	    public void add(int item /*item being added*/) 
	    { 
	    	// increments count, pushes all items forward 1 position in the array, and sets 0 to argument. (no longer pushes stuff off)
	    	
	    	count++;
	    	if (count > list.length) 
	    	{
	    		//this is modified from the original- if the array is too large to hold everything, its size is instead increased by 50%
	    		list = Arrays.copyOf(list, (int) (list.length * 1.5)); 
	    	}
	    	
	    	for (int inc = list.length - 1; inc > 0; inc--) 
	    	{
	    		list[inc] = list[inc - 1];
	    	}
	    	
	    	list[0] = item;
	    	
	    }
	    public void remove(int item /*item being removed*/) 
	    { 
	    	//removes the matching item (argument) from the list. All items past it are pushed back to "fill", and count is lowered by 1.
	    	
	    	int index = search(item); //this method is defined further down- it's repeated code, so I might as well
	    	
	    	if (index != -1) 
	    	{
	    		for (int inc = index; inc < count - 1; inc++) 
	    		{
	    			list[inc] = list[inc + 1];
	    		}
	    		
	    		count--; //this only ticks down if search finds something, so no need for a check
	    		
	    		//this part is modified: if the SimpleList is more than 25% empty, reduce its size appropriately
	    		if (count < (int) list.length * .75) 
	    		{
	    			list = Arrays.copyOf(list, (int) (list.length * .75));
	    		}
	    	}
	    	
	    }
	    public int count() 
	    { //returns count (number of items in the list).
	    	
	    	return count;

	    }
	    public String toString() 
	    { // prints a string of all items in the list. Items are given in-order, and seperated by spaces.
	    	
	    	String output = "";
	    	
	    	for (int inc = 0; inc < count; inc++) 
	    	{
	    		if (inc > 0) output += " "; // adds blank space to seperate numbers
	    		output += list[inc]; // adds numbers
	    	}
	    	
	    	return output; //printed string of all items
	    }
	    
	    public int search(int item /*item being searched for*/) 
	    { //Searches for an item in the list and returns its index value. Returns -1 if not present.
	    	
	    	for (int inc = 0; inc < count; inc++) 
	    	{
	    		if (list[inc] == item) return inc; // if a match is found, it return the "i" value that contains it
	    	}
	    	
	    	return -1; // returned if nothing is found
	    }
	    //TODO: document and test these new functions
	    public void append(int appendedItem) 
	    {
	    	count++;
	    	if (count >= list.length) 
	    	{
	    		list = Arrays.copyOf(list, (int) (list.length * 1.5));
	    	}
	    	
	    	list[count - 1] = appendedItem;
	    }
	    
	    public int first() 
	    {
	    	return list[0];
	    }
	    
	    public int size() 
	    {
	    	return list.length;
	    }
	    

}
