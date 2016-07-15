

public class loserTree {
	Key elements[];
	int input[][] ;/*={ {1,9,11,19,21,31,41,51,61,71},
			{7,17,27,37,47,50,57,60,67,77},
			{2,12,22,29,32,39,42,52,62,72},
			{4,14,24,34,44,54,64,69,74,79},
			{8,18,28,38,48,58,68,70,78,80},
			{5,10,15,20,25,35,45,55,65,75},
			{3,13,23,33,43,49,53,59,63,73},
			{6,16,26,30,36,40,46,56,66,76}};*/
	int [] index;
	public loserTree(int[][] input){
		this.input = input;
		this.elements = new Key[16];  //숫자 세팅하는거
		for(int i=0; i<15; i++){
			this.elements[i] = new Key();
		}
		index = new int[input.length]; //트리에 넣을 거
		for(int i=7; i<15; i++){
			this.elements[i].setArrayNumber(i-7);
			this.elements[i].setElement(input[i-7][0]);
		}
		for(int i=14; i>0;i=i-2){//대기배열들
			Key tmp = new Key();
			if(this.elements[i].getElement() > this.elements[i-1].getElement()){
				tmp = this.elements[i-1];
			}
			else
				tmp = elements[i];
			elements[(i-1)/2] = tmp;
		}
	}

	public void run(){
		int i=0;
		while(i<input.length){
			Key output= this.elements[0];

			System.out.println(output);
			if(index[output.getArrayNumber()]> input.length){
				//한 라인이 다 배ㅜㄹ했을 때
				elements[output.getArrayNumber()+7].setElement(99999);
				i++;
			}

			else{
				index[output.getArrayNumber()]++;	
				elements[output.getArrayNumber()+7]
						.setElement(input[output.getArrayNumber()][index[output.getArrayNumber()]]);

			}	
			//비교졍렬
			for(int j=14; j>0;j=j-2){
				Key tmp = new Key();
				if(elements[j].getElement() > elements[j-1].getElement()){
					tmp = elements[j-1];
				}
				else
					tmp = elements[j];
				elements[(j-1)/2] = tmp;
			}
		}
	}
}
