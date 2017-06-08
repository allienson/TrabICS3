/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab3.ics;

import sintese.*;

public class Instrumentos {
	
    InstrumentoAditivo i1,i2,i3,i4; //instrumentos do banco de dados

    public Instrumentos(){

        Curva[][] curvas; //curvas dos instrumentos (instrumento X harmonico)
        Envoltoria[][] envoltorias; //envoltorias dos instrumentos
        UnidadeH[][] unidades; //unidadesH dos intrumentos

        //inicializa as variaveis. Cada instrumento pode ter ate 5 harmonicos
        curvas = new Curva[3][5];
        envoltorias = new Envoltoria[3][5];
        unidades = new UnidadeH[3][5];

    /*****  Instrumento 1  *****/
        //curvas do instrumento 1:
        //primeiro harmonico:
        curvas[0][0] = new Curva(720);
        curvas[0][0].addPonto(0, 0);
        curvas[0][0].addPonto(30, 1000);
        curvas[0][0].addPonto(600,700);
        curvas[0][0].addPonto(720, 0);
        //segundo harmonico:
        curvas[0][1] = new Curva(720);
        curvas[0][1].addPonto(0, 0);
        curvas[0][1].addPonto(50, 1000);
        curvas[0][1].addPonto(590,600);
        curvas[0][1].addPonto(720, 0);
        //terceiro harmonico:
        curvas[0][2] = new Curva(720);
        curvas[0][2].addPonto(0, 0);
        curvas[0][2].addPonto(40, 1000);
        curvas[0][2].addPonto(620,800);
        curvas[0][2].addPonto(720, 0);

        //envoltorias do intrumento 1:
        envoltorias[0][0] = new Envoltoria();
        envoltorias[0][0].setCURVA(curvas[0][0]);
        envoltorias[0][1] = new Envoltoria();
        envoltorias[0][1].setCURVA(curvas[0][1]);
        envoltorias[0][2] = new Envoltoria();
        envoltorias[0][2].setCURVA(curvas[0][2]);

        //unidadesH do intrumento 1:
        //unidade 1:
        unidades[0][0] = new UnidadeH();
        unidades[0][0].setEnvoltoria(envoltorias[0][0]);
        unidades[0][0].setH(1);
        unidades[0][0].setLambda(0.5);
        unidades[0][0].setFase(0);
        unidades[0][0].setGanho(1f);
        //unidade 2:
        unidades[0][1] = new UnidadeH();
        unidades[0][1].setEnvoltoria(envoltorias[0][1]);
        unidades[0][1].setH(2);
        unidades[0][1].setLambda(0.5);
        unidades[0][1].setFase(0);
        unidades[0][1].setGanho(0.7f);
        //unidade 3:
        unidades[0][2] = new UnidadeH();
        unidades[0][2].setEnvoltoria(envoltorias[0][2]);
        unidades[0][2].setH(3);
        unidades[0][2].setLambda(0.5);
        unidades[0][2].setFase(0);
        unidades[0][2].setGanho(0.75f);

        //inicializa instrumento:
        i1 = new InstrumentoAditivo();
        i1.addUnidade(unidades[0][0]);
        i1.addUnidade(unidades[0][1]);
        i1.addUnidade(unidades[0][2]);
        i1.setGanho(0.7f);


    /*****  Instrumento 2  *****/
        //curvas do instrumento 2:
        //primeiro harmonico:
        curvas[1][0] = new Curva(720);
        curvas[1][0].addPonto(0, 0);
        curvas[1][0].addPonto(30, 1000);
        curvas[1][0].addPonto(600,700);
        curvas[1][0].addPonto(720, 0);
        //segundo harmonico:
        curvas[1][1] = new Curva(720);
        curvas[1][1].addPonto(0, 0);
        curvas[1][1].addPonto(40, 1000);
        curvas[1][1].addPonto(400,600);
        curvas[1][1].addPonto(720, 0);
        //terceiro harmonico:
        curvas[1][2] = new Curva(720);
        curvas[1][2].addPonto(0, 0);
        curvas[1][2].addPonto(50, 1000);
        curvas[1][2].addPonto(620,700);
        curvas[1][2].addPonto(720, 0);

        //envoltorias do intrumento 2:
        envoltorias[1][0] = new Envoltoria();
        envoltorias[1][0].setCURVA(curvas[1][0]);
        envoltorias[1][1] = new Envoltoria();
        envoltorias[1][1].setCURVA(curvas[1][1]);
        envoltorias[1][2] = new Envoltoria();
        envoltorias[1][2].setCURVA(curvas[1][2]);

        //unidadesH do intrumento 2:
        //unidade 1:
        unidades[1][0] = new UnidadeH();
        unidades[1][0].setEnvoltoria(envoltorias[1][0]);
        unidades[1][0].setH(1);
        unidades[1][0].setLambda(0.5);
        unidades[1][0].setFase(0);
        unidades[1][0].setGanho(1f);
        //unidade 2:
        unidades[1][1] = new UnidadeH();
        unidades[1][1].setEnvoltoria(envoltorias[1][1]);
        unidades[1][1].setH(1.5);
        unidades[1][1].setLambda(0.5);
        unidades[1][1].setFase(0);
        unidades[1][1].setGanho(0.7f);
        //unidade 3:
        unidades[1][2] = new UnidadeH();
        unidades[1][2].setEnvoltoria(envoltorias[1][2]);
        unidades[1][2].setH(3);
        unidades[1][2].setLambda(0.5);
        unidades[1][2].setFase(0);
        unidades[1][2].setGanho(0.6f);

        //inicializa instrumento:
        i2 = new InstrumentoAditivo();
        i2.addUnidade(unidades[1][0]);
        i2.addUnidade(unidades[1][1]);
        i2.addUnidade(unidades[1][2]);
        i2.setGanho(0.7f);



    /*****  Instrumento 3  *****/
        //curvas do instrumento 3:
        //primeiro harmonico:
        curvas[2][0] = new Curva(720);
        curvas[2][0].addPonto(0, 0);
        curvas[2][0].addPonto(30,1000);
        curvas[2][0].addPonto(200,700);
        curvas[2][0].addPonto(720,0);
        //segundo harmonico:
        curvas[2][1] = new Curva(720);
        curvas[2][1].addPonto(0, 0);
        curvas[2][1].addPonto(15,1000);
        curvas[2][1].addPonto(100,600);
        curvas[2][1].addPonto(720,0);
        //terceiro harmonico:
        curvas[2][2] = new Curva(720);
        curvas[2][2].addPonto(0,0);
        curvas[2][2].addPonto(10,1000);
        curvas[2][2].addPonto(60,500);
        curvas[2][2].addPonto(720,0);

        //envoltorias do intrumento 3:
        envoltorias[2][0] = new Envoltoria();
        envoltorias[2][0].setCURVA(curvas[2][0]);
        envoltorias[2][1] = new Envoltoria();
        envoltorias[2][1].setCURVA(curvas[2][1]);
        envoltorias[2][2] = new Envoltoria();
        envoltorias[2][2].setCURVA(curvas[2][2]);

        //unidadesH do intrumento 3:
        //unidade 1:
        unidades[2][0] = new UnidadeH();
        unidades[2][0].setEnvoltoria(envoltorias[2][0]);
        unidades[2][0].setH(1);
        unidades[2][0].setLambda(0.5);
        unidades[2][0].setFase(0);
        unidades[2][0].setGanho(1);
        //unidade 2:
        unidades[2][1] = new UnidadeH();
        unidades[2][1].setEnvoltoria(envoltorias[2][1]);
        unidades[2][1].setH(3);
        unidades[2][1].setLambda(0.5);
        unidades[2][1].setFase(0);
        unidades[2][1].setGanho(1f);
        //unidade 3:
        unidades[2][2] = new UnidadeH();
        unidades[2][2].setEnvoltoria(envoltorias[2][2]);
        unidades[2][2].setH(5);
        unidades[2][2].setLambda(0.5);
        unidades[2][2].setFase(0);
        unidades[2][2].setGanho(0.5f);

        //inicializa instrumento:
        i3 = new InstrumentoAditivo();
        i3.addUnidade(unidades[2][0]);
        i3.addUnidade(unidades[2][1]);
        i3.addUnidade(unidades[2][2]);
        i3.setGanho(0.7f);


    /*** prato ortogonal  ***/    

        InstrumentoAditivo Ortog = new InstrumentoAditivo(); 

        Envoltoria envOrtog0     = new Envoltoria(); 
        UnidadeH   uhOrtog0      = new UnidadeH(); 
        Curva      curvaOrtog0   = new Curva(720); 

        curvaOrtog0.addPonto(0.0, 0.0); 
        curvaOrtog0.addPonto(7.0, 1677.0); 
        curvaOrtog0.addPonto(13.0, 2885.0); 
        curvaOrtog0.addPonto(20.0, 3121.0); 
        curvaOrtog0.addPonto(26.0, 2238.0); 
        curvaOrtog0.addPonto(33.0, 4122.0); 
        curvaOrtog0.addPonto(720.0, 0.0); 

        envOrtog0.setCURVA(curvaOrtog0); 
        uhOrtog0.setEnvoltoria(envOrtog0); 
        uhOrtog0.setH(1.0); 
        uhOrtog0.setLambda(0.0); 
        uhOrtog0.setFase(348.1908); 

        Ortog.addUnidade(uhOrtog0); 

        Curva curvaOrtog1 = new Curva(720); 
        Envoltoria envOrtog1 = new Envoltoria(); 
        UnidadeH uhOrtog1 = new UnidadeH(); 
        curvaOrtog1.addPonto(0.0, 0.0); 
        curvaOrtog1.addPonto(7.0, 276.0); 
        curvaOrtog1.addPonto(720.0, 0.0); 

        envOrtog1.setCURVA(curvaOrtog1); 
        uhOrtog1.setEnvoltoria(envOrtog1); 
        uhOrtog1.setH(0.9502); 
        uhOrtog1.setLambda(0.0); 
        uhOrtog1.setFase(348.6828); 

        Ortog.addUnidade(uhOrtog1); 

        Curva curvaOrtog2 = new Curva(720); 
        Envoltoria envOrtog2 = new Envoltoria(); 
        UnidadeH uhOrtog2 = new UnidadeH(); 
        curvaOrtog2.addPonto(0.0, 0.0); 
        curvaOrtog2.addPonto(5.0, 798.0); 
        curvaOrtog2.addPonto(720.0, 0.0); 

        envOrtog2.setCURVA(curvaOrtog2); 
        uhOrtog2.setEnvoltoria(envOrtog2); 
        uhOrtog2.setH(1.2316); 
        uhOrtog2.setLambda(0.0); 
        uhOrtog2.setFase(348.9148); 

        Ortog.addUnidade(uhOrtog2); 

        Curva curvaOrtog3 = new Curva(720); 
        Envoltoria envOrtog3 = new Envoltoria(); 
        UnidadeH uhOrtog3 = new UnidadeH(); 
        curvaOrtog3.addPonto(0.0, 0.0); 
        curvaOrtog3.addPonto(3.0, -739.0); 
        curvaOrtog3.addPonto(720.0, 0.0); 

        envOrtog3.setCURVA(curvaOrtog3); 
        uhOrtog3.setEnvoltoria(envOrtog3); 
        uhOrtog3.setH(1.4643); 
        uhOrtog3.setLambda(0.0); 
        uhOrtog3.setFase(348.56); 

        Ortog.addUnidade(uhOrtog3); 

        Curva curvaOrtog4 = new Curva(720); 
        Envoltoria envOrtog4 = new Envoltoria(); 
        UnidadeH uhOrtog4 = new UnidadeH(); 
        curvaOrtog4.addPonto(0.0, 0.0); 
        curvaOrtog4.addPonto(4.0, -1477.0); 
        curvaOrtog4.addPonto(720.0, 0.0); 

        envOrtog4.setCURVA(curvaOrtog4); 
        uhOrtog4.setEnvoltoria(envOrtog4); 
        uhOrtog4.setH(1.3148); 
        uhOrtog4.setLambda(0.0); 
        uhOrtog4.setFase(348.1095); 

        Ortog.addUnidade(uhOrtog4); 

        Curva curvaOrtog5 = new Curva(720); 
        Envoltoria envOrtog5 = new Envoltoria(); 
        UnidadeH uhOrtog5 = new UnidadeH(); 
        curvaOrtog5.addPonto(0.0, 0.0); 
        curvaOrtog5.addPonto(8.0, -2294.0); 
        curvaOrtog5.addPonto(15.0, -1991.0); 
        curvaOrtog5.addPonto(23.0, -402.0); 
        curvaOrtog5.addPonto(30.0, -2262.0); 
        curvaOrtog5.addPonto(720.0, 0.0); 

        envOrtog5.setCURVA(curvaOrtog5); 
        uhOrtog5.setEnvoltoria(envOrtog5); 
        uhOrtog5.setH(0.8697); 
        uhOrtog5.setLambda(0.0); 
        uhOrtog5.setFase(349.6133); 

        Ortog.addUnidade(uhOrtog5); 

        Curva curvaOrtog6 = new Curva(720); 
        Envoltoria envOrtog6 = new Envoltoria(); 
        UnidadeH uhOrtog6 = new UnidadeH(); 
        curvaOrtog6.addPonto(0.0, 0.0); 
        curvaOrtog6.addPonto(7.0, -704.0); 
        curvaOrtog6.addPonto(720.0, 0.0); 

        envOrtog6.setCURVA(curvaOrtog6); 
        uhOrtog6.setEnvoltoria(envOrtog6); 
        uhOrtog6.setH(1.0014); 
        uhOrtog6.setLambda(0.0); 
        uhOrtog6.setFase(350.0658); 

        Ortog.addUnidade(uhOrtog6); 

        Curva curvaOrtog7 = new Curva(720); 
        Envoltoria envOrtog7 = new Envoltoria(); 
        UnidadeH uhOrtog7 = new UnidadeH(); 
        curvaOrtog7.addPonto(0.0, 0.0); 
        curvaOrtog7.addPonto(4.0, 556.0); 
        curvaOrtog7.addPonto(720.0, 0.0); 

        envOrtog7.setCURVA(curvaOrtog7); 
        uhOrtog7.setEnvoltoria(envOrtog7); 
        uhOrtog7.setH(1.3207); 
        uhOrtog7.setLambda(0.0); 
        uhOrtog7.setFase(350.0068); 

        Ortog.addUnidade(uhOrtog7); 

        Curva curvaOrtog8 = new Curva(720); 
        Envoltoria envOrtog8 = new Envoltoria(); 
        UnidadeH uhOrtog8 = new UnidadeH(); 
        curvaOrtog8.addPonto(0.0, 0.0); 
        curvaOrtog8.addPonto(3.0, -584.0); 
        curvaOrtog8.addPonto(720.0, 0.0); 

        envOrtog8.setCURVA(curvaOrtog8); 
        uhOrtog8.setEnvoltoria(envOrtog8); 
        uhOrtog8.setH(1.3823); 
        uhOrtog8.setLambda(0.0); 
        uhOrtog8.setFase(349.5092); 

        Ortog.addUnidade(uhOrtog8); 

        Curva curvaOrtog9 = new Curva(720); 
        Envoltoria envOrtog9 = new Envoltoria(); 
        UnidadeH uhOrtog9 = new UnidadeH(); 
        curvaOrtog9.addPonto(0.0, 0.0); 
        curvaOrtog9.addPonto(8.0, 2631.0); 
        curvaOrtog9.addPonto(16.0, 2150.0); 
        curvaOrtog9.addPonto(24.0, 474.0); 
        curvaOrtog9.addPonto(720.0, 0.0); 

        envOrtog9.setCURVA(curvaOrtog9); 
        uhOrtog9.setEnvoltoria(envOrtog9); 
        uhOrtog9.setH(0.8103); 
        uhOrtog9.setLambda(0.0); 
        uhOrtog9.setFase(350.9941); 

        Ortog.addUnidade(uhOrtog9); 

        Curva curvaOrtog10 = new Curva(720); 
        Envoltoria envOrtog10 = new Envoltoria(); 
        UnidadeH uhOrtog10 = new UnidadeH(); 
        curvaOrtog10.addPonto(0.0, 0.0); 
        curvaOrtog10.addPonto(6.0, 1775.0); 
        curvaOrtog10.addPonto(720.0, 0.0); 

        envOrtog10.setCURVA(curvaOrtog10); 
        uhOrtog10.setEnvoltoria(envOrtog10); 
        uhOrtog10.setH(1.0811); 
        uhOrtog10.setLambda(0.0); 
        uhOrtog10.setFase(351.2507); 

        Ortog.addUnidade(uhOrtog10); 

        Curva curvaOrtog11 = new Curva(720); 
        Envoltoria envOrtog11 = new Envoltoria(); 
        UnidadeH uhOrtog11 = new UnidadeH(); 
        curvaOrtog11.addPonto(0.0, 0.0); 
        curvaOrtog11.addPonto(4.0, 147.0); 
        curvaOrtog11.addPonto(720.0, 0.0); 

        envOrtog11.setCURVA(curvaOrtog11); 
        uhOrtog11.setEnvoltoria(envOrtog11); 
        uhOrtog11.setH(1.3249); 
        uhOrtog11.setLambda(0.0); 
        uhOrtog11.setFase(350.917); 

        Ortog.addUnidade(uhOrtog11); 

        Curva curvaOrtog12 = new Curva(720); 
        Envoltoria envOrtog12 = new Envoltoria(); 
        UnidadeH uhOrtog12 = new UnidadeH(); 
        curvaOrtog12.addPonto(0.0, 0.0); 
        curvaOrtog12.addPonto(8.0, 134.0); 
        curvaOrtog12.addPonto(16.0, 116.0); 
        curvaOrtog12.addPonto(720.0, 0.0); 

        envOrtog12.setCURVA(curvaOrtog12); 
        uhOrtog12.setEnvoltoria(envOrtog12); 
        uhOrtog12.setH(0.8187); 
        uhOrtog12.setLambda(0.0); 
        uhOrtog12.setFase(352.229); 

        Ortog.addUnidade(uhOrtog12); 

        Curva curvaOrtog13 = new Curva(720); 
        Envoltoria envOrtog13 = new Envoltoria(); 
        UnidadeH uhOrtog13 = new UnidadeH(); 
        curvaOrtog13.addPonto(0.0, 0.0); 
        curvaOrtog13.addPonto(5.0, 1635.0); 
        curvaOrtog13.addPonto(720.0, 0.0); 

        envOrtog13.setCURVA(curvaOrtog13); 
        uhOrtog13.setEnvoltoria(envOrtog13); 
        uhOrtog13.setH(1.1368); 
        uhOrtog13.setLambda(0.0); 
        uhOrtog13.setFase(352.1964); 

        Ortog.addUnidade(uhOrtog13); 

        Curva curvaOrtog14 = new Curva(720); 
        Envoltoria envOrtog14 = new Envoltoria(); 
        UnidadeH uhOrtog14 = new UnidadeH(); 
        curvaOrtog14.addPonto(0.0, 0.0); 
        curvaOrtog14.addPonto(8.0, -955.0); 
        curvaOrtog14.addPonto(720.0, 0.0); 

        envOrtog14.setCURVA(curvaOrtog14); 
        uhOrtog14.setEnvoltoria(envOrtog14); 
        uhOrtog14.setH(0.8638); 
        uhOrtog14.setLambda(0.0); 
        uhOrtog14.setFase(353.2324); 

        Ortog.addUnidade(uhOrtog14); 

        Curva curvaOrtog15 = new Curva(720); 
        Envoltoria envOrtog15 = new Envoltoria(); 
        UnidadeH uhOrtog15 = new UnidadeH(); 
        curvaOrtog15.addPonto(0.0, 0.0); 
        curvaOrtog15.addPonto(9.0, -2060.0); 
        curvaOrtog15.addPonto(19.0, -4515.0); 
        curvaOrtog15.addPonto(28.0, -3883.0); 
        curvaOrtog15.addPonto(37.0, -5358.0); 
        curvaOrtog15.addPonto(47.0, -5863.0); 
        curvaOrtog15.addPonto(720.0, 0.0); 

        envOrtog15.setCURVA(curvaOrtog15); 
        uhOrtog15.setEnvoltoria(envOrtog15); 
        uhOrtog15.setH(1.0); 
        uhOrtog15.setLambda(1.0); 
        uhOrtog15.setFase(192.6686); 

        Ortog.addUnidade(uhOrtog15); 

        Curva curvaOrtog16 = new Curva(720); 
        Envoltoria envOrtog16 = new Envoltoria(); 
        UnidadeH uhOrtog16 = new UnidadeH(); 
        curvaOrtog16.addPonto(0.0, 0.0); 
        curvaOrtog16.addPonto(10.0, -440.0); 
        curvaOrtog16.addPonto(720.0, 0.0); 

        envOrtog16.setCURVA(curvaOrtog16); 
        uhOrtog16.setEnvoltoria(envOrtog16); 
        uhOrtog16.setH(0.8263); 
        uhOrtog16.setLambda(1.0); 
        uhOrtog16.setFase(192.064); 

        Ortog.addUnidade(uhOrtog16); 

        Curva curvaOrtog17 = new Curva(720); 
        Envoltoria envOrtog17 = new Envoltoria(); 
        UnidadeH uhOrtog17 = new UnidadeH(); 
        curvaOrtog17.addPonto(0.0, 0.0); 
        curvaOrtog17.addPonto(8.0, -1333.0); 
        curvaOrtog17.addPonto(720.0, 0.0); 

        envOrtog17.setCURVA(curvaOrtog17); 
        uhOrtog17.setEnvoltoria(envOrtog17); 
        uhOrtog17.setH(1.2638); 
        uhOrtog17.setLambda(1.0); 
        uhOrtog17.setFase(191.6647); 

        Ortog.addUnidade(uhOrtog17); 

        Curva curvaOrtog18 = new Curva(720); 
        Envoltoria envOrtog18 = new Envoltoria(); 
        UnidadeH uhOrtog18 = new UnidadeH(); 
        curvaOrtog18.addPonto(0.0, 0.0); 
        curvaOrtog18.addPonto(5.0, -1189.0); 
        curvaOrtog18.addPonto(720.0, 0.0); 

        envOrtog18.setCURVA(curvaOrtog18); 
        uhOrtog18.setEnvoltoria(envOrtog18); 
        uhOrtog18.setH(1.7163); 
        uhOrtog18.setLambda(1.0); 
        uhOrtog18.setFase(192.0172); 

        Ortog.addUnidade(uhOrtog18); 

        Curva curvaOrtog19 = new Curva(720); 
        Envoltoria envOrtog19 = new Envoltoria(); 
        UnidadeH uhOrtog19 = new UnidadeH(); 
        curvaOrtog19.addPonto(0.0, 0.0); 
        curvaOrtog19.addPonto(6.0, -13.0); 
        curvaOrtog19.addPonto(720.0, 0.0); 

        envOrtog19.setCURVA(curvaOrtog19); 
        uhOrtog19.setEnvoltoria(envOrtog19); 
        uhOrtog19.setH(1.5569); 
        uhOrtog19.setLambda(1.0); 
        uhOrtog19.setFase(192.6415); 

        Ortog.addUnidade(uhOrtog19); 

        Curva curvaOrtog20 = new Curva(720); 
        Envoltoria envOrtog20 = new Envoltoria(); 
        UnidadeH uhOrtog20 = new UnidadeH(); 
        curvaOrtog20.addPonto(0.0, 0.0); 
        curvaOrtog20.addPonto(10.0, -2348.0); 
        curvaOrtog20.addPonto(21.0, -1011.0); 
        curvaOrtog20.addPonto(31.0, -28.0); 
        curvaOrtog20.addPonto(42.0, 1993.0); 
        curvaOrtog20.addPonto(720.0, 0.0); 

        envOrtog20.setCURVA(curvaOrtog20); 
        uhOrtog20.setEnvoltoria(envOrtog20); 
        uhOrtog20.setH(0.8324); 
        uhOrtog20.setLambda(1.0); 
        uhOrtog20.setFase(191.4602); 

        Ortog.addUnidade(uhOrtog20); 

        Curva curvaOrtog21 = new Curva(720); 
        Envoltoria envOrtog21 = new Envoltoria(); 
        UnidadeH uhOrtog21 = new UnidadeH(); 
        curvaOrtog21.addPonto(0.0, 0.0); 
        curvaOrtog21.addPonto(9.0, -769.0); 
        curvaOrtog21.addPonto(720.0, 0.0); 

        envOrtog21.setCURVA(curvaOrtog21); 
        uhOrtog21.setEnvoltoria(envOrtog21); 
        uhOrtog21.setH(0.9966); 
        uhOrtog21.setLambda(1.0); 
        uhOrtog21.setFase(190.83); 

        Ortog.addUnidade(uhOrtog21); 

        Curva curvaOrtog22 = new Curva(720); 
        Envoltoria envOrtog22 = new Envoltoria(); 
        UnidadeH uhOrtog22 = new UnidadeH(); 
        curvaOrtog22.addPonto(0.0, 0.0); 
        curvaOrtog22.addPonto(6.0, -2201.0); 
        curvaOrtog22.addPonto(720.0, 0.0); 

        envOrtog22.setCURVA(curvaOrtog22); 
        uhOrtog22.setEnvoltoria(envOrtog22); 
        uhOrtog22.setH(1.5526); 
        uhOrtog22.setLambda(1.0); 
        uhOrtog22.setFase(190.7965); 

        Ortog.addUnidade(uhOrtog22); 

        Curva curvaOrtog23 = new Curva(720); 
        Envoltoria envOrtog23 = new Envoltoria(); 
        UnidadeH uhOrtog23 = new UnidadeH(); 
        curvaOrtog23.addPonto(0.0, 0.0); 
        curvaOrtog23.addPonto(5.0, -1236.0); 
        curvaOrtog23.addPonto(720.0, 0.0); 

        envOrtog23.setCURVA(curvaOrtog23); 
        uhOrtog23.setEnvoltoria(envOrtog23); 
        uhOrtog23.setH(1.7442); 
        uhOrtog23.setLambda(1.0); 
        uhOrtog23.setFase(191.409); 

        Ortog.addUnidade(uhOrtog23); 

        Curva curvaOrtog24 = new Curva(720); 
        Envoltoria envOrtog24 = new Envoltoria(); 
        UnidadeH uhOrtog24 = new UnidadeH(); 
        curvaOrtog24.addPonto(0.0, 0.0); 
        curvaOrtog24.addPonto(11.0, -890.0); 
        curvaOrtog24.addPonto(21.0, -531.0); 
        curvaOrtog24.addPonto(32.0, -1751.0); 
        curvaOrtog24.addPonto(720.0, 0.0); 

        envOrtog24.setCURVA(curvaOrtog24); 
        uhOrtog24.setEnvoltoria(envOrtog24); 
        uhOrtog24.setH(0.8037); 
        uhOrtog24.setLambda(1.0); 
        uhOrtog24.setFase(190.1712); 

        Ortog.addUnidade(uhOrtog24); 

        Curva curvaOrtog25 = new Curva(720); 
        Envoltoria envOrtog25 = new Envoltoria(); 
        UnidadeH uhOrtog25 = new UnidadeH(); 
        curvaOrtog25.addPonto(0.0, 0.0); 
        curvaOrtog25.addPonto(8.0, -463.0); 
        curvaOrtog25.addPonto(720.0, 0.0); 

        envOrtog25.setCURVA(curvaOrtog25); 
        uhOrtog25.setEnvoltoria(envOrtog25); 
        uhOrtog25.setH(1.2508); 
        uhOrtog25.setLambda(1.0); 
        uhOrtog25.setFase(189.7537); 

        Ortog.addUnidade(uhOrtog25); 

        Curva curvaOrtog26 = new Curva(720); 
        Envoltoria envOrtog26 = new Envoltoria(); 
        UnidadeH uhOrtog26 = new UnidadeH(); 
        curvaOrtog26.addPonto(0.0, 0.0); 
        curvaOrtog26.addPonto(6.0, 1052.0); 
        curvaOrtog26.addPonto(720.0, 0.0); 

        envOrtog26.setCURVA(curvaOrtog26); 
        uhOrtog26.setEnvoltoria(envOrtog26); 
        uhOrtog26.setH(1.7228); 
        uhOrtog26.setLambda(1.0); 
        uhOrtog26.setFase(190.1121); 

        Ortog.addUnidade(uhOrtog26); 

        Curva curvaOrtog27 = new Curva(720); 
        Envoltoria envOrtog27 = new Envoltoria(); 
        UnidadeH uhOrtog27 = new UnidadeH(); 
        curvaOrtog27.addPonto(0.0, 0.0); 
        curvaOrtog27.addPonto(10.0, -241.0); 
        curvaOrtog27.addPonto(20.0, -220.0); 
        curvaOrtog27.addPonto(720.0, 0.0); 

        envOrtog27.setCURVA(curvaOrtog27); 
        uhOrtog27.setEnvoltoria(envOrtog27); 
        uhOrtog27.setH(0.9163); 
        uhOrtog27.setLambda(1.0); 
        uhOrtog27.setFase(188.9535); 

        Ortog.addUnidade(uhOrtog27); 

        Curva curvaOrtog28 = new Curva(720); 
        Envoltoria envOrtog28 = new Envoltoria(); 
        UnidadeH uhOrtog28 = new UnidadeH(); 
        curvaOrtog28.addPonto(0.0, 0.0); 
        curvaOrtog28.addPonto(7.0, -1495.0); 
        curvaOrtog28.addPonto(720.0, 0.0); 

        envOrtog28.setCURVA(curvaOrtog28); 
        uhOrtog28.setEnvoltoria(envOrtog28); 
        uhOrtog28.setH(1.4882); 
        uhOrtog28.setLambda(1.0); 
        uhOrtog28.setFase(188.9125); 

        Ortog.addUnidade(uhOrtog28); 

        Curva curvaOrtog29 = new Curva(720); 
        Envoltoria envOrtog29 = new Envoltoria(); 
        UnidadeH uhOrtog29 = new UnidadeH(); 
        curvaOrtog29.addPonto(0.0, 0.0); 
        curvaOrtog29.addPonto(9.0, 653.0); 
        curvaOrtog29.addPonto(720.0, 0.0); 

        envOrtog29.setCURVA(curvaOrtog29); 
        uhOrtog29.setEnvoltoria(envOrtog29); 
        uhOrtog29.setH(1.1103); 
        uhOrtog29.setLambda(1.0); 
        uhOrtog29.setFase(187.9454); 

        Ortog.addUnidade(uhOrtog29); 
        Ortog.setGanho(0.3f);	

        i4 = Ortog;
            }
    }

