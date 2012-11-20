/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programacostos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mariomaradiaga
 */
public class Par {

    private int cantidad;
    private float tamaño;
    
    public Par(int cantidad, float tamaño){
        this.cantidad = cantidad;
        this.tamaño = tamaño;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public float getTamaño(){
        return this.tamaño;
    }

    public void restar() {
        this.cantidad--;
    }
    
    public static float[] calculos(Par pares[], int varilla){
        Par datos[] = ordenarPares(pares);
        int tamaño = datos.length;
        int numVarillas = 0;
        float desperdicio = 0f;
        float resultados[] = new float[2];
        
        while(!estaVacio(datos)){
            numVarillas++;
            float temp = (float)varilla;
            String var = "";
            for (int i = 0; i < tamaño; i++) {
                while(datos[i].getTamaño() < temp && datos[i].getCantidad() > 0){
                    temp = temp - datos[i].getTamaño();
                    var += datos[i].getTamaño() + " + ";
                    datos[i].restar();
                }
            }
            var = var.substring(0, var.length()-3);
            System.out.println(var);
            desperdicio += temp;
        }
        resultados[0] = numVarillas;
        resultados[1] = desperdicio / (numVarillas * (float)varilla);
        return resultados;
    }
    
    private static boolean estaVacio(Par pares[]){
        for (int i = 0; i < pares.length; i++) {
            if(pares[i].getCantidad() > 0){
                return false;
            }
        }
        return true;
    } 
    
    private static Par[] ordenarPares(Par pares[]){
        Par ordenado[] = pares;
        for (int i = 0; i < pares.length-1; i++) {
            for (int j = i+1; j < pares.length; j++) {
                if(ordenado[j].getTamaño() > ordenado[i].getTamaño()){
                    Par temp = ordenado[i];
                    ordenado[i] = ordenado[j];
                    ordenado[j] = temp;
                }
            }
        }
        return ordenado;
    }
}
