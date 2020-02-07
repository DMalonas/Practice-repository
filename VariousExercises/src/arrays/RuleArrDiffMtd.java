package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleArrDiffMtd {


	private int[][] queries;
	private int arrLen;
	private int queriesNum;
	private int expRes;
	
	public RuleArrDiffMtd(List<ArrayList<Integer>> queries, int arrLen, int queriesNum, int expRes) {
		System.out.println(queries.toString());
		setQueries(queries);
		setArrLen(arrLen);
		setQueriesNum(queriesNum);
		setExpRes(expRes);
	}




	public RuleArrDiffMtd() {
		// TODO Auto-generated constructor stub
	}




	public ArrayList<RuleArrDiffMtd> getArrDiffRules(ArrayList<Integer> crudeInput) {
		ArrayList<RuleArrDiffMtd> rules = new ArrayList<RuleArrDiffMtd>();
		Iterator<Integer> it = crudeInput.iterator();
		boolean firstLine = true;
		int arrLen, queriesNum, expRes;
		List<Integer> query = new ArrayList<Integer>();
		List<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>();
		int size = crudeInput.size();
		int triplets = size / 3;
		
		int cntToCheckIfFirstLine = 0;
		 
		int cnt = 3;
		while(!crudeInput.isEmpty()) {
			arrLen = crudeInput.get(0); queriesNum = crudeInput.get(1); expRes = crudeInput.get(2);
			crudeInput.subList(0, 3).clear();
			for (int i = 0; i < queriesNum; i++) {
				query.add(crudeInput.get(0)); query.add(crudeInput.get(1)); query.add(crudeInput.get(2));
				ArrayList<Integer> newList = new ArrayList<>(query);
				queries.add(newList);
				query.clear();
				crudeInput.subList(0, 3).clear();
			}
			rules.add(new RuleArrDiffMtd(queries, arrLen, queriesNum, expRes));
			queries.clear();
		}
		return rules;
	}




	public int[][] getQueries() {
		return queries;
	}




	public void setQueries(List<ArrayList<Integer>> queries) {
		this.queries = new int[queries.size()][3];
		for (int i = 0; i < this.queries.length; i++) {
			ArrayList<Integer> tmpLi = queries.get(0);
			this.queries[i][0] = tmpLi.get(0); this.queries[i][1] = tmpLi.get(1); this.queries[i][2] = tmpLi.get(2);
			queries.remove(0);
		}
		
		for (int i = 0; i < this.queries.length; i++) {
			for (int j = 0; j < this.queries[0].length; j++) {
				System.out.print(this.queries[i][j] + " ");
			}
			System.out.println("dddddds");
		}
	}




	public int getArrLen() {
		return arrLen;
	}




	public void setArrLen(int arrLen) {
		this.arrLen = arrLen;
	}




	public int getQueriesNum() {
		return queriesNum;
	}




	public void setQueriesNum(int queriesNum) {
		this.queriesNum = queriesNum;
	}




	public int getExpRes() {
		return expRes;
	}




	public void setExpRes(int expRes) {
		this.expRes = expRes;
	}
}
