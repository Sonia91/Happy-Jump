package tw.edu.ntut.csie.game;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class GameMap implements GameObject{
	private MovingBitmap blue;
	private MovingBitmap green;
	private int[][] map ={{1,2,1,2},{2,1,2,1},{0,1,0,1},
						  {2,0,2,0},{1,2,1,2}};
	private final int X=100;
	private final int Y=60;
	
	private final int MW=70;
	private final int MH=40;
	
	public GameMap(){
		blue = new MovingBitmap(R.drawable.blue);
		green = new MovingBitmap(R.drawable.green);
	}
	
	@Override
	public void release() {
		// TODO Auto-generated method stub
		blue.release();
		green.release();
		blue = null;
		green = null;
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				switch(map[i][j]){
				case 0:
					break;
				case 1:
					blue.setLocation(X+(MW*j),Y+(MH*i));
					blue.show();
					break;
				case 2:
					green.setLocation(X+(MW*j),Y+(MH*i));
					green.show();
				default:
					break;
				}
			}
		}
	}
}
