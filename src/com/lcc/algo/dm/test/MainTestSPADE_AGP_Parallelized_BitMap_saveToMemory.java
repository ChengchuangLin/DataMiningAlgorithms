package com.lcc.algo.dm.test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.AlgoSPADE;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.candidatePatternsGeneration.CandidateGenerator;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.candidatePatternsGeneration.CandidateGenerator_Qualitative;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.creators.AbstractionCreator;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.creators.AbstractionCreator_Qualitative;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.database.SequenceDatabase;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.idLists.creators.IdListCreator;
import com.lcc.algo.dm.algorithms.sequentialpatterns.spade_spam_AGP.idLists.creators.IdListCreator_Bitmap;

/**
 * Example of how to use the algorithm SPADE, saving the results in the 
 * main  memory
 * 
 * @author agomariz
 */
public class MainTestSPADE_AGP_Parallelized_BitMap_saveToMemory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Load a sequence database
        double support = 0.5;

        boolean keepPatterns = true;
        boolean verbose = false;

        AbstractionCreator abstractionCreator = AbstractionCreator_Qualitative.getInstance();
        boolean dfs=true;
        
        // if you set the following parameter to true, the sequence ids of the sequences where
        // each pattern appears will be shown in the result
        boolean outputSequenceIdentifiers = false; 
        
        IdListCreator idListCreator = IdListCreator_Bitmap.getInstance();
                
        CandidateGenerator candidateGenerator = CandidateGenerator_Qualitative.getInstance();
        
        SequenceDatabase sequenceDatabase = new SequenceDatabase(abstractionCreator, idListCreator);

        sequenceDatabase.loadFile(fileToPath("contextPrefixSpan.txt"), support);
        
        System.out.println(sequenceDatabase.toString());

        AlgoSPADE algorithm = new AlgoSPADE(support,dfs,abstractionCreator);
        
        algorithm.runAlgorithmParallelized(sequenceDatabase, candidateGenerator,keepPatterns,verbose,null,outputSequenceIdentifiers);
        System.out.println("Minimum support (relative) = "+support);
        System.out.println(algorithm.getNumberOfFrequentPatterns()+ " frequent patterns.");
        
        System.out.println(algorithm.printStatistics());
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = MainTestSPADE_AGP_FatBitMap_saveToFile.class.getResource(filename);
        return java.net.URLDecoder.decode(url.getPath(), "UTF-8");
    }
}
