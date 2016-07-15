package prob02;

public class Graph_pro02 {// 인접 행렬을 사용한 그래프
	int size;
	String[] vertices;
	Node[] a;

	// 내부클래스 사용
	public static class Node {
		String value;
		Node next;
		
		public Node() {
			this.next = null;
			this.value = null;
		}

		public Node(String value) {
			this.value = value;
			this.next = null;
		}

		public void setValue(String v) {
			this.value = v;
		}

		public void setNext(Node n) {
			next = n;
		}

		public String value() {
			return this.value;
		}

		public Node next() {
			return this.next;
		}
		// 연결확인
		public Boolean isNext() {
			return this.next != null;
		}
	}

	public Graph_pro02(String[] args) { // 생성자 일단 정점의 갯수를 통해 인접 행렬 크기를 2차원배열로 만들어야 한다.

		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new Node[size];

		for (int i = 0; i < size; i++) {
			a[i] = new Node();
		}
		for (int i = 0; i < size; i++) {
			a[i].setValue(vertices[i]);
		}
	}

	public void add(String v, String w) { // 추가할때
		Node tmp2 = new Node(w);
		int i = index(v); // v가 몇 번째로 설정되어있는지 
		Node tmp1 = a[i];
		
		while(tmp1.next()!=null){ //연결될 게 이미 연결된걸 덥지 않게
			tmp1 = tmp1.next();
		}
		tmp1.setNext(tmp2);
	}
		/*Node tmp1 = new Node(v); // v라는 값을 같는 노드
		int i = index(v); // v가 몇 번째로 설정되어있는지 
		int j = index(w);
		tmp1.setNext(a[j]); // 해당 노드에 연결 하면서 저장
		a[j] = tmp1;
		tmp2.setNext(a[i]);
		a[i] = tmp2;
	}*/

	public String toString() { // 출력부
		if (size == 0) {
			return "{}";
		}
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++) {
			buf.append("," + vertex(i));
		}
		return buf + "}";
	}

	private int index(String v) { // 몇번째인지
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v)) {
				return i;
			}
		}
		return a.length;
	}

	// //
	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++) {
			if (a[i].isNext()) {
				buf.append(vertices[j]);
			}
		}
		return buf + "";
	}

	public void DFS() {
		ArrayList<String> list = new ArrayList<String>();

		boolean[] visited = new boolean[size]; // 연결되어있는니 아닌지

		int tmp = 0;
		list.push(vertices[tmp]);
		visited[tmp] = true;

		System.out.print("{ ");
		while (!list.isEmpty()) { // 연결되어있으면
			for (int i = 0; i < size; i++) {
				String stmp = (String) list.peek();
				if (stmp.equals(vertices[i])) {
					tmp = i;
					break;
				}
			}
			if(!list.isEmpty()){
				System.out.print("->");
			
				}		
				System.out.print(list.pop() );
					

			for (int i = 0; i < size; i++) {
				if (a[tmp].isNext() && !visited[i]) {
					visited[i] = true;
					a[tmp] = a[tmp].next();
					list.push(vertices[i]);
				}
			}
		}
		System.out.println("}");
	}
}