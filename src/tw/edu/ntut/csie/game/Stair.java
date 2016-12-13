package tw.edu.ntut.csie.game;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Stair  implements GameObject{
	private int x,y;
	private MovingBitmap _stair;
	public Stair(){
		_stair = new MovingBitmap(R.drawable.stair);
		_stair.resize(89, 25);
		x=0;
		y=0;
	}
	public void initialize(){
		_stair.setLocation(x, y);
	}
	public void setLocation(int _x,int _y){
		_stair.setLocation(_x, _y);
	}
	public int getX(){
		return _stair.getX();
	}
	public int getY(){
		return _stair.getY();
	}
	public int getWidth() {
		return _stair.getWidth();
	}
	public int getHeight() {
		return _stair.getHeight();
	}
	@Override
	public void release() {
		// TODO Auto-generated method stub
		_stair.release();
		_stair=null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		_stair.show();
	}

};
