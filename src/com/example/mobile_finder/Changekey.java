package com.example.mobile_finder;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Changekey extends Activity implements OnClickListener{
EditText ekey;
TextView key;
Button b1;
SharedPreferences sp;
public static String s="sup";
public static String ring;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_changekey);
		ekey=(EditText)findViewById(R.id.ekey);
		key=(TextView)findViewById(R.id.key);
		b1=(Button)findViewById(R.id.b1);
		b1.setOnClickListener(this);
		sp=getApplicationContext().getSharedPreferences("Mypref", 0);
		ring=sp.getString("ki", null);
		key.setText("_"+ring+"_");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.changekey, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		String k=ekey.getText().toString();
		if(k.length()<16)
		{sp=getApplicationContext().getSharedPreferences("Mypref", 0);
		Editor editor=sp.edit();
		editor.putString("ki",k);
		editor.commit();
		ring=sp.getString("ki", null);
		key.setText("_"+ring+"_");}
		else
			Toast.makeText(getApplicationContext(), "Your key must not be greater than 15 letters", Toast.LENGTH_LONG).show();
	}

}
