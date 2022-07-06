package Voila;

import DAO.ClasseDAO;
import DAO.EtudiantDAO;
import DAO.MatiereDAO;
import Entités.Classe;
import Entités.Enseignant;
import Entités.Matiere;
import Technique.CRUDE;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Respi extends JFrame {
  
  Classe classe = new Classe();
  
  Matiere matiere = new Matiere();
  
  Enseignant enseignant = new Enseignant();
  
  private JPanel Backx;
  
  private JLabel X;
  
  private JComboBox choixClasse;
  
  private JComboBox choixMatiere;
  
  private JLabel date;
  
  private JButton jButton1;
  
  private JButton jButton2;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JLabel nomEns;
  
  private JLabel prenomEns;
  
  private JLabel s;
  
  public Respi() {
    initComponents();
    this.date.setText((new Date()).toLocaleString());
  }
  
  public Respi(Enseignant e) {
    initComponents();
    this.enseignant = e;
    this.nomEns.setText(e.getNom());
    this.prenomEns.setText(e.getPrenom());
    this.date.setText((new Date()).toLocaleString());
    this.choixClasse.addItem("VEUILLEZ CHOISIR");
    this.choixMatiere.removeAllItems();
    ClasseDAO cdao = new ClasseDAO();
    List<Classe> classes = new ArrayList<>();
    Set<Integer> Idclasse = RechercherClasseId(this.enseignant);
    Idclasse.forEach(i -> classes.add(cdao.RechercherParId(i.intValue())));
    classes.forEach(c -> this.choixClasse.addItem(c.getLibelleClasse()));
  }
  
  public Set<Integer> RechercherClasseId(Enseignant e) {
    String req = "SELECT * FROM  `correspondance`WHERE `idEnseignant` =" + e.getIdEnseignant();
    Set<Integer> list = new HashSet<>();
    ResultSet res = (new CRUDE()).exeRead(req);
    try {
      while (res.next())
        list.add(Integer.valueOf(res.getInt(1))); 
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
      return null;
    } 
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
    this.s = new JLabel();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    this.choixMatiere = new JComboBox();
    this.choixClasse = new JComboBox();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    this.jPanel1.setBackground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.jPanel2.setBackground(new Color(0, 102, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Image/a.png")));
    this.jLabel1.setMaximumSize(new Dimension(1062, 1024));
    this.jLabel1.setMinimumSize(new Dimension(1062, 1024));
    this.jPanel2.add(this.jLabel1);
    this.jLabel1.setBounds(-30, 0, 280, 270);
    this.jLabel3.setIcon(new ImageIcon("Image/holidays-and-absence.png"));
    this.jPanel2.add(this.jLabel3);
    this.jLabel3.setBounds(640, 40, 210, 210);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.jPanel2.add(this.date);
    this.date.setBounds(530, 250, 320, 50);
    this.jLabel5.setBackground(new Color(255, 255, 255));
    this.jLabel5.setFont(new Font("Calibri", 0, 36));
    this.jLabel5.setForeground(new Color(255, 255, 255));
    this.jLabel5.setHorizontalAlignment(0);
    this.jLabel5.setText("Surface Professeur");
    this.jPanel2.add(this.jLabel5);
    this.jLabel5.setBounds(240, 110, 350, 90);
    this.nomEns.setFont(new Font("Calibri", 0, 24));
    this.nomEns.setForeground(new Color(255, 255, 255));
    this.nomEns.setText("getNomResp");
    this.jPanel2.add(this.nomEns);
    this.nomEns.setBounds(30, 260, 170, 40);
    this.prenomEns.setFont(new Font("Calibri", 0, 24));
    this.prenomEns.setForeground(new Color(255, 255, 255));
    this.prenomEns.setText("getPrenomRespo");
    this.jPanel2.add(this.prenomEns);
    this.prenomEns.setBounds(30, 300, 190, 40);
    this.jPanel1.add(this.jPanel2);
    this.jPanel2.setBounds(0, 140, 870, 350);
    this.s.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel1.add(this.s);
    this.s.setBounds(280, 10, 280, 130);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Respi.this.BackxMouseClicked(evt);
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
            Respi.this.XKeyPressed(evt);
          }
        });
    this.Backx.add(this.X);
    this.X.setBounds(0, 0, 30, 36);
    this.jPanel1.add(this.Backx);
    this.Backx.setBounds(840, 0, 30, 36);
    this.jLabel2.setFont(new Font("Calibri", 0, 24));
    this.jLabel2.setText("Classe :");
    this.jPanel1.add(this.jLabel2);
    this.jLabel2.setBounds(100, 530, 150, 50);
    this.jLabel4.setFont(new Font("Calibri", 0, 24));
    this.jLabel4.setText("Matiere :");
    this.jPanel1.add(this.jLabel4);
    this.jLabel4.setBounds(100, 580, 140, 60);
    this.jButton1.setFont(new Font("Calibri", 0, 14));
    this.jButton1.setText("OK");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Respi.this.jButton1ActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.jButton1);
    this.jButton1.setBounds(760, 690, 80, 40);
    this.jButton2.setFont(new Font("Calibri", 0, 14));
    this.jButton2.setText("Retour");
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Respi.this.jButton2ActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.jButton2);
    this.jButton2.setBounds(20, 690, 100, 40);
    this.choixMatiere.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Respi.this.choixMatiereActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.choixMatiere);
    this.choixMatiere.setBounds(250, 590, 170, 40);
    this.choixClasse.setFont(new Font("Calibri", 0, 14));
    this.choixClasse.setModel(new DefaultComboBoxModel<>(new String[] { "1 Année ", "2 Annné ", "BigData/1", "Aeronautique/1","BigData/2", "Aeronautique/2" }));
    this.choixClasse.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Respi.this.choixClasseActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.choixClasse);
    this.choixClasse.setBounds(250, 530, 170, 40);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(this.jPanel1, -2, 870, -2)
          .addGap(0, 0, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(this.jPanel1, -2, 735, -2)
          .addGap(0, 0, 32767)));
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
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    this.matiere = (new MatiereDAO()).RechercherParLibelle(this.choixMatiere.getSelectedItem().toString());
    (new Ens(this.enseignant, this.classe, this.matiere)).setVisible(true);
    setVisible(false);
  }
  
  private void choixClasseActionPerformed(ActionEvent evt) {
    this.choixMatiere.removeAllItems();
    this.choixMatiere.addItem("VEUILLEZ CHOISIR");
    MatiereDAO mdao = new MatiereDAO();
    List<Matiere> matieres = new ArrayList<>();
    this.classe = (new ClasseDAO()).RechercherParLibelle(this.choixClasse.getSelectedItem().toString());
    System.out.println(this.classe);
    Set<Integer> Idmatiere = RechercherMatiereId(this.enseignant, this.classe);
    for (Integer i : Idmatiere)
      matieres.add(mdao.RechercherParId(i.intValue())); 
    for (Matiere m : matieres) {
      this.choixMatiere.addItem(m.getLibelleMatiere());
      System.out.println(m);
    } 
  }
  
  private void choixMatiereActionPerformed(ActionEvent evt) {}
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Respi.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Respi.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Respi.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Respi.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Respi()).setVisible(true);
          }
        });
  }
  
  public Set<Integer> RechercherMatiereId(Enseignant e, Classe c) {
    String req = "SELECT * FROM  `correspondance`WHERE  `idClasse` =" + c.getIdClasse() + " AND  `idEnseignant` =" + e.getIdEnseignant();
    Set<Integer> list = new HashSet<>();
    ResultSet res = (new CRUDE()).exeRead(req);
    try {
      while (res.next())
        list.add(Integer.valueOf(res.getInt(3))); 
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
      return null;
    } 
  }
}
