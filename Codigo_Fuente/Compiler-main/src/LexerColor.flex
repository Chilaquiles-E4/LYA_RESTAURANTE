import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

[1-9][0-9]* { return textColor(yychar, yylength(), new Color(102, 255, 255)); }

/* iluminar camino */
iluminarcamino { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

declararmenu { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

verofertas { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

vermenu { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

realizarpedido { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

rotarmenu { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

solicitarmesero { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

vermesa { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

/* estadomesas */
estadomesas { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

/* tiempopedido */
tiempopedido { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

/* Signo Aritmetico */
"+" |
"-" |
"*" |
"/" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

for { return textColor(yychar, yylength(), new Color(255, 255, 0)); }

while { return textColor(yychar, yylength(), new Color(255, 255, 0)); }

if { return textColor(yychar, yylength(), new Color(255, 255, 0)); }

var { return textColor(yychar, yylength(), new Color(255, 255, 0)); }

";" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

print { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

horaDelDia { return textColor(yychar, yylength(), new Color(204, 153, 255)); }

tipoComida { return textColor(yychar, yylength(), new Color(204, 153, 255)); }

numeroMesa { return textColor(yychar, yylength(), new Color(204, 153, 255)); }

pedido { return textColor(yychar, yylength(), new Color(204, 153, 255)); }

"=" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

main { return textColor(yychar, yylength(), new Color(153, 0, 76)); }

prepararmesa { return textColor(yychar, yylength(), new Color(51, 255, 153)); }

numeroAsientos { return textColor(yychar, yylength(), new Color(204, 153, 255)); }

"(" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

")" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

"{" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

"}" { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

"," { return textColor(yychar, yylength(), new Color(255, 128, 0)); }

"};" { return textColor(yychar, yylength(), new Color(153, 0, 76)); }

estado { return textColor(yychar, yylength(), new Color(204, 153, 255));  }

true |
false { return textColor(yychar, yylength(), new Color(0, 204, 204));  }

vegetariano |
regular |
pesqueteriano { return textColor(yychar, yylength(), new Color(0, 204, 204)); }

mañana |
tarde |
noche { return textColor(yychar, yylength(), new Color(0, 204, 204)); }

[A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü][A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]* { return textColor(yychar, yylength(), new Color(255, 0, 0)); }

. { return textColor(yychar, yylength(), new Color(255, 0, 0)); }