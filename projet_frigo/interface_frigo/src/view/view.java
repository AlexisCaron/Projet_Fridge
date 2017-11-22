package view;

import javax.swing.*;
import java.awt.*;
import javafx.scene.*;




public class view {

	

	private graph graphique; 
	private JFrame frame;
	private JPanel background1;
	private JPanel background2;
	private JButton boutton1;
	private JButton boutton2;
	private JComboBox temp;
	private JLabel tempLabel;
	private JPanel tempPanel;


	
	
	
	
	public view()
	{
		graphique  = new graph();
		//frame = new JFrame("Gestion du mini frigo");
		this.frame = initFrame(); 
	    this.background1 = initBackground(this.frame);
	    this.graphique = (graph) initGraph(this.frame);
	    this.boutton1 = initButton(this.background1,"Yes");
	    this.boutton2 = initButton(this.background1,"No");
	    initTemperature(this.background1);
	    //graphique.setPreferredSize(new Dimension(220, 60));
	    //this.frame.add(graphique,BorderLayout.WEST);
	    graphique.repaint();
	}
	
	
	
	
	private JFrame initFrame()
	{
		JFrame frame = new JFrame("Gestion du mini frigo");
		frame.setVisible(true);
	    frame.setSize(800, 600);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    frame.setResizable(true);
	    return frame;
	}
	
	private JPanel initGraph(JFrame frame)
	{
		graph panel = new graph();
		panel.setPreferredSize(new Dimension(220, 60));
		panel.setBackground(Color.BLUE);
		frame.add(panel, BorderLayout.WEST);
		return panel;
	}
	
	private JPanel initBackground(JFrame frame)
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(220, 60));
		panel.setBackground(Color.gray);
		frame.add(panel, BorderLayout.EAST);
		return panel;
	}
	

	
	private void initTemperature(JPanel panel)
	{
		
	    //panel.setBorder(BorderFactory.createTitledBorder("Température du frigo").s);
	    this.temp = new JComboBox();	   
	    for(int i = 5 ; i < 21 ; i++) temp.addItem(i);
	    this.tempLabel = new JLabel("Température : ");
	    panel.add(tempLabel);
	    panel.add(temp);
	    frame.setContentPane(panel);
	    System.out.println("tempéature : " + temp.getSelectedItem());
	   
	}
	
	private JButton initButton(JPanel panel, String text)
	{
		JButton boutton = new JButton(text);
		panel.add(boutton);
		return boutton;
	}
	
	public void paint(Graphics g) 
	{
		g.drawLine(0, 0, 100, 100);
		g.drawLine(0, 100, 100, 0);
		g.drawLine(40, 25, 250, 180);
		g.drawLine(75, 90, 400, 400);
		g.drawLine(20, 150, 400, 40); //line
		g.drawLine(5, 290, 80, 19); //line
		g.drawLine (5, 75, 5, 75); // point
		g.drawLine (50, 5, 50, 5); // point
	}
	
	


	    
}
