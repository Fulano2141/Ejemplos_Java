package trash;
import java.util.*;
public class Orden {
	public class TuObjeto {
	       public String nombre;
	       public Double nota;
	}
	 public static void studList() {
		 ArrayList<TuObjeto> lista = new ArrayList<TuObjeto>();
		 lista.add(new TuObjeto("Peter", 4.5));
		 lista.add(new TuObjeto("Sophia", 6.5));
		 lista.add(new TuObjeto("Jacob", 5.5));
		 lista.add(new TuObjeto("Matt", 3.0));


	        ArrayList<String> list = sortA(stud,uspe);
	        Collections.sort(list);
	        for(String temp: list){
	            System.out.println(temp);
	        }

	    }

	    private static ArrayList<String> sortA(ArrayList<String> st, ArrayList<Double> us) {
	        ArrayList<String> list = new ArrayList<>();
	        String s;
	        for (int i = 0; i < st.size(); i++) {
	            s = st.get(i) + ": " + us.get(i);
	            list.add(s);
	        }
	        HashSet<String> set = new HashSet<>(list);
	        list.clear();
	        list.addAll(set);
	        return list;
	    }

}