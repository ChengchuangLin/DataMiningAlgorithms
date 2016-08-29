package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.lcc.algo.dm.algorithms.clustering.dbscan.AlgoDBSCAN;
import com.lcc.algo.dm.algorithms.clustering.optics.AlgoOPTICS;
import com.lcc.algo.dm.patterns.cluster.Cluster;
import com.lcc.algo.dm.patterns.cluster.DoubleArray;

/**
 *  Example of how to use the OPTICS algorithm from the source code to obtain the OPTICS cluster
 *  ordering of points and save the result to file.
 */
public class MainTestOPTICS_extractClusterOrdering_saveToFile {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		
		String input = fileToPath("inputDBScan.txt");
		String output = ".//output.txt";
		
		// we set the parameters of DBScan:
		int minPts=2;
		double epsilon = 20d;
		
		// We specify that in the input file, double values on each line are separated by spaces
		String separator = " ";
		
		// Apply the algorithm to compute a cluster ordering
		AlgoOPTICS algo = new AlgoOPTICS();  
		algo.computerClusterOrdering(input, minPts, epsilon, separator);
		
		algo.printStatistics();
		algo.saveClusterOrderingToFile(output);
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestOPTICS_extractClusterOrdering_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
	
}
