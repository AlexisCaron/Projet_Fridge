package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import model.model;

public class graph extends JPanel{
	
	private TimeSeries series1;
	private TimeSeries series2;
	private TimeSeries series3;

    /** The most recent value added. */

    
    
    public graph() {
    	
    	super();
        this.series1 = new TimeSeries("Random Data", Millisecond.class);      
        this.series2 = new TimeSeries("Random Data", Millisecond.class);        
        this.series3 = new TimeSeries("Random Data", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(800,500));
       this.add(content);

    }
    
    
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Dynamic Data Demo", 
            "Time", 
            "Value",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        return result;
    }
    
    
    public void updateGraph(model m) {       
           // this.series.add(new Millisecond(), Double.parseDouble(m.listetempExt.get(m.listetempExt.size() - 1)));
            this.series1.add(new Millisecond(), Double.parseDouble(m.getTempExt()));
            this.series2.add(new Millisecond(), Double.parseDouble(m.getTempInt()));
            this.series3.add(new Millisecond(), Double.parseDouble(m.getTempMod()));
            
            System.out.println("gg");
    }
	
}