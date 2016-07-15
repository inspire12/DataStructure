
 class Node { // ����Ʈ , ���� ������ �� ���δ�. element�� ���(node�� ���)
		String _element;
		int _count;
		Node _next;

		Node(String element, Node next) {
			this._element = element;	
			this._next = next;
			this._count=1;
		}
	
		public Node() {
			this._element = null;
			
			this._next = null;
			this._count=1;
		}

		public String get_element() {
			return _element;
		}
		public void incCount(){
			this._count++;
		}
		public int getCount(){
			return this._count;
		}
		public Node get_Next() {
			return _next;
		}

		public Node(String element) {
			this._element = element;
		}

		public Node next() {
			return this._next;
		}
		

		public void set_Next(Node n) {
			this._next = n;
		}

		
		// ����Ȯ��
		public Boolean isNext() {
			return this._next != null;
		}
	}