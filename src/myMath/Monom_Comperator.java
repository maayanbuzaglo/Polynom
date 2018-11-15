package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	// ******** add your code below *********

	@Override
	/**
	 * This function checks if 2 Monoms have the same power.
	 * if they does return 0.
	 * else if the first is bigger then the second return a positive number.
	 * else return a negative number.
	 */
	public int compare(Monom arg0, Monom arg1) {
		return arg0.get_power() - arg1.get_power();
	}
}
