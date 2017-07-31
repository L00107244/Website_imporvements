package java_classes;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Blob;

import java_classes.sign_up_backend;
public class Post_advert
{
  private int item_id;
  private String Name;
  private String condition;
  private String Description;
  private String Location;
  private String E_mail;
  private String phone_number;
  private String images;
  private int seller_id;
  
	 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/buy-sell-repeat";
	 private static Statement statement = null;
	 private static ResultSet resultSet;
	 public static sign_up_backend ConnectedUser;

	 //  Database credentials
	 static final String USER = "root";
	 static final String PASS = "password";
  
  public Post_advert(String namein, String condin, String Descrip, String locat, String em, String pn, int sid)
  {
	this.Name = namein;
	this.condition = condin;
	this.Description = Descrip;
	this.Location = locat;
	this.E_mail = em;
	this.phone_number = pn;
	this.seller_id = sid;
  }
  public Post_advert( int id,String namein, String condin, String Descrip, String locat, String em, String pn, int sid)
  {
	this.item_id = id;
	this.Name = namein;
	this.condition = condin;
	this.Description = Descrip;
	this.Location = locat;
	this.E_mail = em;
	this.phone_number = pn;
	this.seller_id = sid;
  }
  public Post_advert()
  {
	  
  }
  private void setName(String namein)
  {
	  this.Name = namein;
  }
  private void setCondition(String conditin)
  {
	  this.condition = conditin;
  }
  private void setDescription(String descripin)
  {
	  this.Description = descripin;
  }
  private void setLocation(String locatin)
  {
	  this.Location = locatin;
  }
  private void setEmail(String emin)
  {
	  this.E_mail = emin;
  }
  private void PhoneNum(String pnin)
  {
	  this.phone_number = pnin;
  }
  private void setImage(String imin)
  {
	  this.images = imin;
  }
  public void setSellerid(int idin)
  {
	  seller_id = idin;
  }
  public int getID()
  {
	  return item_id;
  }
  public String getName()
  {
	  return Name;
  }
  public String getCondition()
  {
	  return condition;
  }
  public String getDescription()
  {
	  return Description;
  }
  public String getLocation()
  {
	  return Location;
  }
  public String getEmail()
  {
	  return E_mail;
  }
  public String getPhoneNumber()
  {
	  return phone_number;
  }
  public String getImages()
  {
	  return images;
  }
  public int getSellerid()
  {
	  return seller_id;
  }
	public static int add(Post_advert pad)
	{

			int status = 0;
			String sqlString= "insert into sell( Name, condition,Description, Location, E_mail, phone_number, sellere_id) values(\'"+pad.getName()+ 
					"\', \'"+pad.getCondition()+ 
					"\', \'"+pad.getDescription() + 
					"\', \'"+pad.getLocation() +
					"\', \'"+pad.getEmail() +
					"\', \'"+pad.getPhoneNumber() +
					"\', \'"+ pad.getSellerid()+"\')";
			status = databaseUpdate(sqlString);
			System.out.print(sqlString);  
			return status;
		}
	public static Post_advert getAdvertsByID(int idin)
	{
	  Post_advert pa = new Post_advert();
	  try
	  {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from sell where sell.sellere_id=" + idin);
          
          while ( resultSet.next() )      {
              pa = new Post_advert( resultSet.getInt("item_id"),
            		            resultSet.getString("Name"),   
             		    	    resultSet.getString("condition"),
             		    	    resultSet.getString("Description"),
             		    	    resultSet.getString("Location"),
             		    	    resultSet.getString("E_mail"),
             		    	    resultSet.getString("phone_number"),
             		    	    resultSet.getInt("sellere_id")); 
             		    	                  
           }   
           conn.close();
	  }
      catch (Exception e) {
          e.printStackTrace();
       }  
       return pa;
		
	}
    public static int delete(int itemidIn) 
    {
        int status=0;  
        String sqlString= "delete from sell where item_id=" + itemidIn;     
        status = databaseUpdate(sqlString); 
        if(status == 1)
        {
        	System.out.println("Deleted");
        }
        else
        {
        	System.out.println("Not deleted");
        }
        return status;
     }
	public  static int databaseUpdate(String sqlUpdate)
	{
		int status = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			statement=conn.createStatement();
			status=statement.executeUpdate(sqlUpdate);
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	  public static void main(String []args)
	  {
		  Post_advert search = new Post_advert();
		  int i = 13;
		  search.setSellerid(i);
		  int idin = 13;
			Post_advert SearchNotes = Post_advert.getAdvertsByID(idin);
    
			System.out.println(SearchNotes.getID() + " \t" +
					SearchNotes.getID() + " \t" + 
					SearchNotes.getSellerid() + " \t" +
					SearchNotes.getCondition() + " \t" +
					SearchNotes.getDescription() + " \t" +
					SearchNotes.getLocation() + " \t" +
					SearchNotes.getEmail() + " \t" +
					SearchNotes.getPhoneNumber() + " \t" +
					SearchNotes.getName() );
			   int del = 2;
			   search.delete(del);
		}
	
	   
	  }

