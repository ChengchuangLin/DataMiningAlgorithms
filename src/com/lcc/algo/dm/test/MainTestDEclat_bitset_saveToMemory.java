package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.frequentpatterns.eclat.AlgoDEclat_Bitset;
import com.lcc.algo.dm.input.transaction_database_list_integers.TransactionDatabase;
import com.lcc.algo.dm.patterns.itemset_array_integers_with_count.Itemsets;


/**
 * Example of how to use DECLAT algorithm from the source code.
 * @author Philippe Fournier-Viger - 2014
 */
public class MainTestDEclat_bitset_saveToMemory {

	public static void main(String [] arg) throws IOException{
		// Loading the binary context
		TransactionDatabase database = new TransactionDatabase();
		try {
			database.loadFile(fileToPath("contextPasquier99.txt"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		context.printContext();
		
		// Applying the DECLAT algorithm
		AlgoDEclat_Bitset algo = new AlgoDEclat_Bitset();
		Itemsets patterns = algo.runAlgorithm(null, database, 0.4, true);
		// NOTE 0: We use "null" as output file path, because in this
		// example, we want to save the result to memory instead of
		// saving to a file
		
		// NOTE 1: if you  use "true" in the line above, CHARM will use
		// a triangular matrix  for counting support of itemsets of size 2.
		// For some datasets it should make the algorithm faster.
		
		patterns.printItemsets(database.size());
		algo.printStats();

	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestDEclat_bitset_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
