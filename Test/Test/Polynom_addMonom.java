package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Polynom;
import myMath._Exception;

class Polynom_addMonom {
	
	/**
	 * This test checks the add function (add Monom to Polynom).
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Polynom p = new Polynom("7x^2 + 3*x^4 + 3*x");
		Polynom p2 = new Polynom("1x^2");
		Polynom p3 = new Polynom("8x^2 + 3*x^4 + 3*x");
		p.add(p2);
		assertEquals(true,p.equals(p3));
	}
}
