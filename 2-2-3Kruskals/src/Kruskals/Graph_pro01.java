package Kruskals;

public class Graph_pro01 {// 인접 행렬을 사용한 그래프
	int size; // vertice 갯수
	String[] vertices;
	Edge[] edge;
	int[][] weight;

	Edge[] minEdge;

	int[] union;
	int cost;

	public Graph_pro01(int adjsize) { // 생성자 일단 정점의 갯수를 통해 인접 행렬 크기를 2차원배열로
										// 만들어야 한다.
		size = adjsize;
		vertices = new String[size];
		// System.arraycopy(args, 0, vertices, 0, size);
		weight = new int[size][size];
		union = new int[size];
		for (int i = 0; i < size; i++)
			union[i] = -1;

	}

	public void add(String v, String w, int wei) { // 추가할때
		int i = index(v);
		int j = index(w);
		weight[i][j] = wei;
		weight[j][i] = wei; //방향성이 없으니까
	}

	// 최소 비용 신장 트리
	// 신장트리 모든 정점을 연결하는 서브트리
	// G가 n -> size 개의 저엄을 가질 때, G의 신장트리는 n개의 정점과 n-1개의 간선 간선도? 구성

	// 신장트리의 비용 = 신장트리의 간선들의 가중치의 합 int cost; for()-연결한는 점을 확인
	// {cost+=weight[][];} 이중에 최소를 선택
	// 갈망법, 몇개의 판단기준 -> 뭐야 => 최상의 결정
	//
	public int collapsingfind(int index) {
		while (union[index] != -1) {
			index = union[index];
		}
		return index; //머리가 나온다.
	}

	public void weightedunion(int i, int j) {
		if (i < j)
			union[j] = i;
		else
			union[i] = j;
	}
	public boolean NotCycle(Edge tmpE){
		return (this.collapsingfind(this.VertexToIndex(tmpE.get_to()))!= this
				.collapsingfind(this.VertexToIndex(tmpE.get_from())));
	}
	void numberOfEdge(){
		
	}
	void kruskal() {
		int numberOfEdge = 17;
		int k = 0;
		this.edge = new Edge[numberOfEdge];
		this.minEdge = new Edge[numberOfEdge];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				int w = weight[i][j];
				if (w!=0) {
					this.edge[k] = new Edge(vertices[i], vertices[j],w);
					k++;
				}
			}
		}
		sort();
		// 간선들을 비용이 증가하는 순서로 정렬한다
		int i = 0 ;int h=0;
		while (h<vertices.length-1) {// 0부터 계산
			Edge tmpE = edge[i];
			//int a = this.collapsingfind(this.VertexToIndex(tmpE.get_to()));
			//int b = this.collapsingfind(this.VertexToIndex(tmpE.get_from()));
			if ( NotCycle(tmpE) ) {
				minEdge[h] = tmpE;
				this.weightedunion(this.VertexToIndex(tmpE.get_to()),
						this.VertexToIndex(tmpE.get_from()));
				cost = cost + tmpE.get_weight();
				h++;
			}
			i++;
		}
		System.out.println("\n최저비용의 수 :" +cost);
		
		for(int j=0; j<minEdge.length; j++){
			if(minEdge[j]!=null){
			System.out.print("["+minEdge[j].get_to()+" "+minEdge[j].get_from()+"],");
		}
		}
		
		// 이미 T에 있는 간선들과 함께 사이클을 형성하지 않으면

		// 적은 비용을 가지는 간선들부터 차례로 T에 추가한다.
		// n개의 정점을 가지는 연결그래프에서는 정확히 n-1개의 간산이 선택된다.
	}

	public int VertexToIndex(String vertex) {
		char v = vertex.charAt(0);
		int index = 0;
		for (char c = 'A'; c < 'Z'; c++) {
			if (c == v)
				break;
			else
				index++;
		}
		return index;
	}

	void sort() {
		// 이거 하려면 엣지가 있어야 한다.
		int size = this.edge.length;
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (this.edge[j].get_weight() > this.edge[j+1].get_weight()){
					swap(j, j + 1);
				}
			}
		}
	}

	private void swap(int j, int i) {
		// TODO Auto-generated method stub
		Edge tmp = this.edge[j];
		this.edge[j] = this.edge[i];
		this.edge[i] = tmp;

	}

	public String toString() { // 출력부
		return null;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v)) {
				return i;
			}
		}
		return vertices.length;
	}

	
	public void DFS() { // 스택을 이용해서
		ArrayList<String> list = new ArrayList<String>();
		boolean[] visited = new boolean[size]; // 연결되어있는니 아닌지

		// 시작점 넣기
		int tmp = 0;
		list.push(vertices[tmp]); // 점
		visited[tmp] = true;
		System.out.print("{");
		while (!list.isEmpty()) { //

			// 출력하는 조건확인
			for (int i = 0; i < size; i++) {
				String stmp = (String) list.peek();
				if (stmp.equals(vertices[i])) {
					tmp = i; // 해당하는 깊이로 가게해준다.
					break;
				}
			}
			if (!list.isEmpty()) {
				System.out.print("->");
			}
			System.out.print(list.pop());

			// 넣는 조건확인
			for (int i = 0; i < size; i++) {
				if (weight[tmp][i]!=0 && !visited[i]) {
					visited[i] = true; // 중복 반문하지 않도록
					list.push(vertices[i]);
				}
			}
		}
		System.out.println("}");
	}

}
