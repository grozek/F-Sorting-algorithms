import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using Quicksort.

 * @author Gabriela Roznawska
 *  November 3rd 2023 
 * CSC-207 MP6 
 * Acknowledgements: Prof Rebelsky, Mentor Pom and my individual tutor
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {} // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public <T> void swap(T[] values, int a, int b) {
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }// swap


  // sorts out the array initially
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sortHelper(values, order, 0, values.length-1);

  }

  public <T> void sortHelper(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (lb < ub) {
      int part = partition(values, order, lb, ub);
      sortHelper(values, order, lb, part - 1);
      sortHelper(values, order, part + 1, ub);
    }
  } // sort(T[], Comparator<? super T>


  public <T> int partition(T[] values, Comparator<? super T> order, int lb, int ub) {

    int sm = lb + 1;
    int lg = ub;
    T pivot = values[lb];

   while (sm <= lg) {
      while (sm <= lg && order.compare(values[sm], pivot) <= 0) {
        sm++;
      } 
      while (sm <= lg && order.compare(values[lg], pivot) > 0) {
        lg--;
      }
      if(sm < lg){
        swap(values, sm, lg);
      }
    }
    
      // }
    //}
    
    swap(values, lb, lg);
    
  
    return lg;
  
} // class Quicksort
}