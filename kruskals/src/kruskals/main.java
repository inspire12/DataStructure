package kruskals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException{
		//File Read ������ �о �׷��� ����� �κ�.
		FileReader fileReader = new FileReader("hw03"); // ������ ���� ���� �� �ֵ���
		BufferedReader reader = new BufferedReader(fileReader); 
		// �ϳ��� ���ڰ� �ƴ� ���ӵ� ���ڸ� �ٷ��.
		String tmp = ""; //�ӽ÷� ���� �ϱ� ���� String
		tmp = reader.readLine();
		tmp = reader.readLine();
		//���� tmp���� edge�� ����
		
		kruskal k = new kruskal(Integer.parseInt(tmp), Integer.parseInt(reader.readLine()));
		//tmp.split(" ")[0]
		Edge _e[] = new Edge[Integer.parseInt(tmp)];
		
		for(int i=0; i<_e.length; i++){
			tmp = reader.readLine();
			_e[i] = new Edge(tmp.split(" ")[0], tmp.split(" ")[1], Integer.parseInt(tmp.split(" ")[2]));
		}
		k.set_e(_e);
		k.kruskal();
		System.out.println(k);
		System.out.println("���� : "+k.getcost());
		
	
	}
}
