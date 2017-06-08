/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.sound.midi.*;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

import sintese.*;

public class Controlador {
    LeitorMidi leitor;
    Tradutor tradutor;
    Sequence sequencia;
    Polifonia polifonia;
    Som som = null;
    
    

    public Controlador() {
        leitor = new LeitorMidi();
        tradutor = new Tradutor();
    }

    public void abreMidi(Gui gui) {
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
    
    public void traduz(Gui gui) {
        if(sequencia == null)
            gui.popup.showMessageDialog(gui.frame, "Nao ha arquivo MIDI selecionado!");
        else{
            polifonia = tradutor.traduz(sequencia);

            gui.botaoTraduzir.setEnabled(false);
            gui.botaoJava.setEnabled(true);
        }
    }

    public void geraJava(Gui gui) {
        
        String nome = JOptionPane.showInputDialog("Nome do arquivo(sem extencao):");
        if(nome==null){
            gui.popup.showMessageDialog(gui.frame, "O nome do arquivo nao foi inserido!");
            return;
        }
        try{
                                
    CriaJava.criaJava(polifonia, nome);
        }catch (Exception e){
            e.printStackTrace();
        }

        gui.botaoJava.setEnabled(false);
        gui.botaoTocar.setEnabled(true);

        
        try{
            Component tabela;
            FileReader fr = new FileReader(nome + ".java");
            BufferedReader reader = new BufferedReader(fr);
            
            JTextPane codigo = new JTextPane();
            codigo.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
            codigo.setFont(gui.code.getFont());
            codigo.setContentType("text/html");
            codigo.setEditable(false);
            codigo.setBackground(gui.corFundo3);
            codigo.setForeground(gui.corTexto);
            
            //codigo.read(reader, "codigo");
            
            JScrollPane panel = new JScrollPane(codigo);
            
            String linha = "";
            
            HTMLDocument document = (HTMLDocument) codigo.getDocument();    
            Element elem =  document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.P);
            
            document.insertAfterStart(elem, "<code>");
            int i=1;
            while ((linha = reader.readLine()) != null) {
                document.insertString(document.getLength(), " " + i + "  " + linha + "\n", null);
                i++;
            }
            document.insertBeforeEnd(elem, "</code>");
            //document.insertString(document.getLength(), " </code> </html>", null);
            
            codigo.setDocument(document);
            
            panel.setPreferredSize(new Dimension (800, 600));
            
            JDialog dialogJava = new JDialog(gui.frame, nome + ".java");
            dialogJava.setContentPane(panel);
            dialogJava.setPreferredSize(new Dimension(800, 600));
            dialogJava.setMinimumSize(new Dimension(800, 600));
            dialogJava.setVisible(true);
               
        } catch (Exception e){
            e.printStackTrace();
        }   
    }

    public void toca(Gui gui) {
        if(sequencia == null)
            gui.popup.showMessageDialog(gui.frame, "Nao ha arquivo MIDI selecionado!");
        else if (polifonia == null)
            gui.popup.showMessageDialog(gui.frame, "Arquivo nao foi traduzido!");
        else{
            if(som == null)
                som = polifonia.getSom();
                som.salvawave();
                som.visualiza();
        }
    }
    
    public void reseta(Gui gui) {
        leitor    = null;
        tradutor  = null;
        sequencia = null;
        polifonia = null;
        
        gui.caminhoTextField.setText("  Escolha um arquivo MIDI...");
        gui.labelMIDI.setText("Arquivo MIDI");
        
        gui.botaoAbrir.setEnabled(true);
        gui.botaoResetar.setEnabled(false);
        gui.botaoTraduzir.setEnabled(false);
        gui.botaoJava.setEnabled(false);
        gui.botaoTocar.setEnabled(false);
        
        
    }
}
