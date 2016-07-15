public class Graph_pro04 {// 인접 행렬을 사용한 그래프
	int size;
	String[] vertices;
	Node[] a;

	// 내부클래스 사용

	public Graph_pro04(String[] args) { // 생성자 일단 정점의 갯수를 통해 인접 행렬 크기를 2차원배열로
										// 만들어야 한다.

		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new Node[size];

		for (int i = 0; i < size; i++) {
			a[i] = new Node();
		}
		for (int i = 0; i < size; i++) {
			a[i].setVertex(vertices[i]);
		}
	}

	public Graph_pro04(int adjsize) {
		size = adjsize;
		vertices = new String[size];
		// System.arraycopy(args, 0, vertices, 0, size);
		a = new Node[size];

		for (int i = 0; i < size; i++) {
			a[i] = new Node();
		}
	}

	void add(String v, String w) { // 추가할때
		// int i = index(v); // v가 몇 번째로 설정되어있는지
		/*
		 * int j = index(w); Node tmp1 = new Node(v); a[j].count++; Node tmp2 =
		 * new Node(w); while(tmp1.next()!=null){ //연결될 게 이미 연결된걸 덥지 않게 tmp1 =
		 * tmp1.next(); } tmp1.setNext(tmp2);
		 */
		Node tmp2 = new Node(w);
		int i = index(v); // v가 몇 번째로 설정되어있는지
		Node tmp1 = a[i];

		while (tmp1.next() != null) { // 연결될 게 이미 연결된걸 덥지 않게
			tmp1 = tmp1.next();
		}
		tmp2.count++;
		a[index(w)].count++;
		tmp1.setNext(tmp2);
	}

	/*
	 * Node tmp1 = new Node(v); // v라는 값을 같는 노드 int i = index(v); // v가 몇 번째로
	 * 설정되어있는지 int j = index(w); tmp1.setNext(a[j]); // 해당 노드에 연결 하면서 저장 a[j] =
	 * tmp1; tmp2.setNext(a[i]); a[i] = tmp2; }
	 */

	
	private int index(String v) { // 몇번째인지
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v)) {
				return i;
			}
		}
		return a.length;
	}


	// //
	public void topSorting() {
		ArrayList<Node> TopSortStack = new ArrayList<Node>();
		String pop;

		for (int k = 0; k < vertices.length; k++) {
			// 카운트 0 인거 다 넣어
			for (int i = 0; i < vertices.length; i++) {
				if (a[i].count == 0) {
					TopSortStack.push(a[i]);
					a[i].count = -1; // 넣은걸 -1처리
					break;
				}
			}
			pop = TopSortStack.pop().vertex();
		//	System.out.println(pop);
			print(pop.charAt(0));

			// 넣은거와 연결된 게 있는지 연결리스트로 다확인 연결된거 있음


				Node tmp = a[index(pop)];
				while (tmp.next() != null) {
					tmp = tmp.next();
					a[index(tmp.vertex)].count--;
				}
				
			if(isCycle(a)){
				break;
			}
		}
	}
	private boolean isCycle(Node[] a){
		for (int i = 0; i < vertices.length; i++) {
			if (a[i].count == -1) {
				return false;
			}
		}
		return true;
	}
	private void print(char print){
		
		switch (print) {
		case 'A':
			System.out.println("C언어프로그래밍");
			break;
		case 'B':
			System.out.println("자료구조");
			break;
		case 'C':
			System.out.println("시스템프로그래밍");
			break;
		case 'D':
			System.out.println("컴퓨터구조1");
			break;
		case 'E':
			System.out.println("컴퓨터하드웨어설계1");
			break;
		case 'F':
			System.out.println("컴퓨터구조2");
			break;
		case 'G':
			System.out.println("컴퓨터프로그래밍");
			break;
		case 'H':
			System.out.println("소프트웨어설계1");
			break;
		case 'I':
			System.out.println("소프트웨어설계2");
			break;
		case 'J':
			System.out.println("고급프로그래밍");
			break;
		case 'K':
			System.out.println("소프트웨어공학설계1");
			break;
		case 'L':
			System.out.println("컴퓨터특강");
			break;
		default:
			break;
		}
	}

	private void stackCountsub(ArrayList<String> Stack) {
		for (int i = 0; i < Stack.size(); i++) {
			a[index(Stack.elementAt(i))].count--;
		}
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
			if (!list.isEmpty()) {
				System.out.print("->");

			}
			System.out.print(list.pop());

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