package annotations;

public class Rule {
	private String type;
	private int cost;
	
	
	public Rule() {
		System.out.println("default constructor");
	}
	
	public Rule(String[] currentRule) {
		if(currentRule.length == 2 ) {
			type = currentRule[0];
			cost = Integer.parseInt(currentRule[1]);
			System.out.println("New rule is:: " + type + " " + cost);
		}
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	public String toString() {
		return type +  " " + cost;
	}

	
}
