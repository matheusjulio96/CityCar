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
 * Created by Nelson Souza on 30/05/2017.
 */

public class Adapter_AprovaSolicitacao extends BaseAdapter{
    private Context context;
    private ArrayList<AprovaSolicitacao> arrayList;

    public Adapter_AprovaSolicitacao(Context context, ArrayList<AprovaSolicitacao> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.model_lst_solicitacao,null);
        }
        TextView cpf = (TextView) convertView.findViewById(R.id.idAprova_Solicit_CpfUsuario);
        TextView motivo = (TextView)convertView.findViewById(R.id.idAprovaSolicit_Motivo);
        cpf.setText(arrayList.get(position).getNome());
        motivo.setText(arrayList.get(position).getMotivo());

        return convertView;
    }
}

