package com.mcs.sumojousting.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

	GameLoop loop;
	
	public GameView(Context context) {
		super(context);
		
		loop = new GameLoop(this);
		//System.out.println("h");
	}
	
	public void doDraw(Canvas c){
		Paint p = new Paint();
		p.setColor(Color.BLUE);
		c.drawRect(new Rect(0,0,10,10), p);
		
	}
	
	public void update(){
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		//System.out.println("ahi");
		loop.setRunning(true);
		loop.start();
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		loop.setRunning(false);
	}

}
