




 class Node { // ����Ʈ , ���� ������ �� ���δ�. vertex�� ���(node�� ���)
		String vertex;
		int count;
		Node next;

		Node(String vertex,int count, Node next) {
			this.vertex = vertex;
			this.count = count;
			this.next = next;
		}
		
		public Node() {
			this.vertex = null;
			this.count = 0;
			this.next = null;
		}

		public Node(String vertex) {
			this.vertex = vertex;
		}

		public Node next() {
			return this.next;
		}
		public String vertex(){
			return this.vertex;
		}
		public void setVertex(String v) {
			this.vertex = v;
		}

		public void setNext(Node n) {
			this.next = n;
		}

		public void setcount(int count) {
			this.count = count;
		}

		// ����Ȯ��
		public Boolean isNext() {
			return this.next != null;
		}
	}