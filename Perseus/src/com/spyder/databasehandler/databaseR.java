package com.spyder.databasehandler;
import java.sql.*;
import java.lang.*;
import java.util.*;

public class databaseR
{
		public static Connection conn;
		public static Connection getConnection()
		{
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "", "");
            
            System.out.println ("Database1 connection established");
            
        }
        catch (Exception e)
        { e.printStackTrace();
            System.err.println ("Cannot connect to database server");
        }
        return conn;
		}
}
