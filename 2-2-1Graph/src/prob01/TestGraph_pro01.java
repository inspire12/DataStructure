package prob01;

//����Ʈ�� �̿��ؼ� �����ϱ�
public class TestGraph_pro01 {
	public static void main(String[] args) {

		Graph_pro01 g = new Graph_pro01(new String[] { "SE", "UK", "DE", "FR",
				"CZ", "CH", "AT", "IT" });

		System.out.println(g); // �ʱ� �׷��� ���� ���

		System.out.println("���� �켱 �ƻ��� ����Դϴ�.");
		g.add("SE", "UK"); // Edge �߰�
		g.add("SE", "DE");
		g.add("UK", "FR");
		g.add("DE", "FR");
		g.add("DE", "IT");
		g.add("DE", "CZ");
		g.add("CH", "FR");
		g.add("CH", "IT");
		g.add("CH", "AT");
		
		g.DFS();

	}

}
