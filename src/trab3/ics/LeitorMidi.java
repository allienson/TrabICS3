/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.*;

public class LeitorMidi {
    File midiFile;
    Sequencer sequenciador;
    Sequence sequencia;
    List<EventoMidi> listaDeEventos = new LinkedList<EventoMidi>();

    public class EventoMidi{
        
        public long tique;
        public int trilha;
        public String mensagem;
        
        public EventoMidi(long tique, int trilha, String mensagem){
            this.tique=tique;
            this.trilha=trilha;
            this.mensagem=mensagem;
        }
    }
    
    public LeitorMidi(){
        try{
            sequenciador = MidiSystem.getSequencer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setArquivo(String nome){
        if ((midiFile!=null)&&(midiFile.getName().equals(nome)))
            return;
        midiFile = new File(nome);
        novaSequencia();
    }
    public void setArquivo(File file){
        if (midiFile == file)
            return;
        midiFile = file;
        novaSequencia();
    }
    public void novaSequencia(){
        try{
            sequencia = MidiSystem.getSequence(midiFile);
            sequenciador.setSequence(sequencia);
        }catch(IOException e1){
            e1.printStackTrace();
            sequencia = null;
        }catch(InvalidMidiDataException e2){
            e2.printStackTrace();
            sequencia = null;
        }
    }
    public Sequence getSequencia(){
        return sequencia;
    }
    
    public List<EventoMidi> getEventos()  {
        Track[] trilhas = sequencia.getTracks();
                
        for(int i=0; i<trilhas.length; i++){
            Track trilha =  trilhas[i];
            for(int j=0; j<trilha.size(); j++){
                MidiEvent e = trilha.get(j);
                MidiMessage mensagem = e.getMessage();
                long tique = e.getTick();
                int n = mensagem.getStatus();
                String nomecomando = ""+n;
            
                switch(n)
                {
                    case 128: nomecomando = "noteON"; break;
                    case 144: nomecomando = "noteOFF"; break;
                    case 255:
                    {
                        nomecomando = "MetaMensagem:";
                        switch(mensagem.getMessage()[1])
                        {
                            case 0:
                            {
                                if(2 == mensagem.getMessage()[1])
                                {
                                    nomecomando+= " Número de sequência "+ mensagem.getMessage()[2]+mensagem.getMessage()[3];
                                }
                                break;
                            }
                            case 1:
                            {
                                nomecomando+= " Texto de tamanho: "+ mensagem.getMessage()[2]+ "\t Texto: ";
                                for(int k=0; k < mensagem.getMessage()[2]; k++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[k+3];
                                }
                                break;
                            }
                            case 2:
                            {
                                nomecomando+= " Mensagem de copyright, tamanho: "+ mensagem.getMessage()[2]+ "\t Texto: ";
                                for(int l=0; l < mensagem.getMessage()[2]; l++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[l+3];
                                }
                                break;
                            }
                            case 3:
                            {
                                nomecomando+= " Nome da sequência/trilha, tamanho "+ mensagem.getMessage()[2]+ "\t Nome: ";
                                for(int m=0; m < mensagem.getMessage()[2]; m++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[m+3];
                                }
                                break;
                            }
                            case 4:
                            {
                                nomecomando+= " Nome do instrumento, tamanho: "+ mensagem.getMessage()[2]+ "\t Nome: ";
                                for(int r=0; r < mensagem.getMessage()[2]; r++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[r+3];
                                }
                                break;
                            }
                            case 5:
                            {
                                nomecomando+= " Letra da música, tamanho: "+ mensagem.getMessage()[2]+ "\t Letra: ";
                                for(int o=0; o < mensagem.getMessage()[2]; o++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[o+3];
                                }
                                break;
                            }
                            case 6:
                            {
                                nomecomando+= " Marcador, tamanho: "+ mensagem.getMessage()[2]+ "\t Marcador: ";
                                for(int p=0; p < mensagem.getMessage()[2]; p++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[p+3];
                                }
                                break;
                            }
                            case 7:
                            {
                                nomecomando+= " Ponto de indicação(cue point), tamanho: "+ mensagem.getMessage()[2]+ "\t Ponto de indicação: ";
                                for(int q=0; q < mensagem.getMessage()[2]; q++)
                                {
                                    nomecomando+= (char) mensagem.getMessage()[q+3];
                                }
                                break;
                            }
                            case 0x58:
                            {
                                nomecomando+= "Compasso: "+ mensagem.getMessage()[3] + "/" + (int)Math.pow(2,mensagem.getMessage()[4]);
                                break;
                            }
                            case 0x59:
                            {
                                nomecomando+= "Tonalidade: "+ getTonalidade(mensagem.getMessage()[3],mensagem.getMessage()[4]);
                                break;
                            }
                            case 0x2F:
                            {
                                nomecomando+= " Fim da Trilha.";
                                break;
                            }
                            default:
                                nomecomando = " MetaMensagem." + n;
                        }
                        break; 
                    }
                    //---(introduzir outros casos)
                }
                listaDeEventos.add(new EventoMidi(tique, i, nomecomando));
            }
        }
        return listaDeEventos;
    }

    public Object[][] getMatrizDeEventosMidi(){
        List<EventoMidi> lista = getEventos();

        List<String> list;
        
        Object[][] data= new Object[lista.size()][];
        for(int i=0;i < lista.size(); i++){
            data[i]= new Object[3];
        }
        for(int i=0;i < lista.size(); i++){
            data[i][0]= lista.get(i).tique;
            data[i][1]= lista.get(i).trilha;
            data[i][2]= lista.get(i).mensagem;
        }
        return data;
    }
    
    String getTonalidade(byte tonalidade, byte maior) {
    
        String stonalidade = "";

        String       smaior = "Maior";
            if(maior==1) smaior = "Menor";

            if(smaior.equalsIgnoreCase("Maior")) {
                switch (tonalidade)
                {
                    case -7: stonalidade = "Dob Maior"; break;
                    case -6: stonalidade = "Solb Maior"; break;
                    case -5: stonalidade = "Reb Maior"; break;
                    case -4: stonalidade = "Lab Maior"; break;
                    case -3: stonalidade = "Mib Maior"; break;
                    case -2: stonalidade = "Sib Maior"; break;
                    case -1: stonalidade = "Fa Maior"; break;
                    case  0: stonalidade = "Do Maior"; break;
                    case  1: stonalidade = "Sol Maior"; break;
                    case  2: stonalidade = "Re Maior"; break;
                    case  3: stonalidade = "La Maior"; break;
                    case  4: stonalidade = "Mi Maior"; break;
                    case  5: stonalidade = "Si Maior"; break;
                    case  6: stonalidade = "Fa# Maior"; break;
                    case  7: stonalidade = "Do# Maior"; break;
                }
            }

            else if(smaior.equalsIgnoreCase("Menor"))
            {
                switch (tonalidade)
                {
                    case -7: stonalidade = "Lab Menor"; break;
                    case -6: stonalidade = "Mib Menor"; break;
                    case -5: stonalidade = "Sib Menor"; break;
                    case -4: stonalidade = "Fa Menor"; break;
                    case -3: stonalidade = "Do Menor"; break;
                    case -2: stonalidade = "Sol Menor"; break;
                    case -1: stonalidade = "Re Menor"; break;
                    case  0: stonalidade = "La Menor"; break;
                    case  1: stonalidade = "Mi Menor"; break;
                    case  2: stonalidade = "Si Menor"; break;
                    case  3: stonalidade = "Fa# Menor"; break;
                    case  4: stonalidade = "Do# Menor"; break;
                    case  5: stonalidade = "Sol# Menor"; break;
                    case  6: stonalidade = "Re# Menor"; break;
                    case  7: stonalidade = "La# Menor"; break;
                }
            }
      
      return stonalidade;
    }
}

