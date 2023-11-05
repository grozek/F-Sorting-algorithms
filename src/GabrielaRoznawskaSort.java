
import java.util.Comparator;


/**
 * Sort using merge sort and insertion sort mix
 *
 * @author Gabriela Roznawska
 *  November 3rd 2023 
 * CSC-207 MP6 
 * Acknowledgements: Prof Rebelsky, Mentor Pom and my individual tutor
 */

public class GabrielaRoznawskaSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new GabrielaRoznawskaSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  GabrielaRoznawskaSort() {} // GabrielaRoznawskaSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  public <T> void swap(T[] values, int a, int b) {
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }// swap


  @Override

  public <T> void sort (T[] values, Comparator <? super T> order){
    int left = 1;
    int right = values.length-2;
    int i = 0;
    while (i < values.length/2){
      sortHelper(values, order, left, right);
      i++;
    }
  }

  public <T> void sortHelper (T[] values, Comparator <? super T> order, int left, int right){
    while  (right > 0 && left < values.length-1){
      if(order.compare(values[left-1], values[left]) > 0){
        swap(values, left, left-1);
    }
      if(order.compare(values[left], values[left+1]) > 0){
        swap(values, left, left+1);
    }
      if(order.compare(values[right], values[right-1]) < 0){
        swap(values, right, right-1);
    }
      if(order.compare(values[right+1], values[right]) < 0){
        swap(values, right, right+1);
    }
    right--;
    left++;
    
  } 
}
}
  // @Override
  // public <T> void sort(T[] values, Comparator<? super T> order) {
  //   int j = 1;
  //   int n = 0;
  //   sortHelper(values, order, j, n);
  //   j = 2;
  //   while(j < values.length-1){
  //   sortHelper(values, order, j, n);
  //   j = j+2;
  //   }
  // }


  // public <T> void sort(T[] values, Comparator<? super T> order) {

  // }

//   public <T> void sortHelper(T[]values, Comparator<? super T> order, int j, int n){
//     while (n < values.length){
//       if(order.compare(values[n], values[n+j]) < 0){
        
//       }
//       if(order.compare(values[n], values[n+j]) > 0){
//         swap(values, n, n+j);
        
//       }
//       n = n+2;
//     }    
//   }
// }
