package com.mcs.sumojousting;

import android.app.Activity;
import android.os.Bundle;

import com.mcs.sumojousting.graphics.GameView;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
        System.out.println("hi");
       
    }


   

}
