package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.frequentpatterns.eclat.AlgoDEclat_Bitset;
import com.lcc.algo.dm.input.transaction_database_list_integers.TransactionDatabase;


/**
 * Example of how to use DECLAT algorithm from the source code.
 * @author Philippe Fournier-Viger - 2014
 */
public class MainTestDEclat_bitset_saveToFile {

	public static void main(String [] arg) throws IOException{
		
		// the file paths
		String input = fileToPath("contextPasquier99.txt");  // the database
		String output = ".//output.txt";  // the path for saving the frequent itemsets found
		
		// minimum support
		double minsup = 0.4; // means a minsup of 2 transaction (we used a relative support)

		// Loading the transaction database
		TransactionDatabase database = new TransactionDatabase();
		try {
			database.loadFile(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		context.printContext();
		
		// Applying the DECLAT algorithm
		AlgoDEclat_Bitset algo = new AlgoDEclat_Bitset();
		algo.runAlgorithm(output, database, minsup, true);
		// if you change use "true" in the line above, ECLAT will use
		// a triangular matrix  for counting support of itemsets of size 2.
		// For some datasets it should make the algorithm faster.
		
		algo.printStats();

	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestDEclat_bitset_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
