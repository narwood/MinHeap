package a4;

public class MinHeap implements Heap {

  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size

  // ================================================
  // constructors
  // ================================================

  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }

  public MinHeap() { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================

  public int[] getArray() { // do not change this method
    return this.elts;
  }
  public int getMax() {return this.max;}
  public int getSize() {return this.size;}

  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //========================================================= 


  public void insert(int p) {
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    if (size == max) {
      return;
    }
    if (size == 0) {
      elts[1] = p;
      size++;
      return;
    }
    elts[size + 1] = p;
    int i = size + 1;
    size++;
    while (elts[i / 2] > elts[i]) { //if parent > child
      if (i < 2) {
        return;
      } //guard against index error
      int temp = elts[i]; //store child in temp
      elts[i] = elts[i / 2]; //bubble down parent
      elts[i / 2] = temp; //bubble up child
      i = i / 2; //reset counter to child's new index
    }
  }


  public void delFront() {
    if (size == 0) {return;} //empty

    if (size == 1) { //only has root
      elts[1] = 0;
      size--;
      return;
    }

    int hole = 1; // keep track of where hole is
    int fill = elts[size];

    while (hole < (size/2)) { // while hole has children
      if ((fill<=elts[2*hole]) && (fill<=elts[2*hole+1])) { //if both C> last leaf
        elts[hole] = fill;
        elts[size] = 0;
        size--;
        return;
      }
      if (elts[2*hole] < elts[2*hole+1]) { //if LC < RC
        elts[hole] = elts[2*hole]; //fill hole
        hole = 2*hole; //move hole
      } else { //if RC >= LC
        elts[hole] = elts[2*hole+1];
        hole = 2*hole+1;
      }
    }

    if (elts[2*hole] == 0) { //no children, so fill hole
      elts[hole] = fill;
      elts[size] = 0;
      size--;
      return;
    }
    if (elts[2*hole+1] == 0) { //RC is 0, so fill hole w LC
      if (elts[2*hole]>=fill) {
        elts[hole] = fill;
      }
      else {
        elts[hole] = elts[2 * hole];
        elts[2 * hole] = fill;
      }
      elts[size] = 0;
      size--;
      return;
    }
    if ((elts[2*hole+1]!=0) && (elts[2*hole]!=0)) { //2 children - working on parent of last node
      if (elts[2*hole]<=fill) {
        elts[hole] = elts[2*hole];
        elts[2*hole] = fill;
      }
      else {
        elts[hole] = fill;
      }
      elts[size] = 0;
      size--;
    }
  }

  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    if (size == 0) {
      throw new IllegalStateException(); //Dummy return statement.  Remove (or move elsewhere) when you implement!
    }
    return elts[1];
  }


  public boolean empty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    return size;
    //Dummy return statement.  Remove (or move elsewhere) when you implement!
  }

  public void clear() {
    if (size == 0) {
      return;
    }
    for (int i = 1; i <= size; i++) {
      elts[i] = 0;
    }
    size = 0;
  }

  public void build(int[] e, int ne) {
    //Hint: remember to skip slot 0 in the heap array.
    this.clear(); //clear heap
    this.elts[0] = 0;
    for (int i = 0; i < ne; i++) { //load values into elts
      this.elts[i + 1] = e[i];
    }
    this.size = ne;

    int mark = size / 2; //move mark to parent of last node
    int check = mark; //begin checking at the mark
    int temp;
    boolean done = false;


    if (size%2 == 0) { //special case - first parent node has only LC
      if (elts[size/2] > elts[size]) {
        temp = elts[size];
        elts[size] = elts[size/2];
        elts[size/2] = temp;
      }
      mark = mark-1;
      check = check-1;//move on to next parent, which must have 2 C to satisfy heap structure
    }

    while (mark >= 1) { //until mark hits root
      while (check <= size/2 && !done) { //while check still has children
        if ((elts[check] > elts[2 * check]) || (elts[check] > elts[2 * check + 1])) { //if smaller child, enter loop
          if (elts[2 * check + 1] <= elts[2 * check]) { //pick the smaller child to switch with
            temp = elts[2 * check + 1]; //          ---
            elts[2 * check + 1] = elts[check];//      |
            elts[check] = temp;//                     |--> swap and check next level
            check = check * 2 + 1; //               ---
          } else {
            temp = elts[2 * check];
            elts[2 * check] = elts[check];
            elts[check] = temp;
            check = 2 * check;
          }
        }
        else {done = true;} // if mark doesn't conflict with child, also doesn't conflict with anything below
      }
      mark = mark-1; //move on to next element
      done = false;
      check = mark;
    }
  }

  public int[] sort() {
    // Hint: the smallest element will go in slot 0
    if (this.size == 0) {
      return null;
    }
    if (this.size == 1) {
      int[] r = {elts[1]};
      return r;
    }

    MinHeap newHeap = new MinHeap(this.max);
    for (int i = 1; i <= this.size; i++) { //copy heap
      newHeap.insert(this.elts[i]);
    }

    int[] sortElts = new int[newHeap.size];
    int nextOpen = 0;
    while (!newHeap.empty()) {
      sortElts[nextOpen] = newHeap.elts[1];
      newHeap.delFront();
      nextOpen++;
    }

    return sortElts;
  }


}
