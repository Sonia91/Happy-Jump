package tw.edu.ntut.csie.game;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Practice implements GameObject{
	private MovingBitmap mPractice;
	private int px,py;

	public Practice(){
		mPractice = new MovingBitmap(R.drawable.image);
		px=250;
		py=50;
	}
	
	public  void initialize(){
		mPractice.setLocation(px, py);	
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
		mPractice.release();
		mPractice=null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(px<350){
			px+=5;
		}else{
			py+=5;
		}
		mPractice.setLocation(px, py);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		mPractice.show();
	}


};
