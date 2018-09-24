package lab3;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab3
{
	private final static String INFILE = "/Users/2kisa/programmingIII/FastaSeqCL.txt";
	private final static String OUTFILE = "/Users/2kisa/programmingIII/Fastaout.txt";
	
	public static void main(String[] args) throws Exception
	{ 
		BufferedReader reader = new BufferedReader(new FileReader(new File(INFILE)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUTFILE)));
		
		Boolean startLine = true;
		
		int numA = 0;
		int numC = 0;
		int numG = 0;
		int numT = 0;
		
		int lineCounter = 0;
		String sequence ="";
		
		// header row.
		String HEAD_ROW = "sequenceID"+"\t"+"numA"+"\t"+"numC"+"\t"+"numG"+"\t"+"numT"+"\t"+"sequence"+"\n";
		writer.write(HEAD_ROW);
		
		
		for (String nextLine = reader.readLine(); nextLine != null; nextLine = reader.readLine())
		{
			// for the very first line of the FASTA file.
			if(nextLine.startsWith(">")&& startLine == true)
			{
				startLine = false;
				++lineCounter;
				continue;
			}
			
			// for lines start with ">" but are not the very first line of the file.
			else if(nextLine.startsWith(">")&& startLine == false)
			{				
				// write in info from last sequence.
				writer.write("Seq"+lineCounter+"\t"+numA+"\t"+numC+"\t"+numG+"\t"+numT+"\t"+sequence+"\n");
				
				// reset for new sequence.
				numA = 0;
				numC = 0;
				numG = 0;
				numT = 0;
				++lineCounter;
				sequence ="";
				continue;
			}
			
			// for sequence lines. 
			else
			{
				numA +=counter('A',nextLine);
				numC +=counter('C',nextLine);
				numG +=counter('G',nextLine);
				numT +=counter('T',nextLine);
				sequence+=nextLine;
			}
		}
		
		// for the last sequence. 
		writer.write("Seq"+lineCounter+"\t"+numA+"\t"+numC+"\t"+numG+"\t"+numT+"\t"+sequence+"\n");
		
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	
	/**
	 * count the number of times a char appeared in a String.
	 * @param letter_counted the char that needs to be counted.
	 * @param s a string.
	 * @return counts.
	 */
	public static int counter(char letter_counted, String s)
	{
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(c==letter_counted)
			{
				++count;
			}
		}
		return count;
	}

}
