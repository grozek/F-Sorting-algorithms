import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Gabriela Roznawska
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expecting = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expecting);
  } // orderedStringTest

  @Test
  public void theSameLetterTest(){
    String[] original = { "aelta", "alavo", "arpha" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }//theSameLengthTest

  @Test
  public void oneStringTest(){
    String[] original = { "alpha" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }//oneStringTest

  @Test
  public void mixedWordsTest(){
    String[] original = { "alpha", "delta", "bravo", "hotel", "charlie", "kilo"};
    String[] expected = { "alpha", "bravo", "charlie", "delta", "hotel", "kilo"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }//mixedWordsTest

  
} // class SortTester
