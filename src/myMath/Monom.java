package myMath;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Maayan
 *
 */
public class Monom implements function {

	public Monom(double a, int b) throws _Exception {
		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom(Monom ot) throws _Exception {
		this(ot.get_coefficient(), ot.get_power());
	}

	// ***************** add your code below **********************

	/**
	 * This contractor gets the shape a*x^b and take the coefficient and the power of the Monom.
	 * @param s
	 * @throws _Exception
	 */
	public Monom(String s) throws _Exception {
		s = s.toLowerCase();
		if(s.contains("x")) { // to check if has power.
			if(s.charAt(0) == 'x') {
				s = '1' + s;
			}
			if(s.charAt(0) == '-') {
				if(s.charAt(1) == 'x') {
					s  = s.replace('-', '1');
					s = '-' + s;
				}
			}
			String[] arr = s.split("x"); // I divided by x.
			if(arr[0].contains("*"))
				arr[0] = arr[0].substring(0,arr[0].length()-1); // Remove the multiply.
			this._coefficient = Double.parseDouble(arr[0]); // Change coefficient from String to double.
			if(arr[0].equalsIgnoreCase("x")) {
				this._coefficient = 1;
			}
			if(arr.length > 1) {
				arr[1] = arr[1].substring(1,arr[1].length()); // Remove the power.
				if(arr[1].charAt(0) == '-') { // Check if the power is a negative number.
					throw new _Exception("Negative number.");
				}
				else {
					this._power = Integer.parseInt(arr[1]); // Change power from String to Integer.
				}
			}
			else this._power = 1;
		}
		else {
			this._power = 0;
			this._coefficient = Double.parseDouble(s);
		}
	}

	public Monom() {
		this._coefficient = 0;
		this._power = 0;
	}

	/**
	 * This function gives us value at x.
	 */
	public double f(double x) {	
		return this._coefficient * (Math.pow(x,this._power));
	}

	/**
	 * This function gives us Monom's derivative.
	 * @throws _Exception 
	 */
	public Monom derivative() throws _Exception {
		if(this._power == 0) {
			return new Monom(0,0);
		}
		return new Monom(this._coefficient * this._power, this._power - 1);
	}

	/**
	 *This function check if the power of 2 Monoms equals.
	 *if yes: add.
	 *else: exception.
	 * @throws _Exception 
	 */
	public Monom add(Monom m) throws _Exception {
		if(this._power != m._power) {
			throw new _Exception("Dont have the same power.");
		}
		Monom m2 = new Monom(this._coefficient + m._coefficient,this._power);
		return m2;
	}

	/**
	 * This function multiply 2 Monoms.
	 * @throws _Exception 
	 */
	public Monom multiply(Monom m) throws _Exception {	
		return new Monom(this._coefficient * m._coefficient,this._power + m._power);
	}

	/**
	 * This function check if 2 Monoms are equal.
	 * @param m
	 * @return
	 */
	public boolean equal(Monom m) {
		return this.get_coefficient() == m.get_coefficient() && 
				this.get_power() == m.get_power();
	}

	@Override
	public String toString() {
		return _coefficient + "*x^" + _power;
	}

	public void set_coefficient(double a){
		this._coefficient = a;
	}

	public double get_coefficient() {
		return _coefficient;
	}

	public void set_power(int b) throws _Exception {
		if(b < 0) {
			throw new _Exception("Negative power.");
		}
		//else if(b==0)
		this._power = b;
	}

	public int get_power() {
		return _power;
	}

	//****************** Private Methods and Data *****************

	private double _coefficient; 
	private int _power;
}