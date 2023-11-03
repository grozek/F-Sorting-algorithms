import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;

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
  public static Sorter SORTER = new MergeSort();

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

  public <T> void SortHelper(T[] values, Comparator<? super T> order, int left, int right) {}
}
