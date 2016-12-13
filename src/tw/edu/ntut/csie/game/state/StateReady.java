
package tw.edu.ntut.csie.game.state;

import java.util.HashMap;
import java.util.Map;

import tw.edu.ntut.csie.game.BestInteger;
import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.Stair;
import tw.edu.ntut.csie.game.leadingRole;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;
import tw.edu.ntut.csie.game.extend.Integer;
import tw.edu.ntut.csie.game.state.AbstractGameState;

public class StateReady extends AbstractGameState {

	private MovingBitmap _under;
	private MovingBitmap _role;
	private int _rx;
	
	private MovingBitmap _aboutInfo;
	private BitmapButton _aboutButton;
	private MovingBitmap _helpInfo;
	private BitmapButton _helpButton;
	private BitmapButton _backButton;
	private MovingBitmap _best;
	
	private MovingBitmap _background;	
	private MovingBitmap _title;
	private Animation _tap;
	private MovingBitmap _tapFrame1;
	private MovingBitmap _tapFrame2;
	private MovingBitmap _tapFrame3;
	private MovingBitmap _tapFrame4;

	private BitmapButton _startButton;
	
	private boolean _showHelp;
	private boolean _showAbout;
	
	private int _score_digit = 4;
	private BestInteger _scores;
	private int _score;

	public StateReady(GameEngine engine) {
		super(engine);
	}

	@Override
	public void initialize(Map<String, Object> data) {
		_score = (java.lang.Integer)data.get("bestScore");
		addGameObject(_scores = new BestInteger(_score_digit, _score, 125, 35));
		
		addGameObject(_helpInfo = new MovingBitmap(R.drawable.helpinfo));
		_helpInfo.resize(385, 660);
		_helpInfo.setLocation(-4, -15);
		addGameObject(_aboutInfo = new MovingBitmap(R.drawable.aboutinfo));
		_aboutInfo.resize(385, 660);
		_aboutInfo.setLocation(-4, -15);
		
		
		addGameObject(_background = new MovingBitmap(R.drawable.background));
		_background.resize(410, 681);
		_background.setLocation(-4, -15);

		addGameObject(_under = new MovingBitmap(R.drawable.under));
		_under.resize((int)(_under.getWidth()*0.64), (int)(_under.getHeight()*0.64));
		_under.setLocation((376/2)-(_under.getWidth()/2), 640-_under.getHeight()+27);
		
		
		addGameObject(_role = new MovingBitmap(R.drawable.jelly));
		_role.resize((int)(_role.getWidth()*0.6), (int)(_role.getHeight()*0.6));
		_role.setLocation(188-(_role.getWidth()/2), _under.getY()-_role.getHeight()+6);
		_rx = 188-(_role.getWidth()/2);
		

		addGameObject(_title = new MovingBitmap(R.drawable.happyjump));
		_title.resize((int)(_title.getWidth()*1.1),(int)( _title.getHeight()*1.1 ));
		_title.setLocation(-10, 70);
		
		addGameObject(_best = new MovingBitmap(R.drawable.best));
		_best.resize((int)(_best.getWidth()*0.5), (int)(_best.getHeight()*0.5));
		_best.setLocation(150, 0);
		
		
		_tapFrame1 = new MovingBitmap(R.drawable.tap_to_play);
		_tapFrame1.resize((int)(_tapFrame1.getWidth()*0.63), (int)(_tapFrame1.getHeight()*0.63));
		_tapFrame2 = new MovingBitmap(R.drawable.tap_to_play_visible_75); 
		_tapFrame2.resize((int)(_tapFrame2.getWidth()*0.63), (int)(_tapFrame2.getHeight()*0.63));
		_tapFrame3 = new MovingBitmap(R.drawable.tap_to_play_visible);
		_tapFrame3.resize((int)(_tapFrame3.getWidth()*0.63), (int)(_tapFrame3.getHeight()*0.63));
		_tapFrame4 = new MovingBitmap(R.drawable.tap_to_play_visible_75); 
		_tapFrame4.resize((int)(_tapFrame4.getWidth()*0.63), (int)(_tapFrame4.getHeight()*0.63));
		
		addGameObject(_tap = new Animation());
		_tap.addFrame(_tapFrame1);
		_tap.addFrame(_tapFrame2);
		_tap.addFrame(_tapFrame3);
		_tap.addFrame(_tapFrame4);
		_tap.setLocation(61, 425);
		_tap.setDelay(3);	

		
		initializeStartButton();
		initializeBackButton();
		initializeHelpButton();
		initializeAboutButton();
		setVisibility(false, false);
	}
	
