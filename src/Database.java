import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Database {
	private Connection con;
	private Statement stmnt;
    private ResultSet rs;
    final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    private String border = "----------------------------";
    
    public Database()
    {
    	try
    	{
    		Class.forName(JDBC_DRIVER);
    		con = DriverManager.getConnection("jdbc:mysql://localhost/zombie bite" , "root" , "");
    		stmnt = con.createStatement();
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Database connection could not be established");
    	}
    }
    public void insert(String name , int score)
    {
    	try
    	{
    		stmnt.execute("insert into players values('"+ name + "',"+score+",'"+date+"');");
    		stmnt.execute("commit;");
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Database Error");
    	}
    	
    }
    public int getRowNumber()
    {
    	int rows;
    	try
    	{
    		rs = stmnt.executeQuery("select count(name) from players");
    		rs.next();
    		rows = rs.getInt(1);
    		if(rows > 10)
    			rows = 10;
    		return rows;
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Database Error");
    		System.out.println(e);
    		return 0;
    	}
    }
    public String getData(int index)
    {
    	try
    	{
    		rs = stmnt.executeQuery("select rpad(name,35,'-'),score,lpad(date,35,'-') from players order by score desc limit 10");
    		for(int i = 0; i < index; i++)
    		{
    			rs.next();
    		}
    		return (rs.getString(1)  + rs.getInt(2)  + rs.getString(3));
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Database Error");
    		System.out.println(e);
    		return "NULL";
    	}
    }
    public void clearData()
    {
    	try
    	{
    		stmnt.execute("Delete From players;");
    		new Score();
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Database Error");
    		System.out.println(e);
    	}
    }
}
