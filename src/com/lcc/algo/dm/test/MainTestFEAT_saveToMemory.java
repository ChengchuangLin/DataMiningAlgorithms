package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import com.lcc.algo.dm.algorithms.sequentialpatterns.BIDE_and_prefixspan.AlgoFEAT;
import com.lcc.algo.dm.algorithms.sequentialpatterns.BIDE_and_prefixspan.SequentialPattern;
import com.lcc.algo.dm.input.sequence_database_list_integers.SequenceDatabase;


/**
 * Example of how to use the FEAT algorithm in source code.
 * @author Philippe Fournier-Viger
 */
public class MainTestFEAT_saveToMemory {

	public static void main(String [] arg) throws IOException{    
		// Load a sequence database
		SequenceDatabase sequenceDatabase = new SequenceDatabase(); 
		sequenceDatabase.loadFile(fileToPath("contextPrefixSpan.txt"));
		// print the database to console
		sequenceDatabase.print();
		
		// Create an instance of the algorithm 
		AlgoFEAT algo = new AlgoFEAT(); 
//		algo.setMaximumPatternLength(3);
		
		// execute the algorithm with minsup = 50 %
		List<SequentialPattern> patterns = algo.runAlgorithm(sequenceDatabase, 0.4);    
		algo.printStatistics(sequenceDatabase.size());
		System.out.println(" == PATTERNS ==");
		for(SequentialPattern pattern : patterns){
			System.out.print(pattern + " support : " + pattern.getAbsoluteSupport() + " sequence ids:");
			for(Integer sequenceID: pattern.getSequenceIDs()) {
				System.out.print(" " + sequenceID);
			}
			System.out.println();
		
		}
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestFEAT_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}