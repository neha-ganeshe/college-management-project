package javaapplication1;

import static java.lang.System.exit;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class JavaDB {
          /**
     * @param args the command line arguments
     */
    Connection conn;
    ResultSet rs;
    Statement stmt;

    public static void main(String[] args) {
       JavaDB mydb= new JavaDB();
	//Connect to database
        mydb.ConnectDb();

        Scanner sc=new Scanner(System.in);
        int ch;
        while(true)
        {
        System.out.println("\n====MENU====\n 1.INSERT\n 2.DELETE\n 3.UPDATE\n 4.DISPLAY\n 5.EXIT" );
        System.out.println("Enter your choice");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:  mydb.InsertData();
            break;
            case 2: mydb.DeleteData();
            break;
            case 3: mydb.UpdateData();
            break;
            case 4:mydb.DisplayData();
            break;
            case 5:  mydb.CloseConn();
                     exit(0);
            break;
            default:  System.out.println("Invalid choice");     
        }
        }
        }    
       
        
    void InsertData()
    {
        //code to insert a new value in database
        try{
            stmt=conn.createStatement();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the sponsers id:");
            int spons_id = sc.nextInt();
            System.out.println("Enter the Total amount:");
            int tolamt=sc.nextInt();
            Scanner sc1=new Scanner(System.in);

            System.out.println("Enter the Company:");
            String company=sc1.nextLine();
            System.out.println("Enter the Street:");
            String street=sc1.nextLine();
            System.out.println("Enter the City:");
            String city=sc1.nextLine();
            System.out.println("Enter the State:");
            String state=sc1.nextLine();
            String sql="insert into sponsers values("+spons_id+","+tolamt+",'"+company+"','"+street+"','"+city+"','"+state+"');";
            //String sql="insert into sponsers values(80,120000,'X','Z','Y','W');";
            stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println("Insertion done successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }
    }//End of inert data
    void DeleteData()
    {
        //Code to delete data
        try{
            stmt=conn.createStatement();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the sponsers id:");
            int id = sc.nextInt();
            String sql="delete from sponsers where spons_id='"+id+"'";
            stmt.executeUpdate(sql);
            System.out.println("Deletion done successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }
    }//end of DeleteData
    
    void UpdateData()
    {
        //Code to update the data
        
        try{
            stmt=conn.createStatement();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the sponsers id:");
            int id = sc.nextInt();
            System.out.println("Enter the CompanyName:");
            Scanner sc1=new Scanner(System.in);

            String Companyname = sc1.nextLine();
            String sql="update sponsers set company='"+Companyname+"' where spons_id='"+id+"'";
            stmt.executeUpdate(sql);
            System.out.println("Updation done successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }
    }//End of UpdateData
    
 void ConnectDb()
    {
        //Code to open connection with database
        System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			//e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		conn = null;
                try {
                conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/CSMT", "postgres",
					"vit123");
                System.out.println("You made it, take control your database now!");
                }
                catch(Exception e){
                        System.out.println("Failed to make connection!"+e);
                        }
    }//end of ConnectDb
 void DisplayData()
    {
        try 
            {
            stmt = conn.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM sponsers;" );
            while ( rs.next() ) 
            {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("\tSPONSER ID\tTOTALAMT\tCOMPANY\t\tSTREET\t\tCITY\t\tSTATE\n");
                System.out.println("\t"+rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\n");
               /* System.out.println("SponsId="+rs.getInt(1));
                System.out.println("TolAmt="+rs.getInt(2));
                System.out.println("Company="+rs.getString(3));
                System.out.println("Street="+rs.getString(4));
                System.out.println("City="+rs.getString(5));
                System.out.println("State="+rs.getString(6));*/
                System.out.println("--------------------------------------------------------------------------------------------");
                
            }
            rs.close();
            }
            catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
                    	} 
    }//end of function DisplayData
    void CloseConn()
    {
        //code to close the connection with database.
        try{
        conn.close();
        conn=null;
        }
        catch(Exception e)
        {
        }
        
    }
}
