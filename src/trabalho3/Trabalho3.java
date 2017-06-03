package trabalho3;


import java.util.LinkedList;
import java.util.List;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import sintese.*;

public class Trabalho3 {
    static float frequenciaBase= 440;

    public static void main(String[] args) {
        new GUI(new Controlador());
    }
    public static LinkedList<Nota> ObterListaDeNotas(Sequence sequencia){
        int bpm;
        LinkedList<Nota> notasEsperandoFim= new LinkedList<Nota>();
        LinkedList<long> tickDasNotasEsperandoFim= new LinkedList<long>();
        LinkedList<Nota> listaFinal= new LinkedList<Nota>();
        
        Track[] trilhas = sequencia.getTracks();
        for(int i=0; i<trilhas.length; i++){
            Track trilha =  trilhas[i];
            for(int j=0; j<trilha.size(); j++){
                MidiEvent e = trilha.get(j);
                MidiMessage mensagem = e.getMessage();
                long tique = e.getTick();
                int n = mensagem.getStatus();
                switch(n)
                {
                    case 128://noteON
                    {   
                        int pitch= mensagem.getMessage()[1];
                        double frequencia= frequenciaBase* Math.pow(2, pitch/12);
                        int velocity= mensagem.getMessage()[2];
                        double amplitude= velocity;
                        notasEsperandoFim.add(new Nota(1.0, frequencia, amplitude));
                        tickDasNotasEsperandoFim.add(tique);
                        break;
                    }
                    case 144:{//noteOff
                        int pitch= mensagem.getMessage()[1];
                        double frequencia= frequenciaBase* Math.pow(2, pitch/12);
                        int velocity= mensagem.getMessage()[2];
                        double amplitude= velocity;
                        
                        int posicao;
                        for(int i2=0; i2 < notasEsperandoFim.size(); i2++){
                            if(notasEsperandoFim.get(i2).getFrequencia() == frequencia){
                                listaFinal.add(new Nota( (tique-tickDasNotasEsperandoFim[i2])* bpm, frequencia, notasEsperandoFim.get[i2].getAmplitude()));
                                notasEsperandoFim.remove(i2);
                                tickDasNotasEsperandoFim.remove(i2);
                                break;
                            }
                        }
                        break;
                    }
                }

            }
            //após percorrer toda a trilha talvez deva-se v
            if(!notasEsperandoFim.isEmpty()){
                printf("Ue\n");
            }
        }
        return listaFinal;
    }
}
