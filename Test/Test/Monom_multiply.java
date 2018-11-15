package Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import myMath.Monom;
import myMath._Exception;

class Monom_multiply {

	/**
	 * This test checks the multiply function.
	 * @throws _Exception
	 */
	@Test
	void test() throws _Exception {
		Monom m1 = new Monom(5,2);
		Monom m2 = new Monom(4,2);
		Monom m3 = new Monom(20,4);
		Monom c = m1.multiply(m2);
		assertEquals(true, c.equal(m3));
	}
}
