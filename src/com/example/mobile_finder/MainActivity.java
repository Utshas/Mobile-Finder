package com.example.mobile_finder;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button b,c;
	static TextView messagebox;
	static MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		messagebox=(TextView)findViewById(R.id.textView1);
		mp=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==R.id.ab)
		{AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Mobile Finder");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("This app was developed by \n Ahmed Mahir Tazwar.\n");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(getApplicationContext(), "Thanx for using this app", Toast.LENGTH_SHORT ).show();
			}
		});
		AlertDialog simpleDialog=builder.create();
		simpleDialog.show();
		}
		else
		{
			Intent i=new Intent(MainActivity.this,Changekey.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stopService(new Intent(this,mservice.class));	

	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1)
		{
		mp.stop();
		stopService(new Intent(this,mservice.class));	
		}
	}
}
