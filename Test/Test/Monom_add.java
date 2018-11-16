package Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import myMath.Monom;
import myMath._Exception;

class Monom_add {

	/**
	 * This test checks the add function.
	 * @throws _Exception 
	 */
	@Test
	void test() throws _Exception {
		Monom m = new Monom(5,2);
		Monom n = new Monom(10,2);
		Monom mn = new Monom(15,2);
		Monom c = m;
		assertEquals(true,c.equal(mn));
	}
}
