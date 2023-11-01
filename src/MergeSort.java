import java.util.Comparator;
import java.util.Arrays;
/**
 * Sort using merge sort.
 *
 * @author Your Name Here
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  
  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int left = 0;
    int right = values.length;
    int mid = left+right/2;
    int newI = 0;

    T[] rightArray = Arrays.copyOfRange(values, left, mid);
    T[] leftArray = Arrays.copyOfRange(values, mid+1, right);

    // for (int i=0; values[i]!= values[mid]; i++){
    //   leftArray[i] = values[i];
    // }
    // for (int i=mid+1; values[i]!= values[right]; i++){
    //   rightArray[newI] = values[i];
    //   newI++;
    // }
    int rightIndex = 0;
    int leftIndex = 0;

    for (int i=0; (!((leftArray[leftIndex]==null) || (rightArray[rightIndex] == null))); i++){
      if ((order.compare(leftArray[leftIndex], rightArray[rightIndex])) < 0){
         values[i] = leftArray[leftIndex];
         leftArray[leftIndex] = null;
         leftIndex = leftIndex + 1;
      }
      if ((order.compare(leftArray[leftIndex], rightArray[rightIndex])) == 0){
         values[i] = leftArray[leftIndex];
         leftArray[leftIndex] = null;
         leftIndex = leftIndex + 1;
      }
      if ((order.compare(leftArray[leftIndex], rightArray[rightIndex])) > 0){
         values[i] = rightArray[rightIndex];
         rightArray[rightIndex] = null;
         rightIndex = rightIndex + 1;
      }
    }
    }
  } // sort(T[], Comparator<? super T>
 // class MergeSort
