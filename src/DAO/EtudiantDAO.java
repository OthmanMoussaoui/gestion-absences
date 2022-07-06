/*     */ package DAO;
/*     */ 
/*     */ import Entités.Classe;
/*     */ import Entités.Etudiant;
/*     */ import Technique.CRUDE;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EtudiantDAO
/*     */ {
/*  24 */   CRUDE crude = new CRUDE();
/*     */ 
/*     */   
/*     */   public Etudiant authentification(String login, String pwd) {
/*  28 */     String req = "SELECT * FROM etudiant WHERE login='" + login + "' AND pwd='" + pwd + "'";
/*     */     
/*  30 */     Etudiant e = new Etudiant();
/*  31 */     ResultSet res = this.crude.exeRead(req);
/*  32 */     ClasseDAO cdao = new ClasseDAO();
/*     */     try {
/*  34 */       while (res.next()) {
/*  35 */         e.setIdEtudiant(res.getInt(1));
/*  36 */         e.setNom(res.getString(2));
/*  37 */         e.setPrenom(res.getString(3));
/*  38 */         e.setClasse(cdao.RechercherParId(res.getInt(4)));
/*  39 */         e.setNiveau(res.getInt(7));
/*     */       } 
/*     */ 
/*     */       
/*  43 */       return e;
/*  44 */     } catch (SQLException ex) {
/*     */       
/*  46 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  47 */       return null;
/*     */     } 
/*     */   }
/*     */   public Etudiant RechercherParId(int i) {
/*  51 */     String req = "SELECT * FROM etudiant WHERE idEtudiant=" + i;
/*  52 */     Etudiant etudiant = new Etudiant();
/*  53 */     ResultSet res = this.crude.exeRead(req);
/*  54 */     ClasseDAO cDAO = new ClasseDAO();
/*     */     try {
/*  56 */       while (res.next()) {
/*  57 */         etudiant.setIdEtudiant(i);
/*  58 */         etudiant.setNom(res.getString(2));
/*  59 */         etudiant.setPrenom(res.getString(3));
/*  60 */         etudiant.setClasse(cDAO.RechercherParId(res.getInt(4)));
/*     */       } 
/*  62 */       return etudiant;
/*  63 */     } catch (SQLException ex) {
/*  64 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  65 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Etudiant> ListerEtudiantParClasse(Classe c) {
/*  72 */     String req = "SELECT * FROM etudiant WHERE idClasse=" + c.getIdClasse();
/*  73 */     List<Etudiant> list = new ArrayList<>();
/*  74 */     ResultSet res = this.crude.exeRead(req);
/*  75 */     ClasseDAO cDAO = new ClasseDAO();
/*     */     try {
/*  77 */       while (res.next()) {
/*  78 */         Etudiant etudiant = new Etudiant();
/*  79 */         etudiant.setIdEtudiant(res.getInt(1));
/*  80 */         etudiant.setNom(res.getString(2));
/*  81 */         etudiant.setPrenom(res.getString(3));
/*  82 */         etudiant.setClasse(cDAO.RechercherParId(res.getInt(4)));
/*  83 */         list.add(etudiant);
/*     */       } 
/*  85 */       return list;
/*  86 */     } catch (SQLException ex) {
/*  87 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  88 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void ajouterEtudiant(String nom, String prenom, int id, String login, String pwd) {
/*  93 */     String req = "INSERT INTO etudiant(nom, prenom, idClasse, login, pwd) VALUES ('" + nom + "','" + prenom + "'," + id + ",'" + login + "','" + pwd + "')";
/*     */     
/*  95 */     this.crude.exeCreate(req);
/*     */   }
/*     */   
/*     */   public int CompterToutsLesEtudiants() {
/*  99 */     int nombreAbsence = 0;
/* 100 */     String requete = "SELECT COUNT( * ) FROM  etudiant";
/* 101 */     ResultSet rs = this.crude.exeRead(requete);
/*     */     try {
/* 103 */       while (rs.next()) {
/* 104 */         nombreAbsence += rs.getInt(1);
/*     */       }
/* 106 */     } catch (SQLException ex) {
/* 107 */       Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 109 */     return nombreAbsence;
/*     */   }
/*     */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\DAO\EtudiantDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */