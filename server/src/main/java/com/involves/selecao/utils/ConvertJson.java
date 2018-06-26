package com.involves.selecao.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ConvertJson {

    public static String convertJsonToString(String link) throws IOException {
        URL url = new URL("http://selecao-involves.agilepromoter.com/pesquisas");
        URLConnection con = url.openConnection();
        //con.setRequestMethod("GET");
        String redirect = con.getHeaderField("Location");
        if (redirect != null){
            con = new URL(redirect).openConnection();
        }


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}
