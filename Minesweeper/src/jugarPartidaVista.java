/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///////


//import JugarPartidaOfficialControler;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class jugarPartidaVista extends javax.swing.JFrame {

        //Paneles
    private JPanel PanelLogin;
    private JPanel PanelNivel;
    private JPanel PanelJugar;
        
    //Elementos Panel Login
        private JButton buttonLogin;
    private JButton loginCancelButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;
    private JTextField usernameText;
    private JTextField passwordText;
    
    //Elementos Panel Nivel
    private JButton nivelCancelButton;
    private JButton nivelJugarButton;
    private JScrollPane nivelScrollPane;
    private JTable tablaNivells;
    private JButton[][] tauler;
    private JLabel titleNivelLabel;
    
    //Comun a todos los paneles
    private JScrollPane errorScrollPane;
    private JTextArea errorTextArea;

    private JugarPartidaOfficialControler joc;
    private Integer ii ;
    private Integer ij;
    private JButton jBaux;
    

    public jugarPartidaVista() {
        joc = new JugarPartidaOfficialControler();
        initComponents();
        this.setPreferredSize(new Dimension(600,675));
        setLocationRelativeTo(null);
        
        pack();
        this.setVisible(true);
        this.setResizable(false);
        PanelLogin.setVisible(true);

        PanelNivel.setVisible(false);
        
        PanelJugar.setVisible(false);

    }

    private void initComponents() {
            PanelLogin = new JPanel();
        PanelNivel = new JPanel();
        nivelScrollPane = new JScrollPane();
        tablaNivells = new JTable();
        nivelCancelButton = new JButton();
        nivelJugarButton = new JButton();
        PanelJugar = new JPanel();
        errorScrollPane = new JScrollPane();
        errorTextArea = new JTextArea();
        titleLabel = new JLabel("              BENVINGUT A BUSCAMINES!");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        usernameText = new JTextField();
        usernameLabel = new JLabel();
        passwordText = new JPasswordField();
        passwordLabel = new JLabel();
        buttonLogin = new JButton();
        loginCancelButton = new JButton();
        titleNivelLabel = new JLabel("SELECCIONI UN NIVELL PER JUGAR UNA PARTIDA :");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        String[][] tb = null;
        tablaNivells.setModel((new DefaultTableModel( tb,
            new String [] {
                "Nom", "numC", "numF", "numM"
            })));
            tablaNivells.setRowHeight(25);
            nivelScrollPane.setViewportView(tablaNivells);
            if (tablaNivells.getColumnModel().getColumnCount() > 0) {
                tablaNivells.getColumnModel().getColumn(0).setResizable(false);
                tablaNivells.getColumnModel().getColumn(0).setPreferredWidth(10);
                tablaNivells.getColumnModel().getColumn(1).setResizable(false);
                tablaNivells.getColumnModel().getColumn(1).setPreferredWidth(10);
                tablaNivells.getColumnModel().getColumn(2).setResizable(false);
                tablaNivells.getColumnModel().getColumn(2).setPreferredWidth(10);
                tablaNivells.getColumnModel().getColumn(3).setResizable(false);
                tablaNivells.getColumnModel().getColumn(3).setPreferredWidth(10);
            }

            nivelCancelButton.setText("Cancelar");
            nivelCancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.exit(0);
                }
            });

            nivelJugarButton.setText("Jugar");
            nivelJugarButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonJugarActionPerformed(evt);
                }
            });

            GroupLayout jPanel2Layout = new GroupLayout(PanelNivel);
            PanelNivel.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    	.addComponent(titleNivelLabel, GroupLayout.PREFERRED_SIZE, 444,  GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(nivelCancelButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(nivelJugarButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(nivelScrollPane, GroupLayout.PREFERRED_SIZE, 444,  GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58))))
                            
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                	.addComponent(titleNivelLabel,GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(89, 89, 89)
                    .addComponent(nivelScrollPane,GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nivelJugarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nivelCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(136, Short.MAX_VALUE))
            );

            getContentPane().add(PanelNivel);
            PanelNivel.setBounds(10, 50, 530, 410);
            nivelScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(PanelJugar);
            PanelJugar.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 564, Short.MAX_VALUE)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 460, Short.MAX_VALUE)
            );

            getContentPane().add(PanelJugar);
            PanelJugar.setBounds(0, 10, 564, 460);

            errorTextArea.setColumns(20);
            errorTextArea.setRows(5);
            errorScrollPane.setViewportView(errorTextArea);

            getContentPane().add(errorScrollPane);
            errorScrollPane.setBounds(20, 540, 540, 96);

            usernameLabel.setText("Username:");

            passwordText.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pwdtextActionPerformed(evt);
                }
            });

            passwordLabel.setText("Password:");

            buttonLogin.setText("Login");
            buttonLogin.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            loginCancelButton.setText("Cancelar");
            loginCancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.exit(0);
                }
            });
            GroupLayout jPanel1Layout = new GroupLayout(PanelLogin);
            PanelLogin.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            	.addComponent(titleLabel)
                                .addComponent(passwordText)
                                .addComponent(usernameText, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(loginCancelButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(buttonLogin, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                    .addGap(134, 134, 134))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                		.addGap(10, 10,10)
                		.addComponent(titleLabel)
                    .addGap(161, 161, 161)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameLabel))
                        
                    .addGap(40, 40, 40)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginCancelButton)
                        .addComponent(buttonLogin))
                    .addContainerGap(137, Short.MAX_VALUE))
            );

            getContentPane().add(PanelLogin);
            PanelLogin.setBounds(0, 0, 476, 437);

            pack();
        }

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //Login
        
        String a = new String();
        a = usernameText.getText();
        String b = new String();
        b =   passwordText.getText();
        ArrayList<Nivell> ar = new ArrayList<Nivell>();
        boolean bt = true;
        if(a == null || b == null) ;
        else {
            try{
                ar = joc.PrLoginObtenirNivells(a,b);
            //login
            }
            catch(Exception e){
                    errorTextArea.setText(e.getMessage());
                bt = false;
            }
            //poner niveles en la tabla, y pasar al otro panel
        }
        //recorrer casellas para actualizar

        
        if(bt){
                errorTextArea.setText(" ");
            PanelLogin.setVisible(false);
            PanelNivel.setVisible(true);
            int siz = ar.size();
            String[][] tb = new String[siz][4];
            for(int de = 0; de < siz; ++ de){
                tb[de][0] = ar.get(de).getNom();
                tb[de][1] = ar.get(de).getNombreCasellesXFila().toString();
                tb[de][2] = ar.get(de).getNombreCasellesXColumna().toString();
                tb[de][3] = ar.get(de).getNombreMines().toString();
            }
         tablaNivells.setModel(new javax.swing.table.DefaultTableModel(tb,
                new String [] {"Nom", "Numc", "Numf", "NumM"}) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });

        }
        
        
    }

    public void posarbomba(ActionEvent e){
            if( e.getSource() instanceof JButton) {
                    Icon one = new ImageIcon("src/recursos/mine.gif");
                    ((JButton)e.getSource()).setIcon(one);
   }
}
    
    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJugarActionPerformed
        int[] seleccionades = tablaNivells.getSelectedRows();
        if (seleccionades.length > 1) errorTextArea.setText("Nomes es pot seleccionar un nivell");
        else {
                boolean capNivell = false;
            int m = tablaNivells.getSelectedRow();
            String s = new String();
            int files = 0;
            int columnes = 0;
            
            if(m == 0){
                files = 8;
                columnes = 8;
                joc.PrJugarCrearPartida("Facil");
            }
            else if(m == 1){
                files = 16;
                columnes = 16;
                joc.PrJugarCrearPartida("Normal");
            }
            else if(m == 2){
                files = 30;
                columnes = 30;
                joc.PrJugarCrearPartida("Dificil");
            }
            else {
                    errorTextArea.setText("No hi ha cap nivell seleccionat.");
                    capNivell = true;
            }
            
            if(!capNivell){
                    PanelNivel.setVisible(false);
            
                    PanelJugar.setVisible(true);
                    PanelJugar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createLoweredBevelBorder()));

                    tauler = new JButton[files][columnes];
                    PanelJugar.setLayout(new GridLayout(files +1 ,columnes + 1));
                    PanelJugar.setSize(new Dimension(600,500));
            
            
                    this.setResizable(false);
                    for(int i=0;i<files;++i){
                            for(int j=0;j<columnes;++j){
                                    tauler[i][j] = new JButton("");
                                    ii = i;
                                    ij = j;
                                    jBaux = tauler[i][j];
                                    tauler[i][j].addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {}
                                    });
                    
 
                                    tauler[i][j].addMouseListener(new MouseListener() {

                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                                            if( e.getSource() instanceof JButton) {                        
                                                int iii = -1;
                                                int jjj = -1;
                                                for (int iu = 0; iu < tauler.length; ++iu){
                                                   for (int ju = 0; ju < tauler.length; ++ju){
                                                       if(tauler[iu][ju] == ((JButton)e.getSource())){
                                                           iii = iu;
                                                           jjj = ju;
                                                           iu = ju = tauler.length;
                                                       }
                                                   } 
                                                }
                                
                                if(((JButton)e.getSource()).getIcon() == null){
                                    try {
                                                                        botonmarcar(iii,jjj);
                                                                } catch (Exception e1) {
                                                                        errorTextArea.setText(e1.getMessage());
                                                                }
                                }
                                else{
                                    try {
                                                                        botondesmarcar(iii,jjj);
                                                                } catch (Exception e1) {
                                                                        errorTextArea.setText(e1.getMessage());
                                                                }  
                                }
                            }
                        }
                        else if(SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1){
                                int iii = -1;
                                int jjj = -1;
                                for (int iu = 0; iu < tauler.length; ++iu){
                                   for (int ju = 0; ju < tauler.length; ++ju){
                                       if(tauler[iu][ju] == ((JButton)e.getSource())){
                                           iii = iu;
                                           jjj = ju;
                                           iu = ju = tauler.length;
                                       }
                                   } 
                                }
                            try {
                                botondescobrir(iii,jjj);
                            } catch (Exception ex) {
                                    errorTextArea.setText(ex.getMessage());
                            }
                            
                        }
                                        
                    }
        
                                @Override
                                public void mouseEntered(MouseEvent arg0) {}
                                public void mouseExited(MouseEvent e) {}
                                public void mousePressed(MouseEvent e) {}
                                public void mouseReleased(MouseEvent e) {}  
                            });
                           PanelJugar.add(tauler[i][j], i*tauler.length +j);    
                            tauler[i][j].setVisible(true);
                        }
                    }
            }
        }
    }

       private void botonmarcar(int x,int y) throws Exception{
               joc.PrMarcarCasella(x,y);
               Casella[][] cas =joc.PrActualitzarTauler();
               for(int i = 0; i < cas.length; ++i){
                       for (int j = 0; j < cas.length; ++j){
                               if(cas[i][j].getEstaDescoberta()){
                                       if(cas[i][j].getTeMina()){
                                               Icon one = new ImageIcon("src/recursos/mine.gif");
                                               tauler[i][j].setIcon(one);
                                       }
                               }
                               else if(cas[i][j].getEstaMarcada()){
                                       System.out.println(i +  " "  + j);
                       Icon one = new ImageIcon("src/recursos/flag.gif");
                       tauler[i][j].setIcon(one);
                               }
                               else if(!cas[i][j].getEstaMarcada()) tauler[i][j].setIcon(null);
                       }
               }

       }
    
       
       private void botondesmarcar(int x, int y) throws Exception{
               joc.PrDesMarcar(x,y);
               Casella[][] cas =joc.PrActualitzarTauler();
               cas = joc.PrActualitzarTauler();
           for(int i = 0; i < cas.length; ++i){
                   for (int j = 0; j < cas.length; ++j){
                           if(cas[i][j].getEstaDescoberta()){
                                   if(cas[i][j].getTeMina()){
                                           Icon one = new ImageIcon("src/recursos/mine.gif");
                                           tauler[i][j].setIcon(one);   
                                   }
                           }
                           else if(cas[i][j].getEstaMarcada()){
                                   Icon one = new ImageIcon("src/recursos/flag.gif");
                                   tauler[i][j].setIcon(one);
                           }
                           else if(!cas[i][j].getEstaMarcada()){
                                   tauler[i][j].setIcon(null);
                           }
               
                   }
           }
   
       }
       
       private void botondescobrir(int x, int y) throws Exception{
               Resultado r;
               r = joc.PrDescobrirCasella(x,y);
               Casella[][] cas =joc.PrActualitzarTauler();
               for(int i = 0; i < cas.length; ++i){
                       for (int j = 0; j < cas.length; ++j){
                               if(cas[i][j].getEstaDescoberta()){
                                       if(cas[i][j].getTeMina()){
                                               Icon one = new ImageIcon("src/recursos/mine.gif");
                                               tauler[i][j].setIcon(one);       
                                       }
                                       else {
                                               int num = cas[i][j].getNumero();
                                               if(num == 0) {            
                                                       tauler[i][j].setBackground(Color.GRAY);
                                                       tauler[i][j].setOpaque(true);
                                                       tauler[i][j].setEnabled(false);}
                                               else if (num ==1){
                                                       Icon one = new ImageIcon("src/recursos/1.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==2){
                                                       Icon one = new ImageIcon("src/recursos/2.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==3){
                                                       Icon one = new ImageIcon("src/recursos/3.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==4){
                                                       Icon one = new ImageIcon("src/recursos/4.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==5){
                                                       Icon one = new ImageIcon("src/recursos/5.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==6){
                                                       Icon one = new ImageIcon("src/recursos/6.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==7){
                                                       Icon one = new ImageIcon("src/recursos/7.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                               else if (num ==8){
                                                       Icon one = new ImageIcon("src/recursos/8.gif");
                                                       tauler[i][j].setIcon(one);
                                               }
                                       }        
                               }
                               else if(cas[i][j].getEstaMarcada()){
                        Icon one = new ImageIcon("src/recursos/flag.gif");
                        tauler[i][j].setIcon(one);
                               }
                               else if(!cas[i][j].getEstaMarcada()){
                                       tauler[i][j].setIcon(null);
                               } 
                      }
               }
               if (r.getEstaAcabada()){
                       if(r.getEstaGuanyada()){
                               int punt = r.getPuntuacio();
                               JOptionPane.showMessageDialog(null,  "Enhorabuena! Puntuacion: " + punt , "Partida finalizada",JOptionPane.INFORMATION_MESSAGE);
                               System.exit(0);
                       }
                       else{   
                               JOptionPane.showMessageDialog(null, "Partida finalizada", "Game over",JOptionPane.INFORMATION_MESSAGE);
                               System.exit(0);
                       }
               }

       }
}
