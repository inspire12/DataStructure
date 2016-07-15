import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


public class TestHuffman {
	trecord input;
	trecord NIL ;
	public static void main(String[] args) {

		new TestHuffman("book");
	}
	
	@SuppressWarnings({ "static-access", "resource" })
	public TestHuffman(String file){
		int lineNumber =0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();		
			//빈도수 표 작성
			trecord table = new trecord();
			NIL=table;
			//우선 순위 큐 사용(힙) 정렬 기준은 freq 기준
			Comparator<trecord> comparator = new Comparator<trecord>() {
				@Override
				public int compare(trecord o1, trecord o2) {
					// TODO Auto-generated method stub
					if(o1.getFreq()<o2.getFreq()){
						return -1;
					}if(o1.getFreq()>o2.getFreq()){
						return 1;
					}
					return 0;
				}
			};
			//최소 우선순위큐
			PriorityQueue<trecord> queue= new PriorityQueue<>(26,comparator);
			@SuppressWarnings("unused")
			trecord temp = null;
			while(line!=null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");

				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					for(int i=0;i<word.length();i++){
						char c = word.charAt(i);
						//빈도수 작성
						if(table==NIL){
							table = new trecord(c);
							temp = table;
						}else{
						table.add(c);
						}
					}
				}
				line = in.readLine();
			}
			
			System.out.println(table);
			//heap =  new minimumHeap(table);
			
			NIL=table.NIL;
				
			inOrder(table, queue);
							
			HuffmanTree HuffmanTree = new HuffmanTree(queue);
			HuffmanTree.makeHuffmanCode(HuffmanTree.HuffmanTree, "");
			
			
			in = new BufferedReader(new FileReader(file));
			line = in.readLine();
			String a="";
			
			while(line!=null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");

				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					for(int i=0;i<word.length();i++){
						char c = word.charAt(i);
						//빈도수 작성
						a+=HuffmanTree.encoding(c);
					}
				}
				line = in.readLine();
			}
			
			System.out.println(a);
			HuffmanTree.decoding();
			System.out.println(HuffmanTree.decodingString);
			System.out.println(HuffmanTree);
			in.close();
		}catch(Exception e) {
			// TODO: handle exception
			System.out.println("lines:"+lineNumber);
			
		}
		
	}
	void inOrder(trecord table,PriorityQueue<trecord> queue){
		if(!table.equals(NIL)){
		char alphabet = table.getAlphabet();
		int freq = table.freq;
		input = new trecord(alphabet,freq);
		queue.add(input);
		}
		if(!table.lchild.equals(NIL)){inOrder(table.lchild,queue);}
		if(!table.rchild.equals(NIL)){inOrder(table.rchild,queue);}
	}
}
