package Voila;

import DAO.AbsenceDAO;
import DAO.EtudiantDAO;
import Entités.Classe;
import Entités.Enseignant;
import Entités.Etudiant;
import Entités.Matiere;
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
import java.awt.print.PrinterException;
import java.text.MessageFormat;
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

public class Ens3 extends JFrame implements ActionListener {
  Enseignant enseignant = new Enseignant();
  
  Classe classe = new Classe();
  
  Matiere matiere = new Matiere();
  
  int taille = 0;
  
  List<Etudiant> etudiants = new ArrayList<>();
  
  JPanel entete;
  
  private JTable AffichageDeLaListeDeLaClasse;
  
  private JPanel Backx;
  
  private JLabel ClasseChoisie;
  
  private JLabel X;
  
  private JLabel date;
  
  private JButton jButton2;
  
  private JLabel jLabel1;
  
  private JLabel jLabel12;
  
  private JLabel jLabel13;
  
  private JLabel jLabel3;
  
  private JLabel jLabel5;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JScrollPane jScrollPane1;
  
  private JLabel matiereChoisie;
  
  private JLabel nomEns;
  
  private JLabel prenomEns;
  
  private JButton print;
  
  private JLabel s;
  
  public Ens3() {
    initComponents();
    this.date.setText((new Date()).toLocaleString());
  }
  
  public Ens3(Enseignant e, Classe c, Matiere m) {
    initComponents();
    this.date.setText((new Date()).toLocaleString());
    this.nomEns.setText(e.getNom());
    this.prenomEns.setText(e.getPrenom());
    this.ClasseChoisie.setText(c.getLibelleClasse());
    this.matiereChoisie.setText(m.getLibelleMatiere());
    this.print.addActionListener(this);
    this.enseignant = e;
    this.classe = c;
    this.matiere = m;
    listerLaClasse(c);
  }
  
