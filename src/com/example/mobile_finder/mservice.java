package com.example.mobile_finder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class mservice extends Service{
	static MediaPlayer mp;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AudioManager a=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
		a.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		a.setStreamVolume(AudioManager.STREAM_MUSIC, 15,0);
		mp=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
		mp.start();
		mp.setLooping(true);
		Intent in=new Intent(this,MainActivity.class);
		in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(in);
	}
	


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mp.stop();
	}
	
	

}
