import java.io.*;

public class Voluntario2 {
    public static class circular {
        String nombre;
        circular sgte;
    }

    public static class persona {
        String nombre;
        String apellido;
        persona sgte;
    }

    public static void main(String[] args) throws IOException {
        persona cabc = null;
        int op;
        // int n, x;
        do {
            menu();
            op = leer("?");
            switch (op) {
                case 1:
                    cabc = add_nodos_persona(cabc);
                    break;
                case 2:
                    listado2("\nParticipantes ", cabc);
                    break;
                case 3:
                    if (cabc == null || cabc.sgte == cabc) {
                        System.out.println("Deben estas registradas al menos dos personas");
                    } else {
                        juego(cabc);
                    }
                    break;
            }
        } while (op != 10);
    }

    public static void juego(persona d) throws IOException {
        circular j = null, j2 = null;
        boolean flag;
        String com, nom;
        while (d.sgte != d && contar_cir(j) <= 10) {
            nom = d.nombre;
            System.out.println("Es el turno de: " + nom + " " + d.apellido);
            if (j == null) {
                j = add_nodos_circular(j);
                d = d.sgte;
            } else {
                flag = true;
                j2 = j;
                do {
                    com = leers("Palabra?");
                    if (!com.equals(j2.nombre)) {
                        flag = false;
                    }
                    j2 = j2.sgte;
                } while (flag == true && j2 != j);
                if (flag == false) {
                    System.out.println("Error, queda eliminado " + d.nombre + " " + d.apellido);
                    while (!d.sgte.nombre.equals(nom)) {
                        d = d.sgte;
                    }
                    d.sgte = d.sgte.sgte;
                    d = d.sgte;
                    j = null;
                } else {
                    j = add_nodos_circular(j);
                    d = d.sgte;
                }
            }
        }
        if (d.sgte == d) {
            System.out.println("Gana: " + d.nombre + " " + d.apellido);
        } else {
            listado2("Empataron: ", d);
        }
    }

    public static int contar_cir(circular cab) {
        int c = 0;
        if (cab != null) {
            circular cab2 = cab.sgte;
            do {
                cab2 = cab2.sgte;
                c++;
            } while (cab2 != cab);
        }
        return (c);
    }

    public static void listado(String h, circular c) {
        circular z = c;
        if (c != null) {
            do {
                System.out.print(z.nombre + "\t");
                z = z.sgte;
            } while (z != c);
        }
    }

    public static void listado2(String h, persona c) {
        System.out.println(h);
        persona z = c;
        if (c != null) {
            do {
                System.out.println(z.nombre + "\t" + z.apellido);
                z = z.sgte;
            } while (z != c);
        }
    }

    public static void menu() {
        System.out.println("\n***Listas circulares ****");
        System.out.println("1.- Lectura");
        System.out.println("2.- Listado");
        System.out.println("3.- Juego");
        System.out.println("10.- Salir");
    }

    public static circular add_nodos_circular(circular x) throws IOException {
        circular aux = new circular();
        circular z;
        aux.nombre = leers("Nueva palabra?");
        aux.sgte = aux;
        if (x == null)
            x = aux;
        else {
            z = x;
            while (z.sgte != x)
                z = z.sgte;
            z.sgte = aux;
            aux.sgte = x;
        }
        return (x);
    }

    public static persona add_nodos_persona(persona x) throws IOException {
        persona aux = new persona(), z = x;
        aux.nombre = leers("Nombre?");
        aux.apellido = leers("Apellido?");
        aux.sgte = aux;
        if (x == null)
            x = aux;
        else {
            z = x;
            while (z.sgte != x)
                z = z.sgte;
            z.sgte = aux;
            aux.sgte = x;
        }
        return (x);

    }

    public static String leers(String z) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(z);
        String r = s.readLine();
        return (r);
    }

    public static int leer(String z) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(z);
        int r = Integer.parseInt(s.readLine());
        return (r);
    }
}