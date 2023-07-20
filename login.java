package Parking;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
public class login extends javax.swing.JFrame {
String s1,s2,r2;
int r1;
public login() {
 initComponents();
    }
  private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
  s1=t1.getText();
  s2=t2.getText();
   if(s1.length()<=0 && s2.length()<=0)
        {
  JOptionPane.showMessageDialog(null,"Please fill Details");   
        }
        else
        {
            try
            {
Connection        con=DriverManager.getConnection("jdbc:derby://localhost:1527/parkingdb","parking","system"); 
 PreparedStatement ps;
 int i1=Integer.parseInt(s1);
 ps = con.prepareStatement("select eid,passwd from empdb where eid=? and passwd=?");
 ps.setInt(1,i1);
 ps.setString(2,s2); 
 ResultSet rs=ps.executeQuery();
  if(rs.next())
        {
                r1=rs.getInt(1);
                r2=rs.getString(2);
                if(r1==i1)
                {
                    if(r2.equals(s2))                         
                {
  ps=con.prepareStatement("insert into loginemp (eid,edate,etime) values (?,?,?)");
 java.util.Date date=new java.util.Date();
          java.sql.Date sqlDate=new java.sql.Date(date.getTime());
 java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
 ps.setInt(1,i1);
 ps.setDate(2,sqlDate);
 ps.setTimestamp(3,sqlTime);
    ps.execute();
   JOptionPane.showMessageDialog(null,"Login Successfully done");
    dispose();
    emphome e=new emphome();
     e.setVisible(true);
                }
                }
            }
     else
                {
   JOptionPane.showMessageDialog(null,"Login Unsucessfull please enter    proper details");                    
                }
            }
        catch(SQLException | HeadlessException e)
        {
        }
          }
    }                                     
     private void cancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
    dispose();
    log l=new log();
    l.setVisible(true); 
    }                                      
    public static void main(String args[]) {
java.awt.EventQueue.invokeLater(() -> {
 new login().setVisible(true);
     });
    }
}
