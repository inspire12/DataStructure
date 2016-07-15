package Kruskals;

public class Graph_pro01 {// ���� ����� ����� �׷���
	int size; // vertice ����
	String[] vertices;
	Edge[] edge;
	int[][] weight;

	Edge[] minEdge;

	int[] union;
	int cost;

	public Graph_pro01(int adjsize) { // ������ �ϴ� ������ ������ ���� ���� ��� ũ�⸦ 2�����迭��
										// ������ �Ѵ�.
		size = adjsize;
		vertices = new String[size];
		// System.arraycopy(args, 0, vertices, 0, size);
		weight = new int[size][size];
		union = new int[size];
		for (int i = 0; i < size; i++)
			union[i] = -1;

	}

	public void add(String v, String w, int wei) { // �߰��Ҷ�
		int i = index(v);
		int j = index(w);
		weight[i][j] = wei;
		weight[j][i] = wei; //���⼺�� �����ϱ�
	}

	// �ּ� ��� ���� Ʈ��
	// ����Ʈ�� ��� ������ �����ϴ� ����Ʈ��
	// G�� n -> size ���� ������ ���� ��, G�� ����Ʈ���� n���� ������ n-1���� ���� ������? ����

	// ����Ʈ���� ��� = ����Ʈ���� �������� ����ġ�� �� int cost; for()-�����Ѵ� ���� Ȯ��
	// {cost+=weight[][];} ���߿� �ּҸ� ����
	// ������, ��� �Ǵܱ��� -> ���� => �ֻ��� ����
	//
	public int collapsingfind(int index) {
		while (union[index] != -1) {
			index = union[index];
		}
		return index; //�Ӹ��� ���´�.
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
		// �������� ����� �����ϴ� ������ �����Ѵ�
		int i = 0 ;int h=0;
		while (h<vertices.length-1) {// 0���� ���
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
		System.out.println("\n��������� �� :" +cost);
		
		for(int j=0; j<minEdge.length; j++){
			if(minEdge[j]!=null){
			System.out.print("["+minEdge[j].get_to()+" "+minEdge[j].get_from()+"],");
		}
		}
		
		// �̹� T�� �ִ� ������� �Բ� ����Ŭ�� �������� ������

		// ���� ����� ������ ��������� ���ʷ� T�� �߰��Ѵ�.
		// n���� ������ ������ ����׷��������� ��Ȯ�� n-1���� ������ ���õȴ�.
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
		// �̰� �Ϸ��� ������ �־�� �Ѵ�.
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

	public String toString() { // ��º�
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

	
	public void DFS() { // ������ �̿��ؼ�
		ArrayList<String> list = new ArrayList<String>();
		boolean[] visited = new boolean[size]; // ����Ǿ��ִ´� �ƴ���

		// ������ �ֱ�
		int tmp = 0;
		list.push(vertices[tmp]); // ��
		visited[tmp] = true;
		System.out.print("{");
		while (!list.isEmpty()) { //

			// ����ϴ� ����Ȯ��
			for (int i = 0; i < size; i++) {
				String stmp = (String) list.peek();
				if (stmp.equals(vertices[i])) {
					tmp = i; // �ش��ϴ� ���̷� �������ش�.
					break;
				}
			}
			if (!list.isEmpty()) {
				System.out.print("->");
			}
			System.out.print(list.pop());

			// �ִ� ����Ȯ��
			for (int i = 0; i < size; i++) {
				if (weight[tmp][i]!=0 && !visited[i]) {
					visited[i] = true; // �ߺ� �ݹ����� �ʵ���
					list.push(vertices[i]);
				}
			}
		}
		System.out.println("}");
	}

}
