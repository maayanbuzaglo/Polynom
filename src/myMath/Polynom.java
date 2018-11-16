package myMath;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

import myMath.Monom;

/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral.
 * 2. Finding a numerical value between two values (currently support root only f(x) = 0).
 * 3. Derivative.
 * @author Maayan
 *
 */
public class Polynom implements Polynom_able {

	private final Monom_Comperator Compare_Monom = new Monom_Comperator();
	ArrayList<Monom> list_Polinom = new ArrayList<Monom>();
	Iterator<Monom> it;
	Monom mon;
	private final	double eps = 0.01;
	// ********** add your code below ***********

	public Polynom() {

	}

	public Polynom(String s) throws _Exception {
		s.toLowerCase();
		s = s.replaceAll(" - ", " + -");
		String[] arr = s.split(" "); // Split the Polynom to Monoms.
		if(arr.length % 2 == 0) { //Check if the Polynom fine.
			throw new _Exception("Not a good Polinom.");
		}
		for (int i = 0; i < arr.length; i++) {
			this.list_Polinom.add(new Monom(arr[i]));
			i++;
		}
		sort();
	}

	/**
	 * This function sort the Polynom.
	 * from the smallest Monom (smallest power) to the biggest Monom (biggest power).
	 * @throws _Exception for a wrong Monom.
	 */
	public void sort() throws _Exception {
		for (int i = 0; i < this.list_Polinom.size()-1; i++) {
			for (int j = 1; j < this.list_Polinom.size(); j++) {
				if(this.list_Polinom.get(i).get_power() > this.list_Polinom.get(j).get_power()) {
					Monom temp = new Monom();
					Monom temp2 = new Monom(this.list_Polinom.get(i));
					Monom temp3 = new Monom(this.list_Polinom.get(j));
					temp = temp2;
					this.list_Polinom.set(i,temp3);
					this.list_Polinom.set(j,temp);
				}
			}
		}
	}

	/**
	 * This function check if there are 2 Monoms with the same power.
	 *  if there are - add them.
	 * @throws _Exception for a wrong Monom.
	 */ 
	public void check_Duplicate() throws _Exception {
		for (int i = 0; i < this.list_Polinom.size(); i++) {
			for (int j = i+1; j < this.list_Polinom.size(); j++) {
				if(this.list_Polinom.get(i).get_power() == this.list_Polinom.get(j).get_power()) {
					this.list_Polinom.get(i).set_coefficient(this.list_Polinom.get(i).get_coefficient() + 
							this.list_Polinom.get(j).get_coefficient());
					this.list_Polinom.remove(j);	
				}	
			}
		}
		Reset_Coefficient();
		sort();
	}

	/**
	 * This function check if there is Monom with 0 coefficient.
	 * if there is - delete it.
	 */
	public void Reset_Coefficient() {
		for (int i = 0; i < this.list_Polinom.size(); i++) {
			if(this.list_Polinom.get(i).get_coefficient() == 0) {
				this.list_Polinom.remove(i);
				i--;
			}
		}
	}

