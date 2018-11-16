# Monom
The Monom class implements the function interface.
Monom defines by: 1. coefficient (any number).
                  2. power (integar).
4 constructors: 1. gets coefficient and power.
                2. gets Monom.
		            3. gets a string of Monom.
		            4. gets nothing.
Monom functions:
* f - This function gives us value at x.
* derivative  - This function gives us Monom's derivative.
* add - This function check if the power of 2 Monoms equals: if yes: add.
                                                             else: exception.
* multiply - This function multiply 2 Monoms.
* equal - This function check if 2 Monoms are equal.

# Polynom
The Polynom class implements the Polynom_able interface.
Polynom is an array of Monoms.
2 constructors: 1. gets a string of Polynom.
                2. gets nothing.
Polynom functions:
* sort - This function sort the Polynom from the smallest Monom (smallest power) to the biggest Monom (biggest power).
* check_Duplicate - This function check if there are 2 Monoms with the same power. if there are - add them.
* Reset_Coefficient - This function check if there is Monom with 0 coefficient. if there is - delete it.
* f - This function gets value of x and then compute the value of the Polynom.
* add (Polynom) - This function add the other list of Monon, Then checks duplicate and erase it.
* add (Monom) - This function add Monom to the Polinom.
* substract - This function check if other Polynom has the same power of Monom: if it has: subtract the other Monom's coefficient from the original Monom.
                                                                                else: add - p1 to the Polynom.
* multiply - This function multiply 2 Polynoms.
* equals - This function checks if 2 Polynoms are similar.
* isZero - This function checks if all the coefficients of the Monoms in the Polynom are 0.
* root - This function compute a value x' (x0 <= x' <= x1) for with |f(x')| < eps
assuming (f(x0) * f(x1) <= 0, returns f(x2) such that: (i) x0 <= x2 <= x2 && (ii) f(x2) < eps.
* copy - This function does a deep copy (to a different address).
* derivative - This function derivative the Polynom by the derivative function of Monom.
* area - This function compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps.
* areaGui - This function compute the area under the x line.

# Gui
This class shows the Polynom on a graph.
Gui functions:
* minMax - This function finds minimum and maximum points and shows them on the graph by a purple color.
