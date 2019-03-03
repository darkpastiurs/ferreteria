/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author HP
 */
public class Ferreteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          java.awt.EventQueue.invokeLater(() -> {
              try {
                  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                  new home().setVisible(true);
              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                  Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
    }
    
}
