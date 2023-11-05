
import java.util.Comparator;


/**
 * Personal sort inspired by the Bubble Sort
 *
 * @author Gabriela Roznawska
 *  November 3rd 2023 
 * CSC-207 MP6 
 * Acknowledgements: 
 * ChatGPT: I asked ChatGPT about some other commonly used algorithms that could serve me as an idea to build upon. 
 * One of his answers was "Bubble Sort", which I liked the name of, so asked for a bried description of what it is.
 * This algorithm sounded quite simple and friendly so after this interaction with Chat, I proceeded to write my 
 * bubble-sort inspired algorithm.
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

   /*
  * Unless the input consists of one or less input items, then perform the MergeSort algorithm
  */
  public <T> void swap(T[] values, int a, int b) {
    T temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }// swap

/*
 * While the i is lower than half of the length of the input array, perform a call to sortHelper
 * with left and right values.
 */
  @Override
  public <T> void sort (T[] values, Comparator <? super T> order){
    int left = 1;
    int right = values.length-2;
    for(int i=0; i < values.length/2; i++){
      sortHelper(values, order, left, right);
    }
  }

/*
 * While the right and left are within the bounds of the array, compare items on their 
 * leftmost, almost leftmost, rightmost and almost rightmost indexes. Move the lower items
 * towards the fornt, and the higher ones towards the back.
 */
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
  }//sortHelper(T[], Comparator<? super T>, int, int)
}//GabrielaRoznawskaSort
