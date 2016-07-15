import javax.swing.TransferHandler.TransferSupport;



public class minimumHeap {

	Entry[] _table;
	trecord heap;
	public minimumHeap(Entry[] table){
		this._table=table;
		heap = new trecord();
		sort();
		for(int i =0; i<table.length;i++){
//			heap.add(table[i]);
		}
	
	}
	public trecord remove(){
		return null;
	}
	public void Queue(){
		for(int i=0; i<_table.length; i++){
			
		}
	}
	
	public void sort(){
		for(int i=0;i +1<this._table.length;i++){
						
			for(int j =0;j+1<this._table.length;j++){
				if((this._table[j].getFreq()<this._table[j+1].getFreq())){
				Entry temp= this._table[j+1];
				this._table[j+1]=this._table[j];
				this._table[j]=temp;
				}
			}
			
		}
	}

}
