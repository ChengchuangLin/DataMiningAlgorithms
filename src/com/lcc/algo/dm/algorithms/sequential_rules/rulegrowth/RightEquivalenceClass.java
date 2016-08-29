package com.lcc.algo.dm.algorithms.sequential_rules.rulegrowth;
/* This file is copyright (c) 2008-2013 Philippe Fournier-Viger
* 
* This file is part of the SPMF DATA MINING SOFTWARE
* (http://www.philippe-fournier-viger.com/spmf).
* 
* SPMF is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
* 
* SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* You should have received a copy of the GNU General Public License along with
* SPMF. If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lcc.algo.dm.patterns.itemset_array_integers_with_tids.Itemset;

/**
 * This class represents a right equivalence class.
 * 
 * @see AlgoERMiner
 * @see Itemset
 * @author Philippe Fournier-Viger
 */
public class RightEquivalenceClass {
	
	int[] itemsetI;
	Set<Integer> tidsI;
	Map<Integer, Occurence> occurencesI;
	
	List<RightRule> rules = new ArrayList<RightRule>();

	public RightEquivalenceClass(int[] itemsetI, Set<Integer> tidsI,
			Map<Integer, Occurence> occurencesI) {
			this.itemsetI = itemsetI;
			this.tidsI = tidsI;
			this.occurencesI = occurencesI;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(itemsetI) + " ==> EQ";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		RightEquivalenceClass eq = (RightEquivalenceClass) obj;
		
		// TODO Auto-generated method stub
		return Arrays.equals(itemsetI, eq.itemsetI);
	}

}