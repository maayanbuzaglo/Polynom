package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_check_Duplicate {

	/**
	 * This test checks the check_Duplicate function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 + 3*x^4 + 3*x + 3*x");
		Polynom p2 = new Polynom("7x^2 + 3*x^4 + 6*x");
		p.check_Duplicate();
		assertEquals(true,p.equals(p2));
	}
}
