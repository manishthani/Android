package com.example.gastos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AyudaActivity extends Activity {
	Button okButton;
	TextView helpText;
	String s = "AYUDA SOBRE EL USO DE LA APLICACIÓN \n" +
			"1.Inserte contraseña para acceder a la aplicación,\n " +
			"que es admin por defecto.\n \n" +
			"2.Una vez haya accedido a la aplicación,para añadir\n" +
			"un gasto, pulse el Botón de Añadir para insertar los\n" +
			"datos necesarios(cantidad,categoria,descripcion,\n" +
			"etc).Finalmente,pulse botón de Añadir Gasto para \n" +
			"llevar a cabo esta función.\n \n" +
			"3.Para eliminar un Gasto,marque en la lista de \n" +
			"gastos creados los que desea eliminar y pulse el\n " +
			"botón de Eliminar. Una vez pulsado,los gastos \n" +
			"seleccionados se eliminarán.\n \n" +
			"4.Para generar un fichero de texto con los gastos, \n " +
			"pulse el botón de Guardar en TXT. Posteriormente, " +
			"se le mostrará una vista previa delfichero generado\n" +
			" y verá en su carpeta SDCard un archivo llamado \n" +
			"ListaGastos.txt.Pulse Ok para volver a la \n" +
			"pantalla principal.\n \n" +
			"5.Para modificar un gasto, seleccione un gasto del\n" +
			"listado de gastos creados y sele mostrará una \n" +
			"pantalla con los datosde la última modificación.\n" +
			"Edite estos campos y pulse el botón de modificar\n" +
			"gasto para llevar a cabo esta acción.\n";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ayuda);
		okButton = (Button) findViewById(R.id.okAyudaButton);
		helpText = (TextView) findViewById(R.id.ayudaTextView);
		helpText.setMovementMethod(new ScrollingMovementMethod());
		
		
		helpText.setText(s);
		
		okButton.setOnClickListener(new Button.OnClickListener() {
			//Modify Database
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), IntroductionActivity.class);
				startActivityForResult(myIntent,0);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ayuda, menu);
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
	    Intent intent = new Intent(AyudaActivity.this, IntroductionActivity.class);
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	    startActivity(intent); 
	    finish();

	}
}
