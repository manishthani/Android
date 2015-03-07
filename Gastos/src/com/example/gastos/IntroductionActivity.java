package com.example.gastos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntroductionActivity extends Activity {
	Button loginButton, helpButton; 
	EditText passwordText;
	String password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduction);
		loginButton = (Button) findViewById(R.id.loginButton);
		helpButton = (Button) findViewById(R.id.ayudaButton);
		passwordText = (EditText) findViewById(R.id.contrasenaEdit);
		
		loginButton.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				if(passwordText.getText().toString().equals("admin")){
					Intent myIntent = new Intent(v.getContext(), MainActivity.class);
					startActivityForResult(myIntent,0);
				}
				else {
					Toast.makeText(getBaseContext(), "Contraseña incorrecta!",Toast.LENGTH_LONG).show();
					passwordText.setText("");
				}
			}
			
		});
		
		helpButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), AyudaActivity.class);
				startActivityForResult(myIntent,0);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.introduction, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onBackPressed() {
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
	}
}
