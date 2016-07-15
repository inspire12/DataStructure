
public class Graph {//인접 행렬을 사용한 그래프
	int size;
	String[] vertices;
	boolean[][] a;
	
	public Graph(String[] args){  //생성자
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0 , size);
		a = new boolean[size][size];
	}
	
	public void add(String v, String w){ //추가할때
		int i = index(v);
		int j = index(w);
		a[i][j] = a[j][i] = true;
	}
	public String toString(){
		if(size==0){
			return "{}";
		}
		StringBuffer buf = new StringBuffer("{"+ vertex(0));
		for(int i=1; i<size; i++){
			buf.append(","+ vertex(i));
		}
		return buf + "}";
	}
	
		
	
	private int index(String v){
		for(int i =0; i<size; i++){
			if(vertices[i].equals(v)){
				return i;
			}
		}
		return a.length;
	}
	
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(vertices[i]+":");
		for(int j =0; j<size;j++){
			if(a[i][j]){
				buf.append(vertices[j]);
			}
		}
			return buf+"";
	}
	

}
