package com.example.gastos;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class ModificarGastoActivity extends Activity {
	static final int dialog_id = 1;
	Integer yr, day, month;
	
	Spinner categorySpinner;
	EditText description,euroText;
	TextView dateText2;
	Button modificarFinalButton;
	
	DataHandler handler;
	
	String[] passedValue;
	Gasto gOld; 
	
	private int getIndexSpinner(String initialCategory){
		
		int size = categorySpinner.getCount();
		int i = 0;
		int index = 0;
		boolean stop = false;
		for(i = 0; i < size && !stop; ++i){
			if(categorySpinner.getItemAtPosition(i).equals(initialCategory)){
				stop = true;
				index = i;
			}
		}
		return index;
	}
	
	private void initSpinner(String initialCategory){
		categorySpinner = (Spinner) findViewById(R.id.categoriaSpinner2);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.category_array, android.R.layout.simple_spinner_item);
		
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter2);
		
		categorySpinner.setSelection(getIndexSpinner(initialCategory));
		
	}
	
	
	private void initButton(){
		 modificarFinalButton= (Button) findViewById(R.id.anadirFinalButton2);
		
		 modificarFinalButton.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				String cantidad = euroText.getText().toString();  
				double aux = 0.00;
				try{
					aux = Double.parseDouble(cantidad);
					
					cantidad = String.valueOf(aux);
					
				}catch(Exception e){
					Toast.makeText(getBaseContext(), "Error:Cantidad no valida", Toast.LENGTH_LONG).show();
				}
				if(aux == 0.00) Toast.makeText(getBaseContext(), "Error:Cantidad tiene que ser mayor que 0", Toast.LENGTH_LONG).show();
				else if(((aux*100) - Math.floor(aux*100)) > 0 ) Toast.makeText(getBaseContext(), "Error:Cantidad ha de tener máx. 2 decimales!", Toast.LENGTH_LONG).show();
				else {
					String descripcion = description.getText().toString();
					String categoria = categorySpinner.getSelectedItem().toString();
					String fecha[] = dateText2.getText().toString().split("/");
				
					//PUT DATA TO INSERT
					handler = new DataHandler(getBaseContext());
					handler.open();
					//Gasto(String cantidad, String descripcion, String categoria, String dia, String mes, String ano, String hora, String minuto, String segundo){
					//long id = handler.insertData(cantidad, descripcion, categoria, fecha[0], fecha[1], fecha[2],hour.toString(), minute.toString(), second.toString());
					Gasto g = new Gasto(cantidad, descripcion, categoria, fecha[0], fecha[1], fecha[2], gOld.getHora(), gOld.getMinuto(), gOld.getSegundo());
				
					handler.updateRow(g,gOld);
					//TOAST
					Toast.makeText(getBaseContext(), "Gasto modificado!", Toast.LENGTH_LONG).show();
					//handler.close();
				}
			}
			
		});	
	}
	
	private void initEditText(String initialQuantity, String initialDescription){
		description = (EditText) findViewById(R.id.descripcionText2);
		euroText = (EditText) findViewById(R.id.euroText2);
		euroText.setText(initialQuantity);
		description.setText(initialDescription);
	}
	
	private void initTextView(){
		dateText2 = (TextView) findViewById(R.id.fechaTextMod);
	}
	
	private void initialize(){
		passedValue = getIntent().getStringExtra("GastoAModificar").split("/");
		gOld = new Gasto (passedValue[0],passedValue[1],passedValue[2],passedValue[3],passedValue[4],passedValue[5],passedValue[6],passedValue[7],passedValue[8]);
		initSpinner(passedValue[2]);
		initTextView();
		initButton();
		initEditText(passedValue[0],passedValue[1]);
		dateText2.setText(passedValue[3] + " / " +  passedValue[4] + " / " + passedValue[5]);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modificar_gasto);
		initialize();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modificar_gasto, menu);
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
