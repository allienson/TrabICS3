/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;

import javax.sound.midi.*;
import sintese.*;

public class Tradutor {

    Instrumentos instrumentos;
    public Tradutor(){
        instrumentos = new Instrumentos();
    }

    public Polifonia traduz(Sequence sequencia){
/**  transforma um arquivo midi em uma polifonia  **/
        Polifonia polifonia = new Polifonia();
        double duracao = (double)sequencia.getMicrosecondLength()/1000000;
        double tickTime = duracao/sequencia.getTickLength();//tempo em segundos de um tick
        Track[] tracks = sequencia.getTracks();//array com os tracks do arquivo
        int noTracks = tracks.length;//numero de tracks
        Voz[] vozes = new Voz[noTracks];//uma voz para cada track
        int i = 0;
        while (i<noTracks){
            vozes[i] = leTrack(tracks[i],tickTime);//le um track e armazena sua melodia
            i++;
        }
        i = 0;
        while (i<noTracks){
            if(vozes[i] != null){
                polifonia.addVoz(vozes[i]);
            }
            i++;
        }
        polifonia.setDuracao((float)duracao);
        polifonia.setGanho(6f);
        return polifonia;
    }

    public Voz leTrack(Track track, double tickTime){
/**  armazena um track em uma Voz  **/
        Voz voz = new Voz(tabelaDeInstrumentos(0));
        Melodia melodia = new Melodia();//inicializa melodia da trilha
        long on = -1;//armazena provisoriamente o instante inicial de uma nota
        long off = 0;//armazena provisoriamente o instante final de uma nota
        int valor = -1;//armazena provisoriamente o valor de uma nota
        int velocity = -1;//armazena provisoriamente a intensidade de uma nota
        int ins = 0;//instrumento da trilha (default)
        int i = 0;//contador
        int noEvents = track.size();//numero de eventos na trilha
        while (i<noEvents){//ate acabarem os eventos da track

            MidiEvent e = track.get(i);

            if (e.getMessage() instanceof ShortMessage){//se for uma short message

                    ShortMessage sm = (ShortMessage) e.getMessage();

                    if(sm.getChannel()==10){//o canal 10 e o drum pad
                            /* faz voz da bateria */
                    }
                    if(sm.getCommand() == ShortMessage.PROGRAM_CHANGE){
                        ins = sm.getData1();
                    }

                    if (sm.getCommand() == ShortMessage.NOTE_ON){//caso seja um note on

                        if((on < off)&&(sm.getData2()>0)){//nota anterior ja acabou e nota atual nao e nula
                            on = e.getTick();//inicio da nova nota
                            if (on > off){//ha atraso entre nota anterior e atual
                                melodia.addNota(new Nota((on - off)*(float)tickTime));//adiciona pausa
                            }
                            valor = sm.getData1();//atualiza frequencia e velocity
                            velocity = sm.getData2();
                        }else if(on >= off){//nota anterior nao foi terminada
                                off = e.getTick();
                                if(off > on)//nota possui duracao
                                    melodia.addNota(fazNota(on,off,valor,velocity,tickTime));
                                if(sm.getData2() != 0){//nota possui velocity
                                    on = e.getTick();//atualiza parametros
                                    valor = sm.getData1();
                                    velocity = sm.getData2();
                                }
                        }
                    }

                    else if(sm.getCommand() == ShortMessage.NOTE_OFF){//caso seja um note off

                        if(valor!=sm.getData1()){//note off nao corresponde com note on

                        }
                        off = e.getTick();//pega instante em que acaba a nota
                        melodia.addNota(fazNota(on,off,valor,velocity,tickTime));//adiciona a nota
                    }
            }
            i++;
        }
        if (melodia.getNumeroDeNotas()!=0){//insere melodia na Voz apropriada. Supoe-se que se usa apenas um intrumento por trilha
                voz = new Voz(tabelaDeInstrumentos(ins));
                voz.addMelodia(melodia);
                return voz;
        }
        return null;
    }

    public InstrumentoAditivo tabelaDeInstrumentos (int instrumentoMidi){
/** para cada instumento MIDI seleciona um instrumento aditivo  **/
        InstrumentoAditivo ins = new InstrumentoAditivo();
        if (instrumentoMidi < 41)
            ins = instrumentos.i1;
        else if ((instrumentoMidi >= 41)&&(instrumentoMidi < 81))
            ins = instrumentos.i2;
        else if (instrumentoMidi >= 81)
            ins = instrumentos.i3;
        return ins;
    }

    public Nota fazNota(long on, long off, int valor, int velocity, double tickTime){
/** transforma parametros midi em uma instancia de Nota **/
        double duracao = (off-on)*tickTime;
        double frequencia = 440*(Math.pow(2, (double)(valor-69)/12));
        float amplitude = velocity/117f;
        Nota nota = new Nota(duracao,frequencia,amplitude);
        return nota;
    }

}
