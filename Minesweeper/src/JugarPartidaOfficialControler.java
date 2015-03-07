

import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author daviddavid
 */
public class JugarPartidaOfficialControler {
    
    private ControladorCasoDeUsoJugarPartida jp;
    
    public JugarPartidaOfficialControler(){
        jp = new ControladorCasoDeUsoJugarPartida();
    }

    
    
    ArrayList<Nivell> PrLoginObtenirNivells(String a, String b) throws Exception {//faltan control de excepcions
        jp.Login(a,b);
        return jp.consultarNivell();
        
    }
    
    void PrJugarCrearPartida(String s){
        jp.CrearPartida(s);
    }


    Casella[][] PrActualitzarTauler() {
        return jp.getCaselles();
    }

    Resultado PrDescobrirCasella(Integer x, Integer y) throws Exception {
        return jp.descobrirCasella(x,y);
    }

    void PrDesMarcar(Integer x, Integer y) throws Exception {
        jp.desmarcarCasella(x, y);
    }

    void PrMarcarCasella(Integer x, Integer y) throws Exception {
        jp.marcarCasella(x, y);
    }
    
}
