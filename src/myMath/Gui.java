package myMath;
import java.awt.Color;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

/*
 * This class shows the Polynom on a graph.
 */
public class Gui extends JFrame {
	final private double eps = 0.01;
	private XYPlot plot; 
	private DataTable data;

	public Gui() {

	}

	public Gui(Polynom p , double x0 , double x1) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 400);

		data = new DataTable(Double.class, Double.class);
		for (double x = x0; x <= x1; x += eps + 0.01) {
			double y = p.f(x);
			data.add(x, y);
		}

		plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(0.0f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
	}

	/*
	 * This function finds minimum and maximum points
	 * and shows them on the graph by purple color.
	 */
	public void minMax(Polynom p , double x0 , double x1) throws _Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 400);
		Polynom p2 = (Polynom)p.copy();
		Polynom nig = (Polynom)p.derivative();

		DataTable nig_data = new DataTable(Double.class, Double.class);
		for (double x = x0; x <= x1; x += eps) {
			if(0 > nig.f(x + eps + 0.01) * nig.f(x - eps - 0.01)) {
				double y = p2.f(x);
				nig_data.add(x, y);
			}
		}

		plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(0.0f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
		plot.add(nig_data);
		getContentPane().add(new InteractivePanel(plot));
		lines = new DefaultLineRenderer2D(); /*LineRenderer*/ 
		plot.setLineRenderers(nig_data, lines);
		color = new Color(0.50f, 0.32f, 0.74f); /*Color*/ 
		plot.getPointRenderers(nig_data).get(0).setColor(color);
		plot.getLineRenderers(nig_data).get(0).setColor(color);
	}

	public static void main(String[] args) throws _Exception {
		Polynom n = new Polynom("0.2x^4 - 1.5x^3 + 3.0x^2 - x - 5");
		Gui frame = new Gui(n, -2, 6);
		frame.minMax(n, -2, 6);
		frame.setVisible(true);
	}
}