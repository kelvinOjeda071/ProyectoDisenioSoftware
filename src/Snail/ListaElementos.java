package Snail;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ListaElementos {
    
    private LinkedList <ElementoDeJuego> lista;
    //private ElementoDeJuego elemento;

    public ListaElementos() {
        lista = new LinkedList<ElementoDeJuego>();
    }

    public LinkedList<ElementoDeJuego> getLista() {
        return lista;
    }
    
  

    public void setLista(LinkedList<ElementoDeJuego> lista) {
        this.lista = lista;
    }
    
    public void agregarElemento (ElementoDeJuego elemento){
        //this.elemento = elemento;
        lista.add(elemento);
    }
     
    public void eliminarElemento(Posicion posicion){
        Iterator <ElementoDeJuego> it = getLista().iterator();
        while(it.hasNext()){
            Posicion pos = it.next().getPosicion();
            if((pos.getX() == posicion.getX()) && (pos.getY() == posicion.getY())){
                it.remove();
            }
        }
    }
    
    
    
    
}
