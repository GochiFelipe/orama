package br.com.felipe.gochi.orama;

import android.content.Context;
import android.widget.ListAdapter;

import java.util.List;

import br.com.felipe.gochi.orama.modelo.FundoInvestimento;

/**
 * Created by root on 30/01/18.
 */

abstract class investimentoArrayAdapter implements ListAdapter {
    public investimentoArrayAdapter(Context context, List<FundoInvestimento> fundoInvestimentos) {
    }
}
