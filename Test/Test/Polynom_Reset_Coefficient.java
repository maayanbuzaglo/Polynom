package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_Reset_Coefficient {

	/**
	 * This test checks the Reset_Coefficient function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("0x^2 - 0*x^4 + 3*x");
		Polynom p2 = new Polynom("3*x");
		p.Reset_Coefficient();
		assertEquals(true,p.equals(p2));
	}
}
