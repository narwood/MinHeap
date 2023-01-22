package a4;

public class Print {

   public static void heap (MinHeap h) { 
      int[] elts = h.getArray();
      int e;
      
      System.out.println();
      System.out.println("----heap-array-----------------");
      for(int i=1; i<=h.size(); i++) {
        System.out.print(elts[i] + ", ");
      }
      System.out.println();
      System.out.println("----end------------------------"+"\n");
   }

}
