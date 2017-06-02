package com.example.matheus.citycar;

/**
 * Created by matheus on 02/06/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nelson Souza on 31/05/2017.
 */

public class Adapter_VeiculosDisponiveis extends BaseAdapter {
    private Context context;
    private ArrayList<Veiculo> veiculos ;

    public Adapter_VeiculosDisponiveis(Context context, ArrayList<Veiculo> veiculos) {
        this.context = context;
        this.veiculos = veiculos;
    }

    @Override
    public int getCount() {
        return veiculos.size();
    }

    @Override
    public Object getItem(int position) {
        return veiculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.model_lst_veiculos_disponiveis,null);
        }
        TextView placa = (TextView) convertView.findViewById(R.id.lblVeiculosDisponiveisPlaca);
        TextView modelo = (TextView)convertView.findViewById(R.id.lblVeiculosDisponiveisModelo);
        TextView km = (TextView) convertView.findViewById(R.id.lblVeiculosDisponiveisKm);
        TextView combustivel = (TextView)convertView.findViewById(R.id.lblVeiculosDisponiveisCombustivel);
        placa.setText(veiculos.get(position).getPlaca());
        modelo.setText(veiculos.get(position).getModelo());
        km.setText(String.valueOf(veiculos.get(position).getKmRodado()));
        combustivel.setText(veiculos.get(position).getCombustivel());
        return convertView;
    }
}
