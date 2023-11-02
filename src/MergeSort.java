import java.util.Comparator;
import java.util.ArrayList;
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
   MergeSort() {} // MergeSort()

   // +---------+-----------------------------------------------------
   // | Methods |
   // +---------+

   public <T> void SortHelper(T[] values, Comparator<? super T> order, int left, int right) {

      if (left < right) {
         int mid = (left + right) / 2;

         SortHelper(values, order, left, mid);
         SortHelper(values, order, mid+1, right);
        // ArrayList<T> newArray = new ArrayList<>();
         T[] rightArray = Arrays.copyOfRange(values, left, mid+1);
         T[] leftArray = Arrays.copyOfRange(values, mid + 1, right+1);

         int rightIndex = 0;
         int leftIndex = 0;
         int i = left;
         while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if ((order.compare(leftArray[leftIndex], rightArray[rightIndex])) <= 0) {
               values[i] = leftArray[leftIndex];
               leftIndex++;
            } 
             else{
               values[i] = rightArray[rightIndex];
               rightIndex++;
            }
            i++;
         }
         while (leftIndex < leftArray.length) {
            values[i] = leftArray[leftIndex];
            i++;
            leftIndex++;
         }
         while (rightIndex < rightArray.length) {
            values[i] = rightArray[rightIndex];
            i++;
            rightIndex++;
         }
      }
   }

   @Override
   public <T> void sort(T[] values, Comparator<? super T> order) {

      if (values.length <= 1) {
         return;
      }
      SortHelper(values, order, 0, values.length-1);

   }

}
// sort(T[], Comparator<? super T>
// class MergeSort




