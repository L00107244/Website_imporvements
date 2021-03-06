package java_classes;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.mysql.jdbc.Blob;

import java_classes.sign_up_backend;
public class Post_advert
{
  private static int item_id;
  private String Name;
  private String condition;
  private String Description;
  private String Location;
  private String E_mail;
  private String phone_number;
  private String images;
  private int seller_id;
  private String categories;
  private double price;
  
	 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/buy-sell-repeat";
	 private static Statement statement = null;
	 private static ResultSet resultSet;
	 public static sign_up_backend ConnectedUser;

	 //  Database credentials
	 static final String USER = "root";
	 static final String PASS = "password";
  
  protected Post_advert(String namein, String condin, String Descrip, String locat, String em, String pn, int sid, String cat, double Price)
  {
	this.Name = namein;
	this.condition = condin;
	this.Description = Descrip;
	this.Location = locat;
	this.E_mail = em;
	this.phone_number = pn;
	this.seller_id = sid;
	this.categories = cat;
	this.price = Price;
  }
  protected Post_advert( int id,String namein, String condin, String Descrip, String locat, String em, String pn, int sid, String cate, double Price)
  {
	this.item_id = id;
	this.Name = namein;
	this.condition = condin;
	this.Description = Descrip;
	this.Location = locat;
	this.E_mail = em;
	this.phone_number = pn;
	this.seller_id = sid;
	this.categories = cate;
	this.price = Price;
  }
  protected Post_advert()
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
  protected void setCategories(String catin)
  {
	  categories = catin;
  }
  protected void setPrice(double pricein)
  {
	  price = pricein;
  }
  protected static int getID()
  {
	  return item_id;
  }
  protected String getName()
  {
	  return Name;
  }
  protected String getCondition()
  {
	  return condition;
  }
  protected String getDescription()
  {
	  return Description;
  }
  protected String getLocation()
  {
	  return Location;
  }
  protected String getEmail()
  {
	  return E_mail;
  }
  protected String getPhoneNumber()
  {
	  return phone_number;
  }
  protected String getImages()
  {
	  return images;
  }
  protected int getSellerid()
  {
	  return seller_id;
  }
  protected String getCate()
  {
	  return categories;
  }
  protected double getPrice()
  {
	  return price;
  }
	protected static int add(Post_advert pad)
	{
		//"insert into admin( username, name, Department,password) values(\'"
			int status = 0;
			String sqlString= "insert into sell(Name, condition, Description, Location, Email, phoneNumber, sellerID, categories, price) values(\'"+pad.getName()+ 
					"\', \'"+pad.getCondition()+ 
					"\', \'"+pad.getDescription() + 
					"\', \'"+pad.getLocation() +
					"\', \'"+pad.getEmail() +
					"\', \'"+pad.getPhoneNumber() +
					"\', \'"+ pad.getSellerid()+
					"\', \'"+pad.getCate()+
					"\', \'"+pad.getPrice()+"\')";
			status = databaseUpdate(sqlString);
			System.out.print(sqlString);  
			return status;
		}
	protected static Post_advert getAdvertsByID(int idin)
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
             		    	    resultSet.getInt("sellere_id"),
             		    	    resultSet.getString("categories"),
             		    	    resultSet.getDouble("price")); 
             		    	                  
           }   
           conn.close();
	  }
      catch (Exception e) {
          e.printStackTrace();
       }  
       return pa;
		
	}
	protected static ArrayList<Post_advert>SearchByWords(String name, String tech, String Locat)
	{
	  Post_advert pa = new Post_advert();
	  ArrayList<Post_advert> arr = new ArrayList<Post_advert>();
	  try
	  {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          statement=conn.createStatement();

          resultSet=statement.executeQuery("SELECT * FROM `sell` WHERE Name ='"+name+"'&&categories='"+tech+"'&&Location='"+Locat+"'");
          while ( resultSet.next() )      {
              pa = new Post_advert(
            		            resultSet.getString("Name"),   
             		    	    resultSet.getString("condition"),
             		    	    resultSet.getString("Description"),
             		    	    resultSet.getString("Location"),
             		    	    resultSet.getString("E_mail"),
             		    	    resultSet.getString("phone_number"),
             		    	    resultSet.getInt("sellere_id"),
             		    	    resultSet.getString("categories"),
             		    	    resultSet.getDouble("price")); 
                                
              arr.add(pa);
             		    	                  
           }   
           conn.close();
	  }
      catch (Exception e) {
          e.printStackTrace();
       }  
       return arr;
		
	}
    protected static int delete(int itemidIn) 
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
	protected  static int databaseUpdate(String sqlUpdate)
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
	@Override
	public String toString()
	{
		return " "+item_id+" "+Name+" "+condition+" "+Description+" "+Location+" "+E_mail+" "+phone_number+" "+" "+categories+" "+seller_id;
	}
 
}

