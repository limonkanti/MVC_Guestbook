
package JavaServletCode;



import static JavaServletCode.Provider.*;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionProvider2 
{
     
    private static Connection con = null;
    private ConnectionProvider2()
    {
        
    }
    static 
    {
        
        try
        {
         
           /* Class.forName(driver);
            con=DriverManager.getConnection(url, username, password);*/
            Class.forName(odriver);
            con=DriverManager.getConnection(ourl, ousername, opassword);

        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }
        
    }

    public static Connection getConnection() 
    {
        return con;
    }

    
}
