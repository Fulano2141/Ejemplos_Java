package graficas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class GraficasChartBarras {

    public static void main(String[] args) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.setValue(6, "2013", "Jordi");
     //   dataset.setValue(7, "2014", "Jordi");
        
        dataset.setValue(8, "2013", "Cristina");
    //    dataset.setValue(5, "2014", "Cristina");
        
        dataset.setValue(12, "2013", "Pedro");
     //   dataset.setValue(9, "2014", "Pedro");
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Comparación Ventas 2013-2014",
                "Vendedores", 
                "Ventas", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                false, 
                false
        );
        
        //Mostramos la grafica en pantalla
        ChartFrame frame = new ChartFrame("Ejemplo Grafica de Barras", chart);
        frame.pack();
        frame.setVisible(true);

    }

}