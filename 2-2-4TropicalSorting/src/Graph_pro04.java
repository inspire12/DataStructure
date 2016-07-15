public class Graph_pro04 {// ���� ����� ����� �׷���
	int size;
	String[] vertices;
	Node[] a;

	// ����Ŭ���� ���

	public Graph_pro04(String[] args) { // ������ �ϴ� ������ ������ ���� ���� ��� ũ�⸦ 2�����迭��
										// ������ �Ѵ�.

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

	void add(String v, String w) { // �߰��Ҷ�
		// int i = index(v); // v�� �� ��°�� �����Ǿ��ִ���
		/*
		 * int j = index(w); Node tmp1 = new Node(v); a[j].count++; Node tmp2 =
		 * new Node(w); while(tmp1.next()!=null){ //����� �� �̹� ����Ȱ� ���� �ʰ� tmp1 =
		 * tmp1.next(); } tmp1.setNext(tmp2);
		 */
		Node tmp2 = new Node(w);
		int i = index(v); // v�� �� ��°�� �����Ǿ��ִ���
		Node tmp1 = a[i];

		while (tmp1.next() != null) { // ����� �� �̹� ����Ȱ� ���� �ʰ�
			tmp1 = tmp1.next();
		}
		tmp2.count++;
		a[index(w)].count++;
		tmp1.setNext(tmp2);
	}

	/*
	 * Node tmp1 = new Node(v); // v��� ���� ���� ��� int i = index(v); // v�� �� ��°��
	 * �����Ǿ��ִ��� int j = index(w); tmp1.setNext(a[j]); // �ش� ��忡 ���� �ϸ鼭 ���� a[j] =
	 * tmp1; tmp2.setNext(a[i]); a[i] = tmp2; }
	 */

	
	private int index(String v) { // ���°����
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
			// ī��Ʈ 0 �ΰ� �� �־�
			for (int i = 0; i < vertices.length; i++) {
				if (a[i].count == 0) {
					TopSortStack.push(a[i]);
					a[i].count = -1; // ������ -1ó��
					break;
				}
			}
			pop = TopSortStack.pop().vertex();
		//	System.out.println(pop);
			print(pop.charAt(0));

			// �����ſ� ����� �� �ִ��� ���Ḯ��Ʈ�� ��Ȯ�� ����Ȱ� ����


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
			System.out.println("C������α׷���");
			break;
		case 'B':
			System.out.println("�ڷᱸ��");
			break;
		case 'C':
			System.out.println("�ý������α׷���");
			break;
		case 'D':
			System.out.println("��ǻ�ͱ���1");
			break;
		case 'E':
			System.out.println("��ǻ���ϵ�����1");
			break;
		case 'F':
			System.out.println("��ǻ�ͱ���2");
			break;
		case 'G':
			System.out.println("��ǻ�����α׷���");
			break;
		case 'H':
			System.out.println("����Ʈ�����1");
			break;
		case 'I':
			System.out.println("����Ʈ�����2");
			break;
		case 'J':
			System.out.println("������α׷���");
			break;
		case 'K':
			System.out.println("����Ʈ������м���1");
			break;
		case 'L':
			System.out.println("��ǻ��Ư��");
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

		boolean[] visited = new boolean[size]; // ����Ǿ��ִ´� �ƴ���

		int tmp = 0;
		list.push(vertices[tmp]);
		visited[tmp] = true;

		System.out.print("{ ");
		while (!list.isEmpty()) { // ����Ǿ�������
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