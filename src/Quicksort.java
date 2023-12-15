import java.util.Comparator;

/**
 * Quicksort.java
 * This program sorts using Quicksort.
 * 
 * @author Gabriela Roznawska 
 * November 3rd 2023 
 * CSC-207 
 * MP6 Acknowledgements: Prof Rebelsky, Mentor Pom and my individual tutor https://www.geeksforgeeks.org/quick-sort/ : I have used this
 * resource to learn more about the QuickSort as I struggled with it immensly. I
 * intentionally did not look at the Java version of the algorithm, but read the text and
 * used the helpful graphics.
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

  /**
   * Unless the input consists of one or less input items, then perform the QuickSort algorithm
   */
  public <T> void swap(T[] values, int a, int b) {
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  } // swap (T[], int, int)


  /**
   * Passes the values and calls for the sortHelper which performs Quick Sort algorithm
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sortHelper(values, order, 0, values.length - 1);
  } // sort(T[], Comparator <? super T>)

  /**
   * If the lower bound is lower than the higher bound, then partition the array and save the pivot
   * index so that it can be used in the recursive calls of SortHelper to split the array into two
   * parts: of higher and lower items.
   */
  public <T> void sortHelper(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (lb < ub) {
      int part = partition(values, order, lb, ub);
      sortHelper(values, order, lb, part - 1);
      sortHelper(values, order, part + 1, ub);
    } // if
  } // sort(T[], Comparator<? super T>

  /**
   * Perform partition of the input array. A pivot is chosen as the first item of the array and then
   * compared to the rest of the items. If they are lower than pivot, then the sm-small bound is
   * moved up. If they are larger, then the item in the end of sm-lg bounds is swapped with said
   * item and the lg bounds are moved down. When the whole array is invesitgated, the pivot is put
   * in the middle and its index is returned
   */
  public <T> int partition(T[] values, Comparator<? super T> order, int lb, int ub) {
    int sm = lb + 1;
    int lg = ub;
    T pivot = values[lb];
    while (sm <= lg) {
      while (sm <= lg && order.compare(values[sm], pivot) <= 0) {
        sm++;
      } // while
      while (sm <= lg && order.compare(values[lg], pivot) > 0) {
        lg--;
      } // while
      if (sm < lg) {
        swap(values, sm, lg);
      } // if
    }
    swap(values, lb, lg);
    return lg;
  } // partition(T[], Comparator<? super T>, int, int)
} // class Quicksort
