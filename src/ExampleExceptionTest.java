import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {5, 5, 25},
        {3 ,4, 12}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {-3, -4},
        {-5, -5}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a,b), c, "result is not correct");
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a, b);
    } catch (IllegalArgumentException ie) {
      assertEquals(ie.getMessage(), "input value is below zero!");
    }
  }
}