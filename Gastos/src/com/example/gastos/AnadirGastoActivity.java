package com.example.gastos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class AnadirGastoActivity extends Activity {
	static final int dialog_id = 1;
	Integer yr, day, month;
	
	Spinner categorySpinner;
	EditText description,euroText;
	TextView dateText;
	Button addFinalButton;

	DataHandler handler;
	
	private void initSpinner(){
		categorySpinner = (Spinner) findViewById(R.id.categoriaSpinner);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.category_array, android.R.layout.simple_spinner_item);
		
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter2);
		
	}
	
	public boolean checkDouble(String s){
		boolean point = false;
		int numDecimal = 0;
		for(int i = 0; i < s.length(); ++i){
			if(point){
				++numDecimal;
				if(s.charAt(i) != '0' && numDecimal > 2) return false;
			}
			if(s.charAt(i) == '.') point = true;
		}
		return true;
	}
	
	private void initButton(){
		addFinalButton = (Button) findViewById(R.id.anadirFinalButton);
		
		addFinalButton.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				String cantidad = euroText.getText().toString();
				String cantidadAux = euroText.getText().toString();
				Double aux = 0.00;
				try{
					aux = Double.parseDouble(cantidad);
					
					cantidad = String.valueOf(aux);
					cantidadAux = String.valueOf(aux*100);
					
				}catch(Exception e){
					Toast.makeText(getBaseContext(), "Error:Cantidad no valida", Toast.LENGTH_LONG).show();
				}
				if(aux == 0.00) Toast.makeText(getBaseContext(), "Error:Cantidad tiene que ser mayor que 0", Toast.LENGTH_LONG).show();
				else if(!checkDouble(cantidad) ) Toast.makeText(getBaseContext(), "Error:Cantidad ha de tener máx. 2 decimales!", Toast.LENGTH_LONG).show();
				else {
					String descripcion = description.getText().toString();
				
					String categoria = categorySpinner.getSelectedItem().toString();
					String fecha[] = dateText.getText().toString().split("/");
				
					Calendar today = Calendar.getInstance();
					Integer hour = today.get(Calendar.HOUR_OF_DAY);
					Integer minute = today.get(Calendar.MINUTE);
					Integer second = today.get(Calendar.SECOND);
				
					//PUT DATA TO INSERT
					handler = new DataHandler(getBaseContext());
					handler.open();
				
					long id = handler.insertData(cantidad, descripcion, categoria, fecha[0], fecha[1], fecha[2],hour.toString(), minute.toString(), second.toString());
				//TOAST
					Toast.makeText(getBaseContext(), "Gasto anadido a la Lista!", Toast.LENGTH_LONG).show();
					handler.close();
			        
					euroText.setText("");
					description.setText("");
					categorySpinner.setSelection(0);
					
				}
			}
		});	
	}
	
	
	
	private void initEditText(){
			description = (EditText) findViewById(R.id.descripcionText);
			description.setMovementMethod(new ScrollingMovementMethod());
			euroText = (EditText) findViewById(R.id.euroText);
			euroText.setText("");
		
		
	
	}
	
	private void initTextView(){
		dateText = (TextView) findViewById(R.id.fechaText);
		dateText.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(dialog_id);
			}
			
		});
		
	}
	
	private void initialize(){
		initSpinner();
		initButton();
		initEditText();
		initTextView();
		Calendar today = Calendar.getInstance();
		yr = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH);
		day = today.get(Calendar.DAY_OF_MONTH);
		dateText.setText(day + "/" +  (month+1) + "/" + yr);
	
	}
	
	protected Dialog onCreateDialog(int id){
		switch (id)
		{
		case dialog_id:
			return new DatePickerDialog(this, mDateSetListener2,yr, month, day);
		}	
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener2 = 
			new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
					// TODO Auto-generated method stub
					yr = year;
					month = monthOfYear;
					day  = dayOfMonth;
					dateText.setText(day + "/" +  (month+1) + "/" + yr);
				}
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anadir_gasto);
		initialize();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.anadir_gasto, menu);
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
