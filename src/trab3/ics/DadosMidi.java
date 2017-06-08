/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;


import javax.sound.midi.*;

public class DadosMidi {
	
	static final int FORMULA_DE_COMPASSO = 0x58;
	static final int MENSAGEM_TONALIDADE = 0x59;
	
	public void exibirDados(Sequence sequencia, Gui gui) {
		
            int andamento = -1;
            Par fCompasso = null;
            long durTempo;

            long duracao     = sequencia.getMicrosecondLength()/1000000;
	    int  resolucao   = sequencia.getResolution();
	    long totaltiques = sequencia.getTickLength();

	    float durtique       = (float)duracao/totaltiques;
	    float durseminima    = durtique*resolucao;
	    float bpm            = 60/durseminima;
	    
	    andamento = Math.round(bpm);
	    
	    durTempo = sequencia.getMicrosecondLength()/sequencia.getTickLength()*sequencia.getResolution();
	    durTempo = durTempo/1000;
	    
	    Track trilha = sequencia.getTracks()[0];
	    fCompasso = getFormulaDeCompasso(trilha);
	    String compasso = Integer.toString(fCompasso.getX()) +":"+ (int)(Math.pow(2, fCompasso.getY()));
	    
	    String metro = ("1/"+Integer.toString((int)(Math.pow(2, fCompasso.getY()))));
	    
	    String tom = "Desconhecido";
	    try{
	    	tom = getTonalidade(trilha);
	    }catch (InvalidMidiDataException e){}  
	    
//	    gui.dadosMidi.append(" Andamento:              " + Integer.toString(andamento) + System.lineSeparator());
//	    gui.dadosMidi.append(" Formula de compasso:    " + compasso + System.lineSeparator());
//	    gui.dadosMidi.append(" Metro:                  " + metro + System.lineSeparator());
//	    gui.dadosMidi.append(" Tonalidade:             " + tom + System.lineSeparator());
//	    gui.dadosMidi.append(" Duracao:                " + duracao + "s" + System.lineSeparator());
//	    gui.dadosMidi.append(" Resolucao:              " + resolucao + " PPQ" + System.lineSeparator());
//	    gui.dadosMidi.append(" Quantidade de tiques:   " + totaltiques + System.lineSeparator());
//	    gui.dadosMidi.append(" Duracao do tique:       " + (float)durtique*1000000 + "ms" + System.lineSeparator());
	    
	 }

	static Par getFormulaDeCompasso(Track trilha)
	{   int p=1;
    	int q=1;

    	for(int i=0; i<trilha.size(); i++)
    	{
    		MidiMessage m = trilha.get(i).getMessage();
    		if(m instanceof MetaMessage) 
    		{
    			if(((MetaMessage)m).getType()==FORMULA_DE_COMPASSO)
    			{
    				MetaMessage mm = (MetaMessage)m;
    				byte[] data = mm.getData();
    				p = data[0];
    				q = data[1];
    				return new Par(p,q);
    			}
    		}
    	}
    	return new Par(p,q);
	}            

	static String getTonalidade(Track trilha) throws InvalidMidiDataException
	{       
		String stonalidade = "desconhecida";
		for(int i=0; i<trilha.size(); i++)
		{ 	
			MidiMessage m = trilha.get(i).getMessage();
			if(m instanceof MetaMessage){
			if(((MetaMessage)m).getType() == MENSAGEM_TONALIDADE)    
			{
				MetaMessage mm        = (MetaMessage)m;
				byte[]     data       = mm.getData();
				byte       tonalidade = data[0];
				byte       maior      = data[1];

				String       smaior = "Maior";
				if(maior==1) smaior = "Menor";

				if(smaior.equalsIgnoreCase("Maior"))
				{
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
                		case  6: stonalidade = "FaSus Maior"; break;
                		case  7: stonalidade = "DoSus Maior"; break;
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
						case  3: stonalidade = "FaSus Menor"; break;
						case  4: stonalidade = "DoSus Menor"; break;
						case  5: stonalidade = "SolSus Menor"; break;
						case  6: stonalidade = "ReSus Menor"; break;
						case  7: stonalidade = "LaSus Menor"; break;
					}
				}
				}
			}
		}
		return stonalidade;
	}
	
	static private class Par
	{ 
		int x, y;
  
		Par (int x_, int y_)  
		{
			this.x = x_;
			this.y = y_;          
		}

		int getX()
		{ 
			return x;
		}
  
		int getY()
		{ 	return y;
		}

	}
      
}

