package prob01;

import java.io.IOException;

public class TestGraph_adj {
	public static void main(String[] args) throws IOException{
		
		Graph_Weighted g = new Graph_Weighted(args);//�̹� �����ڿ��� InputStream���� ���� ���夷�ؼ� �������
		 System.out.println("������� �Է��ϼ���."); 
		 
		 g.findShortestPaths();
		 	
	}
}
