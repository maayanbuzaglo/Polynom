package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath._Exception;

class Monom_equal {

	/**
	 * This test checks the equal function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Monom m1 = new Monom(5,2);
		Monom m2 = new Monom(5,2);
		assertEquals(true,m1.equal(m2));
	}
}
