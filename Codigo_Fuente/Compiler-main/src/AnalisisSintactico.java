
import VentanasSecundarias.VentanaAutomata;
import compilerTools.Token;
import java.util.ArrayList;
import java.util.regex.*;

public class AnalisisSintactico {

    private ArrayList<String> tokensArreglo = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();
    private VentanaAutomata vAutomata;
    private String cadena = "";
    private String errores = "";
    private Compilador compilador;

    public AnalisisSintactico(ArrayList<Token> tokens, VentanaAutomata vAutomata, Compilador compilador) {
        for (Token token : tokens) {
            this.tokensArreglo.add(token.getLexeme());
        }
        this.tokens = tokens;
        this.vAutomata = vAutomata;
        this.compilador = compilador;
        //this.compilador.setTxtOutputConsole(errores);
    }

    public void realizarAnalisisSintactico() {

        if (!tokens.isEmpty()) {

        } else {
            compilador.setTxtOutputConsole("ERROR! NO HAY CODIGO PARA COMPILAR");
            return;
        }

        q0Main(0);

        if (!errores.isBlank()) {
            compilador.setTxtOutputConsole(errores);
            vAutomata.setTxtEstados(cadena);
            return;
        }

        vAutomata.setTxtEstados(cadena);

        for (int i = 4; i < tokens.size(); i++) {
            //Se compara el componente lexico
            switch (tokens.get(i).getLexicalComp()) {
                case "vermenu":
                    validarVerMenu(i + 1);
                    break;
                case "variable":
                    validarVariable(i + 1);
                    break;
                case "realizarpedido":
                    validarRealizarPedido(i + 1);
                    break;
                case "solicitarmesero":
                    validarSolicitarMesero(i + 1);
                    break;
                case "iluminarcamino":
                    validarIluminarCamino(i + 1);
                    break;
                case "declararmenu":
                    validarDeclararMenu(i + 1);
                    break;
                case "prepmesa":
                    validarDeclararMesas(i + 1);
                    break;
                case "if":
                    validarIf(i + 1);
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

    private void validarIf(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("operadorLogico") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("CorcheteA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        while (!tokens.get(i).getLexicalComp().equals("CorcheteC")) {
            i++;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: if(condicion){//El codigo} Donde los la condicion puede ser entre dos numeros o variables de tipo int, y los operadores logicos pueden ser: <, >, <=, >=.\n";
        }
    }

    private void validarDeclararMesas(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: prepararmesa(numeroMesa, numeroAsientos); Donde todos los parametros pueden ser variables o numeros enteros.\n";
        }
    }

    private void validarDeclararMenu(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Cadenas") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Cadenas") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("dinero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("tipo") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("arreglo") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: declararmenu(nombrePlatillo, descripcionPlatillo, precioPlatillo, tipoPlatillo, ingredientesPlatillo); Donde todos los parametros pueden ser variables o en el caso de nombrePlatillo y descripcionPlatillo puden recibir una cadena, precioPlatillo un numero con la estructura de un numero decimal, tipoPlatillo puede recibir vegetariano, regular ó pesqueteriano, y ingredientesPlatillo puede recibir un arreglo de tipo String.\n";
        }
    }

    private void validarIluminarCamino(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: iluminarcamino(numeroMesa); Donde numeroMesa es un entero o una variable\n";
        }
    }

    private void validarSolicitarMesero(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("numero") || tokens.get(i).getLexicalComp().equals("Identificadores")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: solicitarmesero(numeroMesa); Donde numeroMesa es un entero o una variable\n";
        }
    }

    private void validarRealizarPedido(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("hDia")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("numero")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("Cadenas")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("booleano")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: realizarpedido(horaDelDia, numeroMesa, Pedido, true | false); Donde la horaDelDia es una variable o una hora en formato de 24 horas, numeroMesa es una variable o un entero, Pedido es una variable o una cadena, y el utlimo campo es una variable o un booleano.\n";
        }
    }

    private void validarVariable(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("Identificadores") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("tipoDato") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: var nombreVariable tipoDato; Donde el tipo de dato puede ser int, String, float ó boolean\n";
        }
    }

    private void validarVerMenu(int i) {
        boolean algunError = false;

        //Donde se realiza la comparacion
        if (tokens.get(i).getLexicalComp().equals("parentecisA") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("Cadenas")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("coma") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if ((tokens.get(i).getLexicalComp().equals("Identificadores") || tokens.get(i).getLexicalComp().equals("tipo")) && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("parentecisC") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }
        if (tokens.get(i).getLexicalComp().equals("finlinea") && algunError == false) {
            i++;
        } else {
            algunError = true;
        }

        if (algunError) {
            errores += "ERROR EN: [ " + tokens.get(i).getLine() + ", " + tokens.get(i).getColumn() + " ]; Tal vez quiso escribir: vermenu(HoraDelDia, tipoComida); Donde: HoraDelDia es una hora en formato de 24 horas y tipoComida puede ser vegetariano, regular ó pesqueteriano.\n";
        }
    }

    private void q0Main(int i) {
        if (tokens.get(i).getLexeme().equals("main")) {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] AVANZA DESDE EL ESTADO q0 HACIA EL ESTADO q1\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] NO PERTENCE A LA TRANSICION DE q0 HACIA q1; SE ESPERABA [ main ]\n";
            errores += "ERROR EN LA TRANSICION DE q0 HACIA q1; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
            return;
        }
        q1Main((i + 1));
        //vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q1Main(int i) {
        if (tokens.get(i).getLexeme().equals("(")) {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] AVANZA DESDE EL ESTADO q1 HACIA EL ESTADO q2\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] NO PERTENCE A LA TRANSICION DE q1 HACIA q2; SE ESPERABA [ ( ]\n";
            errores += "ERROR EN LA TRANSICION DE q1 HACIA q2; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
            return;
        }
        q2Main((i + 1));
        //vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q2Main(int i) {
        if (tokens.get(i).getLexeme().equals(")")) {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] AVANZA DESDE EL ESTADO q2 HACIA EL ESTADO q3\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] NO PERTENCE A LA TRANSICION DE q2 HACIA q3; SE ESPERABA [ ) ]\n";
            errores += "ERROR EN LA TRANSICION DE q2 HACIA q3; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
            return;
        }
        q3Main((i + 1));
        //vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q3Main(int i) {
        if (tokens.get(i).getLexeme().equals("{")) {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] AVANZA DESDE EL ESTADO q3 HACIA EL ESTADO q4\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] NO PERTENCE A LA TRANSICION DE q3 HACIA q4; SE ESPERABA [ { ]\n";
            errores += "ERROR EN LA TRANSICION DE q3 HACIA q4; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
            return;
        }
        q4Main(tokens.size() - 1);
        //vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

    private void q4Main(int i) {

        cadena += "LA CANTIDAD DE [ " + (tokens.size() - 5) + " ] TOKENS AVANZAN DESDE EL ESTADO q4 HACIA EL ESTADO q4\n";
        if (tokens.get(i).getLexeme().equals("};")) {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] AVANZA DESDE EL ESTADO q4 HACIA EL ESTADO q5\n";
        } else {
            cadena += "EL TOKEN [ " + tokens.get(i).getLexeme() + " ] NO PERTENCE A LA TRANSICION DE q4 HACIA q5; SE ESPERABA [ }; ]\n";
            errores += "ERROR EN LA TRANSICION DE q4 HACIA q5; MAS INFORMACION EN: OPCIONES > AUTOMATA\n";
        }
        //vAutomata.setTxtEstados(cadena);
        //compilador.setTxtOutputConsole(errores);
    }

}
