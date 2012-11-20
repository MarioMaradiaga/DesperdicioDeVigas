/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package programacostos;

import java.util.ArrayList;

/**
 *
 * @author mariomaradiaga
 */
public class Excel {
    
    private ArrayList<Varilla> varillas;
    private int numColumnas;
    private int numFilas;
    
    public Excel(){
        this.varillas = new ArrayList<Varilla>();
        this.numColumnas = Varilla.numColumnas;
        this.numFilas = Varilla.numFilas;
    }
}
