package fihirana.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Home extends Activity {
	private boolean back_answer = false;


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		super.onCreateOptionsMenu(menu);
		return true;
	}
	
	@Override //on backTouch press --> dialog are u sure ?
	public boolean onKeyDown (int keyCode, KeyEvent event){
		if (keyCode == KeyEvent.KEYCODE_BACK) {
		    AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setMessage("Etes vous sûr de vouloir quitter ?")
	               .setCancelable(false)
	               .setPositiveButton("Oui", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
	               })
	               .setNegativeButton("Non", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							back_answer = false;
						}
	              });
	         AlertDialog alert = builder.create();
	         alert.show();
		}
        return back_answer;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		//handle menu action
		switch(item.getItemId()){
			case R.id.preferences:
				startActivity(new Intent(getApplicationContext(), Settings.class));
				return true;
			case R.id.exit:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
		
	}

}
