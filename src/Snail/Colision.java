package Snail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Colision {
    private ListaElementos lista;    

    public Colision(ListaElementos lista) {
        this.lista = lista;
    }
    

    public boolean verificarColision(){
        GameElement elemento1;
        GameElement elemento2;
        int x;
        int y;
        int x2;
        int y2;
        for(int i = 0; i<lista.getLista().size(); i++){
            elemento1 =lista.getLista().get(i);
            x = elemento1.getPosition().getX();
            y = elemento1.getPosition().getY();
            
            for (int j = i+1; j<lista.getLista().size(); j++){
                elemento2 = lista.getLista().get(j);
                
                x2 = elemento2.getPosition().getX();
                y2 = elemento2.getPosition().getY();
                
                if((x == x2) && (y == y2) )
                {
                    elemento1.setPosicion(0,0);
                    return true;
                } else{
                    return false;
                }
            }
            
        }
        return false;
    }
    
    
}
