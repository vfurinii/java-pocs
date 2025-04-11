package org.vitorfurini;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.vitorfurini.model.CepResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CepService {

    public CepResponse buscarCep(String cep) {
        try {
            String urlStr = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                response.append(linha);
            }

            reader.close();

            JSONObject obj = new JSONObject(response.toString());

            // Verifica se o CEP existe
            if (obj.has("erro")) {
                return null;
            }

            return new CepResponse(
                    obj.getString("cep"),
                    obj.getString("logradouro"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf")
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP", e);
        }
    }
}
