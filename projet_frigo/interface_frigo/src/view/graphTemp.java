package view;

import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import model.model;
//import org.jfree.ui.RefineryUtilities;
//import org.jfree.ui.Spacer;

/**
 * A simple demonstration application showing how to create a line chart using data from an
 * {@link XYDataset}.
 *
 */
public class graphTemp extends JPanel{

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.     */
	
	private model m ;
	
/*
    public graphTemp(final String title, model m) {

        super();
        this.m = m;
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
   
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     
    
    public void update()
    {
    	this.
    }
    
    
    
  
    
    
    
    
    
    
    private XYDataset createDataset() {
        
        final XYSeries series1 = new XYSeries("Température extérieurr");
        final XYSeries series2 = new XYSeries("Température intérieur");
        final XYSeries series3 = new XYSeries("Température du Module");
        final XYSeries series4 = new XYSeries("Point de Rosé");
        
        double  x = 0;
        for(int i = 0; i < 30 ; i++)
        {
        	
        	series1.add(x, Double.parseDouble(m.listetempExt.get(i)));
        	series2.add(x, Double.parseDouble(m.listetempInt.get(i)));
        	series3.add(x, Double.parseDouble(m.listetempMod.get(i)));
        	series4.add(x, Double.parseDouble(m.listetempRos.get(i)));
        	        	
        	x++;		
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
                
        return dataset;
        
    }
    
   
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Evolution de la température en fonction du temps",      // chart title
            "s",                      // x axis label
            "°C",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }
    */
}
