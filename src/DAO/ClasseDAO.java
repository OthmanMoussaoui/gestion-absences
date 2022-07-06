/*     */ package DAO;
/*     */ 
/*     */ import Entités.Classe;
/*     */ import Technique.CRUDE;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class ClasseDAO
/*     */ {
/*  25 */   CRUDE crude = new CRUDE();
/*     */   
/*     */   public Classe RechercherParId(int i) {
/*  28 */     String req = "SELECT * FROM classe WHERE idClasse=" + i;
/*  29 */     Classe c = new Classe();
/*  30 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/*  32 */       while (res.next()) {
/*  33 */         c.setIdClasse(res.getInt(1));
/*  34 */         c.setLibelleClasse(res.getString(2));
/*  35 */         c.setNiveau(res.getInt(3));
/*  36 */         c.setFiliere(res.getString(4));
/*     */       } 
/*  38 */       return c;
/*  39 */     } catch (SQLException ex) {
/*  40 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  41 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Classe RechercherParLibelle(String libelle) {
/*  46 */     String req = "SELECT * FROM classe WHERE libelle='" + libelle + "'";
/*  47 */     Classe c = new Classe();
/*  48 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/*  50 */       while (res.next()) {
/*  51 */         c.setIdClasse(res.getInt(1));
/*  52 */         c.setLibelleClasse(res.getString(2));
/*  53 */         c.setNiveau(res.getInt(3));
/*  54 */         c.setFiliere(res.getString(4));
/*     */       } 
/*  56 */       return c;
/*  57 */     } catch (SQLException ex) {
/*  58 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  59 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Classe> RechercherParNiveau(int i) {
/*  64 */     String req = "SELECT * FROM classe WHERE niveau=" + i;
/*  65 */     List<Classe> list = new ArrayList<>();
/*  66 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/*  68 */       while (res.next()) {
/*  69 */         Classe c = new Classe();
/*  70 */         c.setIdClasse(res.getInt(1));
/*  71 */         c.setLibelleClasse(res.getString(2));
/*  72 */         c.setNiveau(res.getInt(3));
/*  73 */         c.setFiliere(res.getString(4));
/*  74 */         list.add(c);
/*     */       } 
/*  76 */       return list;
/*  77 */     } catch (SQLException ex) {
/*  78 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  79 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Classe> RechercherParFiliere(String filiere) {
/*  84 */     String req = "SELECT * FROM classe WHERE filiere='" + filiere + "'";
/*  85 */     List<Classe> list = new ArrayList<>();
/*  86 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/*  88 */       while (res.next()) {
/*  89 */         Classe c = new Classe();
/*  90 */         c.setIdClasse(res.getInt(1));
/*  91 */         c.setLibelleClasse(res.getString(2));
/*  92 */         c.setNiveau(res.getInt(3));
/*  93 */         c.setFiliere(res.getString(4));
/*  94 */         list.add(c);
/*     */       } 
/*  96 */       return list;
/*  97 */     } catch (SQLException ex) {
/*  98 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  99 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int CompterClasse() {
/* 104 */     int nombreAbsence = 0;
/* 105 */     String requete = "SELECT COUNT( * ) FROM  `classe`";
/* 106 */     ResultSet rs = this.crude.exeRead(requete);
/* 107 */     int nombreClasse = 0;
/*     */     try {
/* 109 */       while (rs.next()) {
/* 110 */         nombreClasse += rs.getInt(1);
/*     */       }
/* 112 */     } catch (SQLException ex) {
/* 113 */       Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 115 */     return nombreClasse;
/*     */   }
/*     */   
/*     */   public List<Classe> ListerClasse() {
/* 119 */     String req = "SELECT * FROM classe";
/* 120 */     List<Classe> list = new ArrayList<>();
/* 121 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/* 123 */       while (res.next()) {
/* 124 */         Classe c = new Classe();
/* 125 */         c.setIdClasse(res.getInt(1));
/* 126 */         c.setLibelleClasse(res.getString(2));
/* 127 */         c.setNiveau(res.getInt(3));
/* 128 */         c.setFiliere(res.getString(4));
/* 129 */         list.add(c);
/*     */       } 
/* 131 */       return list;
/* 132 */     } catch (SQLException ex) {
/* 133 */       Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 134 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set<String> recupererfiliereNiveau(int niveau) {
/* 139 */     String req = "SELECT * FROM classe WHERE niveau=" + niveau;
/* 140 */     Set<String> filiere = new HashSet<>();
/* 141 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/* 143 */       while (res.next()) {
/* 144 */         filiere.add(res.getString("filiere"));
/*     */       }
/* 146 */     } catch (SQLException ex) {
/* 147 */       Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 149 */     return filiere;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Classe> recupererClasseFiliereNiveau(int niveau, String filiere) {
/* 154 */     String req = "SELECT * FROM classe WHERE filiere = '" + filiere + "' AND niveau=" + niveau;
/* 155 */     List<Classe> list = new ArrayList<>();
/* 156 */     ResultSet res = this.crude.exeRead(req);
/*     */     try {
/* 158 */       while (res.next()) {
/* 159 */         Classe classe = new Classe();
/* 160 */         classe.setIdClasse(res.getInt(1));
/* 161 */         classe.setLibelleClasse(res.getString(2));
/* 162 */         classe.setNiveau(res.getInt(3));
/* 163 */         classe.setFiliere(res.getString(4));
/* 164 */         list.add(classe);
/*     */       } 
/* 166 */     } catch (SQLException ex) {
/* 167 */       Logger.getLogger(AbsenceDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/* 169 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\DAO\ClasseDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */