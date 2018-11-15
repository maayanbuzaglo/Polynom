package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_equals {

	/**
	 * This test checks the equals function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 + 3*x^4 + 3*x");
		Polynom p2 = new Polynom("3*x^4 + 7x^2 + 3*x");
		assertEquals(true,p.equals(p2));
	}
}
