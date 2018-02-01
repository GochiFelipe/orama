package br.com.felipe.gochi.orama.adapter;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.felipe.gochi.orama.R;
import br.com.felipe.gochi.orama.modelo.FundoInvestimento;

public class FundoInvestimentoAdapter extends RecyclerView.Adapter<FundoInvestimentoAdapter.FundoInvestimentoHolder>{

    private List<FundoInvestimento> fundoInvestimentoList;

    public FundoInvestimentoAdapter(List<FundoInvestimento> fundoInvestimentoList) {
        this.fundoInvestimentoList = fundoInvestimentoList;
    }

    @Override
    public FundoInvestimentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_row, parent, false);

        return new FundoInvestimentoHolder(view);
    }

    @Override
    public void onBindViewHolder(FundoInvestimentoHolder holder, int position) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if(fundoInvestimentoList.get(position).getProfitabilities().getM12() != null){
            Float anoFloat = new Float(fundoInvestimentoList.get(position).getProfitabilities().getM12());
            String anoStrign = new String(String.valueOf(decimalFormat.format(anoFloat*100)));
            holder.ano.setText(anoStrign + "%");

        }
        else{
            holder.ano.setText("-");
        }

        if(fundoInvestimentoList.get(position).getProfitabilities().getMonth() != null){
            Float mesFloat = new Float(fundoInvestimentoList.get(position).getProfitabilities().getMonth());
            String mesString = new String(String.valueOf(decimalFormat.format(mesFloat*100)));
            holder.mes.setText(mesString + "%");
        }
        else{
            holder.mes.setText("-");
        }


        holder.simpleName.setText(fundoInvestimentoList.get(position).getSimpleName());
        holder.aplicacaoMinima.setText(fundoInvestimentoList.get(position).getOperability()
                .getMinimumInitialAplicationAmount() + " R$");

        if(fundoInvestimentoList.get(position).getSpecification().getQualified()){
            holder.userQualify.setVisibility(View.VISIBLE);
        }
        else{
            holder.userQualify.setVisibility(View.INVISIBLE);
        }

        if(getHashMap().containsKey(fundoInvestimentoList.get(position).getSpecification().
                getFundoRiskProfile().getScoreRangeOrder())){
            holder.corDeRisco.setBackgroundColor(Color.parseColor(getHashMap()
                    .get(fundoInvestimentoList.get(position).getSpecification().
                    getFundoRiskProfile().getScoreRangeOrder())));
        }
    }

    @Override
    public int getItemCount() {
        return fundoInvestimentoList.size();
    }

    public class FundoInvestimentoHolder extends RecyclerView.ViewHolder {

        TextView simpleName, ano, mes, aplicacaoMinima, corDeRisco, userQualify;

        public FundoInvestimentoHolder(View itemView) {
            super(itemView);
            simpleName = itemView.findViewById(R.id.simple_name);
            ano = itemView.findViewById(R.id.ano);
            mes = itemView.findViewById(R.id.month);
            aplicacaoMinima = itemView.findViewById(R.id.taxa_minima);
            corDeRisco = itemView.findViewById(R.id.cor_risco);
            userQualify = itemView.findViewById(R.id.investidor_qualificado);

        }
    }



    public Map<Integer, String> getHashMap() {
        Map<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(1, "#06ecfc");
        hashMap.put(2, "#68f1dd");
        hashMap.put(3,"#91ed6e");
        hashMap.put(4,"#b0f42a");
        hashMap.put(5,"#ddf40c");
        hashMap.put(6,"#faf00e");
        hashMap.put(7,"#ffbb00");
        hashMap.put(8,"#ff8800");
        hashMap.put(9,"#ff5e00");
        hashMap.put(10,"#ff5e00");
        hashMap.put(11,"#ff0600");
        hashMap.put(12,"#651414");
        return hashMap;
    }

}
