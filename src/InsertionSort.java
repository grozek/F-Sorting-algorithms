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

  public <T> void swap(T[] values, int a, int b){
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int x;

    for (int i=1; i < values.length; i++){
      if ((order.compare(values[i],values[i-1]) < 0)){
        swap(values, i, i-1);
        x = 1;
        //if its out of bounds then stop
        while (order.compare(values[i-x],values[i-x-1]) < 0){
          swap(values, i-x, i-x-1);
          x++;

          if (i-x == 0){
          break;
        }
        }
      }

    }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
