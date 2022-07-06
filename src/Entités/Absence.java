/*     */ package Entités;
/*     */ 
/*     */ import java.sql.Date;
/*     */ 
/*     */ 
/*     */ public class Absence
/*     */ {
/*     */   private int id;
/*     */   private Etudiant etudiant;
/*     */   private Enseignant enseignant;
/*     */   private Matiere matiere;
/*     */   private Classe classe;
/*     */   private int numseance;
/*     */   private Date date;
/*     */   private boolean periode1;
/*     */   private boolean periode2;
/*     */   private String P1;
/*     */   private String P2;
/*     */   
/*     */   public Absence() {}
/*     */   
/*     */   public Absence(int id, Etudiant etudiant, Enseignant enseignant, Matiere matiere, Classe classe, int numseance, Date date, boolean periode1, boolean periode2) {
/*  23 */     this.id = id;
/*  24 */     this.etudiant = etudiant;
/*  25 */     this.enseignant = enseignant;
/*  26 */     this.matiere = matiere;
/*  27 */     this.classe = classe;
/*  28 */     this.numseance = numseance;
/*  29 */     this.date = date;
/*  30 */     this.periode1 = periode1;
/*  31 */     this.periode2 = periode2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setP1(String P1) {
/*  37 */     this.P1 = P1;
/*     */   }
/*     */   
/*     */   public void setP2(String P2) {
/*  41 */     this.P2 = P2;
/*     */   }
/*     */   
/*     */   public String getP1() {
/*  45 */     return this.P1;
/*     */   }
/*     */   
/*     */   public String getP2() {
/*  49 */     return this.P2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Classe getClasse() {
/*  54 */     return this.classe;
/*     */   }
/*     */   
/*     */   public void setClasse(Classe classe) {
/*  58 */     this.classe = classe;
/*     */   }
/*     */   
/*     */   public Date getDate() {
/*  62 */     return this.date;
/*     */   }
/*     */   
/*     */   public void setDate(Date date) {
/*  66 */     this.date = date;
/*     */   }
/*     */   
/*     */   public Enseignant getEnseignant() {
/*  70 */     return this.enseignant;
/*     */   }
/*     */   
/*     */   public void setEnseignant(Enseignant enseignant) {
/*  74 */     this.enseignant = enseignant;
/*     */   }
/*     */   
/*     */   public Etudiant getEtudiant() {
/*  78 */     return this.etudiant;
/*     */   }
/*     */   
/*     */   public void setEtudiant(Etudiant etudiant) {
/*  82 */     this.etudiant = etudiant;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  86 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  90 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Matiere getMatiere() {
/*  94 */     return this.matiere;
/*     */   }
/*     */   
/*     */   public void setMatiere(Matiere matiere) {
/*  98 */     this.matiere = matiere;
/*     */   }
/*     */   
/*     */   public int getNumseance() {
/* 102 */     return this.numseance;
/*     */   }
/*     */   
/*     */   public void setNumseance(int numseance) {
/* 106 */     this.numseance = numseance;
/*     */   }
/*     */   
/*     */   public boolean isPeriode1() {
/* 110 */     return this.periode1;
/*     */   }
/*     */   
/*     */   public void setPeriode1(boolean periode1) {
/* 114 */     this.periode1 = periode1;
/*     */   }
/*     */   
/*     */   public boolean isPeriode2() {
/* 118 */     return this.periode2;
/*     */   }
/*     */   
/*     */   public void setPeriode2(boolean periode2) {
/* 122 */     this.periode2 = periode2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 127 */     return "Id = " + this.id + " \nEtudiant :\n " + this.etudiant + " \nNumero de Seance = : " + this.numseance + " \nPeriode 1 : " + this.periode1 + " \nPeriode 2 : " + this.periode2 + " \n ";
/*     */   }
/*     */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Entit�s\Absence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */