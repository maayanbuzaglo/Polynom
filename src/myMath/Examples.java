package myMath;

public class Examples {

	public static void main(String[] args) throws _Exception {

		Polynom p = new Polynom("7x^2 - 3*x^4 + 3*x"); // Create a Polynom.
		System.out.println(p.toString());
		//p.derivative(); // Check for the derivative.
		System.out.println(p.toString());
		p.add(new Polynom("7*x^5 + 3*x^6 + 2*x"));
		System.out.println(p.toString()); // Checks for add.
		p.add(new Polynom("-7*x^5 + 3*x^6 + 2*x^7"));
		System.out.println(p.toString());

		Polynom p1 = new Polynom("7*x^2 + 3*x^4 + 2*x^1 + 3*x^9");
		Polynom p2 = new Polynom("7*x^2 + 3*x^4 + 2*x^1");
		System.out.println(p1.equals(p2));
		p2.add(new Polynom("7*x^5 + 3*x^6 + 2*x^7"));
		System.out.println(p1.equals(p2)); // Checks equal by map.

		System.out.println(p1.toString()); // Checks substract.
		System.out.println(p2.toString());
		p2.substract(p1);
		System.out.println(p2.toString());

		Polynom p3 = new Polynom("7*x^2 + 2*x^1"); // Checks multiply. 
		p3.multiply(p3);
		System.out.println(p3.toString());
	}
}
