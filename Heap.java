package a4;

public interface Heap {
  
  void insert(int p);
  // Insert adds the element p to the heap.
  // 
  // In this heap the element is an int and IS the priority.
  // 
  // We do not know at this abstract level if this will be
  // a min-heap or a max-heap (or even something else like
  // a fibonacci heap) and those details will be added in
  // the class that implements this heap interface.
  // Duplicate values are allowed.
  //
  // Error: The insert should fail if the heap is "full"
  // meaning the array is maxed out and there is no room
  // in the array for another element.  In this case
  // simply return, and do nothing.

  //Min-heap example:
  //  Suppose we have the following min-heap:
  //  3, 5, 4, 12, 6, 9

  // After inserting 2, the min-heap now looks as follows:
  //  2, 5, 3, 12, 6, 9, 4
  
  void delFront();
  // Remove the "next" item from the heap, however "next" 
  // is defined... in this assignment our implementing class
  // will be a minimum binary heap so this method will remove
  // the item with the smallest priority value.
  //
  // Error: If the heap is empty there is nothing to remove so
  // simply return in this case... do nothing

  //Min-heap example:
  // Suppose we have the following min-heap:
  // 2, 3, 4, 16, 7, 11, 9, 31, 18, 21, 12

  // After calling delFront(), the min-heap now looks as follows:
  // 3, 7, 4, 16, 12, 11, 9, 31, 18, 21
  
  int getFront();
  // Return the element that is "next" however that is defined.
  // Note that this method does not change the state of the heap;
  // no elements are removed or moved.
  //
  // Error: if the heap is empty there is nothing to return,
  // so in this case raise the exception "IllegalStateException"

  //Min-heap example:
  // Suppose we have the following min-heap:
  // 3, 5, 4, 12, 6, 9

  //After calling getFront(), the value 3 is returned and the min-heap looks as follows (unchanged):
  // 3, 5, 4, 12, 6, 9

  boolean empty();
  // Return true or false... is this heap of size 0 or not?

  //Min-heap example:
  // Suppose we have the following min-heap:
  // 3, 5, 4, 12, 6, 9

  //empty() would return false.

  int size();
  // Return the count of the number of elements that are currently
  // in the heap.
  // Note this "int" return is really a positive int or 0

  //Min-heap example:
  // Suppose we have the following min-heap:
  // 3, 5, 4, 12, 6, 9

  //size() would return 6.

  void clear();
  // This operation should return the heap to the original state
  // in which there are no elements in it (size is 0).
  // There is no need to reallocate a new array, although it is
  // not an error to do that.  If you do allocate a new array,
  // then it should have the same max size that the original
  // heap was made with.
      
  int[] sort();
  // Not quite a heap sort but almost.
  // This method should make a new array of elements to return, 
  // and the elements in the new array should be the same values 
  // that are in the heap, but in sorted order, smallest to largest.
  // Start the new returned array at slot 0, so in the returned array
  // slot 0 will have the smallest element from the heap... and
  // then up from there.

  //Min-heap example:
  // Suppose we have the following min-heap:
  // 3, 5, 4, 12, 6, 9

  // sort() would return an array containing 3,4,5,6,9,12.
  
  void build (int[] elts, int N); 
  // The "magic" build operation which constructs a heap in O(N) time
  // the first parameter is an array that contains all the elements that
  // will go into the heap; the second parameter tells how many elements
  // there are (so that the array "elts" can be larger than the number
  // of elements in it... we do not depend on elts.length to determine
  // the size of heap we build.
  //
  // The method works as follows: 
  // first:  the heap that is doing the build will do a clear() 
  //         and it will lose any elements already in that heap
  // second: load the elements in parameter "elts" into the heap
  //         array directly ( a O(N) copying action )
  // third:  perform the "bubble down" operations that a build
  //         requires on the heap array
  // 
  // When testing look to find a sequence of elements that let you 
  // get two different heap structure when you 
  //   1) create a heap from N separate inserts
  //   2) do this build method
  //
  // Here is one such sequence: 101, 37, 26, 19, 15, 12, 9, 2, 3, 5
  //
  // Here is another (from your class PPT): 6, 12, 9, 4, 5, 3
  //
  // Example:  If you call insert on each element one-by-one
  // for the sequence 6, 12, 9, 4, 5, 3, you obtain the following min-heap:

  // 3, 5, 4, 12, 6, 9

  // However, build() will produce the following min-heap:
  // 3, 4, 6, 12, 5, 9
}
