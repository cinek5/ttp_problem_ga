package charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

/**
 * Created by Cinek on 18.03.2019.
 */
public class GeneticAlgorithmChart extends ApplicationFrame {
    private XYSeries max;
    private XYSeries min;
    private XYSeries avg;
    public GeneticAlgorithmChart( String applicationTitle, String chartTitle ) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Kategoria" ,
                "funkcja G" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset( ) {
         max = new XYSeries( "Max" );
         avg = new XYSeries( "Avg" );
         min = new XYSeries( "Min" );

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( max );
        dataset.addSeries( avg );
        dataset.addSeries( min );
        return dataset;
    }

    public XYSeries getMax() {
        return max;
    }

    public XYSeries getMin() {
        return min;
    }

    public XYSeries getAvg() {
        return avg;
    }

    public static void main(String[ ] args ) {
        GeneticAlgorithmChart geneticAlgorithmChart = new GeneticAlgorithmChart("dupa", "dupa");


        geneticAlgorithmChart.pack( );
        RefineryUtilities.centerFrameOnScreen( geneticAlgorithmChart );
        geneticAlgorithmChart.setVisible( true );
    }
}
