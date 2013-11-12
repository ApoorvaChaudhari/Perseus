package com.spyder.invertedindexer;

import java.io.*;
import java.lang.*;
import java.lang.String;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.spyder.stemmer.Stemmer;

public class Inverter {
	MyData data = new MyData();
	TopicData tdata = new TopicData();
	
	 public MyData readData(String dat, int forumid, int topicid, int countpos){
		 /* Read data from sql tables, tokenize for now and write it to the inverted file */
		  data.word = dat;			
		  data.topicList = new LinkedList();

			
			tdata.topicId = forumid;
			tdata.postId = topicid;
			tdata.position = countpos;

			data.topicList.add(tdata);
		 
		 return data;
		 
	 }
	 
	 public void writeData(MyData data)
	 {
		 try{
			 // Create file 
			 Boolean wordExists = false;
			 byte[] tempBuffer ;
			 long pf = 0;
			 RandomAccessFile raf = new RandomAccessFile("dummytest.txt","rw");
			 long lengthOfFile = raf.length();
			 // Comparing if the word is already present in the list or not, if not put in the list otherwise append. This entire code below does this task
			 if(lengthOfFile !=0)
			 {
				 System.out.println("I am in outer if");
				 String s;
				 raf.seek(0);
				 try
				 { 
					 
					 while((s = raf.readLine()) != null) 
					 {
						 pf=raf.getFilePointer()-1;									
						 
						 System.out.println("The Line read from file is "+s);
						 String delimiter = ":";
						 String[] Word_from_file = s.split(delimiter);
						 //for(int i =0; i < Word_from_file.length ; i++)
						 System.out.println("The required word split from read Line is " + Word_from_file[0]);
						 System.out.println(" The new word from the SQLdatabase is "+data.getWord());
						 //System.out.println("Compare res:"+Word_from_file[0].trim().compareToIgnoreCase(data.getWord().toString().trim()));
						 if(Word_from_file[0].trim().compareToIgnoreCase(data.getWord().toString().trim()) == 0)
						 {
							
							 
							 
							 System.out.println("Append");
							 System.out.println("Writing out ... ");
							 System.out.println("The word to write to the linked list is "+data.getWord());
							 TopicData res = (TopicData)data.getTopicList().getFirst();
							 System.out.print(" Position: "+ res.getPosition());
							 System.out.print("\t PostId:  "+ res.getPostId());
							 System.out.print("\t TopicId: "+ res.getTopicId());
							 //s = s.concat("||" + res.getPosition()+ "\t" +res.getPostId() +"\t" +res.getTopicId() + "\n");
							 int tempBuffLength = (int)(lengthOfFile-(pf));
							 tempBuffer = new byte[tempBuffLength];
							 raf.read(tempBuffer, 0, (int)tempBuffLength);
							 raf.seek(pf);
							 raf.writeBytes("||" + res.getPosition()+ "\t" +res.getPostId() +"\t" +res.getTopicId() +"\n");
							 raf.write(tempBuffer);
							 //out.write(s);
							 
							 //System.out.println("\nConcatenated word is"+s);
							 //out.write("||" + res.getPosition()+ "\t" +res.getPostId() +"\t" +res.getTopicId() + "\n");
							 //Close the output stream
							 //out.close();
							 wordExists = true;
							 continue;
							 
						 }
						 //next = raf.readLine();
						 System.out.println("Word not found! run back to find ... ");
						 
						 
						 }
					 //word doesnt exists in the file currently add it
					 if(!wordExists)
					 {
						 System.out.println("Writing out ... ");
						 System.out.println("\n"+"The word to write to the linked list is "+data.getWord());
						 System.out.println("\n"+"Size ofLL "+data.getTopicList().size());
						 TopicData res = (TopicData)data.getTopicList().getFirst();
						 System.out.print(" Position: "+ res.getPosition());
						 System.out.print("\t PostId:  "+ res.getPostId());
						 System.out.print("\t TopicId: "+ res.getTopicId());
						 raf.seek(lengthOfFile);
						 raf.writeBytes(data.getWord() + ":" + res.getPosition()+ "\t" +res.getPostId() +"\t" +res.getTopicId() + "\n");

						 //Close the output stream
						 //out.close();
					 }

					 //out.close();
				 }//closing try
				 catch (IOException e)
				 {
					 System.err.println("Error is at: " + e.getMessage() + e.getStackTrace());
				 }
			 }//closing if
			 else // writing for the first word in the list
			 {
				 System.out.println("Writing out ... ");
				 System.out.println("\n"+"The word for the list is "+data.getWord());
				 System.out.println("\n"+ data.getTopicList().size());
				 TopicData res = (TopicData)data.getTopicList().getFirst();
				 System.out.print(" Position: "+ res.getPosition());
				 System.out.print("\t PostId:  "+ res.getPostId());
				 System.out.print("\t TopicId: "+ res.getTopicId());

				 raf.writeBytes(data.getWord() + ":" + res.getPosition()+ "\t" +res.getPostId() +"\t" +res.getTopicId() + "\n");

				 //Close the output stream
				 //out.close();
			 }
			 
			 raf.close();
		 }
		 catch (Exception e)
		 {//Catch exception if any
			 //System.err.println("Error is at this: " + e.getMessage()+ e.getStackTrace());;
			 e.printStackTrace();
		 } 

	 }


}