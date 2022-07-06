/*    */ package Entités;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Matiere
/*    */ {
/*    */   private int idMatiere;
/*    */   private String libelleMatiere;
/*    */   
/*    */   public Matiere(String libelleMatiere) {
/* 18 */     this.libelleMatiere = libelleMatiere;
/*    */   }
/*    */ 
/*    */   
/*    */   public Matiere() {}
/*    */   
/*    */   public void setIdMatiere(int idMatiere) {
/* 25 */     this.idMatiere = idMatiere;
/*    */   }
/*    */   
/*    */   public void setLibelleMatiere(String libelleMatiere) {
/* 29 */     this.libelleMatiere = libelleMatiere;
/*    */   }
/*    */   
/*    */   public int getIdMatiere() {
/* 33 */     return this.idMatiere;
/*    */   }
/*    */   
/*    */   public String getLibelleMatiere() {
/* 37 */     return this.libelleMatiere;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 42 */     return "Matiere :  " + this.libelleMatiere + " \n ";
/*    */   }
/*    */ }


/* Location:              C:\Users\otman\Downloads\Gestion-D-Absences--master\Gestion_Des_Absences.jar!\Entit�s\Matiere.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */