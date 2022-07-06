package Voila;

import DAO.AbsenceDAO;
import DAO.EtudiantDAO;
import Entités.Classe;
import Entités.Enseignant;
import Entités.Etudiant;
import Entités.Matiere;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ens extends JFrame {
  Enseignant enseignant = new Enseignant();
  
  Classe classe = new Classe();
  
  Matiere matiere = new Matiere();
  
  Etudiant etu = new Etudiant();
  
  int taille = 0;
  
  List<Etudiant> etudiants = new ArrayList<>();
  
  JPanel entete;
  
  private Checkbox[][] periodes;
  
  private Object[] nom;
  
  private JPanel Backx;
  
  private JLabel ClasseChoisie;
  
  private JLabel X;
  
  private JComboBox choixDeLaSeance;
  
  private JLabel date;
  
  private JLabel jLabel1;
  
  private JLabel jLabel10;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JLabel jLabel9;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JPanel jPanel3;
  
  private JLabel matiereChoisie;
  
  private JLabel nomEns;
  
  private JButton ok;
  
  private JLabel prenomEns;
  
  private JButton retour;
  
  public Ens() {
    this.periodes = new Checkbox[0][];
    this.nom = new Object[] { "Periode 1", "Periode 2" };
    this.date.setText((new Date()).toLocaleString());
    this.choixDeLaSeance.addItem(" ");
    for (int i = 1; i < 15; i++)
      this.choixDeLaSeance.addItem(i + ""); 
  }
  
  Ens(Enseignant e, Classe c, Matiere m) {
    this.periodes = new Checkbox[0][];
    this.nom = new Object[] { "Periode 1", "Periode 2" };
    initComponents();
    setLayout((LayoutManager)null);
    this.date.setText((new Date()).toLocaleString());
    this.nomEns.setText(e.getNom());
    this.prenomEns.setText(e.getPrenom());
    this.ClasseChoisie.setText(c.getLibelleClasse());
    this.matiereChoisie.setText(m.getLibelleMatiere());
    this.enseignant = e;
    this.classe = c;
    this.matiere = m;
    this.choixDeLaSeance.addItem("");
    for (int i = 1; i < 15; i++)
      this.choixDeLaSeance.addItem(i + ""); 
    listerLaClasse(c);
  }
  
  public void listerLaClasse(Classe c) {
    EtudiantDAO eDAO = new EtudiantDAO();
    Object[][] data = new Object[0][];
    String[] name = { "     Nom    ", "Prenom    ", "Periode 1     ", "Periode 2     " };
    int indice = 0;
    this.etudiants = eDAO.ListerEtudiantParClasse(c);
    GridLayout g = new GridLayout(this.etudiants.size() + 1, 4);
    this.jPanel3.setLayout(g);
    for (int i = 0; i < 4; i++)
      this.jPanel3.add(new JLabel(name[i])); 
    Checkbox checkbox = new Checkbox();
    this.taille = this.etudiants.size();
    this.periodes = new Checkbox[this.etudiants.size()][2];
    for (Etudiant e : this.etudiants) {
      this.jPanel3.add(new JLabel(e.getNom()));
      this.jPanel3.add(new JLabel(e.getPrenom()));
      this.periodes[indice][0] = new Checkbox();
      this.periodes[indice][1] = new Checkbox();
      this.jPanel3.add(this.periodes[indice][0]);
      this.jPanel3.add(this.periodes[indice][1]);
      indice++;
    } 
  }
  
  private void initComponents() {
    this.jPanel2 = new JPanel();
    this.jPanel1 = new JPanel();
    this.nomEns = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.prenomEns = new JLabel();
    this.jLabel10 = new JLabel();
    this.jLabel9 = new JLabel();
    this.matiereChoisie = new JLabel();
    this.jLabel8 = new JLabel();
    this.date = new JLabel();
    this.jLabel3 = new JLabel();
    this.choixDeLaSeance = new JComboBox();
    this.jLabel1 = new JLabel();
    this.ClasseChoisie = new JLabel();
    this.retour = new JButton();
    this.jLabel2 = new JLabel();
    this.jPanel3 = new JPanel();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.ok = new JButton();
    setDefaultCloseOperation(3);
    setBackground(new Color(255, 255, 255));
    setUndecorated(true);
    setResizable(false);
    getContentPane().setLayout((LayoutManager)null);
    this.jPanel2.setBackground(new Color(255, 255, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jPanel1.setBackground(new Color(0, 102, 255));
    this.jPanel1.setForeground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.nomEns.setFont(new Font("Calibri", 0, 18));
    this.nomEns.setForeground(new Color(255, 255, 255));
    this.nomEns.setText("getNomEns");
    this.jPanel1.add(this.nomEns);
    this.nomEns.setBounds(120, 10, 127, 20);
    this.jLabel6.setBackground(new Color(255, 255, 255));
    this.jLabel6.setFont(new Font("Calibri", 0, 18));
    this.jLabel6.setForeground(new Color(255, 255, 255));
    this.jLabel6.setText("NOM : ");
    this.jPanel1.add(this.jLabel6);
    this.jLabel6.setBounds(20, 10, 55, 23);
    this.jLabel7.setFont(new Font("Calibri", 0, 18));
    this.jLabel7.setForeground(new Color(255, 255, 255));
    this.jLabel7.setText("PRENOM : ");
    this.jPanel1.add(this.jLabel7);
    this.jLabel7.setBounds(20, 40, 80, 23);
    this.prenomEns.setFont(new Font("Calibri", 0, 18));
    this.prenomEns.setForeground(new Color(255, 255, 255));
    this.prenomEns.setText("getPrenomEns");
    this.jPanel1.add(this.prenomEns);
    this.prenomEns.setBounds(119, 30, 130, 40);
    this.jLabel10.setFont(new Font("Calibri", 0, 14));
    this.jLabel10.setForeground(new Color(255, 255, 255));
    this.jLabel10.setText("CLASSE : ");
    this.jPanel1.add(this.jLabel10);
    this.jLabel10.setBounds(20, 80, 63, 17);
    this.jLabel9.setFont(new Font("Calibri", 0, 14));
    this.jLabel9.setForeground(new Color(255, 255, 255));
    this.jLabel9.setText("MATIERE : ");
    this.jPanel1.add(this.jLabel9);
    this.jLabel9.setBounds(20, 100, 63, 17);
    this.matiereChoisie.setBackground(new Color(255, 255, 255));
    this.matiereChoisie.setFont(new Font("Calibri", 0, 14));
    this.matiereChoisie.setForeground(new Color(255, 255, 255));
    this.matiereChoisie.setText("getNomMatiere");
    this.jPanel1.add(this.matiereChoisie);
    this.matiereChoisie.setBounds(90, 90, 107, 37);
    this.jLabel8.setBackground(new Color(255, 255, 255));
    this.jLabel8.setFont(new Font("Calibri", 0, 18));
    this.jLabel8.setForeground(new Color(255, 255, 255));
    this.jLabel8.setText("DATE : ");
    this.jPanel1.add(this.jLabel8);
    this.jLabel8.setBounds(550, 10, 57, 40);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 18));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setText("getDateSyst");
    this.jPanel1.add(this.date);
    this.date.setBounds(630, 20, 136, 20);
    this.jLabel3.setBackground(new Color(255, 255, 255));
    this.jLabel3.setFont(new Font("Calibri", 0, 24));
    this.jLabel3.setForeground(new Color(255, 255, 255));
    this.jLabel3.setText("                    LISTE DE PRESENCE");
    this.jPanel1.add(this.jLabel3);
    this.jLabel3.setBounds(190, 60, 370, 44);
    this.jPanel1.add(this.choixDeLaSeance);
    this.choixDeLaSeance.setBounds(580, 100, 120, 30);
    this.jLabel1.setFont(new Font("Calibri", 0, 14));
    this.jLabel1.setForeground(new Color(255, 255, 255));
    this.jLabel1.setText("SEANCE NUMERO :");
    this.jPanel1.add(this.jLabel1);
    this.jLabel1.setBounds(590, 60, 120, 30);
    this.ClasseChoisie.setFont(new Font("Calibri", 0, 14));
    this.ClasseChoisie.setForeground(new Color(255, 255, 255));
    this.ClasseChoisie.setText("getNomClasse");
    this.jPanel1.add(this.ClasseChoisie);
    this.ClasseChoisie.setBounds(90, 80, 100, 17);
    this.jPanel2.add(this.jPanel1);
    this.jPanel1.setBounds(0, 130, 810, 160);
    this.retour.setFont(new Font("Calibri", 0, 18));
    this.retour.setText("RETOUR");
    this.retour.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens.this.retourActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.retour);
    this.retour.setBounds(20, 610, 95, 39);
    this.jLabel2.setIcon(new ImageIcon("/Image/Elog.png"));
    this.jPanel2.add(this.jLabel2);
    this.jLabel2.setBounds(230, 0, 340, 120);
    this.jPanel3.setBackground(new Color(255, 255, 255));
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 700, 32767));
    jPanel3Layout.setVerticalGroup(jPanel3Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 290, 32767));
    this.jPanel2.add(this.jPanel3);
    this.jPanel3.setBounds(20, 300, 700, 290);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens.this.BackxMouseClicked(evt);
          }
        });
    this.X.setFont(new Font("Calibri", 0, 18));
    this.X.setForeground(new Color(255, 255, 255));
    this.X.setHorizontalAlignment(0);
    this.X.setText("X");
    this.X.setCursor(new Cursor(12));
    this.X.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            Ens.this.XKeyPressed(evt);
          }
        });
    GroupLayout BackxLayout = new GroupLayout(this.Backx);
    this.Backx.setLayout(BackxLayout);
    BackxLayout.setHorizontalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, BackxLayout.createSequentialGroup()
          .addContainerGap(-1, 32767)
          .addComponent(this.X, -2, 28, -2)
          .addGap(22, 22, 22)));
    BackxLayout.setVerticalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, BackxLayout.createSequentialGroup()
          .addGap(0, 0, 32767)
          .addComponent(this.X, -2, 36, -2)));
    this.jPanel2.add(this.Backx);
    this.Backx.setBounds(750, 0, 60, 36);
    this.ok.setFont(new Font("Calibri", 0, 18));
    this.ok.setText("Ajouter");
    this.ok.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens.this.okActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.ok);
    this.ok.setBounds(700, 610, 100, 40);
    getContentPane().add(this.jPanel2);
    this.jPanel2.setBounds(0, 0, 1110, 660);
    setSize(new Dimension(802, 657));
    setLocationRelativeTo(null);
  }
  
  private void retourActionPerformed(ActionEvent evt) {
    (new RespoProf(this.enseignant)).setVisible(true);
    setVisible(false);
  }
  
  private void okActionPerformed(ActionEvent evt) {
    if (this.choixDeLaSeance.getSelectedItem().toString().equals("")) {
      JOptionPane.showMessageDialog(this, "Veuillez choisir le numde s", "AJOUT ABSENCES", 2);
    } else {
      for (int i = 0; i < this.taille; i++) {
        if ((this.periodes[i][0].getState() | this.periodes[i][1].getState()))
          (new AbsenceDAO()).AjouterAbsence(this.etudiants.get(i), this.enseignant, this.matiere, Integer.parseInt(this.choixDeLaSeance.getSelectedItem().toString()), this.periodes[i][0].getState(), this.periodes[i][1].getState()); 
      } 
      JOptionPane.showMessageDialog(this, "Absences ajoutavec succ", "AJOUT ABSENCES", 1);
      (new Ens(this.enseignant, this.classe, this.matiere)).setVisible(true);
      setVisible(false);
    } 
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
      Logger.getLogger(Ens.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Ens.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Ens.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Ens.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Ens()).setVisible(true);
          }
        });
  }
}
