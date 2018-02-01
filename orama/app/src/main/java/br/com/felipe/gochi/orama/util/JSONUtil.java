package br.com.felipe.gochi.orama.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.gochi.orama.modelo.FundoInvestimento;
import br.com.felipe.gochi.orama.modelo.FundoMacroStrategy;
import br.com.felipe.gochi.orama.modelo.FundoRiskProfile;
import br.com.felipe.gochi.orama.modelo.Operability;
import br.com.felipe.gochi.orama.modelo.Profitabilities;
import br.com.felipe.gochi.orama.modelo.Specification;


public class JSONUtil {
    InputStream inputStream = null;
    String json = "";

    public List<FundoInvestimento> getJsonObject(String url) {
        Conexao(url);
        Leitor();

        Gson gson = new Gson();
        List<FundoInvestimento> fundoInvestimentos = gson.fromJson(json,
                new TypeToken<List<FundoInvestimento>>() {
                }.getType());


        return getFundoInvestimentos(fundoInvestimentos);
    }

    private List<FundoInvestimento> getFundoInvestimentos(List<FundoInvestimento> fundoInvestimentos) {
        List<FundoInvestimento> fundoInvestimentoList = new ArrayList<FundoInvestimento>();

        for (FundoInvestimento investimento : fundoInvestimentos) {

            FundoInvestimento fundoInvestimento = new FundoInvestimento();
            Profitabilities profitabilities = new Profitabilities();
            Operability operability = new Operability();
            Specification specification = new Specification();
            FundoMacroStrategy fundoMacroStrategy = new FundoMacroStrategy();
            FundoRiskProfile fundoRiskProfile = new FundoRiskProfile();

            //Fundo Investimento
            fundoInvestimento.setSimpleName(investimento.getSimpleName());

            //Profitabilities
            profitabilities.setM12(investimento.getProfitabilities().
                    getM12());
            profitabilities.setMonth(investimento.getProfitabilities().getMonth());
            fundoInvestimento.setProfitabilities(profitabilities);

            //Operability
            operability.setMinimumInitialAplicationAmount(investimento.getOperability().getMinimumInitialAplicationAmount());
            fundoInvestimento.setOperability(operability);

            //Specification
            specification.setFundType(investimento.getSpecification().getFundType());
            specification.setQualified(investimento.getSpecification().getQualified());
            fundoMacroStrategy.setExplanation(investimento.getSpecification().getFundoMacroStrategy().getExplanation());
            fundoRiskProfile.setNome(investimento.getSpecification().getFundoRiskProfile().getNome());
            fundoRiskProfile.setScoreRangeOrder(investimento.getSpecification().getFundoRiskProfile().getScoreRangeOrder());
            specification.setFundoMacroStrategy(fundoMacroStrategy);
            specification.setFundoRiskProfile(fundoRiskProfile);
            fundoInvestimento.setSpecification(specification);

            fundoInvestimentoList.add(fundoInvestimento);

        }

        return fundoInvestimentoList;
    }

    private void Leitor() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                    "UTF-8"), 8);

            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            inputStream.close();
            json = builder.toString();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Conexao(String url) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

