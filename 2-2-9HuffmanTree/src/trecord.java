
public class trecord {
	trecord lchild;
	char alphabet;
	int freq;
	trecord rchild;

	String haffmanCode="";

	public static final trecord NIL = new trecord();
	public trecord() {
		// TODO Auto-generated constructor stub
		lchild=rchild=this;
		freq=1;
	}
	public trecord(trecord trecord){
		this.alphabet=trecord.getAlphabet();
		this.freq=1;
		this.lchild=NIL;
		this.rchild=NIL;
	
	}
	
	public trecord(char c){
		this.alphabet=c;
		this.freq=1;
		this.lchild=NIL;
		this.rchild=NIL;
		}
	public trecord(char c,int f){
		this.alphabet=c;
		this.freq=f;
		this.lchild=NIL;
		this.rchild=NIL;
	}


	public String getHaffmanCode() {
		return haffmanCode;
	}
	public void setHaffmanCode(String haffmanCode) {
		this.haffmanCode = haffmanCode;
	}
	public boolean add(char input){
		
		//int oldSize=size();
		grow(input);
	
		return true;//size()>oldSize;
	}
	
	private trecord grow(char c){

		if(this==NIL){ 
			return new trecord(c);
		}
		if(c==this.getAlphabet()) {
			freq++;
			return this;
		}
		if(c<this.getAlphabet()){
			lchild = lchild.grow(c);
		}else {
			rchild = rchild.grow(c);
		}

	//	height = 1+Math.max(lchild.height, rchild.height);
		return this;
	}

	public int size(){ //재귀로 모든 사이즈를 알아냄
		if(this == NIL) return 0;
		return 1+lchild.size()+rchild.size();

	}
	public String toString(){
		if(this==NIL)return "";
		//내림차순으로 나오게
		String a="";
	
		a = lchild +""+alphabet+ " : "+" "+"freq:"+freq+"  "+this.haffmanCode+"\n"+rchild;

		return a;
	}
	/*public trecord sort(){
		trecord a = new trecord();
		
		return null;
	}*/
	
	public trecord getLchild() {
		return lchild;
	}

	public void setLchild(trecord lchild) {
		this.lchild = lchild;
	}

	public char getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char alphabet) {
		this.alphabet = alphabet;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public trecord getRchild() {
		return rchild;
	}

	public void setRchild(trecord rchild) {
		this.rchild = rchild;
	}

}
