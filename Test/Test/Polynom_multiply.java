package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_multiply {

	/**
	 * This test checks the add function (add Polynom to Polynom).
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 + 3*x");
		Polynom p2 = new Polynom("7x^2 - 3*x");
		Polynom p3 = new Polynom("49x^4 + -9x^2");
		p.multiply(p2);
		assertEquals(true,p.equals(p3));
	}
}
