package com.mcs.sumojousting.graphics;

import android.graphics.Canvas;

public class GameLoop extends Thread {
       private GameView view;
       private boolean running = false;
       private static int FPS = 10;
      
       public GameLoop(GameView view) {
             this.view = view;
             view.getHolder().addCallback(view);
       }
 
       public void setRunning(boolean run) {
             running = run;
       }
 
       public void run() {
           long ticksPS = 1000 / FPS;
           long startTime;
           long sleepTime;
           while (running) {
                  Canvas c = null;
                  startTime = System.currentTimeMillis();
                  try {
                         c = view.getHolder().lockCanvas();
                         synchronized (view.getHolder()) {
                                view.doDraw(c);
                         }
                  } finally {
                         if (c != null) {
                                view.getHolder().unlockCanvasAndPost(c);
                         }
                  }
                  sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
                  try {
                         if (sleepTime > 0)
                                sleep(sleepTime);
                         else
                                sleep(10);
                  } catch (Exception e) {}
           }
     }
}  
