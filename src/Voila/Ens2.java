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

public class Ens2 extends JFrame {
  Enseignant enseignant = new Enseignant();
  
  Classe classe = new Classe();
  
  Matiere matiere = new Matiere();
  
  JPanel entete;
  
  private JPanel Backx4;
  
  private JLabel X4;
  
  private JComboBox choixClasse;
  
  private JComboBox choixMatiere;
  
  private JLabel date;
  
  private JButton jButton1;
  
  private JButton jButton2;
  
  private JLabel jLabel1;
  
  private JLabel jLabel15;
  
  private JLabel jLabel16;
  
  private JLabel jLabel17;
  
  private JLabel jLabel18;
  
  private JLabel jLabel19;
  
  private JPanel jPanel10;
  
  private JPanel jPanel9;
  
  private JLabel nomEns;
  
  private JLabel prenomEns;
  
  private JLabel s4;
  
  public Ens2() {
    initComponents();
    this.date.setText((new Date()).toLocaleString());
  }
  
  public Ens2(Enseignant e) {
    initComponents();
    this.date.setText((new Date()).toLocaleString());
    this.enseignant = e;
    this.nomEns.setText(e.getNom());
    this.prenomEns.setText(e.getPrenom());
    this.choixClasse.addItem("VEUILLEZ CHOISIR");
    this.choixMatiere.removeAllItems();
    ClasseDAO cdao = new ClasseDAO();
    List<Classe> classes = new ArrayList<>();
    Set<Integer> Idclasse = RechercherClasseId(e);
    for (Integer i : Idclasse)
      classes.add(cdao.RechercherParId(i.intValue())); 
    for (Classe c : classes)
      this.choixClasse.addItem(c.getLibelleClasse()); 
  }
  
