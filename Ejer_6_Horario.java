package P2SarviaRodrigo;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**	6.- Una empresa efectúa el control de asistencia de sus empleados 
       mediante un lector biométrico, el horario en la entrada es a 
       las 8:00 a.m y la salida es a las 16:00 p.m. El empleado tiene 
       una tolerancia de 10 minutos en la entrada, si llega más allá 
       de los 10 minutos de tolerancia se penaliza todos los minutos 
       de atraso (es decir si llega a las 8:12 se penalizan los 12 minutos). 
       De igual forma no puede salir antes del horario establecido en la 
       salida,  (si lo hace se penaliza los minutos faltantes), pero si 
       el empleado entra antes o sale después de sus horarios el sistema 
       solo toma en cuenta las 8 horas laborales de trabajo. 
    El problema consiste en determinar los minutos de penalización para el empleado 
    en cualquier día laboral. Para tal propósito debe crear constructores y funciones, 
    verifique el funcionamiento con los siguientes datos de prueba:
 Código Empleado Hora Entrada Hora Salida  Penalización   Fecha
	101045			7:55		16:15	       0		12/01/2011	
	223032	        8:11		16:00	       11		12/01/2011
	334009		    8:30		16:20	       30		12/01/2011
	443283	        8:05        16:10          0		12/01/2011
*/

public class Ejer_6_Horario 
{
	String Fecha;
	int ID;
	int en;
	int sa;
	public Ejer_6_Horario()
	{
		ID=0;
		Fecha="";
		en=0;
		sa=0;
	}
	public Ejer_6_Horario(int ID, String Fecha, int en, int sa)
	{
		this.ID=ID;
		this.Fecha=Fecha;
		this.en=en;
		this.sa=sa;
	}
	public String getFecha()
	{
		return Fecha;
	}
	public void setFecha(String fecha) 
	{
		Fecha = fecha;
	}
	public int getEn() 
	{
		return en;
	}
	public void setEn(int en) 
	{
		this.en = en;
	}
	public int getSa() 
	{
		return sa;
	}
	public void setSa(int sa) 
	{
		this.sa = sa;
	}
	public int getID()
	{
		return ID;
	}
	public void setID(int iD)
	{
		ID = iD;
	}
public Ejer_6_Horario[] Separa(String t,int a)
{
	int[] temp;
	int i ;
	Ejer_6_Horario[] v;
	do
	{
	v=new Ejer_6_Horario[5];
	i=0;
    temp=new int[5];
	String b=JOptionPane.showInputDialog(t);
	StringTokenizer st = new StringTokenizer(b, "/=;:,._ *");
	while (st.hasMoreTokens()) 
	{
		temp[i] = Integer.parseInt(st.nextToken());
		v[i]=new Ejer_6_Horario();
		if(a==1)
		{
			v[i].setEn(temp[i]);
		}
		else
		{
			v[i].setSa(temp[i]);
		}
		i++;
	}
	if(temp[0] > 24 || temp[1] > 60||temp[2] > 0 || (temp[0] < 0 || temp[1] < 0))
	{
		JOptionPane.showMessageDialog(null,"ingreso mal de datos");
	}
	}while(temp[0] > 24 || temp[1] > 60||temp[2] > 0 || (temp[0] < 0 || temp[1] < 0));
	return(v);
}
public void Penalizacion(Ejer_6_Horario[] v, Ejer_6_Horario[] c)
{
	int a,pe = 0;
	a=v[0].getEn()-8;
	if(a==0)
	{
		if(v[1].getEn()<=10)
		{
			pe=0;
		}else{
			pe=v[1].getEn();
		}
	}
	if(a>=1)
	{
		pe=v[1].getEn()+(a*60);
	}
    a=16-c[0].getSa();
    if(a==1)
    {
         pe+=(60-c[1].getSa());
	}
    if(a>1)
    {
    	pe+=(60-c[1].getSa())+((a-1)*60);
    }
 Mostrar(v,c,pe);
}
public void Mostrar(Ejer_6_Horario[] v, Ejer_6_Horario[] c, int pe) 
{
  String cad="****Datos Del Empleado****\nFecha:"+getFecha()+"\nID:"+getID()+"\nEntrada         Salida\n"
		     +v[0].getEn()+":"+v[1].getEn()+"              "+c[0].getSa()+":"+c[1].getSa()+
						"\nPenalización :"+pe+"min";
		JTextArea area=new JTextArea(6,6);
		area.setText(cad);
		JScrollPane barra=new JScrollPane(area);
		JOptionPane.showMessageDialog(null,barra);
}
}
