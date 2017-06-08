/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;


import java.io.*;
import sintese.*;

public class CriaJava {

	public CriaJava(){}

	static public void criaJava(Polifonia polifonia, String nome) throws IOException{
		Instrumentos ins = new Instrumentos();
		File java = new File(nome+".java");
		FileWriter fp = new FileWriter(java);
		fp.write("import sintese.*;\n\n");
		fp.write("public class "+nome+"{\n\n");//  classe{
		/**  inicializador **/
		fp.write("\tpublic "+nome+"()"+"{\n\n");//   inicializador{{
		fp.write("\t\tInstrumentoAditivo i1,i2,i3;\n");
		fp.write("\t\tCurva[][] curvas;\n");
		fp.write("\t\tEnvoltoria[][] envoltorias;\n");
		fp.write("\t\tUnidadeH[][] unidades;\n");
		fp.write("\t\tcurvas = new Curva[3][5];\n");
		fp.write("\t\tenvoltorias = new Envoltoria[3][5];\n");
		fp.write("\t\tunidades = new UnidadeH[3][5];\n\n");
		fp.write("\t\t/*****  	Instrumento 1  *****/\n\n");
		fp.write("\t\tcurvas[0][0] = new Curva(720);\n");
		fp.write("\t\tcurvas[0][0].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[0][0].addPonto(30, 1000);\n");
		fp.write("\t\tcurvas[0][0].addPonto(600,700);\n");
		fp.write("\t\tcurvas[0][0].addPonto(720, 0);\n\n");
		fp.write("\t\tcurvas[0][1] = new Curva(720);\n");
		fp.write("\t\tcurvas[0][1].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[0][1].addPonto(50, 1000);\n");
		fp.write("\t\tcurvas[0][1].addPonto(590,600);\n");
		fp.write("\t\tcurvas[0][1].addPonto(720, 0);\n\n");
		fp.write("\t\tcurvas[0][2] = new Curva(720);\n");
		fp.write("\t\tcurvas[0][2].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[0][2].addPonto(40, 1000);\n");
		fp.write("\t\tcurvas[0][2].addPonto(620,800);\n");
		fp.write("\t\tcurvas[0][2].addPonto(720, 0);\n\n");
		fp.write("\t\tenvoltorias[0][0] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[0][0].setCURVA(curvas[0][0]);\n");
		fp.write("\t\tenvoltorias[0][1] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[0][1].setCURVA(curvas[0][1]);\n");
		fp.write("\t\tenvoltorias[0][2] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[0][2].setCURVA(curvas[0][2]);\n\n");
		fp.write("\t\tunidades[0][0] = new UnidadeH();\n");
		fp.write("\t\tunidades[0][0].setEnvoltoria(envoltorias[0][0]);\n");
		fp.write("\t\tunidades[0][0].setH(1);\n");
		fp.write("\t\tunidades[0][0].setLambda(0.5);\n");
		fp.write("\t\tunidades[0][0].setFase(0);\n");
		fp.write("\t\tunidades[0][0].setGanho(1f);\n\n");
		fp.write("\t\tunidades[0][1] = new UnidadeH();\n");
		fp.write("\t\tunidades[0][1].setEnvoltoria(envoltorias[0][1]);\n");
		fp.write("\t\tunidades[0][1].setH(2);\n");
		fp.write("\t\tunidades[0][1].setLambda(0.5);\n");
		fp.write("\t\tunidades[0][1].setFase(0);\n");
		fp.write("\t\tunidades[0][1].setGanho(0.7f);\n\n");
		fp.write("\t\tunidades[0][2] = new UnidadeH();\n");
		fp.write("\t\tunidades[0][2].setEnvoltoria(envoltorias[0][2]);\n");
		fp.write("\t\tunidades[0][2].setH(3);\n");
		fp.write("\t\tunidades[0][2].setLambda(0.5);\n");
		fp.write("\t\tunidades[0][2].setFase(0);\n");
		fp.write("\t\tunidades[0][2].setGanho(0.75f);\n\n");
		fp.write("\t\ti1 = new InstrumentoAditivo();\n");
		fp.write("\t\ti1.addUnidade(unidades[0][0]);\n");
		fp.write("\t\ti1.addUnidade(unidades[0][1]);\n");
		fp.write("\t\ti1.addUnidade(unidades[0][2]);\n");
		fp.write("\t\ti1.setGanho(0.7f);\n\n");
		fp.write("\t\t/*****  Instrumento 2  *****/\n\n");
		fp.write("\t\tcurvas[1][0] = new Curva(720);\n");
		fp.write("\t\tcurvas[1][0].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[1][0].addPonto(30, 1000);\n");
		fp.write("\t\tcurvas[1][0].addPonto(600,700);\n");
		fp.write("\t\tcurvas[1][0].addPonto(720, 0);\n\n");
		fp.write("\t\tcurvas[1][1] = new Curva(720);\n");
		fp.write("\t\tcurvas[1][1].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[1][1].addPonto(40, 1000);\n");
		fp.write("\t\tcurvas[1][1].addPonto(400,600);\n");
		fp.write("\t\tcurvas[1][1].addPonto(720, 0);\n\n");
		fp.write("\t\tcurvas[1][2] = new Curva(720);\n");
		fp.write("\t\tcurvas[1][2].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[1][2].addPonto(50, 1000);\n");
		fp.write("\t\tcurvas[1][2].addPonto(620,700);\n");
		fp.write("\t\tcurvas[1][2].addPonto(720, 0);\n\n");
		fp.write("\t\tenvoltorias[1][0] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[1][0].setCURVA(curvas[1][0]);\n");
		fp.write("\t\tenvoltorias[1][1] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[1][1].setCURVA(curvas[1][1]);\n");
		fp.write("\t\tenvoltorias[1][2] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[1][2].setCURVA(curvas[1][2]);\n\n");
		fp.write("\t\tunidades[1][0] = new UnidadeH();\n");
		fp.write("\t\tunidades[1][0].setEnvoltoria(envoltorias[1][0]);\n");
		fp.write("\t\tunidades[1][0].setH(1);\n");
		fp.write("\t\tunidades[1][0].setLambda(0.5);\n");
		fp.write("\t\tunidades[1][0].setFase(0);\n");
		fp.write("\t\tunidades[1][0].setGanho(1f);\n\n");
		fp.write("\t\tunidades[1][1] = new UnidadeH();\n");
		fp.write("\t\tunidades[1][1].setEnvoltoria(envoltorias[1][1]);\n");
		fp.write("\t\tunidades[1][1].setH(1.5);\n");
		fp.write("\t\tunidades[1][1].setLambda(0.5);\n");
		fp.write("\t\tunidades[1][1].setFase(0);\n");
		fp.write("\t\tunidades[1][1].setGanho(0.7f);\n\n");
		fp.write("\t\tunidades[1][2] = new UnidadeH();\n");
		fp.write("\t\tunidades[1][2].setEnvoltoria(envoltorias[1][2]);\n");
		fp.write("\t\tunidades[1][2].setH(3);\n");
		fp.write("\t\tunidades[1][2].setLambda(0.5);\n");
		fp.write("\t\tunidades[1][2].setFase(0);\n");
		fp.write("\t\tunidades[1][2].setGanho(0.6f);\n\n");
		fp.write("\t\ti2 = new InstrumentoAditivo();\n");
		fp.write("\t\ti2.addUnidade(unidades[1][0]);\n");
		fp.write("\t\ti2.addUnidade(unidades[1][1]);\n");
		fp.write("\t\ti2.addUnidade(unidades[1][2]);\n");
		fp.write("\t\ti2.setGanho(0.7f);\n\n");
		fp.write("\t\t/***** 	Instrumento 3  *****/\n\n");
		fp.write("\t\tcurvas[2][0] = new Curva(720);\n");
		fp.write("\t\tcurvas[2][0].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[2][0].addPonto(30,1000);\n");
		fp.write("\t\tcurvas[2][0].addPonto(200,700);\n");
		fp.write("\t\tcurvas[2][0].addPonto(720,0);\n\n");
		fp.write("\t\tcurvas[2][1] = new Curva(720);\n");
		fp.write("\t\tcurvas[2][1].addPonto(0, 0);\n");
		fp.write("\t\tcurvas[2][1].addPonto(15,1000);\n");
		fp.write("\t\tcurvas[2][1].addPonto(100,600);\n");
		fp.write("\t\tcurvas[2][1].addPonto(720,0);\n\n");
		fp.write("\t\tcurvas[2][2] = new Curva(720);\n");
		fp.write("\t\tcurvas[2][2].addPonto(0,0);\n");
		fp.write("\t\tcurvas[2][2].addPonto(10,1000);\n");
		fp.write("\t\tcurvas[2][2].addPonto(60,500);\n");
		fp.write("\t\tcurvas[2][2].addPonto(720,0);\n\n");
		fp.write("\t\tenvoltorias[2][0] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[2][0].setCURVA(curvas[2][0]);\n");
		fp.write("\t\tenvoltorias[2][1] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[2][1].setCURVA(curvas[2][1]);\n");
		fp.write("\t\tenvoltorias[2][2] = new Envoltoria();\n");
		fp.write("\t\tenvoltorias[2][2].setCURVA(curvas[2][2]);\n\n");
		fp.write("\t\tunidades[2][0] = new UnidadeH();\n");
		fp.write("\t\tunidades[2][0].setEnvoltoria(envoltorias[2][0]);\n");
		fp.write("\t\tunidades[2][0].setH(1);\n");
		fp.write("\t\tunidades[2][0].setLambda(0.5);\n");
		fp.write("\t\tunidades[2][0].setFase(0);\n");
		fp.write("\t\tunidades[2][0].setGanho(1);\n\n");
		fp.write("\t\tunidades[2][1] = new UnidadeH();\n");
		fp.write("\t\tunidades[2][1].setEnvoltoria(envoltorias[2][1]);\n");
		fp.write("\t\tunidades[2][1].setH(3);\n");
		fp.write("\t\tunidades[2][1].setLambda(0.5);\n");
		fp.write("\t\tunidades[2][1].setFase(0);\n");
		fp.write("\t\tunidades[2][1].setGanho(1f);\n\n");
		fp.write("\t\tunidades[2][2] = new UnidadeH();\n");
		fp.write("\t\tunidades[2][2].setEnvoltoria(envoltorias[2][2]);\n");
		fp.write("\t\tunidades[2][2].setH(5);\n");
		fp.write("\t\tunidades[2][2].setLambda(0.5);\n");
		fp.write("\t\tunidades[2][2].setFase(0);\n");
		fp.write("\t\tunidades[2][2].setGanho(0.5f);\n\n");
		fp.write("\t\ti3 = new InstrumentoAditivo();\n");
		fp.write("\t\ti3.addUnidade(unidades[2][0]);\n");
		fp.write("\t\ti3.addUnidade(unidades[2][1]);\n");
		fp.write("\t\ti3.addUnidade(unidades[2][2]);\n");
		fp.write("\t\ti3.setGanho(0.7f);\n\n");

		/** polifonia **/

		fp.write("\t\tPolifonia pol = new Polifonia();\n");
		fp.write("\t\tint numVoz = "+polifonia.getNumeroDeVozes()+";\n");
		fp.write("\t\tVoz[] vozes = new Voz[numVoz];\n");
		fp.write("\t\tMelodia mel = new Melodia();\n\n");
		int i = 0;

		while (i<polifonia.getNumeroDeVozes()){

			Melodia melodia = polifonia.getVoz(i).getMelodia(0);//fora
			Dispositivo id = polifonia.getVoz(i).getInstrumento();
			String inst = "i1";
			if(id == ins.i1)
				inst = "i1";
			if(id == ins.i2)
				inst = "i2";
			if(id == ins.i3)
				inst = "i3";
			fp.write("\t\tvozes["+i+"] = new Voz("+inst+");\n\n");
			fp.write("\t\tmel = new Melodia();\n\n");
			int j = 0;
			int numNota = melodia.getNumeroDeNotas();

			while (j<numNota){
				Nota nota = melodia.getNota(j);
				fp.write("\t\tmel.addNota(new Nota("+nota.getDuracao()+","+nota.getFrequencia()+","+nota.getAmplitude()+"));\n");
				j++;
			}
			fp.write("\t\tvozes["+i+"].addMelodia(mel);\n\n");
			i++;
		}
		fp.write("\t\tint i = 0;\n\n");
		fp.write("\t\twhile (i<numVoz){\n");
		fp.write("\t\t\tpol.addVoz(vozes[i]);\n");
		fp.write("\t\t\ti++;\n");
		fp.write("\t}\n\n");
		fp.write("\t\tpol.setGanho(1f);\n");
		fp.write("\t\tSom som = pol.getSom();\n");
		fp.write("\t\tsom.salvawave();\n");
		fp.write("\t\tsom.visualiza();\n");
		fp.write("\t\t}\n\n");
		
		/** main **/
		fp.write("\tpublic static void main(String[] args) {\n");
		fp.write("\t\tnew "+nome+"();\n");
		fp.write("\t}\n");
		fp.write("}");
		fp.close();
	}
}

