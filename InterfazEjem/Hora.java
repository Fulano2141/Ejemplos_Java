import javax.swing.JOptionPane;

public class Hora {  
	String horaEntr;
	String horaSali;
	int minutos=0;
	int hora=0;
	int segundo=0;	
	public Hora(String horaEntr, String horaSali) {
		super();
		this.horaEntr = horaEntr;
		this.horaSali = horaSali;
	}
	public String tiempo()
	{					
		String[]h1=horaEntr.split(":");
		String[]h2=horaSali.split(":");
		hora=Integer.parseInt(h2[0])-Integer.parseInt(h1[0]);
		minutos=Integer.parseInt(h2[1])-Integer.parseInt(h1[1]);
        segundo=Integer.parseInt(h2[2])-Integer.parseInt(h1[2]);
	if(hora<0)
		{
			hora=(Integer.parseInt(h2[0])+12)-(Integer.parseInt(h1[0])-12);
		}
	if(minutos<0){
			minutos=minutos+60;
			hora=hora-1;
		}
		if(segundo<0)
		{
			segundo=segundo+60;
			minutos=minutos-1;
		}
		
		
		
		
		if(hora>=8 && (Integer.parseInt(h1[1])>15) )
				{
			      JOptionPane.showMessageDialog(null,"hora de ingreso "+horaEntr+"\n"+"hora de salida "+horaSali+"\n"
		    		+ "total de horas "+ hora+":"+minutos+":"+segundo+"\n Ingreso tarde al Trabajo");
				}
		
		if(hora>=8 && (Integer.parseInt(h1[1])<15)  )
		{
			
			
		
			JOptionPane.showMessageDialog(null,"hora de ingreso "+horaEntr+"\n"+"hora de salida "+horaSali+"\n"
		    		+ "total de horas "+ hora+":"+minutos+":"+segundo);
			
			
			
		}
		if(hora<8 && (Integer.parseInt(h1[1])>15) )
		{
			JOptionPane.showMessageDialog(null,"hora de ingreso : "+horaEntr+"\n"+"hora de salida "+horaSali+"\n"+
		    		"total de horas "+hora+":"+minutos+":"+segundo+"\n\"trabajo menos de 8 horas \n Ingreso tarde al trabajo");
				
			
		}
		if(hora<8&& (Integer.parseInt(h1[1])<15))
		{
			JOptionPane.showMessageDialog(null,"hora de ingreso "+horaEntr+"\n"+"hora de salida  "+horaSali+"\n"+
		    		"total de horas "+hora+":"+minutos+":"+segundo+"\n\"trabajo menos de 8 horas ");
		}
		
		
		
		return hora+":"+minutos+":"+segundo;
		
	   }
	
	
	
	}
	  

	 
      
	    
   


