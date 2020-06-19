package progra3;

import javax.swing.JOptionPane;

public class NodoArbol
{
    NodoArbol nodoizquierdo;
    int datos;
    NodoArbol nododerecho;
    
    public NodoArbol(int datosNodo)
    {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null; 
    }
    public synchronized void insertar(int valorInsertar)
    {
    	if(valorInsertar < datos)
        {
            if(nodoizquierdo == null)
                nodoizquierdo = new NodoArbol(valorInsertar);
            else   
                nodoizquierdo.insertar(valorInsertar);
        }
        else if(valorInsertar > datos)
        {
            if(nododerecho == null)
                nododerecho = new NodoArbol(valorInsertar);
            else
                nododerecho.insertar(valorInsertar);
        }
    } 
}

class Arbol
{
    private NodoArbol raiz;
    
    public Arbol()
    {
        raiz = null;
    }
    
    public synchronized void insertarNodo(int valorInsertar)
    {
        if(raiz == null)
            raiz = new NodoArbol(valorInsertar);
        else
            raiz.insertar(valorInsertar);     
    }
    public synchronized void recorridoPreorden()
    {
        ayudantePreorden(raiz);
    }
    private void ayudantePreorden(NodoArbol nodo)
    {
        if(nodo == null)
            return;
        
        System.out.print(nodo.datos + " ");     
        ayudantePreorden(nodo.nodoizquierdo);   
        ayudantePreorden(nodo.nododerecho);    
    }
    
    public synchronized void recorridoInorden()
    {
        ayudanteInorden(raiz);
    }
    private void ayudanteInorden( NodoArbol nodo)
    {
        if(nodo == null)
            return;
        
        ayudanteInorden(nodo.nodoizquierdo);
        System.out.print(nodo.datos + " ");
        ayudanteInorden(nodo.nododerecho);
    }
    public synchronized void recorridoPosorden()
    {
        ayudantePosorden(raiz);        
    }
    
    private void ayudantePosorden(NodoArbol nodo)
    {
        if( nodo == null )
            return;
        
        ayudantePosorden(nodo.nodoizquierdo);
        ayudantePosorden(nodo.nododerecho);
        System.out.print(nodo.datos + " ");
    }
    public static void main(String args [])
    {
        Arbol arbol = new Arbol();
        int valor;
        String Dato;
        
        System.out.println("Insertando los siguientes valores: ");
        
        Dato = JOptionPane.showInputDialog("Inserta el numero de nodos que desea ingresar");
        int n = Integer.parseInt(Dato);
        
        for(int i = 1; i <= n; i++ )
        {
            Dato = JOptionPane.showInputDialog("Dame el " + i + " valor para colocar en el Arbol");
            valor = Integer.parseInt(Dato);
            System.out.print(valor + " ");
            arbol.insertarNodo(valor);
        }
        
        System.out.println("\n\nRecorrido Preorden");
        arbol.recorridoPreorden();
        
        System.out.println("\n\nRecorrido Inorden");
        arbol.recorridoInorden();
        
        System.out.println("\n\nRecorrido Postorden");
        arbol.recorridoPosorden();
    }
}