  public void listerLaClasse(Classe c) {
    EtudiantDAO eDAO = new EtudiantDAO();
    Object[][] data = new Object[0][];
    Object[] name = { "Nom", "Prenom", "Nombre d'heure" };
    DefaultTableModel model = new DefaultTableModel(data, name) {
        Class[] types = new Class[] { Integer.class, String.class };
        
        public Class getColumnClass(int columnIndex) {
          return this.types[columnIndex];
        }
      };
    int indice = 0;
    this.etudiants = eDAO.ListerEtudiantParClasse(c);
    data = new Object[this.etudiants.size()][3];
    for (Etudiant e : this.etudiants) {
      data[indice][0] = e.getNom();
      data[indice][1] = e.getPrenom();
      data[indice][2] = (new AbsenceDAO()).CompterAbsences(e, this.matiere);
      indice++;
    } 
    model = new DefaultTableModel(data, name);
    this.AffichageDeLaListeDeLaClasse.setModel(model);
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jLabel3 = new JLabel();
    this.date = new JLabel();
    this.jLabel5 = new JLabel();
    this.nomEns = new JLabel();
    this.prenomEns = new JLabel();
    this.ClasseChoisie = new JLabel();
    this.jLabel12 = new JLabel();
    this.jLabel13 = new JLabel();
    this.matiereChoisie = new JLabel();
    this.s = new JLabel();
    this.print = new JButton();
    this.jButton2 = new JButton();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.AffichageDeLaListeDeLaClasse = new JTable();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    this.jPanel1.setBackground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.jPanel2.setBackground(new Color(0, 102, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jLabel1.setIcon(new ImageIcon("/Image/Self-service-icon.png"));
    this.jLabel1.setMaximumSize(new Dimension(1062, 1024));
    this.jLabel1.setMinimumSize(new Dimension(1062, 1024));
    this.jPanel2.add(this.jLabel1);
    this.jLabel1.setBounds(20, 10, 180, 190);
    this.jLabel3.setIcon(new ImageIcon("/Image/holidays-and-absence.png"));
    this.jPanel2.add(this.jLabel3);
    this.jLabel3.setBounds(540, 0, 210, 210);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.jPanel2.add(this.date);
    this.date.setBounds(540, 220, 210, 50);
    this.jLabel5.setBackground(new Color(255, 255, 255));
    this.jLabel5.setFont(new Font("Calibri", 0, 36));
    this.jLabel5.setForeground(new Color(255, 255, 255));
    this.jLabel5.setHorizontalAlignment(0);
    this.jLabel5.setText("LISTE D'ABSENCE");
    this.jPanel2.add(this.jLabel5);
    this.jLabel5.setBounds(260, 130, 260, 90);
    this.nomEns.setFont(new Font("Calibri", 0, 24));
    this.nomEns.setForeground(new Color(255, 255, 255));
    this.nomEns.setText("getNomResp");
    this.jPanel2.add(this.nomEns);
    this.nomEns.setBounds(40, 200, 170, 40);
    this.prenomEns.setFont(new Font("Calibri", 0, 24));
    this.prenomEns.setForeground(new Color(255, 255, 255));
    this.prenomEns.setText("getPrenomRespo");
    this.jPanel2.add(this.prenomEns);
    this.prenomEns.setBounds(40, 240, 190, 40);
    this.ClasseChoisie.setFont(new Font("Calibri", 0, 14));
    this.ClasseChoisie.setForeground(new Color(255, 255, 255));
    this.ClasseChoisie.setText("getNomClasse");
    this.jPanel2.add(this.ClasseChoisie);
    this.ClasseChoisie.setBounds(120, 280, 90, 17);
    this.jLabel12.setFont(new Font("Calibri", 1, 14));
    this.jLabel12.setForeground(new Color(255, 255, 255));
    this.jLabel12.setText("CLASSE  : ");
    this.jPanel2.add(this.jLabel12);
    this.jLabel12.setBounds(50, 280, 80, 17);
    this.jLabel13.setFont(new Font("Calibri", 1, 14));
    this.jLabel13.setForeground(new Color(255, 255, 255));
    this.jLabel13.setText("MATIERE : ");
    this.jPanel2.add(this.jLabel13);
    this.jLabel13.setBounds(50, 300, 80, 17);
    this.matiereChoisie.setFont(new Font("Calibri", 0, 14));
    this.matiereChoisie.setForeground(new Color(255, 255, 255));
    this.matiereChoisie.setText("getNomMatiere");
    this.jPanel2.add(this.matiereChoisie);
    this.matiereChoisie.setBounds(120, 300, 92, 17);
    this.jPanel1.add(this.jPanel2);
    this.jPanel2.setBounds(0, 140, 800, 330);
    this.s.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel1.add(this.s);
    this.s.setBounds(230, 10, 280, 130);
    this.print.setFont(new Font("Calibri", 0, 18));
    this.print.setText("Imprimer");
    this.print.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens3.this.printActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.print);
    this.print.setBounds(630, 720, 140, 40);
    this.jButton2.setFont(new Font("Calibri", 0, 14));
    this.jButton2.setText("Retour");
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens3.this.jButton2ActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.jButton2);
    this.jButton2.setBounds(30, 720, 100, 40);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens3.this.BackxMouseClicked(evt);
          }
        });
    this.Backx.setLayout((LayoutManager)null);
    this.X.setFont(new Font("Calibri", 0, 18));
    this.X.setForeground(new Color(255, 255, 255));
    this.X.setHorizontalAlignment(0);
    this.X.setText("X");
    this.X.setCursor(new Cursor(12));
    this.X.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            Ens3.this.XKeyPressed(evt);
          }
        });
    this.Backx.add(this.X);
    this.X.setBounds(0, 0, 40, 36);
    this.jPanel1.add(this.Backx);
    this.Backx.setBounds(760, 0, 40, 36);
    this.AffichageDeLaListeDeLaClasse.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }) {
          boolean[] canEdit = new boolean[] { false, false, false, false };
          
          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
          }
        });
    this.AffichageDeLaListeDeLaClasse.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens3.this.AffichageDeLaListeDeLaClasseMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.AffichageDeLaListeDeLaClasse);
    this.jPanel1.add(this.jScrollPane1);
    this.jScrollPane1.setBounds(2, 470, 860, 232);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel1, -1, 799, 32767));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel1, -2, 774, -2));
    pack();
    setLocationRelativeTo(null);
  }
  
  private void XKeyPressed(KeyEvent evt) {}
  
  private void BackxMouseClicked(MouseEvent evt) {
    System.exit(0);
  }
  
  private void jButton2ActionPerformed(ActionEvent evt) {
    (new RespoProf(this.enseignant)).setVisible(true);
    setVisible(false);
  }
  
  private void printActionPerformed(ActionEvent evt) {}
  
  private void AffichageDeLaListeDeLaClasseMouseClicked(MouseEvent evt) {
    Etudiant e = this.etudiants.get(this.AffichageDeLaListeDeLaClasse.getSelectedRow());
    Ens4 I = new Ens4(this.enseignant, this.classe, e, this.matiere);
    I.setVisible(true);
    setVisible(false);
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
      Logger.getLogger(Ens3.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Ens3.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Ens3.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Ens3.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Ens3()).setVisible(true);
          }
        });
  }
  
  public void actionPerformed(ActionEvent e) {
    MessageFormat header = new MessageFormat("Page {0,number,integer}");
    try {
      this.AffichageDeLaListeDeLaClasse.print(JTable.PrintMode.FIT_WIDTH, header, (MessageFormat)null);
    } catch (PrinterException c) {
      System.err.format("Cannot print %s%n", new Object[] { c.getMessage() });
    } 
  }
}
