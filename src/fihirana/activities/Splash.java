package fihirana.activities;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Timer timer = new Timer();
		timer.schedule( new TimerTask(){
		   public void run() { 
		   		startActivity(new Intent(getApplicationContext(), Home.class));
		   		finish(); //remove from the pile
		    }
		 }, 500);
	}


}
