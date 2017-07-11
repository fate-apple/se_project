package andycpp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	/*你要测试哪个类，那么你首先就要创建一个该类的对象*/
    private static Calculator calculator=new Calculator();
    /*在任何一个测试执行之前必须执行的代码就是一个Fixture，我们用@Before来标注它*/
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5,calculator.getResult());
	}

	@Test
	public void testSubstract() {
		calculator.add(10);
		calculator.substract(2);
		assertEquals(8,calculator.getResult());
		
	}
    @Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
		
	}

	@Test
	public void testDivide() {
		calculator.add(8);
		calculator.divide(2);;
		assertEquals(4,calculator.getResult());
	}

}
