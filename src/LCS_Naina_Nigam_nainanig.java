//Program to print the longest common subsequence and its length
import java.io.File;
import java.io.IOException;

import java.io.PrintStream;
import java.util.Scanner;

public class LCS {

	public static void main(String[]args)throws IOException
	{
		
		try{
			
			String opPath="output.txt";  //to direct and write output to output.txt file
			String ipPath="input.txt";  //to retrieve query terms from input.txt file
			File file = new File(ipPath);
			Scanner scanner = new Scanner(file);
			PrintStream fw=new PrintStream(opPath);
			//store both the strings in string1 and string2 respectively from input file 
			String string1=scanner.nextLine();
			String string2=scanner.nextLine();
			
			
		int length1,length2;//lengths of string 1 and string2 respectively are stored in these
		length1=string1.length();
		length2=string2.length();
		int[][]opt=new int[length1+1][length2+1];//array to store the edit distance
		char[][]dir=new char[length1+1][length2+1];//array to store the direction to backtrack the string subsequence
		int i,j;
		for(i=0;i<=length1;i++)
		{
			opt[i][0]=0;
			dir[i][0]='e';//assigning empty to first column
		}
		for(j=0;j<=length2;j++)
		{
			opt[0][j]=0;
			dir[0][j]='e';//assigning empty to first row
		}
		for(i=1;i<=length1;i++)
		{
			for(j=1;j<=length2;j++)
		{
			if(string1.charAt(i-1)==(string2.charAt(j-1)))
			{
				opt[i][j]=opt[i-1][j-1]+1;
				dir[i][j]='d';
			}
			else if(opt[i][j-1]>=opt[i-1][j])
			{
				opt[i][j]=opt[i][j-1];
				dir[i][j]='l';
			}
			else {
				opt[i][j]=opt[i-1][j];
				dir[i][j]='u';
			}
		}
		}
		int p = length1, q =length2;
        StringBuffer s = new StringBuffer();
        while (p >0 && q >0) 
        {
            if (dir[p][q]=='d')
            {
                s.append(string1.charAt(p-1));
                p--;
                q--;
            }
            else if (dir[p][q]=='u') 
                p--;
            else
                q--;
        }
        fw.println(opt[length1][length2]);
        fw.println(s.reverse().toString());
        scanner.close();
        fw.close();
		}
		catch (Exception e)

		{
			e.printStackTrace();
			System.out.println(e);
		}
	}}
    
	
		
		
	
	
	
	
