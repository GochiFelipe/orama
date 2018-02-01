package br.com.felipe.gochi.orama;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.gochi.orama.modelo.FundoInvestimento;
import br.com.felipe.gochi.orama.util.JSONUtil;

public class FundoInvestimentoActivityAntigo extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundo_investimento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.listaView);
        Context context = this;

        new AsyncCaller(listView,context).execute();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    private class AsyncCaller extends AsyncTask<Void, Void, List<FundoInvestimento>> {

        private ListView listView;
        private Context context;

        public AsyncCaller(ListView listView, Context context){
            this.listView = listView;
            this.context = context;
        }
        @Override
        protected List<FundoInvestimento> doInBackground(Void... params) {
            new JSONUtil();
            return new JSONUtil().getJsonObject("https://s3.amazonaws.com/orama-media/json/" +
                    "fund_detail_full.json?limit=1000&offset=0&serializer=fund_detail_full");

        }

        @Override
        protected void onPostExecute(List<FundoInvestimento> fundoInvestimentos) {
            super.onPostExecute(fundoInvestimentos);


            List<String> textos = ConverterToString(fundoInvestimentos);

            ArrayAdapter<String> investimentoArrayAdapter = new ArrayAdapter<String>
                    (context,android.R.layout.simple_list_item_1,
                            textos);

            listView.setAdapter(investimentoArrayAdapter);
        }

        private List<String> ConverterToString(List<FundoInvestimento> fundoInvestimentos) {
            List<String> retorno = new ArrayList<>();
            for(FundoInvestimento investimento : fundoInvestimentos){
                retorno.add(investimento.getSimpleName());
                retorno.add(investimento.getOperability().getMinimumInitialAplicationAmount());
            }
            return retorno;
        }


    }*/
}
