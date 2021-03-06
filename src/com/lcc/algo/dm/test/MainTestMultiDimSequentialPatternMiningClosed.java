package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.sequentialpatterns.fournier2008_seqdim.AlgoBIDEPlus;
import com.lcc.algo.dm.algorithms.sequentialpatterns.fournier2008_seqdim.multidimensionalpatterns.AlgoDim;
import com.lcc.algo.dm.algorithms.sequentialpatterns.fournier2008_seqdim.multidimensionalsequentialpatterns.AlgoSeqDim;
import com.lcc.algo.dm.algorithms.sequentialpatterns.fournier2008_seqdim.multidimensionalsequentialpatterns.MDSequenceDatabase;

/**
 *  Example of how to do closed multi-dimensional sequential
 *  pattern mining in source code.
 * @author Philippe Fournier-Viger
 */
public class MainTestMultiDimSequentialPatternMiningClosed {

	public static void main(String [] arg) throws IOException{    
		// Minimum absolute support = 50 %
		double minsupp = 0.50;
		String input = fileToPath("ContextMDSequenceNoTime.txt");
		String output = ".//output.txt";
		
		// Load a sequence database
		MDSequenceDatabase contextMDDatabase  = new MDSequenceDatabase(); //
		contextMDDatabase.loadFile(input);
//		contextMDDatabase.printContext();
		
		// If the second boolean is true, the algorithm will use
		// CHARM instead of AprioriClose for mining frequent closed itemsets.
		// This options is offered because on some database, AprioriClose does not
		// perform very well. Other algorithms could be added.
		AlgoDim algoDim = new AlgoDim(false, true);
		
		AlgoSeqDim algoSeqDim = new AlgoSeqDim();
		
		// Apply algorithm
		AlgoBIDEPlus bideplus = new AlgoBIDEPlus(minsupp);  
		algoSeqDim.runAlgorithm(contextMDDatabase, bideplus, algoDim, true, output);
		
		// Print results
		algoSeqDim.printStatistics(contextMDDatabase.size());
		
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestMultiDimSequentialPatternMiningClosed.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}


