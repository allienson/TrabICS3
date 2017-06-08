/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Usuário
 */
public class Gui extends Frame implements ActionListener {
    
    Controlador controlador;
     
    JFrame frame                        = new JFrame("Conversor MIDI-Java");
    PanelPersonalizado panelConteudo    = new PanelPersonalizado();
    GroupLayout layout                  = new GroupLayout(panelConteudo);
    BufferedImage backgroundPanel;
    ImageIcon frameIcon                 = new ImageIcon("./img/frameicon.png");
    JOptionPane popup                   = new JOptionPane();
    
    JFileChooser chooser;
    
    JPanel panelTopo      = new JPanel();
    JPanel panelTopo2      = new JPanel();
    JPanel panelMIDI    = new JPanel();
    JPanel panelPlay      = new JPanel();
    
    JTextField caminhoTextField = new JTextField("  Escolha um arquivo MIDI...");

    JLabel labelMIDI = new JLabel("Arquivo MIDI", SwingConstants.LEFT); 
    
    BotaoSimples botaoAbrir     = new BotaoSimples("Abrir");
    BotaoSimples botaoResetar   = new BotaoSimples("Resetar Conversor");
    BotaoSimples botaoFiller    = new BotaoSimples("");
    BotaoSimples botaoTraduzir  = new BotaoSimples("Traduzir MIDI");
    BotaoSimples botaoJava      = new BotaoSimples("Criar Java");
    BotaoSimples botaoTocar     = new BotaoSimples("Tocar");   
    
    Color corFundo   = new Color(0, 0, 0);
    Color corFundo2  = new Color(199, 199, 199);
    Color corFundo3  = new Color(39, 40, 34);
    Color corTexto   = new Color(230, 232, 234);
    Color corTexto2  = new Color(142, 145, 151);
    Color corAzul    = new Color(40, 102, 213);
    Color corAzul2    = new Color(38, 17, 244);
    
    Font font1 = new Font("Gill Sans MT Condensed", java.awt.Font.PLAIN, 30);
    Font font2 = new Font("Arial Narrow", java.awt.Font.ITALIC, 18);
    Font font3 = new Font("Monospaced", java.awt.Font.PLAIN, 15);
    
    JLabel code = new JLabel("");
    
    public class PanelPersonalizado extends JPanel {
        
        public PanelPersonalizado() {
            try {
                backgroundPanel = ImageIO.read(new File("./img/background.jpg"));
            } catch(IOException e) {
                e.printStackTrace();
            }
            setOpaque(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundPanel, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    public class BotaoSimples extends JButton{

        public BotaoSimples(String label) {
            setText(label);
            setContentAreaFilled(false);
            setBorder(BorderFactory.createEmptyBorder());
            setOpaque(true);
            setBackground(corAzul);
            setForeground(corTexto);
            setFocusable(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));    
        }
        
        @Override
        public void setEnabled(boolean b){
            if (b){
                setBackground(corAzul);
                setForeground(corTexto);
            } else {
                setBackground(corFundo2);
            }
            super.setEnabled(b);
        }
    }
    
    public Gui(Controlador control){
        this.controlador = control;

        code.setFont(font3);
        // PANEL TOPO
        panelTopo.setPreferredSize(new Dimension (650, 40));
        panelTopo.setOpaque(false);

        caminhoTextField.setEditable(false);
        caminhoTextField.setBackground(corFundo);
        caminhoTextField.setForeground(corTexto);
        caminhoTextField.setBorder(BorderFactory.createEmptyBorder());
        caminhoTextField.setPreferredSize(new Dimension(350, 25));   

        botaoAbrir.setPreferredSize(new Dimension(55, 25));
        botaoAbrir.setEnabled(true);
        botaoAbrir.addActionListener(this);
        botaoResetar.setPreferredSize(new Dimension(120, 25));
        botaoResetar.setEnabled(false);
        botaoResetar.addActionListener(this);
        botaoFiller.setPreferredSize(new Dimension(100, 25));
        botaoFiller.setOpaque(false);

        panelTopo.add(caminhoTextField);
        panelTopo.add(botaoAbrir);
        panelTopo.add(botaoFiller);
        panelTopo.add(botaoResetar);
        
        panelTopo.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        
        chooser = new JFileChooser("midi/.");
        FileFilter filter = new FileNameExtensionFilter("Arquivo MIDI","mid");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(filter);
        
        // PANEL TOPO 2 
        panelTopo2.setPreferredSize(new Dimension (650, 60));
        panelTopo2.setOpaque(false);

        labelMIDI.setFont(font1);
        labelMIDI.setForeground(corTexto);
        
        panelTopo2.add(labelMIDI);
        
        panelTopo2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
       
        // PANEL MIDI
        panelMIDI.setPreferredSize(new Dimension (650, 350));
        panelMIDI.setOpaque(false);
                
        panelMIDI.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        // PANEL PLAY
        panelPlay.setPreferredSize(new Dimension (650, 50));
        panelPlay.setOpaque(false);

        botaoTraduzir.setPreferredSize(new Dimension(100, 25));
        botaoTraduzir.setEnabled(false);
        botaoTraduzir.addActionListener(this);
        botaoJava.setPreferredSize(new Dimension(100, 25));
        botaoJava.setEnabled(false);
        botaoJava.addActionListener(this);
        botaoTocar.setPreferredSize(new Dimension(60, 25));
        botaoTocar.setEnabled(false);
        botaoTocar.addActionListener(this);
        
        panelPlay.add(botaoTraduzir);
        panelPlay.add(botaoJava);
        panelPlay.add(botaoTocar);
        
        panelPlay.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(panelTopo) 
            .addComponent(panelTopo2) 
            .addComponent(panelMIDI) 
            .addComponent(panelPlay) 
        );
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension (700, 550));
        frame.setResizable(false);
        frame.setContentPane(panelConteudo);
        frame.setIconImage(frameIcon.getImage());
        frame.pack();
        frame.setVisible(true); 
    }

    public JTable preparaTabelaMIDI(Object[][] dados){
      
        String[] colunas = {"Tique", "Trilha", "Mensagem"};
                
        JTable tabela = new JTable(dados, colunas);
        TableColumnModel tcm = tabela.getColumnModel();
        tabela.setOpaque(false);
        tcm.getColumn(0).setPreferredWidth(10);
        tcm.getColumn(1).setPreferredWidth(10);
        tcm.getColumn(2).setPreferredWidth(400);
        
        JScrollPane panelTabela = new JScrollPane(tabela);
        panelTabela.setPreferredSize(new Dimension (650, 350));
        
        tabela.setFillsViewportHeight(true);
        
        panelMIDI.add(panelTabela);
          
        return tabela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == botaoTraduzir) {
                controlador.traduz(this);
        }
        if (source == botaoJava) {
                controlador.geraJava(this);
        }
        if (source == botaoAbrir) {
                controlador.abreMidi(this);
        }
        if (source == botaoTocar) {
                controlador.toca(this);
        }
        if (source == botaoResetar) {
                controlador.reseta(this);
        }
    }

}

