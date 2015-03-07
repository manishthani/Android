package com.example.gastos;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.Data;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	Spinner monthSpinner, yearSpinner;
	Button addButton, deleteButton,generateTXTButton;
	ListView list;
	DataHandler handler;
	ArrayAdapter<Gasto> adapt;
	ArrayList<Gasto> listaGastosGlobal;
	TextView grandTotalText;
	
	Double grandTotal = 0.0;
	//Funcion para generar txt
	
	
	public void initTextViews(){
		grandTotalText = (TextView) findViewById(R.id.totalGastoText);
	}
	
	private void initButtons(){
		addButton = (Button) findViewById(R.id.anadir);
		
		deleteButton = (Button) findViewById(R.id.eliminar);
		//myTestButton.setBackgroundColor(Color.RED);
		generateTXTButton = (Button) findViewById(R.id.guardarEnTxt);
		
		generateTXTButton.setOnClickListener(new Button.OnClickListener() {
			//Modify Database
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<Gasto> listaGasto = new ArrayList<Gasto>(getGastos());
				String s = "";
				for(Gasto i : listaGasto){
					s += i.getCantidad() + "€ " + i.getDescripcion() + "  " + i.getCategoria() + "  " + i.getDia() + "/" + i.getMes() + "/" + i.getAno() + "  " + i.getHora() + ":" + i.getMinuto() + ":" + i.getSegundo() + "\n"; 
				}
				try {
					FileOutputStream fou = openFileOutput("ListaGastos.txt",MODE_WORLD_READABLE);
					OutputStreamWriter osw = new OutputStreamWriter(fou);
					osw.write(s);
					osw.flush();
					osw.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Intent myIntent = new Intent(getBaseContext(), TxtFileActivity.class);
				startActivityForResult(myIntent,0);
			}
		});
		
		deleteButton.setOnClickListener(new Button.OnClickListener() {
			//Swap to another Activity
			@Override
			
			public void onClick(View v) {
				ArrayList<Gasto> removeGastos = new ArrayList<Gasto>();
                 for(Gasto i : listaGastosGlobal){
                	 if(i.isSelected()) {
                		 removeGastos.add(i);
                	 }
                 }
                 
                handler.deleteRows(removeGastos);
                if(removeGastos.isEmpty()) Toast.makeText(getBaseContext(), "No hay gastos seleccionados a eliminar!", Toast.LENGTH_LONG).show();
                else Toast.makeText(getBaseContext(), "Gastos seleccionados eliminados de la Lista!", Toast.LENGTH_LONG).show();
 				onResume();
			}
		});
		addButton.setOnClickListener(new Button.OnClickListener() {
			//Modify Database
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), AnadirGastoActivity.class);
				startActivityForResult(myIntent,0);
				
			}
		});
	}
	
	void initListViews(){
		list = (ListView) findViewById(R.id.listaGastos);
		
	}
	
	private void initialize() {
		initButtons();
		initListViews();
		initTextViews();
	}
	
	public boolean getMaxDate(Gasto i, Gasto j){
		if(Integer.parseInt(i.getAno()) > Integer.parseInt(j.getAno())) return true;
		else if( Integer.parseInt(i.getAno()) < Integer.parseInt(j.getAno())) return false;
		else {
			if(Integer.parseInt(i.getMes()) > Integer.parseInt(j.getMes())) return true;
			else if(Integer.parseInt(i.getMes()) < Integer.parseInt(j.getMes())) return false;
			else{
				if(Integer.parseInt(i.getDia()) > Integer.parseInt(j.getDia())) return true;
				else if(Integer.parseInt(i.getDia()) < Integer.parseInt(j.getDia())) return false;
				else{
					if(Integer.parseInt(i.getHora()) > Integer.parseInt(j.getHora())) return true;
					else if(Integer.parseInt(i.getHora()) < Integer.parseInt(j.getHora())) return false;
					else{
						if(Integer.parseInt(i.getMinuto()) > Integer.parseInt(j.getMinuto())) return true;
						else if(Integer.parseInt(i.getMinuto()) < Integer.parseInt(j.getMinuto())) return false;
					}
				}
			}
		}
		return true;
	}
	
	public ArrayList<Gasto> getGastos(){
		ArrayList<Gasto> listaGastosAux = new ArrayList<Gasto>();
		
		handler = new DataHandler(getBaseContext());
		handler.open();
		Cursor C = handler.returnAllOrdered();
		if(C.moveToFirst()){
			do{
		        listaGastosAux.add(new Gasto(C.getString(0),C.getString(1), C.getString(2),C.getString(3),C.getString(4),C.getString(5),C.getString(6),C.getString(7),C.getString(8)));			
			} while(C.moveToNext());
		}
		
		return listaGastosAux;
		
	}
	
	
	public void assignGrandTotal(){
		for(Gasto i : getGastos()){
			grandTotal += Double.parseDouble(i.getCantidad());
		}
		grandTotal = (double) Math.round(grandTotal * 1000.0);
		grandTotal = grandTotal/1000.0;
		String aux = String.valueOf(grandTotal);
		grandTotalText.setText("€ " + aux );
		grandTotal = 0.0;
	}
	
	protected void onResume(){
		super.onResume();

		listaGastosGlobal = getGastos();
		assignGrandTotal();
		adapt = new AdapterList(this,listaGastosGlobal);
	
        list.setAdapter(adapt);

        list.setOnItemClickListener(new OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Gasto elegido = (Gasto) pariente.getItemAtPosition(posicion); 
                String stringGasto = elegido.toString();
                Intent myIntent = new Intent(getBaseContext(), ModificarGastoActivity.class);
                myIntent.putExtra("GastoAModificar",stringGasto);
				startActivityForResult(myIntent,0);
            }
         });
	  	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void onBackPressed()
	{
	    super.onBackPressed(); 
	    Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	    startActivity( intent ); 
	    finish();

	}

}
