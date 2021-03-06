package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.sequentialpatterns.BIDE_and_prefixspan.AlgoBIDEPlus;
import com.lcc.algo.dm.algorithms.sequentialpatterns.BIDE_and_prefixspan.SequentialPatterns;
import com.lcc.algo.dm.input.sequence_database_list_integers.SequenceDatabase;

/**
 * Example of how to use the BIDE+ algorithm, from the source code.
 * 
 * @author Philippe Fournier-Viger
 */
public class MainTestBIDEPlus_saveToMemory {

	public static void main(String [] arg) throws IOException{    
		// Load a sequence database
		SequenceDatabase sequenceDatabase = new SequenceDatabase(); 
		sequenceDatabase.loadFile(fileToPath("contextPrefixSpan.txt"));
		sequenceDatabase.print();
		// Create an instance of the algorithm
		AlgoBIDEPlus algo  = new AlgoBIDEPlus();
		
        // if you set the following parameter to true, the sequence ids of the sequences where
        // each pattern appears will be shown in the result
        boolean showSequenceIdentifiers = true;
		
		// execute the algorithm
		SequentialPatterns patterns = algo.runAlgorithm(sequenceDatabase, null, 2);    
		algo.printStatistics(sequenceDatabase.size());
		patterns.printFrequentPatterns(sequenceDatabase.size(),showSequenceIdentifiers);
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestBIDEPlus_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}