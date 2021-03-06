package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceEuclidian;
import com.lcc.algo.dm.algorithms.clustering.distanceFunctions.DistanceFunction;
import com.lcc.algo.dm.algorithms.clustering.hierarchical_clustering.AlgoHierarchicalClustering;
import com.lcc.algo.dm.patterns.cluster.ClusterWithMean;
import com.lcc.algo.dm.patterns.cluster.DoubleArray;

/**
 * Example of how to use the hierarchical clustering algorithm
 * from the source code.
 */
public class MainTestHierarchicalClustering_saveToMemory {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		
		String input = fileToPath("configKmeans.txt");
		String output = ".//output.txt";
		int maxdistance = 4;
		
		// Here we specify that we want to use the euclidian distance
		DistanceFunction distanceFunction = new DistanceEuclidian(); 
		// Alternative distance functions are also available such as:
//		DistanceFunction distanceFunction = new DistanceManathan(); 
//		DistanceFunction distanceFunction = new DistanceCosine(); 
//		DistanceFunction distanceFunction = new DistanceCorrelation(); 
//		DistanceFunction distanceFunction = new DistanceJaccard(); 
		
		// Apply the algorithm
		AlgoHierarchicalClustering algo = new AlgoHierarchicalClustering();  // we request 3 clusters
		List<ClusterWithMean> clusters = algo.runAlgorithm(input, maxdistance, distanceFunction);
		algo.printStatistics();
		
		// Print the clusters found by the algorithm
		// For each cluster:
		int i=0;
		for(ClusterWithMean cluster : clusters) {
			System.out.println("Cluster " + i++);
			// For each data point:
			for(DoubleArray dataPoint : cluster.getVectors()) {
				System.out.println("   " + dataPoint);
			}
		}

	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestHierarchicalClustering_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
	
}
