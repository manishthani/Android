package com.example.gastos;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class AdapterList extends ArrayAdapter<Gasto> {
 
    private final List<Gasto> list;
    private final MainActivity context;
 
    public AdapterList(Activity context, ArrayList<Gasto> listaDatos) {
        super(context, R.layout.entry, listaDatos);
        this.context = (MainActivity)context;
        this.list = listaDatos;
    }
 
    static class ViewHolder {
        protected TextView text, subRight, subLeft;
        protected CheckBox checkbox;
    }
    
    public void startModifyActivity(){
      
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.entry, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.textView_superior);
            viewHolder.text.setTextColor(Color.BLACK);
            viewHolder.subLeft = (TextView) view.findViewById(R.id.fechaItem);
            viewHolder.subLeft.setTextColor(Color.GRAY);
            viewHolder.subRight = (TextView) view.findViewById(R.id.categoriaItem);
            viewHolder.checkbox = (CheckBox) view.findViewById(R.id.checkBox1);
            
            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                            Gasto element = (Gasto) viewHolder.checkbox.getTag();
                            element.setSelected(buttonView.isChecked());
                      
                            Log.d("Gastos","Checked : " + element.getCantidad());    
                        }
                    });
            view.setTag(viewHolder);
            viewHolder.checkbox.setTag(list.get(position));
        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text.setText(list.get(position).getCantidad());
        holder.subLeft.setText(list.get(position).getHoraYMinuto());
        holder.subRight.setText(list.get(position).getCategoria());
        holder.checkbox.setChecked(list.get(position).isSelected());
        return view;
    }
};