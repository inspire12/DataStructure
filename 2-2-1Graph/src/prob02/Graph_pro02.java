package prob02;

public class Graph_pro02 {// ���� ����� ����� �׷���
	int size;
	String[] vertices;
	Node[] a;

	// ����Ŭ���� ���
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
		// ����Ȯ��
		public Boolean isNext() {
			return this.next != null;
		}
	}

	public Graph_pro02(String[] args) { // ������ �ϴ� ������ ������ ���� ���� ��� ũ�⸦ 2�����迭�� ������ �Ѵ�.

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

	public void add(String v, String w) { // �߰��Ҷ�
		Node tmp2 = new Node(w);
		int i = index(v); // v�� �� ��°�� �����Ǿ��ִ��� 
		Node tmp1 = a[i];
		
		while(tmp1.next()!=null){ //����� �� �̹� ����Ȱ� ���� �ʰ�
			tmp1 = tmp1.next();
		}
		tmp1.setNext(tmp2);
	}
		/*Node tmp1 = new Node(v); // v��� ���� ���� ���
		int i = index(v); // v�� �� ��°�� �����Ǿ��ִ��� 
		int j = index(w);
		tmp1.setNext(a[j]); // �ش� ��忡 ���� �ϸ鼭 ����
		a[j] = tmp1;
		tmp2.setNext(a[i]);
		a[i] = tmp2;
	}*/

	public String toString() { // ��º�
		if (size == 0) {
			return "{}";
		}
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++) {
			buf.append("," + vertex(i));
		}
		return buf + "}";
	}

	private int index(String v) { // ���°����
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