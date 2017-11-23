package view;

import java.awt.BorderLayout;

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

import model.model;



public class graphHum extends JPanel{
	
	
	private TimeSeries series1;
	
public graphHum() {
    	
    	super();
        this.series1 = new TimeSeries("Température extérieur", Millisecond.class);      
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(800,300));
       this.add(content);

    }

private JFreeChart createChart(final XYDataset dataset) {
    final JFreeChart result = ChartFactory.createTimeSeriesChart(
        "Evolution de l'humidité dans le temps", 
        "Temps", 
        "% d'humidité",
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
    axis.setRange(0.0, 100.0); 
    return result;
}
    public void updateGraph(model m) {       
        // this.series.add(new Millisecond(), Double.parseDouble(m.listetempExt.get(m.listetempExt.size() - 1)));
         this.series1.add(new Millisecond(), Double.parseDouble(m.getHum()));

         
         //System.out.println("gg");
 }
}

