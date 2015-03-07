package com.example.gastos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler {
	
	public static final String CANTIDAD = "cantidad";
	public static final String DESCRIPCION = "descripcion";
	public static final String CATEGORIA = "categoria";
	public static final String DIA = "dia";
	public static final String MES = "mes";
	public static final String ANO = "ano";
	public static final String HORA = "hora";
	public static final String MINUTO = "minuto";
	public static final String SEGUNDO = "segundo";

	
	public static final String TABLE_NAME= "gasto";
	public static final String DATA_BASE_NAME="dbgasto";
	public static final int DATABASE_VERSION = 2;
	
	public static final String TABLE_CREATE ="create table gasto (cantidad text not null, descripcion text not null, categoria text not null, dia text not null, mes text not null, ano text not null,hora text not null, minuto text not null,segundo text not null)";
	
	
	DataBaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
	
	public DataHandler(Context ctx){
		this.ctx = ctx;
		dbhelper = new DataBaseHelper(ctx);
		
	}
	
	private static class DataBaseHelper extends SQLiteOpenHelper {

		public DataBaseHelper(Context ctx){
			super(ctx,DATA_BASE_NAME,null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			try{
				db.execSQL(TABLE_CREATE);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS gasto");
			onCreate(db);
		}
	}
	public DataHandler open(){
		db = dbhelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbhelper.close();
	}
	
	public long insertData(String cantidad, String descripcion, String categoria, String dia, String mes, String ano, String hora, String minuto, String segundo){
		ContentValues content = new ContentValues();
		content.put(CANTIDAD, cantidad);
		content.put(DESCRIPCION, descripcion);
		content.put(CATEGORIA, categoria);
		content.put(DIA, dia);
		content.put(MES, mes);
		content.put(ANO, ano);
		content.put(HORA,hora);
		content.put(MINUTO, minuto);
		content.put(SEGUNDO, segundo);
		
		return db.insertOrThrow(TABLE_NAME, null, content);
	}
	
	public Cursor returnAll(){
		return db.query(TABLE_NAME,  new String[] {CANTIDAD, DESCRIPCION, CATEGORIA, DIA, MES, ANO,HORA, MINUTO, SEGUNDO}, null, null, null, null, null);
	}
	
	public Cursor returnAllOrdered(){
		return db.rawQuery("SELECT * FROM gasto ORDER BY ANO,MES,DIA DESC", null);
	}
	
	public void updateRow(Gasto gNew, Gasto gOld){
		ContentValues cv = new ContentValues();
		cv.put("CANTIDAD",gNew.getCantidad()); //These Fields should be your String values of actual column names
		cv.put("DESCRIPCION",gNew.getDescripcion());
		cv.put("CATEGORIA",gNew.getCategoria());
		cv.put("DIA",gNew.getDia());
		cv.put("MES",gNew.getMes());
		cv.put("ANO",gNew.getAno());
		cv.put("HORA",gNew.getHora());
		cv.put("MINUTO",gNew.getMinuto());
		cv.put("SEGUNDO",gNew.getSegundo());
		db.update(TABLE_NAME, cv, "cantidad =? AND descripcion=? AND categoria=? AND dia=? AND mes=? AND ano=? AND hora=? AND minuto=? AND segundo=?", new String[] {gOld.getCantidad(),gOld.getDescripcion(),gOld.getCategoria(),gOld.getDia(),gOld.getMes(),gOld.getAno(),gOld.getHora(),gOld.getMinuto(),gOld.getSegundo()});
	}
	public void deleteRows(ArrayList<Gasto> g){
		//TODO
		for(Gasto gOld : g) db.delete(TABLE_NAME, "cantidad =? AND descripcion=? AND categoria=? AND dia=? AND mes=? AND ano=? AND hora=? AND minuto=? AND segundo=?", new String[] {gOld.getCantidad(),gOld.getDescripcion(),gOld.getCategoria(),gOld.getDia(),gOld.getMes(),gOld.getAno(),gOld.getHora(),gOld.getMinuto(),gOld.getSegundo()});
	}
	/*public void setCheck(Gasto gOld , boolean isSelected){
		ContentValues cv = new ContentValues();
		cv.put("SELECTED",isSelected);
		db.update(TABLE_NAME, cv, "cantidad =? AND descripcion=? AND categoria=? AND dia=? AND mes=? AND ano=? AND hora=? AND minuto=? AND segundo=?", new String[] {gOld.getCantidad(),gOld.getDescripcion(),gOld.getCategoria(),gOld.getDia(),gOld.getMes(),gOld.getAno(),gOld.getHora(),gOld.getMinuto(),gOld.getSegundo()});
	}*/
}
