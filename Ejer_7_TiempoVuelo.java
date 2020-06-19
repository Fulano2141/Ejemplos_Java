package P2SarviaRodrigo;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**	7.-Crear una aplicación que permita calcular el tiempo de vuelo de 
      todos los vuelos contenidos en el ejemplo, para tal efecto debe 
      crear constructores y funciones, verifique el funcionamiento con 
      los siguientes datos de prueba:
		Nº Vuelo  Hora Salida  Hora Llegada	 Tiempo Vuelo
		   495		10:15		  12:30			2:15
		   706		10:40		  13:20	   		2:40
		   951		23:30		   2:40	   	    3:10
		   743		23:20	  	   2:10	   		2:50
*/

public class Ejer_7_TiempoVuelo
{
	int Nu;
	int Hosa;
	int Misa;
	int Hoen;
	int Mien;
	String Tiem;
	public Ejer_7_TiempoVuelo()
	{
		 Nu=0;
		 Mien=0;
		 Hoen=0;
		 Misa=0;
		 Hosa=0;
		 Tiem="";
	 }
	public Ejer_7_TiempoVuelo(String Tiem, int Mien, int Misa, int Hoen, int Hosa,int Nu)
	{
		 this.Nu=Nu;
		 this.Mien=Mien;
		 this.Misa=Misa;
		 this.Hoen=Hoen;
		 this.Hosa=Hosa;
		 this.Tiem=Tiem;
	 }
	public int getNu()
	{
		return Nu;
	}
	public void setNu(int nu) 
	{
		Nu = nu;
	}
	public int getHosa() 
	{
		return Hosa;
	}
	public void setHosa(int hosa)
	{
		Hosa = hosa;
	}
	public int getMisa()
	{
		return Misa;
	}
	public void setMisa(int misa) 
	{
		Misa = misa;
	}
	public int getHoen() 
	{
		return Hoen;
	}
	public void setHoen(int hoen) 
	{
		Hoen = hoen;
	}
	public int getMien() 
	{
		return Mien;
	}
	public void setMien(int mien) 
	{
		Mien = mien;
	}
	public String getTiem() 
	{
		return Tiem;
	}
	public void setTiem(String tiem) 
	{
		Tiem = tiem;
	}
public void Separar(String t,int a) 
{
		try 
		{
			int[] temp;
			do
			{
		    temp=new int[5];
			String b=JOptionPane.showInputDialog(t);
			StringTokenizer st = new StringTokenizer(b, "/=;:,._ *");
			int i = 0;
			while (st.hasMoreTokens()) 
			{
				// de un dato de String lo pasamos un Int
				temp[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			if(a==1)
			{
				setHoen(temp[0]);
				setMien(temp[1]);
				setHosa(25);
			}
			if(a==2)
			{
				setHosa(temp[0]);
				setMisa(temp[1]);
			}	
			if (temp[2] > 0) 
			{
				JOptionPane.showMessageDialog(null, "Solo escriba H/M");
			}
			if (temp[0] < 0 || temp[1] < 0 ) 
			{
				JOptionPane.showMessageDialog(null, "No Escriba Numeros Negativos");
			}
			if (temp[0] > 24 || temp[1] > 59 ) 
			{
				JOptionPane.showMessageDialog(null, "Las Horas son de 0 a 24 y los Minutos de 0 a 59 ");
			}
			if(getHoen()==getHosa() && getMien()==getMisa())
			{
				JOptionPane.showMessageDialog(null, "La hora de llegada tiene q ser mayor a la de Salida");
				temp[2]=1;
			}
			}while(temp[0] > 24 || temp[1] > 59||temp[2] > 0 || (temp[0] < 0 || temp[1] < 0));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingreso mal de datos");
		}
	}	
public void Tiempo()
{
	int a=getHosa()-getHoen();
	int b=0;
	System.out.println(a);
	if(a==0){
		setTiem("00:"+(getMisa()-getMien()));
	}
	if(a>=1){
		if(getMien()<=getMisa())
		{
			System.out.println("if");
			setTiem(a+":"+(getMisa()-getMien()));
		}else{
			System.out.println("else");
			setTiem((a-1)+":"+(60-(getMien()-getMisa())));
		}
	}
	if(getHoen()>getHosa())
	{
	 a=23-getHoen();
	if(getMien()>getMisa())
	{
		b=60-getMien();
		a=a+getHosa();
		setTiem((a+":"+(b+getMisa())));
		}
	else{
		b=60-getMien();
		a=a+getHosa();
		System.out.println(a);
		System.out.println("else");
		setTiem((a+1)+":"+((b+getMisa())-60));
	}
	}
	System.out.println(getTiem());
}
public void Mostrar() 
{
	  String cad="****Datos Del Vuelo****\nNº del vuelo:"+getNu()+"\nHora Salida   Hora Llegada\n     "
			     +getHoen()+":"+getMien()+"                 "+getHosa()+":"+getMisa()+
							"\nTiempo de vuelo "+getTiem();
			JTextArea area=new JTextArea(6,6);
			area.setText(cad);
			JScrollPane barra=new JScrollPane(area);
			JOptionPane.showMessageDialog(null,barra);
	}
}
