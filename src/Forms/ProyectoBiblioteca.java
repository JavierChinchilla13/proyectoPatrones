package Forms;

import Clases.LibroService;
import Clases.LibroTO;
import Clases.SalidaService;
import Clases.SalidaTO;
import Clases.UsuarioService;
import Clases.UsuariosTO;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ProyectoBiblioteca extends javax.swing.JFrame {
    //LIBROS
    LibroService lib = new LibroService();
    LibroTO selectedLibro = new LibroTO();
    //USUARIOS
    UsuarioService user = new UsuarioService();
    UsuariosTO selectedUsuario = new UsuariosTO();
    //Salida
    SalidaService salida = new SalidaService();
    SalidaTO selectedSalida = new SalidaTO();
    
    
    //Getters y setters
    public LibroService getLib() {
        return lib;
    }

    public void setLib(LibroService lib) {
        this.lib = lib;
    }

    public LibroTO getSelectedLibro() {
        return selectedLibro;
    }

    public void setSelectedLibro(LibroTO selectedLibro) {
        this.selectedLibro = selectedLibro;
    }

    public UsuarioService getUser() {
        return user;
    }

    public void setUser(UsuarioService user) {
        this.user = user;
    }

    public UsuariosTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuariosTO selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public SalidaService getSalida() {
        return salida;
    }

    public void setSalida(SalidaService salida) {
        this.salida = salida;
    }

    public SalidaTO getSelectedSalida() {
        return selectedSalida;
    }

    public void setSelectedSalida(SalidaTO selectedSalida) {
        this.selectedSalida = selectedSalida;
    }
    
    
    
    //Variable global
    public ProyectoBiblioteca() {
        initComponents();
        this.setLocationRelativeTo(this);
        lib.RellenaLaTablaConDatosMySQL("libro", jTable_libros);
        user.leerLectores("usuario", jTable_lectores);
        salida.leerPrestamos(jTable_prestamos);
        salida.leerSalidas("salida", jTable_pres);

        jTable_libros.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    jTxtTitulo.setText(jTable_libros.getValueAt(jTable_libros.getSelectedRow(), 1).toString());
                    jTxtEditorial.setText(jTable_libros.getValueAt(jTable_libros.getSelectedRow(), 2).toString());
                    jTxtAnio.setText(jTable_libros.getValueAt(jTable_libros.getSelectedRow(), 3).toString());
                }
            }
        });

        jTable_lectores.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    jTxtNombre.setText(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 1).toString());
                    jTxtDireccion.setText(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 2).toString());
                    jTxtTelefono.setText(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 3).toString());
                    jTxtCiudad.setText(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 4).toString());
                    jTxtCorreo.setText(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 5).toString());
                }
            }
        });
        
        jTable_pres.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    jTxtUsuario.setText(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 5).toString());
                    jTxtLibro.setText(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 4).toString());
                    jTxtFechaSalida.setText(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 1).toString());
                    jTxtFechaRegreso.setText(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 2).toString());
                    jTxtObservacion.setText(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 3).toString());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTbdFormulas = new javax.swing.JTabbedPane();
        jPnlFormulaGeneral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFrtLiteralB = new javax.swing.JFormattedTextField();
        jFrtLiteralC = new javax.swing.JFormattedTextField();
        jFrtLiteralA = new javax.swing.JFormattedTextField();
        jLblLiteralA = new javax.swing.JLabel();
        jLblLiteralB = new javax.swing.JLabel();
        jLblLiteralC = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        jLblX1 = new javax.swing.JLabel();
        jLblX2 = new javax.swing.JLabel();
        jPnlMiFormula = new javax.swing.JPanel();
        Jbtn_guardar2 = new java.awt.Button();
        jTxtTitulo2 = new java.awt.TextField();
        jTxtNombre2 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_libros = new javax.swing.JTable();
        jPanel_prop = new javax.swing.JPanel();
        jLbl_titulo = new java.awt.Label();
        jLbl_editorial = new java.awt.Label();
        jLbl_anio = new java.awt.Label();
        JlblDatos = new java.awt.Label();
        jTxtTitulo = new javax.swing.JTextField();
        jTxtEditorial = new javax.swing.JTextField();
        jTxtAnio = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_lectores = new javax.swing.JTable();
        jPanelDatosUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jLblTelefono = new javax.swing.JLabel();
        jLblDireccion = new javax.swing.JLabel();
        jLblCiudad = new javax.swing.JLabel();
        jLblCorreo = new javax.swing.JLabel();
        jTxtDireccion = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtCiudad = new javax.swing.JTextField();
        jTxtTelefono = new javax.swing.JTextField();
        jTxtCorreo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_prestamos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_pres = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLblNombre1 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jLblNombre2 = new javax.swing.JLabel();
        jTxtLibro = new javax.swing.JTextField();
        jLblNombre3 = new javax.swing.JLabel();
        jTxtFechaSalida = new javax.swing.JTextField();
        jLblNombre4 = new javax.swing.JLabel();
        jTxtFechaRegreso = new javax.swing.JTextField();
        jLblNombre5 = new javax.swing.JLabel();
        jTxtObservacion = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        jPanel_buttons = new javax.swing.JPanel();
        Jbtn_actualizar = new javax.swing.JButton();
        Jbtn_guardar = new javax.swing.JButton();
        Jbtn_eliminar = new javax.swing.JButton();
        Jbtn_nuevo = new javax.swing.JButton();

        jPnlFormulaGeneral.setBackground(new java.awt.Color(255, 204, 0));
        jPnlFormulaGeneral.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Ingresa la literales y resuelve la fórmula");

        jFrtLiteralB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFrtLiteralB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrtLiteralBActionPerformed(evt);
            }
        });

        jFrtLiteralC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFrtLiteralC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrtLiteralCActionPerformed(evt);
            }
        });

        jFrtLiteralA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFrtLiteralA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrtLiteralAActionPerformed(evt);
            }
        });

        jLblLiteralA.setText("a:");

        jLblLiteralB.setText("b:");

        jLblLiteralC.setText("c:");

        Separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLblX1.setText("X1:");

        jLblX2.setText("x2:");

        javax.swing.GroupLayout jPnlFormulaGeneralLayout = new javax.swing.GroupLayout(jPnlFormulaGeneral);
        jPnlFormulaGeneral.setLayout(jPnlFormulaGeneralLayout);
        jPnlFormulaGeneralLayout.setHorizontalGroup(
            jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblLiteralA)
                            .addComponent(jLblLiteralB)
                            .addComponent(jLblLiteralC))
                        .addGap(27, 27, 27)
                        .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFrtLiteralA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFrtLiteralC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFrtLiteralB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblX1)
                            .addComponent(jLblX2))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPnlFormulaGeneralLayout.setVerticalGroup(
            jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFrtLiteralA, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblLiteralA))
                                .addGap(18, 18, 18)
                                .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFrtLiteralB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblLiteralB))
                                .addGap(18, 18, 18)
                                .addGroup(jPnlFormulaGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFrtLiteralC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblLiteralC)))
                            .addComponent(Separator))
                        .addGap(19, 19, 19))
                    .addGroup(jPnlFormulaGeneralLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLblX1)
                        .addGap(52, 52, 52)
                        .addComponent(jLblX2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTbdFormulas.addTab("Fórmula General", jPnlFormulaGeneral);

        javax.swing.GroupLayout jPnlMiFormulaLayout = new javax.swing.GroupLayout(jPnlMiFormula);
        jPnlMiFormula.setLayout(jPnlMiFormulaLayout);
        jPnlMiFormulaLayout.setHorizontalGroup(
            jPnlMiFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        jPnlMiFormulaLayout.setVerticalGroup(
            jPnlMiFormulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        jTbdFormulas.addTab("Mi Fórmula", jPnlMiFormula);

        Jbtn_guardar2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        Jbtn_guardar2.setLabel("Guardar");

        jTxtTitulo2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTxtNombre2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTable_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_libros);

        jPanel_prop.setBackground(new java.awt.Color(153, 204, 255));

        jLbl_titulo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_titulo.setText("Titulo");

        jLbl_editorial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_editorial.setText("Editorial");

        jLbl_anio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_anio.setText("Año");

        JlblDatos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JlblDatos.setText("Datos para libro");

        jTxtTitulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTxtEditorial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTxtAnio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel_propLayout = new javax.swing.GroupLayout(jPanel_prop);
        jPanel_prop.setLayout(jPanel_propLayout);
        jPanel_propLayout.setHorizontalGroup(
            jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_propLayout.createSequentialGroup()
                        .addComponent(jLbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jTxtTitulo))
                    .addGroup(jPanel_propLayout.createSequentialGroup()
                        .addComponent(JlblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(jPanel_propLayout.createSequentialGroup()
                        .addComponent(jLbl_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEditorial))
                    .addGroup(jPanel_propLayout.createSequentialGroup()
                        .addComponent(jLbl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTxtAnio)))
                .addContainerGap())
        );
        jPanel_propLayout.setVerticalGroup(
            jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_propLayout.createSequentialGroup()
                        .addGroup(jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_propLayout.createSequentialGroup()
                                .addComponent(JlblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLbl_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel_propLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_prop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel_prop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Libros", jPanel2);

        jTable_lectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_lectores);

        jPanelDatosUsuario.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Datos para usuario");

        jLblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre.setText("Nombre");

        jLblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblTelefono.setText("Telefono");

        jLblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblDireccion.setText("Dirección");

        jLblCiudad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblCiudad.setText("Ciudad");

        jLblCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblCorreo.setText("Correo");

        jTxtDireccion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jTxtNombre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jTxtCiudad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jTxtTelefono.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jTxtCorreo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanelDatosUsuarioLayout = new javax.swing.GroupLayout(jPanelDatosUsuario);
        jPanelDatosUsuario.setLayout(jPanelDatosUsuarioLayout);
        jPanelDatosUsuarioLayout.setHorizontalGroup(
            jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtNombre))
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDireccion))
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLblCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCorreo))
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtTelefono))
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 164, Short.MAX_VALUE))
                    .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                        .addComponent(jLblCiudad)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCiudad)))
                .addContainerGap())
        );
        jPanelDatosUsuarioLayout.setVerticalGroup(
            jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDireccion)
                    .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTelefono)
                    .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCiudad)
                    .addComponent(jTxtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCorreo)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Lectores", jPanel3);

        jTable_prestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable_prestamos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Leyendo", jPanel4);

        jTable_pres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable_pres);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Datos para prestamo");

        jLblNombre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre1.setText("IDUsuario");

        jTxtUsuario.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblNombre2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre2.setText("IDLibro");

        jTxtLibro.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblNombre3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre3.setText("Fecha Salida");

        jTxtFechaSalida.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblNombre4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre4.setText("Fecha Regreso");

        jTxtFechaRegreso.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblNombre5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre5.setText("Observacion");

        jTxtObservacion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLblNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLblNombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtLibro))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLblNombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFechaSalida))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLblNombre4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtFechaRegreso))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLblNombre5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtObservacion)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre1)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblNombre2)
                    .addComponent(jTxtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre3)
                    .addComponent(jTxtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre4)
                    .addComponent(jTxtFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre5)
                    .addComponent(jTxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Préstamos", jPanel5);

        label1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Panel de administración");

        jPanel_buttons.setBackground(new java.awt.Color(0, 51, 255));

        Jbtn_actualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jbtn_actualizar.setText("Actualizar");
        Jbtn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_actualizarActionPerformed(evt);
            }
        });

        Jbtn_guardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jbtn_guardar.setText("Guardar");
        Jbtn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_guardarActionPerformed(evt);
            }
        });

        Jbtn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jbtn_eliminar.setText("Eliminar");
        Jbtn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_eliminarActionPerformed(evt);
            }
        });

        Jbtn_nuevo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Jbtn_nuevo.setText("Limpiar campos");
        Jbtn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_buttonsLayout = new javax.swing.GroupLayout(jPanel_buttons);
        jPanel_buttons.setLayout(jPanel_buttonsLayout);
        jPanel_buttonsLayout.setHorizontalGroup(
            jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jbtn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Jbtn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Jbtn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jbtn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_buttonsLayout.setVerticalGroup(
            jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_buttonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jbtn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(Jbtn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jbtn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jbtn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFrtLiteralBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFrtLiteralBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFrtLiteralBActionPerformed

    private void jFrtLiteralCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFrtLiteralCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFrtLiteralCActionPerformed

    private void jFrtLiteralAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFrtLiteralAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFrtLiteralAActionPerformed

    private void Jbtn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_guardarActionPerformed
        // Este es el botón de guardar, al presionarlo ejecutará los siguientes comandos.
        
        
        try {
            
            int indexSelect = jTabbedPane.getSelectedIndex();
            boolean flag = true;
            switch (indexSelect) {
                // Libros
                case 0:
                    // Estos 3 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if (jTxtTitulo.getText() == null || jTxtTitulo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un titulo correcto");
                        flag= false;
                    }
                    if (jTxtEditorial.getText() == null || jTxtEditorial.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar editorial");
                        flag= false;
                    }
                    if ( Integer.parseInt(jTxtAnio.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar año");
                        flag= false;   
                    }
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla libros.
                    if (flag){
                        LibroTO l = new LibroTO(0, jTxtTitulo.getText(), jTxtEditorial.getText(), Integer.parseInt(jTxtAnio.getText()));
                        lib.insert(l);
                        lib.RellenaLaTablaConDatosMySQL("libro", jTable_libros);

                        JOptionPane.showMessageDialog(null, "Se ha guardado el libro exitosamente");
                    }
                       

                    // Usuarios
                case 1:
                    // Estos 5 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtNombre.getText()== null || jTxtNombre.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un nombre correcto");
                        flag= false;
                    }
                    if(jTxtDireccion.getText() == null  || jTxtDireccion.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una dirreccion correcta");
                        flag = false;
                    }
                    
                    if (jTxtCiudad.getText() == null || jTxtCiudad.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una ciudad correctamente");
                        flag = false;
                    }
                    if (jTxtCorreo.getText() == null || jTxtCorreo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un correo correcto");
                        flag = false;
                    }
                    if (Integer.parseInt(jTxtTelefono.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar telefono");
                        flag= false;
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla usuarios.
                    }
                    if (flag) {
                        
                        UsuariosTO usr = new UsuariosTO(0, jTxtNombre.getText(), jTxtDireccion.getText(), Integer.parseInt(jTxtTelefono.getText()), jTxtCiudad.getText(), jTxtCorreo.getText());
                        //jTxtNombre.getText(), jTxtDireccion.getText(), Integer.parseInt(jTxtTelefono.getText()), jTxtCiudad.getText(), jTxtCorreo.getText());

                        user.insert(usr);
                        user.leerLectores("usuario", jTable_lectores);
                        JOptionPane.showMessageDialog(null, "Se ha guardado el usuario exitosamente");
                    }
                    
                    // Salida
                case 3:
                    
                    // Estos 4 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtUsuario.getText()== null || jTxtUsuario.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un usuario correcto");
                        flag= false;
                    }
                    if(jTxtLibro.getText() == null  || jTxtLibro.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un libro existente");
                        flag = false;
                    }
                    
                    if (jTxtFechaSalida.getText() == null || jTxtFechaSalida.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una fecha de manera correcta");
                        flag = false;
                    }
                    
                    
                    
                    if (jTxtObservacion.getText() == null || jTxtObservacion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una observacion");
                        flag = false;
                    }
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla salida.
                    
                    if (flag) {
                        SalidaTO sali = new SalidaTO(0,jTxtFechaSalida.getText(), jTxtFechaRegreso.getText(), jTxtObservacion.getText(),Integer.parseInt(jTxtLibro.getText()) , Integer.parseInt(jTxtUsuario.getText()));
                                               
                        salida.insert(sali);
                        salida.leerSalidas("salida", jTable_pres);
                        salida.leerPrestamos(jTable_prestamos);
                        JOptionPane.showMessageDialog(null, "Se ha guardado el prestamo exitosamente");
                    }
                    
                    
                break;

      
                    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_Jbtn_guardarActionPerformed

    private void Jbtn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_actualizarActionPerformed
        // Este botón permite actualizar la información en la base de datos.
        
        try {
            int indexSelect = jTabbedPane.getSelectedIndex();
            boolean flag = true;
            switch (indexSelect) {
                //Libros
                case 0:
                    // Estos 3 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if (jTxtTitulo.getText() == null || jTxtTitulo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un titulo correcto");
                        flag= false;
                    }
                    if (jTxtEditorial.getText() == null || jTxtEditorial.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar editorial");
                        flag= false;
                    }
                    if ( Integer.parseInt(jTxtAnio.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar año");
                        flag= false;
                        
                    }
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla libros.
                    if (flag){
                        int id = Integer.parseInt(jTable_libros.getValueAt(jTable_libros.getSelectedRow(), 0).toString());

                        lib.update(id, jTxtTitulo.getText(), Integer.parseInt(jTxtAnio.getText()), jTxtEditorial.getText());

                        lib.RellenaLaTablaConDatosMySQL("libro", jTable_libros);

                        JOptionPane.showMessageDialog(null, "Se ha actualizado el libro exitosamente");
                    }

                    
                //Usuarios
                case 1:
                    // Estos 5 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtNombre.getText()== null || jTxtNombre.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un nombre correcto");
                        flag= false;
                    }
                    if(jTxtDireccion.getText() == null  || jTxtDireccion.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una dirreccion correcta");
                        flag = false;
                    }
                    
                    if (jTxtCiudad.getText() == null || jTxtCiudad.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una ciudad correctamente");
                        flag = false;
                    }
                    if (jTxtCorreo.getText() == null || jTxtCorreo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un correo correcto");
                        flag = false;
                    }
                    if ( Integer.parseInt(jTxtTelefono.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar telefono");
                        flag= false;
                        
                    }
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla usuarios.
                    if (flag) {
                        int ide = Integer.parseInt(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 0).toString());

                        user.update(ide, jTxtNombre.getText(), jTxtDireccion.getText(), Integer.parseInt(jTxtTelefono.getText()), jTxtCiudad.getText(), jTxtCorreo.getText());

                        user.leerLectores("usuario", jTable_lectores);
                        JOptionPane.showMessageDialog(null, "Se ha actualizado el usuario exitosamente");
                    }

                //codigo caso de prestamos
                case 3:
                    // Estos 4 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtUsuario.getText()== null || jTxtUsuario.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un usuario correcto");
                        flag= false;
                    }
                    if(jTxtLibro.getText() == null  || jTxtLibro.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un libro existente");
                        flag = false;
                    }
                    
                    if (jTxtFechaSalida.getText() == null || jTxtFechaSalida.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una fecha de manera correcta");
                        flag = false;
                    }
                    if (jTxtObservacion.getText() == null || jTxtObservacion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una observacion");
                        flag = false;
                    }
                    //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla salida.
                    if (flag){
                        
                        int idus = Integer.parseInt(jTxtUsuario.getText());
                        int idlib = Integer.parseInt(jTxtLibro.getText());
                        String fechaSalida = jTxtFechaSalida.getText();
                        String fechaRegreso = jTxtFechaRegreso.getText();
                        
                        int ide = Integer.parseInt(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 0).toString());
                        
                        salida.update(ide,jTxtFechaSalida.getText(), jTxtFechaRegreso.getText(), jTxtObservacion.getText(),Integer.parseInt(jTxtLibro.getText()) , Integer.parseInt(jTxtUsuario.getText()));

                        salida.leerSalidas("salida", jTable_pres);
                        salida.leerPrestamos(jTable_prestamos);
                        JOptionPane.showMessageDialog(null, "Se ha actualizado la inforamcion del prestamo exitosamente");
                    }
                    
                    
                break;
                    
                    
            }
            
            //Este apartado es para luego dejar las textbox en blanco
            jTxtTitulo.setText("");
            jTxtEditorial.setText("");
            jTxtAnio.setText("");
            jTxtNombre.setText("");
            jTxtDireccion.setText("");
            jTxtTelefono.setText("");
            jTxtCiudad.setText("");
            jTxtCorreo.setText("");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_Jbtn_actualizarActionPerformed

    private void Jbtn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_eliminarActionPerformed
        // Este botón permite eliminar de la base de dato, lo digitado en los espacios correspondientes.
        try {
            int indexSelect = jTabbedPane.getSelectedIndex();
            boolean flag = true;
            switch (indexSelect) {
                //Libros
                case 0:
                    // Estos 3 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if (jTxtTitulo.getText() == null || jTxtTitulo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un titulo correcto");
                        flag= false;
                    }
                    if (jTxtEditorial.getText() == null || jTxtEditorial.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar editorial");
                        flag= false;
                    }
                    if ( Integer.parseInt(jTxtAnio.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar año");
                        flag= false;
                        
                    }
                     //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla libros.
                    if (flag){
                        int id = Integer.parseInt(jTable_libros.getValueAt(jTable_libros.getSelectedRow(), 0).toString());

                        lib.delete(id);
                        lib.RellenaLaTablaConDatosMySQL("libro", jTable_libros);

                        JOptionPane.showMessageDialog(null, "Se ha eliminado el libro exitosamente");
                    }

                    
                    
                //Usuarios
                case 1:
                    // Estos 5 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtNombre.getText()== null || jTxtNombre.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un nombre correcto");
                        flag= false;
                    }
                    if(jTxtDireccion.getText() == null  || jTxtDireccion.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una dirreccion correcta");
                        flag = false;
                    }
                    
                    if (jTxtCiudad.getText() == null || jTxtCiudad.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una ciudad correctamente");
                        flag = false;
                    }
                    if (jTxtCorreo.getText() == null || jTxtCorreo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un correo correcto");
                        flag = false;
                    }
                    if ( Integer.parseInt(jTxtTelefono.getText()) == 0){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar telefono");
                        flag= false;
                        
                    } //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla usuarios.
                    
                    if (flag) {

                        int ide = Integer.parseInt(jTable_lectores.getValueAt(jTable_lectores.getSelectedRow(), 0).toString());

                        user.delete(ide);
                        user.leerLectores("usuario", jTable_lectores);

                        JOptionPane.showMessageDialog(null, "Se ha eliminado el usuario exitosamente");
                    }
                    
                    
                //codigo caso de prestamos
                case 3:
                    // Estos 4 primeros if, son condicionales
                    // Como no se debe dejar nada en blanco, esto permite a que
                    // Los espacios no queden en blanco.
                    if(jTxtUsuario.getText()== null || jTxtUsuario.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un usuario correcto");
                        flag= false;
                    }
                    if(jTxtLibro.getText() == null  || jTxtLibro.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Porfavor agregar un libro existente");
                        flag = false;
                    }
                    
                    if (jTxtFechaSalida.getText() == null || jTxtFechaSalida.getText().equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una fecha de manera correcta");
                        flag = false;
                    }
                    
                    if (jTxtObservacion.getText() == null || jTxtObservacion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Porfavor agregar una observacion");
                        flag = false;
                    }
                     //---------------------------------------
                    
                    // Aqui lee la información y lo guarda en la tabla salida.
                    if (flag) {
                        
                        int id = Integer.parseInt(jTable_pres.getValueAt(jTable_pres.getSelectedRow(), 0).toString());
                        
                        salida.delete(id);
                        salida.leerSalidas("salida", jTable_pres);
                        salida.leerPrestamos(jTable_prestamos);
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el prestamo exitosamente");
  
                    }
                    
                    
                break;
                    
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_Jbtn_eliminarActionPerformed

    private void Jbtn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_nuevoActionPerformed
        // TODO add your handling code here:
        jTxtTitulo.setText("");
        jTxtEditorial.setText("");
        jTxtAnio.setText("");
        jTxtNombre.setText("");
        jTxtDireccion.setText("");
        jTxtTelefono.setText("");
        jTxtCiudad.setText("");
        jTxtCorreo.setText("");
        jTxtUsuario.setText("");
        jTxtLibro.setText("");
        jTxtFechaSalida.setText("");
        jTxtFechaRegreso.setText("");
        jTxtObservacion.setText("");
        
    }//GEN-LAST:event_Jbtn_nuevoActionPerformed

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
            java.util.logging.Logger.getLogger(ProyectoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProyectoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProyectoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProyectoBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectoBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbtn_actualizar;
    private javax.swing.JButton Jbtn_eliminar;
    private javax.swing.JButton Jbtn_guardar;
    private java.awt.Button Jbtn_guardar2;
    private javax.swing.JButton Jbtn_nuevo;
    private java.awt.Label JlblDatos;
    private javax.swing.JSeparator Separator;
    private javax.swing.JFormattedTextField jFrtLiteralA;
    private javax.swing.JFormattedTextField jFrtLiteralB;
    private javax.swing.JFormattedTextField jFrtLiteralC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblCiudad;
    private javax.swing.JLabel jLblCorreo;
    private javax.swing.JLabel jLblDireccion;
    private javax.swing.JLabel jLblLiteralA;
    private javax.swing.JLabel jLblLiteralB;
    private javax.swing.JLabel jLblLiteralC;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblNombre1;
    private javax.swing.JLabel jLblNombre2;
    private javax.swing.JLabel jLblNombre3;
    private javax.swing.JLabel jLblNombre4;
    private javax.swing.JLabel jLblNombre5;
    private javax.swing.JLabel jLblTelefono;
    private javax.swing.JLabel jLblX1;
    private javax.swing.JLabel jLblX2;
    private java.awt.Label jLbl_anio;
    private java.awt.Label jLbl_editorial;
    private java.awt.Label jLbl_titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelDatosUsuario;
    private javax.swing.JPanel jPanel_buttons;
    private javax.swing.JPanel jPanel_prop;
    private javax.swing.JPanel jPnlFormulaGeneral;
    private javax.swing.JPanel jPnlMiFormula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_lectores;
    private javax.swing.JTable jTable_libros;
    private javax.swing.JTable jTable_pres;
    private javax.swing.JTable jTable_prestamos;
    private javax.swing.JTabbedPane jTbdFormulas;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxtAnio;
    private javax.swing.JTextField jTxtCiudad;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtEditorial;
    private javax.swing.JTextField jTxtFechaRegreso;
    private javax.swing.JTextField jTxtFechaSalida;
    private javax.swing.JTextField jTxtLibro;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNombre2;
    private javax.swing.JTextField jTxtObservacion;
    private javax.swing.JTextField jTxtTelefono;
    private javax.swing.JTextField jTxtTitulo;
    private java.awt.TextField jTxtTitulo2;
    private javax.swing.JTextField jTxtUsuario;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
