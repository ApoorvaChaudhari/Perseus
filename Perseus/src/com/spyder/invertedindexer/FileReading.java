package com.spyder.invertedindexer;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileReading
{
	public ArrayList<String> getInfo(String input)
	{
		ArrayList outputlist = new ArrayList();
		try
		{
			
			String r = input;
			java.io.FileReader fr = new java.io.FileReader("/Users/Apoorva/Test.txt");
			BufferedReader br = new BufferedReader(fr);
			String s, positionList="", postList="", topicList="" ;
			while((s = br.readLine()) != null) 
			{
				String delimiter = ":";
				String[] Word_from_file = s.split(delimiter);
				
				if(Word_from_file[0].trim().compareToIgnoreCase(r) == 0)
				{
					
					String match_word=Word_from_file[1];
					String delimiter1 = "||";
					 StringTokenizer st = new StringTokenizer(match_word,delimiter1);
					 ArrayList topicInfoList = new ArrayList();
				     while (st.hasMoreTokens()) {
				    	 topicInfoList.add(st.nextToken());
				     }
					
				     for(int i=0;i<topicInfoList.size();i++)
				     {
				    	 String item = (String) topicInfoList.get(i);
				    	 System.out.println("item:" +item);
				    	 String[] temp = item.split("\t");
				    	 positionList = positionList.concat(temp[0]+",");
				    	 postList=postList.concat(temp[1]+",");
				    	 topicList=topicList.concat(temp[2]+",");
				     }
				     System.out.println("Position List=" +positionList+" PostList="+postList+ " TopicList="+topicList); 
					 outputlist.add(0,positionList);
					 outputlist.add(1,postList);
					 outputlist.add(2,topicList);
				     break;
				}
			}
			fr.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			
		}
		return outputlist;
		
		
	}	
	
}

