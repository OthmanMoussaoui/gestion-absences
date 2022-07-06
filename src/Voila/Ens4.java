package Voila;

import DAO.AbsenceDAO;
import Entités.Absence;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Ens4 extends JFrame {
 
  
  Classe classe = new Classe();
  
  Etudiant etudiant = new Etudiant();
  
  List<Absence> absences;
  
  Statement stm;
  
  private Enseignant enseignant;
  
  private Matiere matiere;
  
  private JPanel Backx;
  
  private JLabel ClasseChoisie;
  
  private JLabel X;
  
  private JTable absenceEtudiant;
  
  private JLabel date;
  
  private JLabel jLabel12;
  
  private JLabel jLabel13;
  
  private JLabel jLabel4;
  
  private JLabel jLabel6;
  
  private JLabel jLabel8;
  
  private JLabel jLabel9;
  
  private JPanel jPanel1;
  
  private JScrollPane jScrollPane1;
  
  private JLabel matiereChoisie;
  
  private JPanel nomAdm;
  
  private JLabel nomEns;
  
  private JLabel nomEtu;
  
  private JLabel prenomEns;
  
  private JLabel prenomEtu;
  
  private JButton retourALalisteDAbsence;
  
  private JLabel s;
  
  public Ens4() {
    initComponents();
  }
  
  Ens4(Enseignant enseignant, Classe c, Etudiant e, Matiere m) {
    initComponents();
    this.absenceEtudiant.setEnabled(true);
    this.date.setText((new Date()).toLocaleString());
    this.ClasseChoisie.setText(e.getClasse().getLibelleClasse());
    this.etudiant = e;
    this.matiere = m;
    this.nomEns.setText(e.getNom());
    this.prenomEns.setText(e.getPrenom());
    this.nomEtu.setText(e.getNom());
    this.prenomEtu.setText(e.getPrenom());
    this.matiereChoisie.setText(m.getLibelleMatiere());
    this.ClasseChoisie.setText(e.getClasse().getLibelleClasse());
    this.date.setText((new Date()).toLocaleString());
    this.classe = c;
    this.enseignant = enseignant;
    listerAbsences(e);
  }
  
  public void listerAbsences(Etudiant e) {
    this.absences = new ArrayList<>();
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
    this.absences = aDAO.ListerAbsenceEtudiant(e);
    this.absences.stream().map(a -> {
          System.out.println(a.isPeriode1());
          return a;
        }).forEachOrdered(a -> System.out.println(a.isPeriode2()));
    data = new Object[this.absences.size()][6];
    for (Absence a : this.absences) {
      data[indice][0] = a.getDate();
      data[indice][1] = Integer.valueOf(a.getNumseance());
      data[indice][2] = a.getP1().toString();
      data[indice][3] = a.getP2().toString();
      data[indice][4] = a.getMatiere().getLibelleMatiere();
      data[indice][5] = a.getEnseignant().getNom();
      indice++;
    } 
    model = new DefaultTableModel(data, name);
    this.absenceEtudiant.setModel(model);
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.retourALalisteDAbsence = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.absenceEtudiant = new JTable();
    this.nomAdm = new JPanel();
    this.jLabel4 = new JLabel();
    this.date = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel9 = new JLabel();
    this.nomEtu = new JLabel();
    this.jLabel8 = new JLabel();
    this.prenomEtu = new JLabel();
    this.jLabel12 = new JLabel();
    this.jLabel13 = new JLabel();
    this.matiereChoisie = new JLabel();
    this.ClasseChoisie = new JLabel();
    this.nomEns = new JLabel();
    this.prenomEns = new JLabel();
    this.s = new JLabel();
    this.Backx = new JPanel();
    this.X = new JLabel();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    getContentPane().setLayout((LayoutManager)null);
    this.jPanel1.setBackground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.retourALalisteDAbsence.setText("RETOUR");
    this.retourALalisteDAbsence.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens4.this.retourALalisteDAbsenceActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.retourALalisteDAbsence);
    this.retourALalisteDAbsence.setBounds(10, 620, 102, 44);
    this.absenceEtudiant.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }) {
          boolean[] canEdit = new boolean[] { false, false, false, false };
          
          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
          }
        });
    this.absenceEtudiant.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens4.this.absenceEtudiantMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.absenceEtudiant);
    this.jPanel1.add(this.jScrollPane1);
    this.jScrollPane1.setBounds(0, 420, 770, 200);
    this.nomAdm.setBackground(new Color(0, 102, 255));
    this.nomAdm.setLayout((LayoutManager)null);
    this.jLabel4.setIcon(new ImageIcon("C:\\Users\\Mouaad\\Documents\\NetBeansProjects\\Projet Java\\src\\Image\\holidays-and-absence.png"));
    this.nomAdm.add(this.jLabel4);
    this.jLabel4.setBounds(550, 10, 210, 210);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.nomAdm.add(this.date);
    this.date.setBounds(550, 220, 210, 50);
    this.jLabel6.setBackground(new Color(255, 255, 255));
    this.jLabel6.setFont(new Font("Calibri", 0, 36));
    this.jLabel6.setForeground(new Color(255, 255, 255));
    this.jLabel6.setHorizontalAlignment(0);
    this.jLabel6.setText("Fiche D'absence Etudiant");
    this.nomAdm.add(this.jLabel6);
    this.jLabel6.setBounds(160, 70, 400, 80);
    this.jLabel9.setFont(new Font("Calibri", 0, 12));
    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("NOM : ");
    this.nomAdm.add(this.jLabel9);
    this.jLabel9.setBounds(240, 200, 50, 16);
    this.nomEtu.setFont(new Font("Calibri", 0, 12));
    this.nomEtu.setForeground(new Color(255, 255, 255));
    this.nomEtu.setText("nom etudiant");
    this.nomAdm.add(this.nomEtu);
    this.nomEtu.setBounds(290, 200, 80, 16);
    this.jLabel8.setFont(new Font("Calibri", 0, 12));
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("PRENOM :");
    this.nomAdm.add(this.jLabel8);
    this.jLabel8.setBounds(240, 240, 52, 14);
    this.prenomEtu.setFont(new Font("Calibri", 0, 12));
    this.prenomEtu.setForeground(new Color(255, 255, 255));
    this.prenomEtu.setText("prenom Etu");
    this.nomAdm.add(this.prenomEtu);
    this.prenomEtu.setBounds(300, 240, 90, 10);
    this.jLabel12.setFont(new Font("Calibri", 1, 14));
    this.jLabel12.setForeground(new Color(255, 255, 255));
    this.jLabel12.setText("CLASSE  : ");
    this.nomAdm.add(this.jLabel12);
    this.jLabel12.setBounds(10, 230, 80, 17);
    this.jLabel13.setFont(new Font("Calibri", 1, 14));
    this.jLabel13.setForeground(new Color(255, 255, 255));
    this.jLabel13.setText("MATIERE : ");
    this.nomAdm.add(this.jLabel13);
    this.jLabel13.setBounds(10, 250, 80, 17);
    this.matiereChoisie.setFont(new Font("Calibri", 0, 14));
    this.matiereChoisie.setForeground(new Color(255, 255, 255));
    this.matiereChoisie.setText("getNomMatiere");
    this.nomAdm.add(this.matiereChoisie);
    this.matiereChoisie.setBounds(80, 250, 92, 17);
    this.ClasseChoisie.setFont(new Font("Calibri", 0, 14));
    this.ClasseChoisie.setForeground(new Color(255, 255, 255));
    this.ClasseChoisie.setText("getNomClasse");
    this.nomAdm.add(this.ClasseChoisie);
    this.ClasseChoisie.setBounds(80, 230, 90, 17);
    this.nomEns.setFont(new Font("Calibri", 0, 24));
    this.nomEns.setForeground(new Color(255, 255, 255));
    this.nomEns.setText("getNomEns");
    this.nomAdm.add(this.nomEns);
    this.nomEns.setBounds(10, 140, 170, 40);
    this.prenomEns.setFont(new Font("Calibri", 0, 24));
    this.prenomEns.setForeground(new Color(255, 255, 255));
    this.prenomEns.setText("getPrenomEns");
    this.nomAdm.add(this.prenomEns);
    this.prenomEns.setBounds(10, 180, 190, 40);
    this.jPanel1.add(this.nomAdm);
    this.nomAdm.setBounds(0, 130, 770, 290);
    this.s.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel1.add(this.s);
    this.s.setBounds(240, 0, 280, 130);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens4.this.BackxMouseClicked(evt);
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
            Ens4.this.XKeyPressed(evt);
          }
        });
    this.Backx.add(this.X);
    this.X.setBounds(0, 0, 40, 36);
    this.jPanel1.add(this.Backx);
    this.Backx.setBounds(730, 0, 40, 36);
    getContentPane().add(this.jPanel1);
    this.jPanel1.setBounds(0, 0, 770, 680);
    setSize(new Dimension(769, 671));
    setLocationRelativeTo(null);
  }
  
  private void retourALalisteDAbsenceActionPerformed(ActionEvent evt) {
    (new Ens3(this.enseignant, this.classe, this.matiere)).setVisible(true);
    setVisible(false);
  }
  
  private void absenceEtudiantMouseClicked(MouseEvent evt) {}
  
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
      Logger.getLogger(Ens4.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Ens4.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Ens4.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Ens4.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Ens4()).setVisible(true);
          }
        });
  }
}
