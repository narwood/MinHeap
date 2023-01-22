package a4;

import java.util.Arrays;
public class Main {


  public static MinHeap make(int[] e) {
    MinHeap hp = new MinHeap();
    for (int i = 0; i < e.length; i++) {
      hp.insert(e[i]);
    }
    return hp;
  }
  public static void main(String[] args) {

    /*You are free to test your code however you wish.  Some code samples
    are commented below as an example.  These operations (e.g., insert, build)
    won't function correctly until you provide the implementation in MinHeap.java.
     */



    //int[] e = new int[] {  101, 37, 26, 19, 15, 12, 9, 2, 3, 5  };
    int[] e = new int[] {  3, 5, 4, 12, 6, 9  };
    int[] f = new int[] {101, 37, 26, 19, 15, 12, 9, 2, 3, 5};
    MinHeap hq = new MinHeap();
    hq.build(f, 10);
    int[] sort;
    sort = hq.sort();
    System.out.println(Arrays.toString(hq.getArray()));
    System.out.println(Arrays.toString(sort));

    /*for (int i = 1; i<=10; i++) {
      hq.delFront();
      System.out.println(Arrays.toString(hq.getArray()));
    }*/




    /*hq.build(f, 6);
    int[] val = hq.getArray();
    System.out.println(Arrays.toString(val));
    */

   // for (int i = 0; i<=5; i++) {
     // hq.delFront();
     // System.out.println(Arrays.toString(hq.getArray()));
    //}


    //System.out.println("Array view:");

    /*
    System.out.println("heap many inserts: ");
    Print.heap(hp);  // one form

    
    hp.build(e,6);
    System.out.println("heap magic build: ");
    Print.heap(hp);  // another form
    */

  }
}

