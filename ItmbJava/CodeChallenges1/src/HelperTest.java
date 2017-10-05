

import org.junit.Assert;
import org.junit.Test;

public class HelperTest {
//   @Test
   //Test when giving n return nth item in fbonacci sequence
//   public void testFibonacci() {
//       Assert.assertEquals(2, Helper.fibonacci(3));
//       Assert.assertEquals(610, Helper.fibonacci(15));
////       Assert.assertEquals(-1, Helper.fibonacci(-2));
//       Assert.assertEquals(-1, Helper.fibonacci(-1));
//   }
   
   @Test
   //Test when giving a sentence return reverse words
   public void testReverse() {
       Assert.assertEquals("gnuH", Helper.reverse("Hung"));
       Assert.assertEquals("gnuH", Helper.reverse("Hung"));
       Assert.assertEquals("ziR al ssa", Helper.reverse("Riz la ass"));
       Assert.assertEquals("", Helper.reverse(""));
   }
   
   @Test
   //Tests when giving three numbers returns triangle type
   public void testTriangleType() {
       Assert.assertEquals("Scalene", Helper.triangleType(3,4,5));
       Assert.assertEquals("Isosceles", Helper.triangleType(2,2,3));
       Assert.assertEquals("Isosceles", Helper.triangleType(2,3,3));
       Assert.assertEquals("Equilateral", Helper.triangleType(3,3,3));
       Assert.assertEquals("Error", Helper.triangleType(-3,2,1));
       Assert.assertEquals("Error", Helper.triangleType(4,4,9));
   }
}
