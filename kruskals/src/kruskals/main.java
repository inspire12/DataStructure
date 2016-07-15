package kruskals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException{
		//File Read 파일을 읽어서 그래프 만드는 부분.
		FileReader fileReader = new FileReader("hw03"); // 파일을 열고 읽을 수 있도록
		BufferedReader reader = new BufferedReader(fileReader); 
		// 하나의 문자가 아닌 연속된 문자를 다룬다.
		String tmp = ""; //임시로 저장 하기 위한 String
		tmp = reader.readLine();
		tmp = reader.readLine();
		//현재 tmp에는 edge의 갯수
		
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
		System.out.println("길이 : "+k.getcost());
		
	
	}
}
