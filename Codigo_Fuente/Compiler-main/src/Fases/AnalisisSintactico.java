package Fases;

import Principal.Compilador;
import VentanasSecundarias.VentanaAutomata;
import compilerTools.Token;
import java.util.ArrayList;

public class AnalisisSintactico {

    private ArrayList<String> tokens = new ArrayList<>();
    private VentanaAutomata vAutomata;
    private String cadena = "";
    private String errores = "";
    private Compilador compilador;

    public AnalisisSintactico(ArrayList<Token> tokens, VentanaAutomata vAutomata, Compilador compilador) {
        for (Token token : tokens) {
            this.tokens.add(token.getLexeme());
        }
        this.vAutomata = vAutomata;
        this.compilador = compilador;
        //this.compilador.setTxtOutputConsole(errores);
    }

    public void realizarAnalisisSintactico() {
        if (!tokens.isEmpty()) {

        } else {
            vAutomata.setTxtEstados("ERROR!, NO HAY CODIGO REALIZAR EL ANALISIS SINTACTICO");
            return;
        }

        for (int i = 0; i < tokens.size(); i++) {

            switch (tokens.get(i)) {
                case "main":
                    q0Main(i);
                    break;
                case "vermenu":
                    validarVerMenu(i + 1);
                    break;
            }
            //System.out.println(tokens.get(i));
        }
        if (errores.isBlank()) {
            compilador.setTxtOutputConsole("Compilación terminada...");
        } else {
            compilador.setTxtOutputConsole(errores);
        }
    }

    private void validarVerMenu(int i) {
        ArrayList<String> comprobacion = new ArrayList<>();
        comprobacion.add("(");
        comprobacion.add(")");
        comprobacion.add(";");

        for (int j = 0; j < comprobacion.size(); j++, i++) {
            if (!comprobacion.get(j).equals(tokens.get(i))) {
                switch (j) {
                    case 0:
                        errores += "ERROR SE ESPERABA [ ( ] EN LA LINEA: [  ]\n";
                        break;
                    case 1:
                        errores += "ERROR SE ESPERABA [ ) ] EN LA LINEA: [  ]\n";
                        break;
                    case 2:
                        errores += "ERROR SE ESPERABA [ ; ] EN LA LINEA: [  ]\n";
                        break;
                }
            }
        }

        //compilador.setTxtOutputConsole(errores);
    }

    private void q0Main(int i) {
        if (tokens.get(i).equals("main")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q0 HACIA EL ESTADO q1\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q0 HACIA q1; SE ESPERABA [ main ]\n";
            errores += "ERROR EN LA TRANSICION DE q0 HACIA q1; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        q1Main((i + 1));
        vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q1Main(int i) {
        if (tokens.get(i).equals("(")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q1 HACIA EL ESTADO q2\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q1 HACIA q2; SE ESPERABA [ ( ]\n";
            errores += "ERROR EN LA TRANSICION DE q1 HACIA q2; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        q2Main((i + 1));
        vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q2Main(int i) {
        if (tokens.get(i).equals(")")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q2 HACIA EL ESTADO q3\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q2 HACIA q3; SE ESPERABA [ ) ]\n";
            errores += "ERROR EN LA TRANSICION DE q2 HACIA q3; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        q3Main((i + 1));
        vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q3Main(int i) {
        if (tokens.get(i).equals("{")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q3 HACIA EL ESTADO q4\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q3 HACIA q4; SE ESPERABA [ { ]\n";
            errores += "ERROR EN LA TRANSICION DE q3 HACIA q4; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        q4Main(tokens.size() - 1);
        vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q4Main(int i) {

        cadena += "LA CANTIDAD DE [ " + (tokens.size() - 5) + " ] TOKENS AVANZAN DESDE EL ESTADO q4 HACIA EL ESTADO q4\n";
        if (tokens.get(i).equals("};")) {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] AVANZA DESDE EL ESTADO q4 HACIA EL ESTADO q5\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i) + " ] NO PERTENCE A LA TRANSICION DE q4 HACIA q5; SE ESPERABA [ }; ]\n";
            errores += "ERROR EN LA TRANSICION DE q4 HACIA q5; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

}
