/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3;

import java.io.File;
import javax.sound.midi.Sequence;
import javax.swing.JFileChooser;
import sintese.Som;

/**
 *
 * @author Usuário
 */
public class Controlador {
    
    LeitorMIDI leitor;
    Sequence sequencia;
    Som som;
    
    public Controlador(){
        leitor = new LeitorMIDI();
        
    
    }
    
    public void abrirMIDI(GUI gui){
        int result = gui.chooser.showOpenDialog(gui);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = gui.chooser.getSelectedFile();
            leitor.setArquivo(file);
            sequencia = leitor.getSequencia();
            som = null;

            gui.caminhoTextField.setText(gui.chooser.getSelectedFile().toString());
            gui.labelMIDI.setText(file.getName());
            gui.preparaTabelaMIDI(leitor.getMatrizDeEventosMidi());
            gui.botaoResetar.setEnabled(true);
            gui.botaoTraduzir.setEnabled(true);
        }
        
    }
    
}
