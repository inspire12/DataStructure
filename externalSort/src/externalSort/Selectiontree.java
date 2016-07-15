package externalSort;

public class Selectiontree {

	Element[] elements;
	private final static int infinit = 0x7FFFFFFF;
	int[][] numbers = {{1,9,11,19,21,31,41,51,61,71},
			{7,17,27,37,47,50,57,60,67,77},
			{2,12,22,29,32,39,42,52,62,72},
			{4,14,24,34,44,54,64,69,74,79},
			{8,18,28,38,48,58,68,70,78,80},
			{5,10,15,20,25,35,45,55,65,75},
			{3,13,23,33,43,49,53,59,63,73},
			{6,16,26,30,36,40,46,56,66,76}};
	int [] index;
	
	public Selectiontree(){
		elements = new Element[16];
		for(int i=0; i<15; i++){
			elements[i] = new Element();
		}
		index = new int[8];
	}
	
	public void initial(){
		for(int i=7; i<15; i++){
			elements[i].setIndex(i-7);
			elements[i].setValue(numbers[i-7][0]); //맨앞 값을 일단 넣음
		}
		for(int i=14; i>0;i=i-2){
			Element tmp = new Element();
			if(elements[i].getValue() > elements[i-1].getValue()){
				tmp = elements[i-1];
			}
			else
				tmp = elements[i];
			elements[(i-1)/2] = tmp;
		}
	}
	public void looserTree(){
		while(!this.loopCondition()){
			Element e = elements[0];
			System.out.println(e.getValue());
			if(index[e.getIndex()]>= 9){
				elements[e.getIndex()+7].setValue(infinit);
			}
			else{
				index[e.getIndex()]++;	
				elements[e.getIndex()+7].setValue(numbers[e.getIndex()][index[e.getIndex()]]);
				
			}
			for(int i=14; i>0;i=i-2){
				Element tmp = new Element();
				if(elements[i].getValue() > elements[i-1].getValue()){
					tmp = elements[i-1];
				}
				else
					tmp = elements[i];
				elements[(i-1)/2] = tmp;
			}
		}

	}
	public boolean loopCondition(){
		boolean x = true;
		for(int i=0; i<8; i++){
			boolean y = false;
			if(index[i] >= 9)
				y = true;
			
			x = x&&y;
		}
		return x;
	}
}
