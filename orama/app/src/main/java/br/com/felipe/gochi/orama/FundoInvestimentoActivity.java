package br.com.felipe.gochi.orama;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.felipe.gochi.orama.adapter.FundoInvestimentoAdapter;
import br.com.felipe.gochi.orama.modelo.FundoInvestimento;
import br.com.felipe.gochi.orama.util.JSONUtil;

public class FundoInvestimentoActivity extends AppCompatActivity {

    private FundoInvestimentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundo_investimento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        Context context = this;
        new AsyncCaller(recyclerView,context).execute();

    }


    private class AsyncCaller extends AsyncTask<Void, Void, List<FundoInvestimento>> {

        private RecyclerView recyclerView;
        private Context context;
        private ProgressBar progressBar;

        public AsyncCaller(RecyclerView recyclerView, Context context){
            this.recyclerView = recyclerView;
            this.context = context;
        }
        @Override
        protected List<FundoInvestimento> doInBackground(Void... params) {
            new JSONUtil();
            return new JSONUtil().getJsonObject("https://s3.amazonaws.com/orama-media/json/" +
                    "fund_detail_full.json?limit=1000&offset=0&serializer=fund_detail_full");

        }

        @Override
        protected void onPreExecute() {
            progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<FundoInvestimento> fundoInvestimentos) {
            super.onPostExecute(fundoInvestimentos);

            //List<String> textos = ConverterToString(fundoInvestimentos);

            adapter = new FundoInvestimentoAdapter(fundoInvestimentos);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(adapter);
            progressBar.setVisibility(View.INVISIBLE);
            progressBar.getLayoutParams().height = 0;

        }

    }
}
