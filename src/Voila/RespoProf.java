package Voila;

import Entités.Classe;
import Entités.Enseignant;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RespoProf extends JFrame {
  Enseignant enseignant = new Enseignant();
  
  Classe classe = new Classe();
  
  Matiere matiere = new Matiere();
  
  private JPanel Backx;
  
  private JLabel X;
  
  private JLabel date;
  
  private JLabel jLabel1;
  
  private JLabel jLabel3;
  
  private JLabel jLabel5;
  
  private JPanel jPanel1;
  
  private JPanel jPanel2;
  
  private JButton listeDePresence;
  
  private JButton lsiteDAbsence;
  
  private JLabel nomAdm;
  
  private JLabel prenomAdm;
  
  private JLabel s;
  
  public RespoProf() {
    initComponents();
  }
  
  RespoProf(Enseignant enseignant) {
    initComponents();
    this.nomAdm.setText(enseignant.getNom());
    this.prenomAdm.setText(enseignant.getPrenom());
    this.date.setText((new Date()).toLocaleString());
    this.enseignant = enseignant;
  }
  
  private void initComponents() {
    this.jPanel1 = new JPanel();
    this.jPanel2 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jLabel3 = new JLabel();
    this.date = new JLabel();
    this.jLabel5 = new JLabel();
    this.nomAdm = new JLabel();
    this.prenomAdm = new JLabel();
    this.s = new JLabel();
    this.Backx = new JPanel();
    this.X = new JLabel();
    this.listeDePresence = new JButton();
    this.lsiteDAbsence = new JButton();
    setDefaultCloseOperation(3);
    setUndecorated(true);
    setResizable(false);
    this.jPanel1.setBackground(new Color(255, 255, 255));
    this.jPanel1.setLayout((LayoutManager)null);
    this.jPanel2.setBackground(new Color(0, 102, 255));
    this.jPanel2.setLayout((LayoutManager)null);
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Image/image_gallery.png")));
    this.jLabel1.setMaximumSize(new Dimension(1062, 1024));
    this.jLabel1.setMinimumSize(new Dimension(1062, 1024));
    this.jPanel2.add(this.jLabel1);
    this.jLabel1.setBounds(0, 0, 280, 270);
    this.jLabel3.setIcon(new ImageIcon("C:\\Users\\Mouaad\\Documents\\NetBeansProjects\\Projet Java\\src\\Image\\holidays-and-absence.png"));
    this.jPanel2.add(this.jLabel3);
    this.jLabel3.setBounds(660, 10, 210, 210);
    this.date.setBackground(new Color(255, 255, 255));
    this.date.setFont(new Font("Calibri", 0, 24));
    this.date.setForeground(new Color(255, 255, 255));
    this.date.setHorizontalAlignment(0);
    this.date.setText("getDateSyst");
    this.jPanel2.add(this.date);
    this.date.setBounds(640, 220, 210, 50);
    this.jLabel5.setBackground(new Color(255, 255, 255));
    this.jLabel5.setFont(new Font("Calibri", 0, 36));
    this.jLabel5.setForeground(new Color(255, 255, 255));
    this.jLabel5.setHorizontalAlignment(0);
    this.jLabel5.setText("Surface Professeur");
    this.jPanel2.add(this.jLabel5);
    this.jLabel5.setBounds(270, 140, 350, 90);
    this.nomAdm.setFont(new Font("Calibri", 0, 24));
    this.nomAdm.setForeground(new Color(255, 255, 255));
    this.nomAdm.setText("getNomResp");
    this.jPanel2.add(this.nomAdm);
    this.nomAdm.setBounds(60, 260, 170, 40);
    this.prenomAdm.setFont(new Font("Calibri", 0, 24));
    this.prenomAdm.setForeground(new Color(255, 255, 255));
    this.prenomAdm.setText("getPrenomRespo");
    this.jPanel2.add(this.prenomAdm);
    this.prenomAdm.setBounds(60, 300, 190, 40);
    this.jPanel1.add(this.jPanel2);
    this.jPanel2.setBounds(0, 140, 870, 360);
    this.s.setIcon(new ImageIcon(getClass().getResource("/Image/Elog.png")));
    this.jPanel1.add(this.s);
    this.s.setBounds(280, 10, 280, 130);
    this.Backx.setBackground(new Color(0, 102, 255));
    this.Backx.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            RespoProf.this.BackxMouseClicked(evt);
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
            RespoProf.this.XKeyPressed(evt);
          }
        });
    this.Backx.add(this.X);
    this.X.setBounds(0, 0, 30, 36);
    this.jPanel1.add(this.Backx);
    this.Backx.setBounds(840, 0, 30, 36);
    this.listeDePresence.setFont(new Font("Calibri", 0, 18));
    this.listeDePresence.setText("Liste de Presence");
    this.listeDePresence.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            RespoProf.this.listeDePresenceActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.listeDePresence);
    this.listeDePresence.setBounds(330, 550, 220, 50);
    this.lsiteDAbsence.setFont(new Font("Calibri", 0, 18));
    this.lsiteDAbsence.setText("Liste D'Absence");
    this.lsiteDAbsence.setPreferredSize(new Dimension(120, 23));
    this.lsiteDAbsence.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            RespoProf.this.lsiteDAbsenceActionPerformed(evt);
          }
        });
    this.jPanel1.add(this.lsiteDAbsence);
    this.lsiteDAbsence.setBounds(330, 620, 220, 50);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel1, -2, 870, -2));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(this.jPanel1, -2, 710, -2));
    pack();
    setLocationRelativeTo(null);
  }
  
  private void XKeyPressed(KeyEvent evt) {}
  
  private void BackxMouseClicked(MouseEvent evt) {
    System.exit(0);
  }
  
  private void listeDePresenceActionPerformed(ActionEvent evt) {
    (new Respi(this.enseignant)).setVisible(true);
    setVisible(false);
  }
  
  private void lsiteDAbsenceActionPerformed(ActionEvent evt) {
    (new Ens1(this.enseignant)).setVisible(true);
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
      Logger.getLogger(RespoProf.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(RespoProf.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(RespoProf.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(RespoProf.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new RespoProf()).setVisible(true);
          }
        });
  }
}
