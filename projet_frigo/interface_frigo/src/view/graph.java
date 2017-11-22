package view;
import java.awt.Graphics;
import javax.swing.JPanel;

public class graph extends JPanel{
	
	int[] xs = {25, 75, 125, 85, 125, 75, 25, 65};


	int[] ys = {50, 90, 50, 100, 150, 110, 150, 100};
	



	public void paint(Graphics g) {
	      g.drawPolyline(xs, ys, 8);

	  
	  }
	  
	  
		public int[] getXs() {
			return xs;
		}
		
		  public int[] getYs() {
				return ys;
			}
}
