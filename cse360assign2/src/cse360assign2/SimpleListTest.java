package cse360assign2;
/*Name: Evan Garvey
 * Student ID: 18600511
 * Class ID: 143 (?)
 * Assignment #: 1
 * 
 * 
 * */
// Contains various JUnit test methods to test the methods of SimpleList.
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cse360assign2.SimpleList;

class SimpleListTest {

	@Test
	//Tests to make sure SimpleList can be created correctly.
	void testSimpleList() 
	{ 
		SimpleList test = new SimpleList();
		assertNotNull(test);
	}

	@Test
	//Tests to make sure items are added in a "stack" style
	void testAdd() 
	{ 
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals("3 2 1",test.toString()); //Uses toString to verify contents of SimpleList
	}
	
	@Test
	// Tests to ensure count is incremented properly
	void testAddCount() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(3,test.count());
	}
	
	@Test
	// Tests to ensure count is incremented properly after an "overflow" (data is added past 10 items)
	void testAddOverflow() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		
		assertEquals(11,test.count());
	}

	@Test
	//Tests to make sure items are removed properly from the SimpleList.
	//items must be "pushed" to fill the empty space.
	void testRemove() 
	{ 
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(7);
		test.add(4);
		test.add(3);
		
		test.remove(7);
		
		assertEquals("3 4 1",test.toString()); //needed to verify contents of the array
		
	}
	
	@Test
	//Tests to ensure "count" is decremented properly.
	void testRemoveCount() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(7);
		test.add(4);
		test.add(3);
		
		test.remove(7);
		
		assertEquals(3,test.count());
	}
	
	@Test
	//Tests to ensure "count" does not go down when remove() is used on an empty list.
	void testRemoveEmpty() 
	{
		SimpleList test = new SimpleList();
		
		test.remove(7);
		
		assertEquals(0,test.count());
	}
	
	@Test
	//Tests to ensure nothing is removed if the target is not found.
	void testRemoveMiss() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(7);
		test.add(4);
		test.add(3);
		
		test.remove(2);
		
		assertEquals("3 4 7 1",test.toString());
	}

	@Test
	// Tests to ensure count properly represents the # of items in SimpleList.
	void testCount() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(4);
		
		assertEquals(2,test.count());
	}

	@Test
	// Ensures toString properly prints the contents of the SimpleList, and in the correct order and format (seperated by spaces, no stray whitespace)
	void testToString() 
	{
		SimpleList test = new SimpleList();
		
		test.add(5);
		test.add(23);
		
		assertEquals("23 5",test.toString());
	}
	
	@Test
	// Ensures toString is empty when used on an empty list.
	void testToStringEmpty() 
	{
		SimpleList test = new SimpleList();
		
		assertEquals("",test.toString());
	}
	
	@Test
	// Ensures toString works properly if the string "overflows".
	void testToStringOverflow() 
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		
		assertEquals("11 10 9 8 7 6 5 4 3 2 1",test.toString());
	}
	
	

	@Test
	// Ensures the search function always returns the correct index value.
	// First item is represented by 0, items added later are higher.
	void testSearch() 
	{
		SimpleList test = new SimpleList();
		
		test.add(8);
		test.add(6);
		test.add(23);
		test.add(9);
		
		assertEquals(2,test.search(6));
	}
	
	@Test
	// Ensures search() returns -1 if the value is not found.
	void testSearchVoid() 
	{
		SimpleList test = new SimpleList();
		
		test.add(8);
		test.add(6);
		test.add(23);
		test.add(9);
		
		assertEquals(-1,test.search(5));
	}
	
	@Test
	void testAppend() 
	// Tests append to ensure the value added is added to the end.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.append(4);
		
		assertEquals("3 2 1 4", test.toString());
	}
	
	@Test
	void testAppendCount() 
	// Tests append to ensure the value added is added to the end.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.append(4);
		
		assertEquals(4, test.count());
	}
	
	@Test
	void testSize() 
	// Tests to make sure the initial list size reading is correct.
	{
		SimpleList test = new SimpleList();
		
		assertEquals(10, test.size());
	}
	
	@Test
	void testAddSize() 
	// Tests to ensure the array grows properly in the event of an overflow.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		
		assertEquals(15, test.size());
		
	}
	
	@Test
	void testRemoveSize() 
	// Ensures the array shrinks properly in the event of a removal.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(7);
		test.add(4);
		test.add(3);
		
		test.remove(7);
		
		assertEquals(7, test.size());
	}
	
	@Test
	void testFirst() 
	// Ensures first() returns the correct value.
	{
		SimpleList test = new SimpleList();
		
		test.add(1);
		test.add(7);
		test.add(4);
		test.add(3);
		
		assertEquals(3, test.first());
	}
	
	


}
