package Parking;
          import java.awt.Toolkit;
          public class log extends javax.swing.JFrame {
          public log() {
          this.setUndecorated(true);
          this.setAlwaysOnTop(true);
          this.setResizable(false);
          initComponents();
          Toolkit tk=Toolkit.getDefaultToolkit();
          int x=(int)tk.getScreenSize().getWidth();
          int y=(int)tk.getScreenSize().getHeight();
          this.setSize(x, y);
             }
          private void adminActionPerformed(java.awt.event.ActionEvent evt) {                                      
          dispose();
          loginadm l=new loginadm();
          l.setVisible(true);
             }                                     
          private void employeeActionPerformed(java.awt.event.ActionEvent evt) {                                        
          dispose();
          login l=new login();
 l.setVisible(true);
    }                                        
 private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
dispose();
    }                                        
  private void windowadapter(java.awt.event.WindowEvent evt) {                               
    }                              
  public static void main(String args[]) {
  java.awt.EventQueue.invokeLater(new Runnable() {
  public void run() {
  new log().setVisible(true);
    }
   });
    }
}
