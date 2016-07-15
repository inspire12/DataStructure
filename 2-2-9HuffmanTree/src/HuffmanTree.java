import java.util.Comparator;
import java.util.PriorityQueue;


public class HuffmanTree {

	//텍스트를 읽어 빈도수를 조사(트리)
	//트리 만들고 우선수누이큐 구현
	trecord HuffmanTree =null;
	trecord[] table;
	int i=0;
	String bit="";
	String decodingString="";
	public HuffmanTree(PriorityQueue<trecord> queue){
		int i;
		int n=queue.size();
		table=new trecord[n];
		
		for (i=1; i<n; i++){   //n은 알파벳 개수
		trecord tnode = new trecord( );
		
		tnode.lchild = queue.remove(); 
		
		//우선순위큐 queue에서 우선 순위가 높은 원소 삭제해서 리턴
		tnode.rchild = queue.remove();
		
		tnode.freq = tnode.lchild.freq + tnode.rchild.freq;
		queue.add(tnode); //우선순위큐 queue에 새로 생성된 트리 tnode 를 삽입

		}
		this.HuffmanTree=queue.element();
		

		
	}
	public String toString(){
		return this.HuffmanTree.toString();
	}
	
	public void makeHuffmanCode(trecord x, String s){
		
		if(x.alphabet==0){
			makeHuffmanCode(x.lchild, s+0);
			makeHuffmanCode(x.rchild, s+1);
			
		}else{
			
			x.haffmanCode=s;
			table[i]= x;
			i++;
		}
	}
	public String encoding(char c){
		for(int i=0;i<this.table.length;i++){
			if(this.table[i].alphabet==c){
				bit+=this.table[i].haffmanCode;
				return this.table[i].haffmanCode;
			}
		}
		return null;
	}
	private Boolean isAlphabet(char a){
		return (a<=90)&&(a>=65);
	}
	public void decoding(){
		for(int index =0;index<bit.length();){
			trecord decode = this.HuffmanTree;
			while(!isAlphabet(decode.getAlphabet())){
				char code = bit.charAt(index);
				if(code == '0'){
					decode=decode.lchild;
				}else{
					decode=decode.rchild;
				}		
				index++;
			}
			decodingString+=decode.getAlphabet();
		}
	}
}
/*private static void buildCode(String[] st, Node x, String s) {
    if (!x.isLeaf()) {
        buildCode(st, x.left,  s + '0');
        buildCode(st, x.right, s + '1');
    }
    else {
        st[x.ch] = s;
    }
}*/