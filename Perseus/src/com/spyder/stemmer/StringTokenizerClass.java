package com.spyder.stemmer;
import java.lang.*;
import java.util.*;
public class StringTokenizerClass {
public ArrayList<String> getTokens(String input){
		
		int count =0;
		ArrayList tokenList = new ArrayList();
		
		StringTokenizer st = new StringTokenizer(input);
		while (st.hasMoreTokens()) {
			
			count++;
	        String str = st.nextToken();  /* str has individual generated tokens one at a time as the loop runs */
	        System.out.println("Word from database before getting tokenized:" + str);  
			int l = str.length();  /* length of the word i.e the no. of characters of the word in the tokenizer */
			System.out.print("The length of the word being tokenized is " +l);
			
           /*int flag = 0;
			if(l>3)
			{
			if((str.charAt(l-1)=='.') && (str.charAt(l-2)=='.') && (str.charAt(l-3)=='.') && (str.charAt(l-4)=='.'))
			{
				String newstr = str.substring(0,l-4);
				tokenList.add(newstr);
				System.out.print(" The word being tokenized is ");
				System.out.println(newstr);
				System.out.print(" || This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
				flag = 1;
			}
			else
			{
			//System.out.println(i);  to print every single character of the word 
			
			tokenList.add(str);
			System.out.print(" || The word being tokenized is ");
			System.out.println(str);  //to print the word currently in the tokenizer 	
			System.out.print(" || This word is at position " +count); System.out.println("\n");
		    System.out.println("****************************");
			}
			}
			
			if(flag == 0 && l>2)
			{
			if((str.charAt(l-1)=='.') && (str.charAt(l-2)=='.') && (str.charAt(l-3)=='.') || (str.charAt(l-1)=='?') && (str.charAt(l-2)=='?') && (str.charAt(l-3)=='?') || (str.charAt(l-1)=='!') && (str.charAt(l-2)=='!') && (str.charAt(l-3)=='!')) // || ((str.charAt(l-1)=='?') && (str.charAt(l-2)=='?')) || ((str.charAt(l-1)=='>' && (str.charAt(l-2)=='a')) && (str.charAt(1)=='<') && (str.charAt(2)=='a')))
			{
				String newstr = str.substring(0,l-3);
				tokenList.add(newstr);
				System.out.print(" The word being tokenized is ");
				System.out.print(newstr);
				System.out.print(" || This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
				flag = 1;
			}
			}
			
			if(flag == 0)
			{
				if((str.charAt(0)=='"'))
				{
					String newstr = str.substring(1,l);
					tokenList.add(newstr);
					System.out.print(" The word being tokenized is ");
					System.out.print(newstr);
					System.out.print(" || This word is at position " +count); System.out.println("\n");
					System.out.println("****************************");
					flag = 1;
				}
			}
			
			if(flag == 0 && l>2)
			{
				if((str.charAt(0)=='/') && (str.charAt(1)=='>'))
				{
					String newstr = str.substring(2,l);
					tokenList.add(newstr);
					System.out.print(" The word being tokenized is ");
					System.out.print(newstr);
					System.out.print(" || This word is at position " +count); System.out.println("\n");
					System.out.println("****************************");
					flag = 1;
				}
			}
			
			if(flag == 0 && l>2)
			{
			if(((str.charAt(l-1)=='/' && (str.charAt(l-2)=='/')) || (str.charAt(l-1)=='!') && (str.charAt(l-2)=='!'))) 
			{
				String newstr = str.substring(0,l-2);
				tokenList.add(newstr);
				System.out.print(" The word being tokenized is ");
				System.out.print(newstr);
				System.out.print(" || This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
				flag = 1;
			}
			}
			
			if(flag == 0 && l>2)
			{
			if((str.charAt(l-1)=='.') && (str.charAt(l-2)=='.') || (str.charAt(l-1)=='?') && (str.charAt(l-2)=='?')) //|| ((str.charAt(l-1)=='.') && (str.charAt(l-2)=='.') && (str.charAt(l-3)=='.')) // || ((str.charAt(l-1)=='?') && (str.charAt(l-2)=='?')) || ((str.charAt(l-1)=='>' && (str.charAt(l-2)=='a')) && (str.charAt(1)=='<') && (str.charAt(2)=='a')))
			{
				String newstr = str.substring(0,l-2);
				tokenList.add(newstr);
				System.out.print(" The word being tokenized is ");
				System.out.print(newstr);
				System.out.print(" || This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
				flag = 1;
			}
			
			}
			
			if(flag == 0)
			{
			if((str.charAt(l-1) == ',') || (str.charAt(l-1)==';') || (str.charAt(l-1)=='%') || (str.charAt(l-1)=='$') || (str.charAt(l-1)=='?') || (str.charAt(l-1)=='.') || (str.charAt(l-1)=='!') ||(str.charAt(l-1)=='(') || (str.charAt(l-1)==')') || (str.charAt(l-1)=='"'))
			{
				String newstr = str.substring(0,l-1);
				tokenList.add(newstr);
				System.out.print(" The Word being tokenized is ");
				System.out.print(newstr);
				System.out.print(" || This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
			}
				if(flag == 0 && l>=3)
				{
					int z= str.indexOf("<br");
					if(z>=0)
					//if((str.charAt(l-1) == 'r') && (str.charAt(l-2)=='b') && (str.charAt(l-3)=='<'))
				{
				   String newstr = str.substring(0,l-3);
				   tokenList.add(newstr);
				   System.out.print(" The Word being tokenized is ");
				   System.out.print(newstr);
				   System.out.print(" || This word is at position " +count); System.out.println("\n");
				   System.out.println("****************************"); 
				   flag=0;
				} 
				}
				
				if(flag == 0 && l>=3)
				{
					int z= str.indexOf(" />");
					if(z>=0)
					//if((str.charAt(2) == 'r') && (str.charAt(1)=='b') && (str.charAt(0)=='<'))
				{
				   String newstr = str.substring(3,l);
				   tokenList.add(newstr);
				   System.out.print(" The Word being tokenized is ");
				   System.out.print(newstr);
				   System.out.print(" || This word is at position " +count); System.out.println("\n");
				   System.out.println("****************************"); 
				   flag=0;
				} 
				}
				
			if(flag == 1)
			{
				tokenList.add(str);
				System.out.print(" || The WWord being tokenized is ");
				System.out.print(str);  
				System.out.print(" || This word is at position " +count); System.out.println("\n");
				System.out.println("****************************");
			}*/

			if((str.charAt(l-1) == ',') || (str.charAt(l-1)==';') || (str.charAt(l-1)=='%') || (str.charAt(l-1)=='$') || (str.charAt(l-1)=='?') || (str.charAt(l-1)=='.') || (str.charAt(l-1)=='D'))
			{
				String newstr = str.substring(0,l-1);
				tokenList.add(newstr);
				System.out.print(" || The word being tokenized is ");
				System.out.println(newstr);
				System.out.print(" ||and This word is at position " +count); System.out.println("\n");
			    System.out.println("****************************");
			}
			
			else
			{
			tokenList.add(str);
			System.out.print(" || The word being tokenized is ");
			System.out.println(str);  //to print the word currently in the tokenizer 	
			System.out.print(" || and This word is at position " +count); System.out.println("\n");
		    System.out.println("****************************");
			}
			
		}
		
		return tokenList;
		
	}
	
	public static void main (String[] args) {
		System.out.println ("Hello World!");
	    Stemmer s = new Stemmer();
	    ArrayList tokenList = new ArrayList();
		StringTokenizerClass st = new StringTokenizerClass();
		tokenList = st.getTokens("ehh!!! huh??? />Sawen duh! \"fdfd fuck?? drab!! for) />poiu rew( shit? afaf<br greff\"");
		
		for (int i = 0; i < tokenList.size(); i++)
		   
		    {
		       String tempWord = (String) tokenList.get(i);
		       System.out.println(tempWord+"\t");
		       /*s.add(tempWord.toCharArray(), tempWord.length());
		       s.stem();
		       String u;*/
		       //To test output
               /*u = s.toString();
               System.out.print(u);*/
		         
		       }
		    
		
	}
}
