
package trash;
import java.io.*;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Estudiante {
        initComponents() {
		}
        
        //Se almacenan los datos que seran usados en el gráfico
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(8,"java","Misael");
        datos.setValue(9,"java","Don Enrique");
        datos.setValue(6,"java","Lupe");
        
        //Se crea el gráfico y se asignan algunas caracteristicas
        JFreeChart grafico_barras = ChartFactory.createBarChart3D("Calificaciones Java","Estudiantes", "Promedios",datos, PlotOrientation.VERTICAL, true, true, false);
        
        //Se guarda el grafico
        BufferedImage image = grafico_barras.createBufferedImage(500,300);
        
        //Se crea la imagen y se agrega a la etiqueta
        grafico.setIcon(new ImageIcon(image));
        
        pack();
        repaint();       
    }