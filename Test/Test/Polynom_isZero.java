package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_isZero {

	/**
	 * This test checks the isZero function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("0x^2 + 0*x^4 + 0*x");
		assertEquals(true,p.isZero());
	}
}
