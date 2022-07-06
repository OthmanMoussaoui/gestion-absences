package Voila;

import DAO.EnseignantDAO;
import DAO.EtudiantDAO;

import Entités.Enseignant;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Main extends JFrame {
  public String st;
  
  private JPanel Backx;
  
  private JPanel Bleu;
  
  private JLabel IDENTIFIANT;
  
  private JTextField LOGIN;
  
  private JLabel STATUT;
  
  private JLabel Taswira;
  
  private JLabel X;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JPasswordField pwd;
  
  private JComboBox<String> statut;
  
  private JButton valideAutentifiant;
  
  public Main() {
    initComponents();
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.STATUT = new JLabel();
    this.Bleu = new JPanel();
    this.Taswira = new JLabel();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.LOGIN = new JTextField();
    this.IDENTIFIANT = new JLabel();
    this.pwd = new JPasswordField();
    JLabel MotsDePasse = new JLabel();
    this.statut = new JComboBox<>();
    this.valideAutentifiant = new JButton();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    this.jPanel2.setBackground(new Color(255, 255, 255));
    this.jPanel2.setForeground(new Color(255, 255, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.STATUT.setFont(new Font("Calibri", 0, 24));
    this.STATUT.setForeground(new Color(153, 153, 153));
    this.STATUT.setHorizontalAlignment(0);
    this.STATUT.setText("STATUT");
    this.jPanel2.add(this.STATUT);
    this.STATUT.setBounds(500, 320, 150, 50);
    this.Bleu.setBackground(new Color(0, 102, 255));
    this.Bleu.setLayout((LayoutManager)null);
    this.Taswira.setIcon(new ImageIcon(getClass().getResource("/Image/i.png")));
    this.Bleu.add(this.Taswira);
    this.Taswira.setBounds(10, -60, 400, 680);
    this.jPanel2.add(this.Bleu);
    this.Bleu.setBounds(-10, -4, 410, 560);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            Main.this.BackxMouseClicked(evt);
          }
        });
    this.X.setFont(new Font("Calibri", 0, 18));
    this.X.setForeground(new Color(255, 255, 255));
    this.X.setHorizontalAlignment(0);
    this.X.setText("X");
    this.X.setCursor(new Cursor(12));
    this.X.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            Main.this.XKeyPressed(evt);
          }
        });
    GroupLayout BackxLayout = new GroupLayout(this.Backx);
    this.Backx.setLayout(BackxLayout);
    BackxLayout.setHorizontalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.X, -1, 42, 32767));
    BackxLayout.setVerticalGroup(BackxLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.X, GroupLayout.Alignment.TRAILING, -1, 36, 32767));
    this.jPanel2.add(this.Backx);
    this.Backx.setBounds(668, 0, 42, 36);
    this.LOGIN.setFont(new Font("Calibri", 0, 12));
    this.LOGIN.setHorizontalAlignment(0);
    this.LOGIN.setText("Login");
    this.LOGIN.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.LOGINActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.LOGIN);
    this.LOGIN.setBounds(510, 160, 130, 30);
    this.IDENTIFIANT.setFont(new Font("Calibri", 0, 24));
    this.IDENTIFIANT.setForeground(new Color(153, 153, 153));
    this.IDENTIFIANT.setHorizontalAlignment(0);
    this.IDENTIFIANT.setText("IDENTIFIANT");
    this.jPanel2.add(this.IDENTIFIANT);
    this.IDENTIFIANT.setBounds(500, 90, 150, 50);
    this.jPanel2.add(this.pwd);
    this.pwd.setBounds(510, 280, 130, 30);
    MotsDePasse.setFont(new Font("Calibri", 0, 24));
    MotsDePasse.setForeground(new Color(153, 153, 153));
    MotsDePasse.setHorizontalAlignment(0);
    MotsDePasse.setText("MOT DE PASSE");
    this.jPanel2.add(MotsDePasse);
    MotsDePasse.setBounds(500, 210, 150, 50);
    this.statut.setModel(new DefaultComboBoxModel<>(new String[] { "ETUDIANT", "ENSEIGNANT" }));
    this.statut.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.statutActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.statut);
    this.statut.setBounds(510, 390, 130, 30);
    this.valideAutentifiant.setFont(new Font("Calibri", 0, 14));
    this.valideAutentifiant.setForeground(new Color(51, 51, 51));
    this.valideAutentifiant.setText("Connecter");
    this.valideAutentifiant.setBorder((Border)null);
    this.valideAutentifiant.setCursor(new Cursor(12));
    this.valideAutentifiant.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.valideAutentifiantActionPerformed(evt);
          }
        });
    this.jPanel2.add(this.valideAutentifiant);
    this.valideAutentifiant.setBounds(530, 440, 90, 40);
    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addComponent(this.jPanel2, -2, 710, -2)
          .addGap(0, 0, 32767)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addComponent(this.jPanel2, -2, 543, -2)
          .addGap(0, 11, 32767)));
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 710, 32767)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 32767)
            .addComponent(this.jPanel1, -2, -1, -2)
            .addGap(0, 0, 32767))));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 554, 32767)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 32767)
            .addComponent(this.jPanel1, -2, -1, -2)
            .addGap(0, 0, 32767))));
    setSize(new Dimension(710, 541));
    setLocationRelativeTo(null);
  }
  
  private void LOGINActionPerformed(ActionEvent evt) {}
  
  private void statutActionPerformed(ActionEvent evt) {}
  
  private void valideAutentifiantActionPerformed(ActionEvent evt) {
    if (this.statut.getSelectedItem().toString().equals("ETUDIANT")) {
      Etudiant etudiant = null;
      etudiant = (new EtudiantDAO()).authentification(this.LOGIN.getText(), this.pwd.getText());
      if (etudiant.getNom().equals("PADNOM")) {
        JOptionPane.showMessageDialog(this, "Identifiant ou mot de passe erron","ECHEC D AUTHENTIFICATION", -1);
      } else {
        InterfaceEtudiant goetu = new InterfaceEtudiant(etudiant);
        goetu.setVisible(true);
        setVisible(false);
      } 
    } else if (this.statut.getSelectedItem().toString().equals("ENSEIGNANT")) {
      Enseignant enseignant = new Enseignant();
      enseignant = (new EnseignantDAO()).authentification(this.LOGIN.getText(), this.pwd.getText());
      if (enseignant.getNom().equals("PADNOM")) {
        JOptionPane.showMessageDialog(this, "Identifiant ou mot de passe erron", "ECHEC D'AUTHENTIFICATION", 2);
      } else {
        RespoProf ifETU = new RespoProf(enseignant);
        ifETU.setVisible(true);
        setVisible(false);
      } 
    }
     else {
      JOptionPane.showMessageDialog(this, "Veuillez sun statut", "ECHEC D'AUTHENTIFICATION", 2);
    } 
  }
  
  private void BackxMouseClicked(MouseEvent evt) {
    System.exit(0);
  }
  
  private void XKeyPressed(KeyEvent evt) {
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
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Main()).setVisible(true);
          }
        });
  }
}