  Ens2(Enseignant enseignant, Classe classe, Matiere matiere) {
    throw new UnsupportedOperationException("Not supported yet.");
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
    this.jPanel9 = new JPanel();
    this.jPanel10 = new JPanel();
    this.jLabel15 = new JLabel();
    this.jLabel16 = new JLabel();
    this.date = new JLabel();
    this.jLabel17 = new JLabel();
    this.nomEns = new JLabel();
    this.prenomEns = new JLabel();
    this.s4 = new JLabel();
    this.Backx4 = new JPanel();
    this.X4 = new JLabel();
    this.jLabel18 = new JLabel();
    this.jLabel19 = new JLabel();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    this.choixMatiere = new JComboBox();
    this.choixClasse = new JComboBox();
    this.jLabel1 = new JLabel();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    this.jPanel9.setBackground(new Color(255, 255, 255));
    this.jPanel9.setLayout((LayoutManager)null);
    this.jPanel10.setBackground(new Color(0, 102, 255));
    this.jPanel10.setLayout((LayoutManager)null);
    this.jLabel15.setIcon(new ImageIcon("/Image/Self-service-icon.png"));
    this.jLabel15.setMaximumSize(new Dimension(1062, 1024));
    this.jLabel15.setMinimumSize(new Dimension(1062, 1024));
    this.jPanel10.add(this.jLabel15);
    this.jLabel15.setBounds(20, 10, 180, 190);
    this.jLabel16.setIcon(new ImageIcon("Image/holidays-and-absence.png"));
    this.jPanel10.add(this.jLabel16);
    this.jLabel16.setBounds(600, 10, 210, 210);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.jPanel10.add(this.date);
    this.date.setBounds(600, 220, 210, 50);
    this.jLabel17.setBackground(new Color(255, 255, 255));
    this.jLabel17.setFont(new Font("Calibri", 0, 36));
    this.jLabel17.setForeground(new Color(255, 255, 255));
    this.jLabel17.setHorizontalAlignment(0);
    this.jLabel17.setText("  Liste De Presence");
    this.jPanel10.add(this.jLabel17);
    this.jLabel17.setBounds(210, 80, 350, 90);
    this.nomEns.setFont(new Font("Calibri", 0, 24));
    this.nomEns.setForeground(new Color(255, 255, 255));
    this.nomEns.setText("getNomEns");
    this.jPanel10.add(this.nomEns);
    this.nomEns.setBounds(40, 200, 170, 40);
    this.prenomEns.setFont(new Font("Calibri", 0, 24));
    this.prenomEns.setForeground(new Color(255, 255, 255));
    this.prenomEns.setText("getPrenomRespo");
    this.jPanel10.add(this.prenomEns);
    this.prenomEns.setBounds(40, 240, 190, 40);
    this.jPanel9.add(this.jPanel10);
    this.jPanel10.setBounds(0, 140, 840, 290);
    this.s4.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel9.add(this.s4);
    this.s4.setBounds(270, 10, 280, 130);
    this.Backx4.setBackground(new Color(0, 102, 255));
    this.Backx4.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Ens2.this.Backx4MouseClicked(evt);
          }
        });
    this.Backx4.setLayout((LayoutManager)null);
    this.X4.setFont(new Font("Calibri", 0, 18));
    this.X4.setForeground(new Color(255, 255, 255));
    this.X4.setHorizontalAlignment(0);
    this.X4.setText("X");
    this.X4.setCursor(new Cursor(12));
    this.X4.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            Ens2.this.X4KeyPressed(evt);
          }
        });
    this.Backx4.add(this.X4);
    this.X4.setBounds(0, 0, 40, 36);
    this.jPanel9.add(this.Backx4);
    this.Backx4.setBounds(800, 0, 40, 40);
    this.jLabel18.setFont(new Font("Calibri", 0, 24));
    this.jLabel18.setText("Classe :");
    this.jPanel9.add(this.jLabel18);
    this.jLabel18.setBounds(90, 470, 150, 50);
    this.jLabel19.setFont(new Font("Calibri", 0, 24));
    this.jLabel19.setText("Matiere :");
    this.jPanel9.add(this.jLabel19);
    this.jLabel19.setBounds(90, 530, 140, 60);
    this.jButton1.setFont(new Font("Calibri", 0, 14));
    this.jButton1.setText("OK");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens2.this.jButton1ActionPerformed(evt);
          }
        });
    this.jPanel9.add(this.jButton1);
    this.jButton1.setBounds(730, 680, 80, 40);
    this.jButton2.setFont(new Font("Calibri", 0, 14));
    this.jButton2.setText("Retour");
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens2.this.jButton2ActionPerformed(evt);
          }
        });
    this.jPanel9.add(this.jButton2);
    this.jButton2.setBounds(60, 680, 100, 40);
    this.choixMatiere.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens2.this.choixMatiereActionPerformed(evt);
          }
        });
    this.jPanel9.add(this.choixMatiere);
    this.choixMatiere.setBounds(230, 540, 170, 40);
    this.choixClasse.setFont(new Font("Calibri", 0, 14));
    this.choixClasse.setModel(new DefaultComboBoxModel<>(new String[] { "1 Année ", "2 Année ", "BigData/1", "Aeronautique/1","BigData/2", "Aeronautique/2" }));
    this.choixClasse.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Ens2.this.choixClasseActionPerformed(evt);
          }
        });
    this.jPanel9.add(this.choixClasse);
    this.choixClasse.setBounds(230, 480, 170, 40);
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Image/audit.png")));
    this.jPanel9.add(this.jLabel1);
    this.jLabel1.setBounds(450, 400, 600, 360);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(this.jPanel9, -2, 833, -2)
          .addGap(0, 0, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel9, -2, 735, -2));
    pack();
    setLocationRelativeTo(null);
  }
  
  private void X4KeyPressed(KeyEvent evt) {}
  
  private void Backx4MouseClicked(MouseEvent evt) {
    System.exit(0);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    this.matiere = (new MatiereDAO()).RechercherParLibelle(this.choixMatiere.getSelectedItem().toString());
    (new Ens(this.enseignant, this.classe, this.matiere)).setVisible(true);
    setVisible(false);
  }
  
  private void jButton2ActionPerformed(ActionEvent evt) {
    (new RespoProf(this.enseignant)).setVisible(true);
    setVisible(false);
  }
  
  private void choixMatiereActionPerformed(ActionEvent evt) {}
  
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
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Ens2.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Ens2.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Ens2.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Ens2.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Ens2()).setVisible(true);
          }
        });
  }
}
