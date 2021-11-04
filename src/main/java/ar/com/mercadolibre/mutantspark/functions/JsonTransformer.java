/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.mercadolibre.mutantspark.functions;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 *
 * @author rcarballo
 */
public class JsonTransformer implements ResponseTransformer {
    private Gson gson = new Gson();

    @Override
    public String render(Object data) throws Exception {
            return gson.toJson(data);
    }
}
