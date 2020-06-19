public class arraybidi2 {

    public static void main( String args[ ]){
        int [ ][ ]A ={{5,6,2,1,3},
                                {1,2,3,4,5},
                                {6,7,8,9,0}};
        /**
         * Primero vamos a imprimir la matriz dada
         */
        System.out.println("La matriz dada es: ");
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                System.out.print(" " + A[i][j] + " ");
            }
            System.out.println();
        }
        /**Ahora podemos observar como la matriz anterior la cual es 3 X 5
         * se convierte en una 5 x 3, es decir la filas se convierten en columnas
         * y las columnas se convierten en filas. Lo que hacemos a continuación
         * es intercambiar los for para imprimir de la manera que queremos.
         */
        System.out.println("La matriz transpuesta es: ");
        for(int j = 0; j < A[0].length; j++){
            for(int i = 0; i < A.length; i++){
                System.out.print(" " + A[i][j] + " ");
            }
            System.out.println();
        }
    }
}