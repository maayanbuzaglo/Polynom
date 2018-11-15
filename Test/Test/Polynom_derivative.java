package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_derivative {

	/**
	 * This test checks the derivative function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 - 3*x^4 + 3*x");
		Polynom p2 = new Polynom("14x - 12x^3 + 3");
		Polynom p3 = (Polynom)p.derivative();
		assertEquals(true,p2.equals(p3));
	}
}