	/* (non-Javadoc)
	 * @see tw.edu.ntut.csie.game.state.AbstractGameState#show()
	 */
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		_scores.show();
	}
	
	// 初始化『About』的按鈕。
	// 開發簡介
	private void initializeAboutButton() {
		addGameObject(_aboutButton = new BitmapButton(R.drawable.abouthappy, R.drawable.abouthappy2, 10, 10));
		_aboutButton.addButtonEventHandler(new ButtonEventHandler() {
			@Override
			public void perform(BitmapButton button) {
				setVisibility(false, true);
			}
		});
		addPointerEventHandler(_aboutButton);
	}
 
	// 初始化『Help』的按鈕。
	// 遊戲說明
	private void initializeHelpButton() {
		addGameObject(_helpButton = new BitmapButton(R.drawable.helphappy, R.drawable.helphappy2, 262, 10));
		_helpButton.addButtonEventHandler(new ButtonEventHandler() {
			@Override
			public void perform(BitmapButton button) {
				setVisibility(true, false);
			}
		});
		addPointerEventHandler(_helpButton);
	}
	
	// 初始化『Back』的按鈕。
	private void initializeBackButton() {
		addGameObject(_backButton = new BitmapButton(R.drawable.backhappy, R.drawable.backhappy2, 220, 520));
		_backButton.addButtonEventHandler(new ButtonEventHandler() {
			@Override
			public void perform(BitmapButton button) {
				setVisibility(false, false);
			}
		});
		addPointerEventHandler(_backButton);
	}
	
	// 初始化『Start』的按鈕。 
	private void initializeStartButton() {
		addGameObject(_startButton = new BitmapButton(R.drawable.backgroundtransparent, R.drawable.backgroundtransparent, -4, 325));//, 386, 150));//642));
		_startButton.addButtonEventHandler(new ButtonEventHandler() {
			@Override
			public void perform(BitmapButton button) {
				Map<String, Object> paras = new HashMap<String, Object>();
				paras.put("jellyLocation", _role.getX());
				paras.put("bestScore", _score);
				changeState(Game.RUNNING_STATE,  paras);
			}
		});
		addPointerEventHandler(_startButton);
	}

	
	@Override
	public void pause() {}

	@Override
	public void resume() {}

	/** 設定畫面上那些圖片該顯示，那些圖片該隱藏。
	 * 
	 * @param showHelp 顯示Help畫面
	 * @param showAbout 顯示About畫面
	 */
	private void setVisibility(boolean showHelp, boolean showAbout) {
		
		_showHelp = showHelp;
		_showAbout = showAbout;
		
		boolean showMenu = !_showAbout && !_showHelp;
		
		_helpInfo.setVisible(_showHelp);
		_aboutInfo.setVisible(_showAbout);
		
		_background.setVisible(showMenu);
		_startButton.setVisible(showMenu);
		_best.setVisible(showMenu);
		
		_title.setVisible(showMenu);
		_tap.setVisible(showMenu);
		_under.setVisible(showMenu);
		_role.setVisible(showMenu);
		
		_helpButton.setVisible(showMenu);
		_aboutButton.setVisible(showMenu);
		_backButton.setVisible(!showMenu);
	}
	
	
	public void orientationChanged(float pitch, float azimuth, float roll) {
		if(roll > 1 && roll < 90 ){
			if(_rx > 0-_role.getWidth()){
				_rx -= (int)((Math.sqrt(roll))*2);
			}else{
				_rx = 376;
			}
		}
		if(roll < -1 && roll > -90 ){
			if(_rx < 376){
				_rx += (int)((Math.sqrt(-(roll)))*2);
			}else{
				_rx = 0-_role.getWidth();
			}
		}
		_role.setLocation(_rx, _role.getY());
	}

}
