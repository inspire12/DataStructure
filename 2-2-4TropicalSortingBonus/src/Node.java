




 class Node { // ����Ʈ , ���� ������ �� ���δ�. vertex�� ���(node�� ���)
		String vertex;
		int grade;
		int count;
		Node next;

		Node(String vertex,int grade,int count, Node next) {
			this.vertex = vertex;
			this.grade = grade;
			this.count = count;
			this.next = next;
		}
		public Node() {
			this.vertex = null;
			this.grade = 0;
			this.count = 0;
			this.next = null;
		}
		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public String getVertex() {
			return vertex;
		}

		public Node getNext() {
			return next;
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