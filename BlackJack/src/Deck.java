import java.util.Random;


public class Deck {

	Card[] _pokerCard;
	final int HowmanyCard = 52;
	private static int pickNumber =0;
	public Deck() {
		// TODO Auto-generated constructor stub
		this._pokerCard = new Card[52];


		for(int i =0; i<HowmanyCard; i++){
			if(i<13){
				this._pokerCard[i] = new Card(i+1,'¡ß');
				
			}else if(i<26){
				this._pokerCard[i] = new Card(i+1-13,'¢¾');

			}else if(i<39){
				this._pokerCard[i] = new Card(i+1-26,'¢À');

			}else if(i<52){
				this._pokerCard[i] = new Card(i+1-39,'¢¼');					

			}else{
				System.out.println("¿À·ù");
			}
		}
	}
	void shuffle(){
		Random _random = new Random();
		for(int i =0; i<HowmanyCard; i++){
			if(i<13){		
				int a =Math.abs(_random.nextInt()%52);
				this._pokerCard[i].set_shuffle(a);

			}else if(i<26){
				int a =Math.abs(_random.nextInt()%52);
				this._pokerCard[i].set_shuffle(a);

			}else if(i<39){
				int a =Math.abs(_random.nextInt()%52);
				this._pokerCard[i].set_shuffle(a);

			}else {
				int a =Math.abs(_random.nextInt()%52);
				this._pokerCard[i].set_shuffle(a);
			}		
		}
		sortbyshuffle(this._pokerCard);

	}
	void sortbyshuffle(Card[] card){
		for(int i =card.length-1;i>0; i--){
			for(int j = 0; j<i;j++){
				if(card[j].get_shuffle()>card[j+1].get_shuffle()){
					swap(card,j,j+1);
				}
			}
		}
	}
	void swap(Card[] card,int j, int k){
		Card tmp = card[j];
		card[j] = card[k];
		card[k] = tmp;
	}


	Card CardDraw(){
		Card drawCard;

		drawCard = this._pokerCard[getPickNumber()];

		this._pokerCard[getPickNumber()].CardDelete();
		setPickNumber(getPickNumber() + 1);
		return drawCard;
	}
	public int getPickNumber() {
		return pickNumber;
	}
	public static void setPickNumber(int pickNumber) {
		Deck.pickNumber = pickNumber;
	}
}
