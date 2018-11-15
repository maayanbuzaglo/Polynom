package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath._Exception;

class Monom_derivative {

	/**
	 * This test checks the derivative function.
	 * @throws _Exception 
	 */
	@Test
	void test() throws _Exception {
		Monom m = new Monom("x^2");
		Monom n = new Monom("2x");
		Monom c = m.derivative();
		assertEquals(true,c.equal(n));
	}
}
