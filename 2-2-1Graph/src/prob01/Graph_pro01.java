package prob01;


public class Graph_pro01 {//인접 행렬을 사용한 그래프
	int size;
	String[] vertices;
	boolean[][] a;
	
	public Graph_pro01(String[] args){  //생성자 일단 정점의 갯수를 통해 인접 행렬 크기를 2차원배열로 만들어야 한다.
		
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
	
	public String toString(){ //출력부
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
		StringBuffer buf = new StringBuffer(vertices[i]+":"); //StringBuffer 새로운 객체를 생성하지 않고 이어나감
		for(int j =0; j<size;j++){
			if(a[i][j]){
				buf.append(vertices[j]);  //buf.append가 뭐야
			}
		}
			return buf+"";
	}
	
	public void DFS(){ //스택을 이용해서
		ArrayList<String> list = new ArrayList<String>();
		boolean[] visited = new boolean[size]; //연결되어있는니 아닌지
		
		//시작점 넣기
		int tmp=0; 
		list.push(vertices[tmp]); //점
		visited[tmp]=true;
		System.out.print("{");
		while(!list.isEmpty()){  //
		
			//출력하는 조건확인
			for(int i=0; i<size; i++){
				String stmp = (String) list.peek();
				if(stmp.equals(vertices[i])){ 
					tmp=i;   //해당하는 깊이로 가게해준다.
					break;
				}
			}
			if(!list.isEmpty()){
				System.out.print("->");
			}		
			System.out.print(list.pop() );
			
			//넣는 조건확인 
			for(int i=0; i<size; i++){	
				if(a[tmp][i]&&  !visited[i]){
					visited[i]=true;   //중복 반문하지 않도록
					list.push(vertices[i]);
				}
			}
		}
		System.out.println("}");
	}

}
