/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdv.sisac;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PDVSISAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

          //iniciando configurações salvas do banco
         String[] arquivo = new String[1];
			try{			
                                FileReader entrada = new FileReader("con.sist");
                                BufferedReader leitor = new BufferedReader(entrada);
				int c = 0;
				String linha = null;
				pdv frame_pdv = new pdv();
                                frame_pdv.setVisible(true);
                                
			}catch(IOException e){
                               base_de_dados frame_pdv = new base_de_dados();
                               frame_pdv.setVisible(true);
                               
                               
                        }

        //abrindo tela do PDV
        
    
    }
    
}
