package com.example.gastos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TxtFileActivity extends Activity {
	 TextView myText;
	 Button ok;
	 int data_block = 100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_txt_file);
		myText = (TextView) findViewById(R.id.txtFileView);
		myText.setMovementMethod(new ScrollingMovementMethod());
		ok = (Button) findViewById(R.id.OkButton);
		
		
		
		try {
			FileInputStream fis = openFileInput("ListaGastos.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			int size;
			char[] data = new char[data_block];
			String final_data = "";
			
			while((size = isr.read(data)) > 0 ){
				String read_data = String.copyValueOf(data, 0, size);
				final_data += read_data;
				data = new char[data_block];
			}
			myText.setText(final_data);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ok.setOnClickListener(new Button.OnClickListener() {
			//Modify Database
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(myIntent,0);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.txt_file, menu);
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
}
