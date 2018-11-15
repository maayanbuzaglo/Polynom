package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_substract {

	/**
	 * This test checks the substract function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 + 3*x^4 + 3*x");
		Polynom p2 = new Polynom("1x^2 - 1x^4 + 1x");
		Polynom p3 = new Polynom("6x^2 + 4x^4 + 2*x");
		p.substract(p2);
		assertEquals(true,p.equals(p3));
	}
}
