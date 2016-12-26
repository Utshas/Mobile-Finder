package com.example.mobile_finder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class recieve extends BroadcastReceiver{
String messagebox;
MediaPlayer mp;
SharedPreferences sp;
String ring;
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle=intent.getExtras();
		sp=context.getSharedPreferences("Mypref", 0);
		ring=sp.getString("ki", null);
		Object[] messages=(Object[])bundle.get("pdus");
		SmsMessage[]sms=new SmsMessage[messages.length];
		for(int n=0;n<messages.length;n++)
		{
			sms[n]=SmsMessage.createFromPdu((byte[])messages[n]);
		}
		
		for(SmsMessage msg:sms)
		{
			if(msg.getMessageBody().equalsIgnoreCase(ring))
			{
				Intent i=new Intent(context,mservice.class);
				context.startService(i);
			}
		}
	}
	
}