	/**
	 * This function gets value of x and then compute the value of the Polynom.
	 */
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double ans = 0;
		for(Monom it: this.list_Polinom) {
			ans +=  it.f(x);
		}
		return ans;
	}

	/**
	 * This function add the other list of Monon,
	 *  Then checks duplicate and erase it.
	 * @throws _Exception for a wrong Monom.
	 */ 
	public void add(Polynom_able p1) throws _Exception {
		this.it = p1.iteretor();
		while(it.hasNext()) {
			this.mon = it.next();
			this.list_Polinom.add(mon);
		}
		check_Duplicate();
		sort();
	}

	/**
	 * This function add Monom to the Polinom.
	 * @throws _Exception for a wrong Monom.
	 */
	@Override
	public void add(Monom m1) throws _Exception {
		boolean flag = true;
		for(Monom it: this.list_Polinom) {
			if(it.get_power() == m1.get_power()) {
				it.set_coefficient(it.get_coefficient() + m1.get_coefficient());
				flag = false;
			}
		}
		if(flag) {
			this.list_Polinom.add(m1);
		}
		Reset_Coefficient();
		sort();
	}

	/**
	 * This function check if other Polynom has the same power of Monom.
	 * if it has: subtract the other Monom's coefficient from the original Monom.
	 * else: add - p1 to the Polynom.
	 * @throws _Exception for a wrong Monom.
	 */
	@Override
	public void substract(Polynom_able p1) throws _Exception {
		this.it = p1.iteretor();
		while(this.it.hasNext()) {
			this.mon = it.next();
			this.mon.set_coefficient(-1 * this.mon.get_coefficient());	
		}
		this.add(p1);
		Reset_Coefficient();
		sort();
	}

	/**
	 * This function multiply 2 Polynoms.
	 * @throws _Exception for a wrong Monom.
	 */
	@Override
	public void multiply(Polynom_able p1) throws _Exception {
		ArrayList<Monom> multy_Polinom = new ArrayList<Monom>();
		this.it=p1.iteretor();
		for (int i = 0; i < this.list_Polinom.size(); i++) {
			while (this.it.hasNext()) {
				this.mon = this.it.next();
				multy_Polinom.add(this.list_Polinom.get(i).multiply(this.mon));
			}
			this.it = p1.iteretor();
		}
		this.list_Polinom.clear();
		for (int i = 0; i < multy_Polinom.size(); i++) {
			this.list_Polinom.add(multy_Polinom.get(i));
		}
		check_Duplicate();
		Reset_Coefficient();
		sort();
	}

	/**
	 * This function checks if 2 Polynoms are similar.
	 */
	@Override
	public boolean equals(Polynom_able p1)  {
		this.it = p1.iteretor();
		HashMap<Integer, Double> hmap = new HashMap<Integer, Double>();
		/*Adding elements to HashMap*/
		while(this.it.hasNext()) {
			mon = this.it.next();
			hmap.put(mon.get_power(), mon.get_coefficient());
		}
		if(this.list_Polinom.size() != hmap.size())
			return false;
		boolean flag = true;
		for(Monom it_Mo: this.list_Polinom) {
			if(hmap.getOrDefault(it_Mo.get_power(),null) != it_Mo.get_coefficient()) //Check Duplicate in the map O(1)
				flag = false;
		}
		return flag;
	}

	/**
	 * This function checks if all the coefficients of the Monoms in the Polynom are 0.
	 */
	@Override
	public boolean isZero() {
		for(Monom tmp: this.list_Polinom) {
			if(tmp.get_coefficient() != 0)
				return false;
		}
		return true;
	}

	/**
	 * This function compute a value x' (x0 <= x' <= x1) for with |f(x')| < eps,
	 * assuming (f(x0) * f(x1) <= 0, returns f(x2) such that:
	 * (i) x0 <= x2 <= x2 && (ii) f(x2) < eps.
	 * @param x0 starting point.
	 * @param x1 end point.
	 * @param eps step (positive) value.
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		while(true) {
			if(this.f(x1) == 0) {
				return x1;
			}
			else if (this.f(x0) == 0) {
				return x0;
			}
			else if(Math.abs(x0 - x1) < eps){
				return (x0 + x1)/2;
			}
			double mid = (x0 + x1)/2;
			if(this.f(x0) * this.f(mid) < 0) {
				x1 = mid;
			}
			else {
				x0 = mid;
			}
		}
	}

	/**
	 * This function does a deep copy (to a different address).
	 */
	public Polynom_able copy() throws _Exception {
		Polynom copy = new Polynom();
		for(Monom it: this.list_Polinom) {
			copy.list_Polinom.add(new Monom(it.get_coefficient(),it.get_power()));
		}
		return copy;
	}

	/**
	 * This function derivative the Polynom by the derivative function of Monom.
	 * @throws _Exception for a wrong Monom.
	 */
	@Override
	public Polynom_able derivative() throws _Exception {
		Polynom_able temp = copy();
		this.it = temp.iteretor();
		this.list_Polinom.clear();
		while(it.hasNext()) {
			this.mon = it.next();
			this.list_Polinom.add(mon.derivative());
		}
		check_Duplicate();
		Reset_Coefficient();
		sort();
		return this;
	}

	/**
	 * This function compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps.
	 * @return the approximated area above the x - axis below this Polynom and between the [x0,x1] range. 
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		int pieces = (int)(Math.abs((x1 - x0)/eps));
		double sum = 0;
		for (int i = 0; i < pieces; i++) {
			if(this.f(x0) > 0)
				sum += this.f(x0) * eps;
			x0 += eps;
		}
		return sum;
	}

	/*
	 * This function compute the area under the x line.
	 */
	public void areaGui(double x0, double x1) {
		double part = Math.abs((x1 - x0) / this.eps);
		double area = 0;
		for(int i = 0; i < part; i++) {
			if(this.f(x0) < 0)
				area = area + this.f(x0) * eps;
			x0 += eps;
		}
		System.out.println(area);
	}

	/**
	 * Iterator of this Polynom.
	 */
	@Override
	public Iterator<Monom> iteretor() {
		return this.list_Polinom.iterator();
	}

	@Override
	public String toString() {
		String Polinom = "";
		for (int i = 0; i < this.list_Polinom.size(); i++) {
			Polinom += this.list_Polinom.get(i).toString();
			if(i != this.list_Polinom.size()-1) {
				Polinom += " + ";
			}
		}
		return Polinom;
	}
}