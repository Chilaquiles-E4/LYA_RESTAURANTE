package Fases;

import Ventanas.VentanaAutomata;
import compilerTools.Token;
import java.util.ArrayList;

public class AnalisisSintactico {

    private ArrayList<String> tokens = new ArrayList<>();
    private VentanaAutomata vAutomata;
    private String cadena = "";

    public AnalisisSintactico(ArrayList<Token> tokens, VentanaAutomata vAutomata) {

        for (Token token : tokens) {
            this.tokens.add(token.getLexeme());
        }
        this.vAutomata = vAutomata;
    }

    public void validarMain() {
        int i = 0;

        if (!tokens.isEmpty()) {
            q0Main(tokens, i);
        } else {
            vAutomata.setTxtEstados("ERROR!, NO HAY CODIGO PARA ANALIZAR");
        }
        /*
        for (int i = 0; i < tokens.size() - 1; i++) {
            Token token = tokens.get(i);
            if (token.toString().toUpperCase().equals("MAIN")) {

            }
        }
         */
    }

    private void q0Main(ArrayList<String> tokens, int i) {
        if (tokens.get(i).equals("main")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q0 HACIA EL ESTADO q1\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q0 HACIA q1";
        }
        q1Main(tokens, (i + 1));
        vAutomata.setTxtEstados(cadena);
    }

    private void q1Main(ArrayList<String> tokens, int i) {
        if (tokens.get(i).equals("(")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q1 HACIA EL ESTADO q2\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q1 HACIA q2";
        }
        q2Main(tokens, (i + 1));
        vAutomata.setTxtEstados(cadena);
    }

    private void q2Main(ArrayList<String> tokens, int i) {
        if (tokens.get(i).equals(")")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q2 HACIA EL ESTADO q3\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q2 HACIA q3";
        }
        q3Main(tokens, (i + 1));
        vAutomata.setTxtEstados(cadena);
    }

    private void q3Main(ArrayList<String> tokens, int i) {
        if (tokens.get(i).equals("{")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q3 HACIA EL ESTADO q4\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q3 HACIA q4";
        }
        q4Main(tokens, tokens.size()-1);
        vAutomata.setTxtEstados(cadena);
    }

    private void q4Main(ArrayList<String> tokens, int i) {

        cadena += "LA CANTIDAD DE [ " + (tokens.size()-5) + " ] TOKENS AVANZAN DESDE EL ESTADO q4 HACIA EL ESTADO q4\n";
        if (tokens.get(i).equals("};")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q4 HACIA EL ESTADO q5";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q4 HACIA q5";
        }
        vAutomata.setTxtEstados(cadena);
    }

}
