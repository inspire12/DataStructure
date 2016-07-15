import java.util.Scanner;


public class AppController {
	boolean Win=false;  //�ºΰ� ����. 
	int sumYour=0;
	int sumDealer=0;
	Scanner _Scanner = new Scanner(System.in);
	BlackjackHand dealerHand;
	BlackjackHand userHand;
	Deck deck;

	boolean selectGoStop(){


		System.out.println("select action : 1) hit / 2) stand");
		int select = this._Scanner.nextInt();
		if(select==1){
			System.out.println("user select hit");
			return true;
		}else if(select ==2){
			System.out.println("user select stand");
			return false;
		}else{
			System.out.println("�߸� �Է��߽��ϴ�. ���൹���մϴ�.");
		}

		return true;
	}
	boolean playGame(){
		System.out.println("������ �����Ͻ÷��� 1�� ��������");
		int select = this._Scanner.nextInt();
		return select ==1;

	}
	void playBlackjack(){
		//��������� �����߽��ϴ�. ī�带 ���ڽ��ϴ�.

		while(playGame()){
			//���� 2�� �� 2��
			deck= new Deck(); 
			deck.shuffle();
			dealerHand=new BlackjackHand();
			userHand = new BlackjackHand();

			dealerHand.addCard(deck.CardDraw());
			dealerHand.addCard(deck.CardDraw());

			userHand.addCard(deck.CardDraw());
			userHand.addCard(deck.CardDraw());

			dealerHand.dealerfirstCard();
			sumYour = userHand.yourCard();
			sumDealer = dealerHand.dealerCard();
			deckInfo(deck.getPickNumber());
			//
			if(Wins(this.sumYour,this.sumDealer)){Win = true;break;}

			while(selectGoStop()){
				//dealerHand.addCard(deck.CardDraw());
				userHand.addCard(deck.CardDraw());
				sumYour = userHand.yourCard();
				if(Wins(this.sumYour,this.sumDealer)){Win = true;break;}		
			}
			//stand �ϸ� ������ ī�带 �̴´�.
			int i=0;
			while(sumDealer<16|i>dealerHand._pickCard.length){
				dealerHand.addCard(deck.CardDraw());
				sumDealer=dealerHand.dealerCard();
				if(Wins(this.sumYour,this.sumDealer)){Win = true;break;}
				System.out.println("");
				i++;
				//if(Wins(this.sumYour,this.sumDealer)){Win = true;break;}	
			}			
			if(Win)standWins(this.sumYour, this.sumDealer);
			end(dealerHand);
		}	
	}


	void end(BlackjackHand dealer){
		dealer.dealerprint();
		dealer.yourCard();

	}
	void deckInfo(int i){
		System.out.println("<deck info> Deck used card : "+i);
	}
	void standWins(int y, int d){
		if(y>d)
		{dealerHand.userprintln(); 
		}else if(y<d)
		{dealerHand.dealerprintln();
		}else{

			System.out.println("���º��Դϴ�.");

		}
	}
	
	boolean Wins(int sumYour, int sumDealer){
		if (sumYour ==21|sumDealer>21 ){
			userHand.winer = true;
			System.out.println("You win.");
			return true;
		}
		if (sumYour >21|sumDealer==21){
			dealerHand.winer = true;
			System.out.println("Dealer win");
			return true;
		}
		Win = true;
		return false;
	}

	

}
