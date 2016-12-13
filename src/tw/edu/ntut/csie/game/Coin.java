package tw.edu.ntut.csie.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Coin implements GameObject  {
	private int coinType;
	private MovingBitmap[] _coin;
	private MovingBitmap _topCoin;
	private MovingBitmap _buttomCoin;
	
	public Coin(){
		coinType = 0;
		_coin = new MovingBitmap[100];
		for(int i=0; i<100; i++){
			_coin[i] = new MovingBitmap(R.drawable.coin);
			_coin[i].resize( (int)(_coin[i].getWidth()*0.6), (int)(_coin[i].getHeight()*0.6) );
		}
		_topCoin = new MovingBitmap(R.drawable.coin);
		_buttomCoin = new MovingBitmap(R.drawable.coin);
		
	}

	public void setCoinType(int coinType, int topStairY){
		this.coinType = coinType;
		switch(coinType){
			case 1:
				creatLineCoin(topStairY);
				break;
			case 2:
				creatSquareCoin(topStairY);
				break;
			default:
		}
	}
	
	public void creatLineCoin(int topStairY){
		int xLocation=(int)(Math.random()*175)+50;
		int i;
		for(i=0 ;i<20;i++){
			_coin[i].setLocation(xLocation, topStairY - _coin[i].getHeight() - 50 - (26*i));//���Z26
		}
		_topCoin = _coin[i-1];
		_buttomCoin = _coin[0];
	}
	
	public void creatSquareCoin(int topStairY){
		for(int i=0; i<9; i++){
			int xLocation=(int)(Math.random()*155)+50;
			for(int j=0; j<9; j++){
				_coin[ (i*9) + j ].setLocation(xLocation + ((int)(j%3))*26 ,
										topStairY - _coin[i].getHeight() - ((int)(j/3))*26 - i*150);
			}
		}
		_topCoin = _coin[ 81-1 ];
		_buttomCoin = _coin[0];
	}
	
	public MovingBitmap getTopCoin(){
		return this._topCoin;
	}
	
	public MovingBitmap getButtomCoin(){
		return this._buttomCoin;
	}
	
	public int size(){
		int size = 0;
		if(coinType == 1)	size = 20;
		else if(coinType == 2)	size = 81;
		return size;
	}
	
	public void setLocation(int index, int x, int y){
		_coin[index].setLocation(x, y);
	}
	
	public int getX(int index){
		return _coin[index].getX();
	}
	
	public int getY(int index){
		return _coin[index].getY();
	}
	public MovingBitmap getCoin(int index){
		return _coin[index];
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++){
			_coin[i].release();
			_coin[i]=null;
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		for(int i=0; i<this.size(); i++){
			_coin[i].show();
		}
	}

}
