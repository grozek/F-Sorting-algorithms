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
 * The fakeTest(), orderedStringTest() and reverseOrdereeedStringTest() as well as the Sorter class were 
 * provided by the prof. Samuel Rebelsky. The remainder of the tests is my own edition.
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

  @Test
   public void longWordsTest(){
      String[] original = {"lemur", "alpaca", "dog", "cat", "anteater", "leopard", "cheeta", "turtle", 
      "dinoasaur", "salamandra", "bird", "tucan", "elephant", "pig", "cow", "bison", 
      "goat", "hen", "donkey", "horse", "llama", "fox", "bear", "duck", "hog", 
      "wolf", "lion", "sloth", "panda", "koala", "deer", "moose", "frog", "slug", 
      "fly", "bee", "hummingbird"};
      String [] expected = {"alpaca", "anteater", "bear", "bee", "bird", "bison", 
      "cat", "cheeta", "cow", "deer", "dinoasaur", "dog", "donkey", "duck", "elephant", 
      "fly", "fox", "frog", "goat", "hen", "hog", "horse", "hummingbird", "koala", "lemur", 
      "leopard", "lion", "llama", "moose", "panda", "pig", "salamandra", "sloth", "slug", 
      "tucan", "turtle", "wolf"};
       sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(original, expected);
   }//longWordsTest

   @Test
   public void repeatedString (){
      String[] original = {"bird", "moose", "sloth", "llama", "bird", "moose", "llama", 
      "moose", "sloth", "bird", "sloth", "moose"};
      String[] expected = {"bird", "bird", "bird", "llama", "llama", "moose", "moose", 
      "moose", "moose", "sloth", "sloth", "sloth"};
      sorter.sort(original, (x, y) -> x.compareTo(y));
      assertArrayEquals(original, expected);
   }//repeatedString

} // class SortTester
