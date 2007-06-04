/*
 * BuscaminasA.java
 *
 * Created on 4 de junio de 2007, 09:08 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

// package buscaminas;

import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author JuHU
 */
public class BuscaminasA extends Applet {
    
    protected Buscaminas pBuscaminas;
    protected   boolean update=true;
    
    public BuscaminasA() {
    }
    
    public void init() {

        pBuscaminas= new Buscaminas();
        add(pBuscaminas.GetPanel());
    }
    
    public void start() {
        Timer timer = new Timer (1000, new ActionListener () 
        {
            public void actionPerformed(ActionEvent e) 
            { 
                if(update)
                    pBuscaminas.Update();
                update=false;
             }
        });
        timer.start();
    }
}
