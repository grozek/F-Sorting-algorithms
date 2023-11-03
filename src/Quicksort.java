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
    int len = values.length;
    sortHelper(values, order, 0, len);

  }

  public <T> void sortHelper(T[] values, Comparator<? super T> order, int lb, int ub) {
    // int len = values.length;
    // T[] rightArray = Arrays.copyOfRange(values, 0, len / 2);
    // T[] leftArray = Arrays.copyOfRange(values, len / 2, len - 1);
    if (lb != ub) {
      int part = partition(values, order, lb, ub);
      sortHelper(values, order, lb, part);
      sortHelper(values, order, part + 1, ub);
    }
  } // sort(T[], Comparator<? super T>


  public <T> int partition(T[] values, Comparator<? super T> order, int lb, int ub) {
    int sm = 1;
    int lg = ub;
    // if ( != lg) {
    // partition (values, order, lb, ub);
    T pivot = values[lb];
    // should i put pivot to the ub/2 and then shift all ub/2+1 until len back ??????
    while (sm < lg) {
      if ((order.compare(values[sm], pivot)) <= 0) {
        sm++;
      } else {
        swap(values, sm, lg);
        lg--;
      }
      // }
    }
    swap(values, lb, sm - 1);
    return sm - 1;
  }
} // class Quicksort
