package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;
import myMath._Exception;

class Monom_f {

	/**
	 * This test checks the f function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Monom m = new Monom(1,0);
		double check = m.f(2);
		assertEquals(1,check);
	}
}
