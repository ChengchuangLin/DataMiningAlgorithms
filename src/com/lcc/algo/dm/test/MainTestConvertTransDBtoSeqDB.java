package com.lcc.algo.dm.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import com.lcc.algo.dm.tools.dataset_converter.Formats;
import com.lcc.algo.dm.tools.dataset_converter.SequenceDatabaseConverter;
import com.lcc.algo.dm.tools.dataset_converter.TransactionDatabaseConverter;

/**
 * Example of how to convert a transaction database in SPMF format to 
 * a sequence database in SPMF format.
 */
public class MainTestConvertTransDBtoSeqDB {
	
	public static void main(String [] arg) throws IOException{
		
		String inputFile = fileToPath("contextPasquier99.txt");
		String outputFile = ".//output.txt";
		Formats inputFileformat = Formats.SPMF_TRANSACTION_DB;
		int transaction_count = Integer.MAX_VALUE;
		
		SequenceDatabaseConverter converter = new SequenceDatabaseConverter();
		converter.convert(inputFile, outputFile, inputFileformat, transaction_count);
	}

	

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestConvertTransDBtoSeqDB.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
