
public class BlackjackHand {
//ī�� �ΰ��� �⺻ �������Ѵ�. 
//�������� ī�带 �ް� ī�� ���� ����ؼ� 21�̸� �̰�ٰ� �ϰ� ��
	Card[] _pickCard= new Card[5];
	boolean winer = false;
	int forUserWinSum=0;
	public BlackjackHand() {
		// TODO Auto-generated constructor stub
		
		for(int i=0;i<5;i++){
			this._pickCard[i] = new Card();
		}
	}
	int addCard(Card card){
		int i=0;
		while(this._pickCard[i].get_shape()!='0'){
		i++;
		if(i>4){System.out.println("ī�尡 �ʰ��߾� �̰ھ�");winer = true;break;}
		}
		this._pickCard[i] = card;
		return this._pickCard[i].get_value();
	}
	public void userprint(){
		System.out.print("<user>");
	}
	public void dealerprint(){
		System.out.print("<dealer>");
	}
	public void userprintln(){
		System.out.println("Winner:<user>");
	}
	public void dealerprintln(){
		System.out.println("Winner:<dealer>");
	}
	public int yourCard(){
		int i=0;
		int sumCard = 0;
		System.out.print("Hand : ");
		while(this._pickCard[i].get_shape()!='0'){
			System.out.print(this._pickCard[i]+" ");
			
			
			if (this._pickCard[i].get_value()<10){
				sumCard+=this._pickCard[i].get_value();}
			else{
				sumCard+=10;
			}
			i++;
			
			if(i==5){
				System.out.println("ī�� �� �ʰ�.");
				break;
			}
		}
		System.out.println("sum : "+sumCard);
		return sumCard;
	}
	public void dealerfirstCard(){
		System.out.println("<dealer> Hand : ( ? , ? )"+this._pickCard[0]);
	}
	public int dealerCard(){
		int i=0;
		int sumCard = 0;
		
		while(this._pickCard[i].get_shape()!='0'){
			sumCard+=this._pickCard[i].get_value();
			i++;
			if(i==5){
				System.out.println("ī�� �� �ʰ�");
				break;
			}
		}
		return sumCard;
	}
	
	public int getBlackjackValue(){
		int i =0;
		while(this._pickCard[i].get_shape()=='0')
		forUserWinSum+=this._pickCard[i].get_value();
			
		return  forUserWinSum;
	}
}
