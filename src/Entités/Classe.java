/*    */ package Entités;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Classe
/*    */ {
/*    */   private int idClasse;
/*    */   private String libelleClasse;
/*    */   private int niveau;
/*    */   private String filiere;
/*    */   
/*    */   public Classe() {}
/*    */   
/*    */   public Classe(int idClasse, String libelleClasse, int niveau, String filiere) {
/* 18 */     this.idClasse = idClasse;
/* 19 */     this.libelleClasse = libelleClasse;
/* 20 */     this.niveau = niveau;
/* 21 */     this.filiere = filiere;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFiliere() {
/* 27 */     return this.filiere;
/*    */   }
/*    */   
/*    */   public void setFiliere(String filiere) {
/* 31 */     this.filiere = filiere;
/*    */   }
/*    */   
/*    */   public int getNiveau() {
/* 35 */     return this.niveau;
/*    */   }
/*    */   
/*    */   public void setNiveau(int niveau) {
/* 39 */     this.niveau = niveau;
/*    */   }
/*    */   
/*    */   public void setIdClasse(int idClasse) {
/* 43 */     this.idClasse = idClasse;
/*    */   }
/*    */   
/*    */   public void setLibelleClasse(String libelleClasse) {
/* 47 */     this.libelleClasse = libelleClasse;
/*    */   }
/*    */   
/*    */   public int getIdClasse() {
/* 51 */     return this.idClasse;
/*    */   }
/*    */   
/*    */   public String getLibelleClasse() {
/* 55 */     return this.libelleClasse;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return "Libelle : " + this.libelleClasse + " \n Niveau = " + this.niveau + "  \n";
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Entit�s\Classe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */