import java.util.Comparator;
import java.util.Arrays;

/**
 * Sort using merge sort.
 * 
 * @author Gabriela Roznawska 
 * November 3rd 2023 
 * Acknowledgements: Prof Rebelsky, Mentor Pom Dao and
 * an individual tutor Destany Best
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

   /*
    * Unless the input consists of one or less input items, then perform the MergeSort algorithm
    */
   @Override
   public <T> void sort(T[] values, Comparator<? super T> order) {

      if (values.length <= 1) {
         return;
      } // if
      sortHelper(values, order, 0, values.length - 1);

   }// sort(T[], Comparator<? super T>

   /*
    * If the left is lower than right, then compute the middle and recursively split the input into
    * singular numbers and then merge them into one array, where the numbers are put in raising
    * order. If one array "runs out" of numbers then just simply add the end of the remaining array
    * to the back of new array
    */
   public <T> void sortHelper(T[] values, Comparator<? super T> order, int left, int right) {
      if (left < right) {
         int mid = (left + right) / 2;
         sortHelper(values, order, left, mid);
         sortHelper(values, order, mid + 1, right);
         T[] rightArray = Arrays.copyOfRange(values, left, mid + 1);
         T[] leftArray = Arrays.copyOfRange(values, mid + 1, right + 1);
         int rightIndex = 0;
         int leftIndex = 0;
         int i = left;
         while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if ((order.compare(leftArray[leftIndex], rightArray[rightIndex])) <= 0) {
               values[i] = leftArray[leftIndex];
               leftIndex++;
            } else {
               values[i] = rightArray[rightIndex];
               rightIndex++;
            } // else
            i++;
         } // while
         while (leftIndex < leftArray.length) {
            values[i] = leftArray[leftIndex];
            i++;
            leftIndex++;
         } // while
         while (rightIndex < rightArray.length) {
            values[i] = rightArray[rightIndex];
            i++;
            rightIndex++;
         } // while
      } // if
   } // sorterHelper(T[], Comparator<? super T, int, int>
} // class MergeSort


