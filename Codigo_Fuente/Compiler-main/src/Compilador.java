
import ClasesSecundarias.UndoAction;
import ClasesSecundarias.RedoAction;
import ClasesSecundarias.SalidaPersonalizada;
import VentanasSecundarias.*;
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
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.undo.UndoManager;

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

    UndoManager manager;
    Action undoAction;
    Action redoAction;

    VentanaAutomata ventAutomata = new VentanaAutomata(this, true);
    AcercaDe acercaDe = new AcercaDe(this, true);
    ComponentesLexicos componentesLexicos = new ComponentesLexicos();

    AnalisisSintactico analisisSintactico;

    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Restaurante Automata";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, txtSource, title, ".comp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(txtSource);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, txtSource, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{
            "iluminarcamino", "declararmenu", "verofertas", "vermenu", "realizarpedido",
            "solicitarmesero", "vermesa", "estadomesa", "tiempopedido", "for", "while", "if", "var",
            "print", "horaDelDia", "tipoComida", "numeroMesa", "pedido", "main", "prepararmesa",
            "numeroAsientos", "estado", "vegetariano", "regular", "pesqueteriano", "true", "false",
            "mañana", "tarde", "noche"}, txtSource, () -> {
            timerKeyReleased.restart();
        });

        manager = new UndoManager();
        txtSource.getDocument().addUndoableEditListener(manager);
        undoAction = new UndoAction(manager);
        redoAction = new RedoAction(manager);

        txtSource.registerKeyboardAction(undoAction, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);
        txtSource.registerKeyboardAction(redoAction, KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSource = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutputConsole = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        gramaticaUtilizada = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        gramaticaTotal = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        letrafuente = new javax.swing.JComboBox<>();
        btnConstruir = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        txtSource.setName(""); // NOI18N
        jScrollPane1.setViewportView(txtSource);

        txtOutputConsole.setEditable(false);
        txtOutputConsole.setColumns(20);
        txtOutputConsole.setLineWrap(true);
        txtOutputConsole.setRows(5);
        jScrollPane2.setViewportView(txtOutputConsole);

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

        gramaticaUtilizada.setEditable(false);
        gramaticaUtilizada.setColumns(20);
        gramaticaUtilizada.setRows(5);
        jScrollPane5.setViewportView(gramaticaUtilizada);

        jTabbedPane1.addTab("Gramatica utilizada", jScrollPane5);

        gramaticaTotal.setEditable(false);
        gramaticaTotal.setColumns(20);
        gramaticaTotal.setRows(5);
        gramaticaTotal.setText("var\nq1-v->q2-a->q3-r->qf\nif\nq1-i->q2-f->qf\nwhile\nq1-w->q2-h->q3-i->q4-l->q5-e->qf\nfor\nq1-f->q2-o->q3-r->qf\ntiempopedido\nq1-t->q2-i->q3-e->q4-m->q5-p->q6-o->q7-p->q8-e->q9-d->q10-i->q11-d->q12-o->qf\niluminarcamino\nq1-i->q2-l->q3-u->q4-m->q5-i->q6-n->q7-a->q8-r->q9-c->q10-a->q11-m->q12-i->q13-n->q14-o->qf\nq1-d->q2-e->q3-c->q4-l->q5-a->q6-r->q7-a->q8-r->q9-m->q10-e->q11-n->q12-u->qf\nq1-v->q2-e->q3-r->q4-o->q5-f->q6-e->q7-r->q8-t->q9-a->q10-s->qf\nq1-v->q2-e->q3-r->q4-m->q5-e->q6-n->q7-u->qf\nq1-r->q2-e->q3-a->q4-l->q5-i->q6-z->q7-a->q8-r->q9-p->q10-e->q11-d->q12-i->q13-d->q14-o->qf\nq1-s->q2-o->q3-l->q4-i->q5-c->q6-i->q7-t->q8-a->q9-r->q10-m->q11-e->q12-s->q13-e->q14-r->q15-o->qf\nq1-v->q2-e->q3-r->q4-m->q5-e->q6-s->q7-a->qf\nq1-e->q2-s->q3-t->q4-a->q5-d->q6-o->q7-m->q8-e->q9-s->q10-a->qf\nprint\nq1-p->q2-r->q3-i->q4-n->q5-t->qf\nhoraDelDia\nq1-h->q2-o->q3-r->q4-a->q5-D->q6-e->q7-l->q8-D->q9-i->q10-a->qf\ntipoComida\nq1-t->q2-i->q3-p->q4-o->q5-C->q6-o->q7-m->q8-i->q9-d->q10-a->qf\nnumeroMesa\nq1-n->q2-u->q3-m->q4-e->q5-r->q6-o->q7-M->q8-e->q9-s->q10-a->qf\npedido\nq1-p->q2-e->q3-d->q4-i->q5-d->q6-o->qf\nmain\nq1-m->q2-a->q3-i->q4-n->qf\nprepararmesa\nq1-p->q2-r->q3-e->q4-p->q5-a->q6-r->q7-a->q8-r->q9-m->q10-e->q11-s->q12-a->qf\nnumeroAsientos\nq1-n->q2-u->q3-m->q4-e->q5-r->q6-o->q7-A->q8-s->q9-i->q10-e->q11-n->q12-t->q13-o->q14-s->qf\nestado\nq1-e->q2-s->q3-t->q4-a->q5-d->q6-o->qf\nvegetariano\nq1-v->q2-e->q3-g->q4-e->q5-t->q6-a->q7-r->q8-i->q9-a->q10-n->q11-o->qf\nregular\nq1-r->q2-e->q3-g->q4-u->q5-l->q6-a->q7-r->qf\npesquetariano\nq1-p->q2-e->q3-s->q4-q->q5-u->q6-e->q7-t->q8-a->q9-r->q10-i->q11-a->q12-n->q13-o->qf\ntrue\nq1-t->q2-r->q3-u->q4-e->qf\nfalse\nq1-f->q2-a->q3-l->q4-s->q5-e->qf\nmañana\nq1-m->q2-a->q3-ñ->q4-a->q5-n->q6-a->qf\ntarde\nq1-t->q2-a->q3-r->q4-d->q5-e->qf\nnoche\nq1-n->q2-o->q3-c->q4-h->q5-e->qf");
        jScrollPane4.setViewportView(gramaticaTotal);

        jTabbedPane1.addTab("Gramatica total", jScrollPane4);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGrandeNuevo.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGrandeAbrir.png"))); // NOI18N
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGrandeGuardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGrandeGuardarComo.png"))); // NOI18N
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardarC);

        letrafuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "14", "16", "18", "20", "22", "24" }));
        letrafuente.setMaximumSize(new java.awt.Dimension(50, 30));
        letrafuente.setMinimumSize(new java.awt.Dimension(50, 30));
        letrafuente.setName(""); // NOI18N
        letrafuente.setPreferredSize(new java.awt.Dimension(50, 30));
        letrafuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letrafuenteActionPerformed(evt);
            }
        });
        jToolBar1.add(letrafuente);

        btnConstruir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgConstruir.png"))); // NOI18N
        btnConstruir.setMaximumSize(new java.awt.Dimension(37, 37));
        btnConstruir.setMinimumSize(new java.awt.Dimension(37, 37));
        btnConstruir.setPreferredSize(new java.awt.Dimension(37, 37));
        btnConstruir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstruirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConstruir);

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGrandeCompilar.png"))); // NOI18N
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCompilar);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(426, 426, 426))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(rootPanel);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgNuevo.png"))); // NOI18N
        jMenuItem1.setText("Nuevo archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAbrir.png"))); // NOI18N
        jMenuItem2.setText("Abrir archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGuardar.png"))); // NOI18N
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgGuardarComo.png"))); // NOI18N
        jMenuItem4.setText("Guardar como");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        barraMenu.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgDeshazer.png"))); // NOI18N
        jMenuItem6.setText("Deshazer");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImgRehacer.png"))); // NOI18N
        jMenuItem7.setText("Rehacer");
        jMenu2.add(jMenuItem7);
        jMenu2.add(jSeparator3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCortar.png"))); // NOI18N
        jMenuItem8.setText("Cortar");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCopiar.png"))); // NOI18N
        jMenuItem9.setText("Copiar");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgPegar.png"))); // NOI18N
        jMenuItem10.setText("Pegar");
        jMenu2.add(jMenuItem10);

        barraMenu.add(jMenu2);

        jMenu5.setText("Run");

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCompilar.png"))); // NOI18N
        jMenuItem19.setText("Compilar");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgConstruir.png"))); // NOI18N
        jMenuItem20.setText("Construir");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        barraMenu.add(jMenu5);

        jMenu3.setText("Opciones");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setText("Componentes lexicos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem12.setText("Gramatica actual");
        jMenu3.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem13.setText("Gramatica total");
        jMenu3.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem14.setText("Automata");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenu6.setText("Cambiar tamaño de la fuente");

        jMenuItem21.setText("12");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuItem22.setText("14");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);

        jMenuItem23.setText("16");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        jMenuItem24.setText("18");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem24);

        jMenuItem25.setText("20");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem25);

        jMenuItem26.setText("22");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem26);

        jMenuItem27.setText("24");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem27);

        jMenu3.add(jMenu6);

        barraMenu.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgAyuda.png"))); // NOI18N
        jMenuItem15.setText("Documentación online y soporte");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgReportarError.png"))); // NOI18N
        jMenuItem16.setText("Reportar un error");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuItem17.setText("Acerca de");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        barraMenu.add(jMenu4);

        setJMenuBar(barraMenu);

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

    private void btnConstruirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConstruirActionPerformed
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
    }//GEN-LAST:event_btnConstruirActionPerformed

    private void letrafuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letrafuenteActionPerformed
        int indice = letrafuente.getSelectedIndex();
        cambiarTamFuente(indice);
    }//GEN-LAST:event_letrafuenteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://sites.google.com/ittepic.edu.mx/restaurante-automata/p%C3%A1gina-principal"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
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
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        cambiarTamFuente(3);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        cambiarTamFuente(0);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        cambiarTamFuente(1);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        cambiarTamFuente(2);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        cambiarTamFuente(4);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        cambiarTamFuente(5);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        cambiarTamFuente(6);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        //Automata
        ventAutomata.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://forms.gle/TgFzdoDa4Rg2NT3z9"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        acercaDe.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        componentesLexicos.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        //printConsole();
        codeHasBeenCompiled = true;
    }

    public void setGramaticaUtilizada(String gramaticausada) {
        gramaticaUtilizada.setText(gramaticausada+"/n");
    }
    

    private void cambiarTamFuente(int indice) {

        int tamFuente = 12;

        switch (indice) {
            case 0:
                tamFuente = 12;
                letrafuente.setSelectedIndex(0);
                break;
            case 1:
                tamFuente = 14;
                letrafuente.setSelectedIndex(1);
                break;
            case 2:
                tamFuente = 16;
                letrafuente.setSelectedIndex(2);
                break;
            case 3:
                tamFuente = 18;
                letrafuente.setSelectedIndex(3);
                break;
            case 4:
                tamFuente = 20;
                letrafuente.setSelectedIndex(4);
                break;
            case 5:
                tamFuente = 22;
                letrafuente.setSelectedIndex(5);
                break;
            case 6:
                tamFuente = 24;
                letrafuente.setSelectedIndex(6);
                break;
        }//fin switch
        txtSource.setFont(new Font(txtSource.getFont().getName(), Font.PLAIN, tamFuente));
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = txtSource.getText().getBytes();
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
        //Grammar gramatica = new Grammar(tokens, errors);
        analisisSintactico = new AnalisisSintactico(tokens, ventAutomata, this);

        analisisSintactico.realizarAnalisisSintactico();

        /*
        //Eliminación de errores
        gramatica.delete(new String[]{"ERROR_LEX"}, 1);
        //AGRUPACION DE VALORES
        
        gramatica.group("VALOR", "(NUMERO|COLOR)", true);
        gramatica.group("inicio", "inicio parentecisA parentecisC CorcheteA", true);
        gramatica.group("inicio", "inicio parentecisC CorcheteA", true, 2, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("inicio", "inicio parentecisA CorcheteA", true, 2, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("inicio", "inicio parentecisA parentecisC", true, 2, "Error Sintactico: Falta { [#,%]");
        gramatica.group("fin", "CorcheteC finlinea", true);
        gramatica.group("fin", "CorcheteC", true, 3, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino parentecisA numMesa parentecisC finlinea", true);
        gramatica.group("funcion_iluminar", "iluminarcamino  numMesa parentecisC finlinea", true, 4, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino parentecisA  parentecisC finlinea", true, 4, "Error Sintactico: Falta numero Mesa [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino parentecisA numMesa finlinea", true, 4, "Error Sintactico: Falta el ) [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino parentecisA numMesa parentecisC", true, 4, "Error Sintactico: Falta el ; [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino numMesa parentecisC finlinea", true, 4, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_iluminar", "iluminarcamino parentecisA parentecisC finlinea", true, 4, "Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA numMesa coma numasientos parentecisC finlinea ", true);
        gramatica.group("funcion_prepMesa", "prepmesa numMesa coma numasientos parentecisC finlinea ", true, 5, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA coma numasientos parentecisC finlinea ", true, 5, "Error Sintactico: Falta numMesa [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA numMesa numasientos parentecisC finlinea ", true, 5, "Error Sintactico: Falta , entre numMesa y numAsientos [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA numMesa coma parentecisC finlinea ", true, 5, "Error Sintactico: Falta numasientos despues de la , [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA numMesa coma numasientos finlinea ", true, 5, "Error Sintactico: Falta ) despues de numasientos [#,%]");
        gramatica.group("funcion_prepMesa", "prepmesa parentecisA numMesa coma numasientos parentecisC", true, 5, "Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("funcion_ofertas", "verofertas parentecisA hDia coma tipo parentecisC finlinea", true);
        gramatica.group("funcion_ofertas", "verofertas hDia coma tipo parentecisC finlinea", true, 6, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_ofertas", "verofertas parentecisA coma tipo parentecisC finlinea", true, 6, "Error Sintactico: Falta horaDelDia [#,%]");
        gramatica.group("funcion_ofertas", "verofertas parentecisA hDia tipo parentecisC finlinea", true, 6, "Error Sintactico: Falta , [#,%]");
        gramatica.group("funcion_ofertas", "verofertas parentecisA hDia coma parentecisC finlinea", true, 6, "Error Sintactico: Falta tipoComida [#,%]");
        gramatica.group("funcion_ofertas", "verofertas parentecisA hDia coma tcomida finlinea", true, 6, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA hDia coma tcomida parentecisC finlinea", true);
        gramatica.group("funcion_menu", "vermenu hDia coma tcomida parentecisC finlinea", true, 7, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA coma tcomida parentecisC finlinea", true, 7, "Error Sintactico: Falta horaDelDia [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA hDia tcomida parentecisC finlinea", true, 7, "Error Sintactico: Falta , [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA hDia coma parentecisC finlinea", true, 7, "Error Sintactico: Falta tipoComida, [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA hDia coma tcomida finlinea", true, 7, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("funcion_menu", "vermenu parentecisA hDia coma tcomida parentecisC", true, 7, "Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("realizar_pedido", "vermenu parentecisA hDia coma numMesa coma pedido coma estado parentecisC finlinea", true);
        gramatica.group("solicitar_mesero", "solicitarmesero parentecisA numMesa parentecisB finlinea", true);
        gramatica.group("solicitar_mesero", "solicitarmesero numMesa parentecisB finlinea", true, 9, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("solicitar_mesero", "solicitarmesero parentecisA parentecisB finlinea", true, 9, "Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("solicitar_mesero", "solicitarmesero parentecisA numMesa finlinea", true, 9, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("solicitar_mesero", "solicitarmesero parentecisA numMesa parentecisB", true, 9, "Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa parentecisB finlinea", true);
        gramatica.group("ver_disponibilidad", "vermesa numMesa parentecisB finlinea", true, 10, "Error Sintactico: Falta ( [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA parentecisB finlinea", true, 10, "Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa finlinea", true, 10, "Error Sintactico: Falta ) [#,%]");
        gramatica.group("ver_disponibilidad", "vermesa parentecisA numMesa parentecisB", true, 10, "Error Sintactico: Falta ; para el fin de linea [#,%]");
        gramatica.group("tiempo_pedido", "tiempopedido parentecisA numMesa coma pedido coma estado parentecisC finlinea", true);

        gramatica.group("variable_A", "variable hDia asignacion tiempo finlinea", true);
        gramatica.group("variable_A", "variable hDia asignacion tiempo", true, 12, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_A", "variable hDia asignacion finlinea", true, 12, "Error Sintactico: Falta tiempo [#,%]");
        gramatica.group("variable_A", "variable asignación tiempo finlinea", true, 12, "Error Sintactico: Falta hDia [#,%]");
        gramatica.group("variable_A", "hDia asignacion tiempo finlinea", true, 12, "Error Sintactico: Falta variable [#,%]");

        gramatica.group("variable_E", "variable estado asignacion booleano finlinea", true);
        gramatica.group("variable_E", "variable estado asignacion booleano", true, 13, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_E", "variable estado asignacion finlinea", true, 13, "Error Sintactico: Falta booleano [#,%]");
        gramatica.group("variable_E", "variable estado booleano finlinea", true, 13, "Error Sintactico: Falta asignación [#,%]");
        gramatica.group("variable_E", "variable asignacion booleano finlinea", true, 13, "Error Sintactico: Falta estado [#,%]");
        gramatica.group("variable_E", "estado asignacion booleano finlinea", true, 13, "Error Sintactico: Falta variable [#,%]");

        gramatica.group("variable_B", "variable numasientos asignacion numero finlinea", true);
        gramatica.group("variable_B", "variable numasientos asignacion numero", true, 14, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_B", "variable numasientos asignacion finlinea", true, 14, "Error Sintactico: Falta numero [#,%]");
        gramatica.group("variable_B", "variable numasientos numero finlinea", true, 14, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_B", "variable asignacion numero finlinea", true, 14, "Error Sintactico: Falta numasientos [#,%]");
        gramatica.group("variable_B", "numasientos asignacion numero finlinea", true, 14, "Error Sintactico: Falta variable [#,%]");

        gramatica.group("variable_P", "variable pedido asignacion booleano finlinea", true);
        gramatica.group("variable_P", "variable pedido asignacion booleano", true, 15, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_P", "variable pedido asignacion finlinea", true, 15, "Error Sintactico: Falta booleano [#,%]");
        gramatica.group("variable_P", "variable pedido booleano finlinea", true, 15, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_P", "variable asignación booleano finlinea", true, 15, "Error Sintactico: Falta pedido [#,%]");
        gramatica.group("variable_P", "pedido asignacion booleano finlinea", true, 15, "Error Sintactico: Falta variable [#,%]");

        gramatica.group("variable_M", "variable numeroMesa asignacion numero finlinea", true);
        gramatica.group("variable_M", "variable numeroMesa asignacion numero", true, 16, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_M", "variable numeroMesa asignacion finlinea", true, 16, "Error Sintactico: Falta numero [#,%]");
        gramatica.group("variable_M", "variable numeroMesa numero finlinea", true, 16, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_M", "variable asignación numero finlinea", true, 16, "Error Sintactico: Falta numeroMesa [#,%]");
        gramatica.group("variable_M", "numeroMesa asignacion numero finlinea", true, 16, "Error Sintactico: Falta variable [#,%]");

        gramatica.group("variable_C", "variable tcomida asignacion tipo finlinea", true);
        gramatica.group("variable_C", "variable tcomida asignacion tipo", true, 17, "Error Sintactico: Falta ; [#,%]");
        gramatica.group("variable_C", "variable tcomida asignacion finlinea", true, 17, "Error Sintactico: Falta tipo [#,%]");
        gramatica.group("variable_C", "variable tcomida tipo finlinea", true, 17, "Error Sintactico: Falta asignacion [#,%]");
        gramatica.group("variable_C", "variable asignacion tipo finlinea", true, 17, "Error Sintactico: Falta tcomida [#,%]");
        gramatica.group("variable_C", "tcomida asignacion tipo finlinea", true, 17, "Error Sintactico: Falta variable [#,%]");
         */
        //Mostrar gramáticas
        //Limpiar jtextArea
        //if (gramaticaUtilizada.getText().length() > 0) {
        //    gramaticaUtilizada.setText("");
        //}
        /*
        //Forzar la impresion de txt en el jtextArea
        SalidaPersonalizada prueba = new SalidaPersonalizada(gramaticaUtilizada);
        PrintStream d = new PrintStream(prueba);
        System.setOut(d);
        System.setErr(d);
         */
 /*
        //Mostrar gramatica
        gramatica.show();

        String cad = gramaticaUtilizada.getText().substring(143, gramaticaUtilizada.getText().length());

        gramaticaUtilizada.setText("");
        gramaticaUtilizada.setText(cad);
         */
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
            byte[] bytesText = txtSource.getText().getBytes();
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
        Functions.colorTextPane(textsColor, txtSource, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
            Functions.addRowDataInTable(componentesLexicos.getTablaTokens(), data);
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
            txtOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            txtOutputConsole.setText("Compilación terminada...");
        }
        txtOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        Functions.clearDataInTable(componentesLexicos.getTablaTokens());
        txtOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
        if (gramaticaUtilizada.getText().length() > 0) {
            gramaticaUtilizada.setText("");
        }
    }

    public String getTxtOutputConsole() {
        return txtOutputConsole.getText();
    }

    public void setTxtOutputConsole(String txt) {
        this.txtOutputConsole.setText(txt);
    }

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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnConstruir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextArea gramaticaTotal;
    public javax.swing.JTextArea gramaticaUtilizada;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> letrafuente;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    public javax.swing.JTextArea txtOutputConsole;
    private javax.swing.JTextPane txtSource;
    // End of variables declaration//GEN-END:variables
}
