package JavaServletCode;

public interface Provider {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/mvctest";
    String username = "root";
    String password = "";
    
    
    String odriver = "oracle.jdbc.driver.OracleDriver";

    String ourl = "jdbc:oracle:thin:@localhost:1521:xe";

    String ousername = "system";

    String opassword = "12345";

}
