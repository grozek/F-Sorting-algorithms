import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  Character[] array;
  int max;

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
    max = 30;
    array = new Character[max];
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /* 
   * Given an array of items swaps the values of items with provided indexes
   */
  public <T> void swap(T[] values, int a, int b) {
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }//swap

  /* 
   * Provided unsorted array of items, performs insertion sort and sorts out the array.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int x = 0;
    for (int i = 1; i < values.length; i++) {
      if ((order.compare(values[i], values[i - 1]) < 0)) {
        x = 0;
        while (order.compare(values[i - x], values[i - x - 1]) < 0) {
          swap(values, i - x, i - x - 1);
          if (i - x - 1 == 0) {
            break;
          }
          x++;
        }
      }
    }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
