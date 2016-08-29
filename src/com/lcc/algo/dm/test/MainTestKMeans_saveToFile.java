package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceCorrelation;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceCosine;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceEuclidian;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceFunction;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceJaccard;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceManathan;
import com.lcc.algo.dm.algorithms.clustering.kmeans.AlgoKMeans;

/**
 *  Example of how to use the KMEans algorithm, in source code.
 */
public class MainTestKMeans_saveToFile {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		
		String input = fileToPath("configKmeans.txt");
		String output = ".//output.txt";
		// we request 3 clusters
		int k=3;
		
		// Here we specify that we want to use the euclidian distance
		DistanceFunction distanceFunction = new DistanceEuclidian(); 
		// Alternative distance functions are also available such as:
//		DistanceFunction distanceFunction = new DistanceManathan(); 
//		DistanceFunction distanceFunction = new DistanceCosine(); 
//		DistanceFunction distanceFunction = new DistanceCorrelation(); 
//		DistanceFunction distanceFunction = new DistanceJaccard(); 
		
		// Apply the algorithm
		AlgoKMeans algoKMeans = new AlgoKMeans();  
		algoKMeans.runAlgorithm(input, k, distanceFunction);
		algoKMeans.printStatistics();
		algoKMeans.saveToFile(output);
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestKMeans_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
	
}
