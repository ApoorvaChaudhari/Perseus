package com.spyder.main;
import java.util.LinkedList;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;

import com.spyder.databasehandler.databaseR;
import com.spyder.invertedindexer.Inverter;
import com.spyder.invertedindexer.MyData;
import com.spyder.invertedindexer.TopicData;
import com.spyder.stemmer.Stemmer;
import com.spyder.stemmer.StringTokenizerClass;

public class PerseusMain {
	
	
	 /** Test program for demonstrating the Stemmer.  It reads text from a
	  * a list of files, stems each word, and writes the result to standard
	  * output. Note that the word stemmed is expected to be in lower case:
	  * forcing lower case must be done outside the Stemmer class.
	  * Usage: Stemmer file-name file-name ...
	 * @throws SQLException 
	  */
	// SEQ #1
	 public static void main(String[] args) throws SQLException
	 {
	    char[] result = new char[501];
	    Stemmer stem = new Stemmer();
	    Inverter invert = new Inverter();
	     databaseR dbobj = new databaseR();
	     Connection con = dbobj.getConnection();
	     
	     //String query = "SELECT forum_name,forum_id FROM forum";
	     String query = "SELECT post_id,content,topic_id FROM post";
	     //String query = "SELECT forum_id,topic_title,topic_id FROM topic LIMIT 100";
		 StringTokenizerClass tokens = new StringTokenizerClass();
		 ArrayList tokenD = new ArrayList();
		 tokenD.clear();
	     Statement stmt = con.createStatement();
	     
	     ResultSet rs = stmt.executeQuery(query);
     	/* Tokenize the output from the database table and make it ready to put it into the stemmer */
     	
     	while (rs.next()) 
     	{
     		String output_c1 = rs.getString("content");
     		int postsid = rs.getInt("post_id");
     		int topicid = rs.getInt("topic_id");
     		//System.out.println(forumsid);
     		/*int lt = output_c1.length();
     		int a = output_c1.indexOf("<a href");
     		int b = output_c1.indexOf("</a>");
     		System.out.println("Occurences");
     		System.out.println(a+"\t"+b);
     		if(a>=0 && b>=0)
     		{
     			String output_c1a = output_c1.substring(0, a-1);
     			String output_c1b = output_c1.substring(b+1, lt);
     			String output_c2 = output_c1a.concat(output_c1b);
     			System.out.println("Concat Successful");
     			tokenD = tokens.getTokens(output_c2);
     		}
     		else
     		{
     		tokenD = tokens.getTokens(output_c1);
     		}
            */
     		// SEQ #2 goes to StringTokenizeerClass to create tokens 
     		tokenD = tokens.getTokens(output_c1);
     		int m=tokenD.size();
     		int countp=1;
     		System.out.println("****************************");
     		System.out.println("The array list is of size "+m);
     		for(int i = 0;i<tokenD.size();i++)
     		{
	    	 	
     			System.out.println("\n--->");
     			System.out.println(tokenD.get(i));
     			System.out.println("****************");
     			String output_token_stem = (String) tokenD.get(i);
				//System.out.println(tokenD.get(j));
				/*String string_to_char= (String) tokenD.get(i);
		
        		char chr[]=string_to_char.toCharArray();
			
        		System.out.println("Type cast string to char :"+chr.length);
					for(int n=0; n<chr.length; n++)
						{
						System.out.println(chr[n]);
						char charlower = Character.toLowerCase(chr[n]);
						chr[n]=charlower;
						System.out.println("----");
						System.out.println(chr[n]);
						stem.add(chr, chr.length);
						}
     			
	    		 stem.stem();	
	    		 String u;

                and now, to test toString() : 
               u = stem.toString();

                to test getResultBuffer(), getResultLength() : 
                //u = new String(stem.getResultBuffer(), 0, stem.getResultLength()); 
               System.out.println("The stemmed WORD is ");
               int b=u.length();
               System.out.println(b);
               System.out.print(u); */
     			// Code for writing to inverted index SEQ #3
               LinkedList list = new LinkedList();
               MyData data = new MyData();
               Inverter inv = new Inverter();
               data=inv.readData(output_token_stem,postsid,topicid,countp);
           	   //Goes to the inverter page to create and write the list
               //TopicData tdata = new TopicData();
               list.add(data); 
       			Iterator i1 = list.iterator();
       			MyData toPrint = (MyData) list.getFirst();
       			
       		   inv.writeData(toPrint); 
       			countp++;
	    	}
	     }

	    
	    //stem.add('a');
	    //result = stem.stem();
	    //invert.readData(); 
	    
	    }
}
