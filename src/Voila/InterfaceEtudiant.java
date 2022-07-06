package Voila;

import DAO.AbsenceDAO;
import Entités.Absence;
import Entités.Etudiant;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class InterfaceEtudiant extends JFrame {
  public Etudiant e = null;
  
  private JPanel Backx;
  
  private JLabel ClasseChoisie;
  
  private JLabel X;
  
  private JLabel date;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JPanel jPanel3;
  
  private JScrollPane jScrollPane1;
  
  private JScrollPane jScrollPane2;
  
  private JTable jTable1;
  
  private JLabel nivo;
  
  private JLabel nomDeLEtudiant;
  
  private JLabel prenomEtu;
  
  private JButton retour;
  
  private JTable tble;
  
  public void listerAbsences(Etudiant e) {
    List<Absence> absences = new ArrayList<>();
    AbsenceDAO aDAO = new AbsenceDAO();
    Object[][] data = new Object[0][];
    Object[] name = { "Date D'absence", "Numero de seance", "Periode 1", "Periode 2", "Matiere", "Enseignant" };
    DefaultTableModel model = new DefaultTableModel(data, name) {
        Class[] types = new Class[] { Integer.class, String.class };
        
        public Class getColumnClass(int columnIndex) {
          return this.types[columnIndex];
        }
      };
    int indice = 0;
    absences = aDAO.ListerAbsenceEtudiant(e);
    for (Absence a : absences) {
      System.out.println(a.isPeriode1());
      System.out.println(a.isPeriode2());
    } 
    data = new Object[absences.size()][6];
    for (Absence a : absences) {
      data[indice][0] = a.getDate();
      data[indice][1] = Integer.valueOf(a.getNumseance());
      data[indice][2] = a.getP1().toString();
      data[indice][3] = a.getP2().toString();
      data[indice][4] = a.getMatiere().getLibelleMatiere();
      data[indice][5] = a.getEnseignant().getNom();
      indice++;
    } 
    model = new DefaultTableModel(data, name);
    this.tble.setModel(model);
  }
  
  public InterfaceEtudiant() {
    initComponents();
  }
  
  public InterfaceEtudiant(Etudiant e) {
    initComponents();
    this.e = e;
    this.nomDeLEtudiant.setText(e.getNom());
    this.prenomEtu.setText(e.getPrenom());
    this.nivo.setText(e.getClasse().getLibelleClasse());
    this.nivo.setText(String.valueOf(e.getNiveau()));
    this.date.setText((new Date()).toLocaleString());
    listerAbsences(e);
  }
  
  private void initComponents() {
    this.jScrollPane1 = new JScrollPane();
    this.jTable1 = new JTable();
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.nomDeLEtudiant = new JLabel();
    this.jLabel3 = new JLabel();
    this.prenomEtu = new JLabel();
    this.date = new JLabel();
    this.jLabel5 = new JLabel();
    this.nivo = new JLabel();
    this.ClasseChoisie = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jPanel3 = new JPanel();
    this.retour = new JButton();
    this.jScrollPane2 = new JScrollPane();
    this.tble = new JTable();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.jScrollPane1.setBackground(new Color(0, 102, 255));
    this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null },  { null, null, null, null },  { null, null, null, null },  { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.jScrollPane1.setViewportView(this.jTable1);
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    getContentPane().setLayout((LayoutManager)null);
    this.jPanel1.setBackground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.jPanel2.setBackground(new Color(0, 102, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Image/q.png")));
    this.jLabel1.setMaximumSize(new Dimension(1062, 1024));
    this.jLabel1.setMinimumSize(new Dimension(1062, 1024));
    this.jPanel2.add(this.jLabel1);
    this.jLabel1.setBounds(-100, -40, 460, 610);
    this.nomDeLEtudiant.setBackground(new Color(255, 255, 255));
    this.nomDeLEtudiant.setFont(new Font("Calibri", 0, 24));
    this.nomDeLEtudiant.setForeground(new Color(255, 255, 255));
    this.nomDeLEtudiant.setHorizontalAlignment(0);
    this.nomDeLEtudiant.setText("getNomEtu");
    this.jPanel2.add(this.nomDeLEtudiant);
    this.nomDeLEtudiant.setBounds(380, 300, 170, 40);
    this.jLabel3.setIcon(new ImageIcon("C:\\Users\\Mouaad\\Documents\\NetBeansProjects\\Projet Java\\src\\Image\\holidays-and-absence.png"));
    this.jPanel2.add(this.jLabel3);
    this.jLabel3.setBounds(650, 0, 210, 210);
    this.prenomEtu.setBackground(new Color(255, 255, 255));
    this.prenomEtu.setFont(new Font("Calibri", 0, 24));
    this.prenomEtu.setForeground(new Color(255, 255, 255));
    this.prenomEtu.setHorizontalAlignment(0);
    this.prenomEtu.setText("getPrenomEtu");
    this.jPanel2.add(this.prenomEtu);
    this.prenomEtu.setBounds(390, 340, 170, 40);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.jPanel2.add(this.date);
    this.date.setBounds(600, 210, 280, 40);
    this.jLabel5.setBackground(new Color(255, 255, 255));
    this.jLabel5.setFont(new Font("Calibri", 0, 24));
    this.jLabel5.setForeground(new Color(255, 255, 255));
    this.jLabel5.setHorizontalAlignment(0);
    this.jLabel5.setText("Classe:");
    this.jPanel2.add(this.jLabel5);
    this.jLabel5.setBounds(340, 240, 110, 40);
    this.nivo.setBackground(new Color(255, 255, 255));
    this.nivo.setFont(new Font("Calibri", 0, 24));
    this.nivo.setForeground(new Color(255, 255, 255));
    this.nivo.setHorizontalAlignment(0);
    this.nivo.setText("2");
    this.jPanel2.add(this.nivo);
    this.nivo.setBounds(400, 250, 100, 20);
    this.ClasseChoisie.setBackground(new Color(255, 255, 255));
    this.ClasseChoisie.setFont(new Font("Calibri", 0, 24));
    this.ClasseChoisie.setForeground(new Color(255, 255, 255));
    this.ClasseChoisie.setHorizontalAlignment(0);
    this.ClasseChoisie.setText("B");
    this.jPanel2.add(this.ClasseChoisie);
    this.ClasseChoisie.setBounds(590, 240, 90, 40);
    this.jLabel4.setFont(new Font("Calibri", 0, 24));
    this.jLabel4.setForeground(new Color(255, 255, 255));
    this.jLabel4.setText("AnnGroupe :");
    this.jPanel2.add(this.jLabel4);
    this.jLabel4.setBounds(470, 250, 170, 20);
    this.jPanel1.add(this.jPanel2);
    this.jPanel2.setBounds(0, 130, 890, 400);
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel1.add(this.jLabel2);
    this.jLabel2.setBounds(320, 0, 330, 140);
    this.jPanel3.setBackground(new Color(255, 255, 255));
    this.jPanel3.setLayout((LayoutManager)null);
    this.retour.setFont(new Font("Calibri", 0, 18));
    this.retour.setForeground(new Color(51, 51, 51));
    this.retour.setText("Retour");
    this.retour.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            InterfaceEtudiant.this.retourActionPerformed(evt);
          }
        });
    this.jPanel3.add(this.retour);
    this.retour.setBounds(30, 230, 130, 40);
    this.tble.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null },  { null, null, null, null }, { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    this.jScrollPane2.setViewportView(this.tble);
    this.jPanel3.add(this.jScrollPane2);
    this.jScrollPane2.setBounds(210, 90, 670, 180);
    this.jPanel1.add(this.jPanel3);
    this.jPanel3.setBounds(10, 440, 880, 280);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            InterfaceEtudiant.this.BackxMouseClicked(evt);
          }
        });
    this.X.setFont(new Font("Calibri", 0, 18));
    this.X.setForeground(new Color(255, 255, 255));
    this.X.setHorizontalAlignment(0);
    this.X.setText("X");
    this.X.setCursor(new Cursor(12));
    this.X.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            InterfaceEtudiant.this.XKeyPressed(evt);
          }
        });
    GroupLayout BackxLayout = new GroupLayout(this.Backx);
    this.Backx.setLayout(BackxLayout);
    BackxLayout.setHorizontalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(BackxLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.X, -1, 22, 32767)
          .addContainerGap()));
    BackxLayout.setVerticalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, BackxLayout.createSequentialGroup()
          .addComponent(this.X, -2, 36, -2)
          .addGap(0, 0, 32767)));
    this.jPanel1.add(this.Backx);
    this.Backx.setBounds(850, 0, 42, 36);
    getContentPane().add(this.jPanel1);
    this.jPanel1.setBounds(0, 0, 890, 760);
    setSize(new Dimension(891, 740));
    setLocationRelativeTo(null);
  }
  
  private void retourActionPerformed(ActionEvent evt) {
    Main l = new Main();
    setVisible(false);
    l.setVisible(true);
  }
  
  private void XKeyPressed(KeyEvent evt) {}
  
  private void BackxMouseClicked(MouseEvent evt) {
    System.exit(0);
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(InterfaceEtudiant.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(InterfaceEtudiant.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(InterfaceEtudiant.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(InterfaceEtudiant.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new InterfaceEtudiant()).setVisible(true);
          }
        });
  }
}
