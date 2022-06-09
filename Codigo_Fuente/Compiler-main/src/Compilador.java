
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {
    public String fuente;
    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
        automata();
    }

    private ImageIcon automata;
    private Icon auto;

public void automata(){
        automata = new ImageIcon("uno.jpg");
        auto = new ImageIcon(automata.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_AREA_AVERAGING));
        Imagen.setIcon(auto);
	this.repaint();
    }
    
    private void init() {
        title = "Restaurante Automata";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".comp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{
            "iluminarcamino","declararmenu","verofertas","vermenu","realizarpedido",
            "solicitarmesero","vermesa","estadomesa","tiempopedido","for","while","if","var",
            "print","horaDelDia","tipoComida","numeroMesa","pedido","main","prepararmesa",
            "numeroAsientos","estado","vegetariano","regular","pesqueteriano","true","false",
            "mañana","tarde","noche"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        letrafuente = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        gramaticaUtilizada = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        Imagen = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jtpCode.setName("letrafuente"); // NOI18N
        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        letrafuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "14", "16", "18", "20", "22", "24" }));
        letrafuente.setName(""); // NOI18N
        letrafuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letrafuenteActionPerformed(evt);
            }
        });

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        jTabbedPane1.addTab("Componentes Lexicos", jScrollPane3);

        gramaticaUtilizada.setColumns(20);
        gramaticaUtilizada.setRows(5);
        jScrollPane5.setViewportView(gramaticaUtilizada);

        jTabbedPane1.addTab("Gramatica actual", jScrollPane5);

        Imagen.setName("Imagen"); // NOI18N
        jScrollPane6.setViewportView(Imagen);

        jTabbedPane1.addTab("tab4", jScrollPane6);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("var\nq1-v->q2-a->q3-r->qf\nif\nq1-i->q2-f->qf\nwhile\nq1-w->q2-h->q3-i->q4-l->q5-e->qf\nfor\nq1-f->q2-o->q3-r->qf\ntiempopedido\nq1-t->q2-i->q3-e->q4-m->q5-p->q6-o->q7-p->q8-e->q9-d->q10-i->q11-d->q12-o->qf\niluminarcamino\nq1-i->q2-l->q3-u->q4-m->q5-i->q6-n->q7-a->q8-r->q9-c->q10-a->q11-m->q12-i->q13-n->q14-o->qf\nq1-d->q2-e->q3-c->q4-l->q5-a->q6-r->q7-a->q8-r->q9-m->q10-e->q11-n->q12-u->qf\nq1-v->q2-e->q3-r->q4-o->q5-f->q6-e->q7-r->q8-t->q9-a->q10-s->qf\nq1-v->q2-e->q3-r->q4-m->q5-e->q6-n->q7-u->qf\nq1-r->q2-e->q3-a->q4-l->q5-i->q6-z->q7-a->q8-r->q9-p->q10-e->q11-d->q12-i->q13-d->q14-o->qf\nq1-s->q2-o->q3-l->q4-i->q5-c->q6-i->q7-t->q8-a->q9-r->q10-m->q11-e->q12-s->q13-e->q14-r->q15-o->qf\nq1-v->q2-e->q3-r->q4-m->q5-e->q6-s->q7-a->qf\nq1-e->q2-s->q3-t->q4-a->q5-d->q6-o->q7-m->q8-e->q9-s->q10-a->qf\nprint\nq1-p->q2-r->q3-i->q4-n->q5-t->qf\nhoraDelDia\nq1-h->q2-o->q3-r->q4-a->q5-D->q6-e->q7-l->q8-D->q9-i->q10-a->qf\ntipoComida\nq1-t->q2-i->q3-p->q4-o->q5-C->q6-o->q7-m->q8-i->q9-d->q10-a->qf\nnumeroMesa\nq1-n->q2-u->q3-m->q4-e->q5-r->q6-o->q7-M->q8-e->q9-s->q10-a->qf\npedido\nq1-p->q2-e->q3-d->q4-i->q5-d->q6-o->qf\nmain\nq1-m->q2-a->q3-i->q4-n->qf\nprepararmesa\nq1-p->q2-r->q3-e->q4-p->q5-a->q6-r->q7-a->q8-r->q9-m->q10-e->q11-s->q12-a->qf\nnumeroAsientos\nq1-n->q2-u->q3-m->q4-e->q5-r->q6-o->q7-A->q8-s->q9-i->q10-e->q11-n->q12-t->q13-o->q14-s->qf\nestado\nq1-e->q2-s->q3-t->q4-a->q5-d->q6-o->qf\nvegetariano\nq1-v->q2-e->q3-g->q4-e->q5-t->q6-a->q7-r->q8-i->q9-a->q10-n->q11-o->qf\nregular\nq1-r->q2-e->q3-g->q4-u->q5-l->q6-a->q7-r->qf\npesquetariano\nq1-p->q2-e->q3-s->q4-q->q5-u->q6-e->q7-t->q8-a->q9-r->q10-i->q11-a->q12-n->q13-o->qf\ntrue\nq1-t->q2-r->q3-u->q4-e->qf\nfalse\nq1-f->q2-a->q3-l->q4-s->q5-e->qf\nmañana\nq1-m->q2-a->q3-ñ->q4-a->q5-n->q6-a->qf\ntarde\nq1-t->q2-a->q3-r->q4-d->q5-e->qf\nnoche\nq1-n->q2-o->q3-c->q4-h->q5-e->qf");
        jScrollPane4.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Gramatica total", jScrollPane4);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(letrafuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(letrafuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void letrafuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letrafuenteActionPerformed
       int indice = letrafuente.getSelectedIndex();
        int tamFuente=12;
        
          switch(indice){
            case 0:
                tamFuente = 12;
            break;
            case 1:
                tamFuente = 14;
            break;
            case 2:
                tamFuente = 16;
            break;
            case 3:
                tamFuente = 18;
            break;
            case 4:
                tamFuente = 20;
            break;
            case 5:
                tamFuente = 22;
            break;
            case 6:
                tamFuente = 24;
            break;
        }//fin switch
        jtpCode.setFont(new Font(jtpCode.getFont().getName(), Font.PLAIN, tamFuente));
    }//GEN-LAST:event_letrafuenteActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
        
        /*Eliminación de errores*/
        gramatica.delete(new String[]{"ERROR_LEX"},1);
        /*AGRUPACION DE VALORES*/
        gramatica.group("VALOR", "(NUMERO|COLOR)",true);
        gramatica.group("inicio","inicio parentecisA parentecisC CorcheteA", true);
        gramatica.group("inicio", "inicio parentecisC CorcheteA",true,2,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("inicio", "inicio parentecisA CorcheteA",true,2,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("inicio", "inicio parentecisA parentecisC",true,2,"Error Sintactico: Falta { [#,%]");
        gramatica.group("fin","CorcheteC finlinea",true);
        gramatica.group("fin","CorcheteC",true,3,"Error Sintactico: Falta ; [#,%]");
        gramatica.group("funcion_iluminar","iluminarcamino parentecisA numMesa parentecisC finlinea",true);
        gramatica.group("funcion_iluminar","iluminarcamino  numMesa parentecisC finlinea",true,4, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_iluminar","iluminarcamino parentecisA  parentecisC finlinea",true,4, "Error Sintactico: Falta numero Mesa [#,%]");
        gramatica.group("funcion_iluminar","iluminarcamino parentecisA numMesa finlinea",true, 4, "Error Sintactico: Falta el ) [#,%]");
        gramatica.group("funcion_iluminar","iluminarcamino parentecisA numMesa parentecisC",true,4, "Error Sintactico: Falta el ; [#,%]");        
        gramatica.group("funcion_iluminar","iluminarcamino numMesa parentecisC finlinea",true,4,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_iluminar","iluminarcamino parentecisA parentecisC finlinea",true,4,"Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA numMesa coma numasientos parentecisC finlinea ",true);
        gramatica.group("funcion_prepMesa","prepmesa numMesa coma numasientos parentecisC finlinea ",true,5,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA coma numasientos parentecisC finlinea ",true,5,"Error Sintactico: Falta numMesa [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA numMesa numasientos parentecisC finlinea ",true,5,"Error Sintactico: Falta , entre numMesa y numAsientos [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA numMesa coma parentecisC finlinea ",true,5,"Error Sintactico: Falta numasientos despues de la , [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA numMesa coma numasientos finlinea ",true,5,"Error Sintactico: Falta ) despues de numasientos [#,%]");
        gramatica.group("funcion_prepMesa","prepmesa parentecisA numMesa coma numasientos parentecisC",true,5,"Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("funcion_ofertas","verofertas parentecisA hDia coma tipo parentecisC finlinea",true);
        gramatica.group("funcion_ofertas","verofertas hDia coma tipo parentecisC finlinea",true,6,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_ofertas","verofertas parentecisA coma tipo parentecisC finlinea",true,6,"Error Sintactico: Falta horaDelDia [#,%]");
        gramatica.group("funcion_ofertas","verofertas parentecisA hDia tipo parentecisC finlinea",true,6,"Error Sintactico: Falta , [#,%]");
        gramatica.group("funcion_ofertas","verofertas parentecisA hDia coma parentecisC finlinea",true,6,"Error Sintactico: Falta tipoComida [#,%]");
        gramatica.group("funcion_ofertas","verofertas parentecisA hDia coma tcomida finlinea",true,6,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA hDia coma tcomida parentecisC finlinea",true);
        gramatica.group("funcion_menu","vermenu hDia coma tcomida parentecisC finlinea",true,7,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA coma tcomida parentecisC finlinea",true,7,"Error Sintactico: Falta horaDelDia [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA hDia tcomida parentecisC finlinea",true,7,"Error Sintactico: Falta , [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA hDia coma parentecisC finlinea",true,7,"Error Sintactico: Falta tipoComida, [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA hDia coma tcomida finlinea",true,7,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_menu","vermenu parentecisA hDia coma tcomida parentecisC",true,7,"Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("realizar_pedido","vermenu parentecisA hDia coma numMesa coma pedido coma estado parentecisC finlinea", true);
        gramatica.group("solicitar_mesero","solicitarmesero parentecisA numMesa parentecisB finlinea",true);
        gramatica.group("solicitar_mesero","solicitarmesero numMesa parentecisB finlinea",true,9,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("solicitar_mesero","solicitarmesero parentecisA parentecisB finlinea",true,9,"Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("solicitar_mesero","solicitarmesero parentecisA numMesa finlinea",true,9,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("solicitar_mesero","solicitarmesero parentecisA numMesa parentecisB",true,9,"Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa parentecisB finlinea",true);
        gramatica.group("ver_disponibilidad", "vermesa numMesa parentecisB finlinea",true,10,"Error Sintactico: Falta ( [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA parentecisB finlinea",true,10,"Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa finlinea",true,10,"Error Sintactico: Falta ) [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa parentecisB",true,10,"Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("tiempo_pedido","tiempopedido parentecisA numMesa coma pedido coma estado parentecisC finlinea",true);
        
        gramatica.group("variable_A","variable hDia asignacion tiempo finlinea",true);
        gramatica.group("variable_A","variable hDia asignacion tiempo",true,12, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_A","variable hDia asignacion finlinea",true,12, "Error Sintactico: Falta tiempo [#,%]");
        gramatica.group("variable_A","variable asignación tiempo finlinea",true,12, "Error Sintactico: Falta hDia [#,%]");
        gramatica.group("variable_A","hDia asignacion tiempo finlinea",true,12, "Error Sintactico: Falta variable [#,%]");
        
        gramatica.group("variable_E","variable estado asignacion booleano finlinea",true);
        gramatica.group("variable_E","variable estado asignacion booleano",true,13, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_E","variable estado asignacion finlinea",true,13, "Error Sintactico: Falta booleano [#,%]");
        gramatica.group("variable_E","variable estado booleano finlinea",true,13, "Error Sintactico: Falta asignación [#,%]");
        gramatica.group("variable_E","variable asignacion booleano finlinea",true,13, "Error Sintactico: Falta estado [#,%]");
        gramatica.group("variable_E","estado asignacion booleano finlinea",true,13, "Error Sintactico: Falta variable [#,%]");
        
        gramatica.group("variable_B","variable numasientos asignacion numero finlinea",true);
        gramatica.group("variable_B","variable numasientos asignacion numero",true,14, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_B","variable numasientos asignacion finlinea",true,14, "Error Sintactico: Falta numero [#,%]");
        gramatica.group("variable_B","variable numasientos numero finlinea",true,14, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_B","variable asignacion numero finlinea",true,14, "Error Sintactico: Falta numasientos [#,%]");
        gramatica.group("variable_B","numasientos asignacion numero finlinea",true,14, "Error Sintactico: Falta variable [#,%]");
        
        gramatica.group("variable_P","variable pedido asignacion booleano finlinea",true);
        gramatica.group("variable_P","variable pedido asignacion booleano",true,15, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_P","variable pedido asignacion finlinea",true,15, "Error Sintactico: Falta booleano [#,%]");
        gramatica.group("variable_P","variable pedido booleano finlinea",true,15, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_P","variable asignación booleano finlinea",true,15, "Error Sintactico: Falta pedido [#,%]");
        gramatica.group("variable_P","pedido asignacion booleano finlinea",true,15, "Error Sintactico: Falta variable [#,%]");
        
        gramatica.group("variable_M","variable numeroMesa asignacion numero finlinea",true);
        gramatica.group("variable_M","variable numeroMesa asignacion numero",true,16, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_M","variable numeroMesa asignacion finlinea",true,16, "Error Sintactico: Falta numero [#,%]");
        gramatica.group("variable_M","variable numeroMesa numero finlinea",true,16, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_M","variable asignación numero finlinea",true,16, "Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("variable_M","numeroMesa asignacion numero finlinea",true,16, "Error Sintactico: Falta variable [#,%]");
        
        
        gramatica.group("variable_C","variable tcomida asignacion tipo finlinea",true);
        gramatica.group("variable_C","variable tcomida asignacion tipo",true,17, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_C","variable tcomida asignacion finlinea",true,17, "Error Sintactico: Falta tipo [#,%]");
        gramatica.group("variable_C","variable tcomida tipo finlinea",true,17, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_C","variable asignacion tipo finlinea",true,17, "Error Sintactico: Falta tcomida [#,%]");
        gramatica.group("variable_C","tcomida asignacion tipo finlinea",true,17, "Error Sintactico: Falta variable [#,%]");
        
        /* Mostrar gramáticas */

        //Limpiar jtextArea
        if (gramaticaUtilizada.getText().length() > 0) {
            gramaticaUtilizada.setText("");
        }
        
        //Forzar la impresion de txt en el jtextArea
        SalidaPersonalizada prueba = new SalidaPersonalizada(gramaticaUtilizada);
        PrintStream d = new PrintStream(prueba);
        System.setOut(d);
        System.setErr(d);

        //Mostrar gramatica
        gramatica.show();
        
         String cad = gramaticaUtilizada.getText().substring(143, gramaticaUtilizada.getText().length());
        
        gramaticaUtilizada.setText("");
        gramaticaUtilizada.setText(cad);
        
    }

    private void semanticAnalysis() {
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JTextArea gramaticaUtilizada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JComboBox<String> letrafuente;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
