package com.vectree.billing.utils;

import com.google.gson.Gson;
import com.vectree.billing.controller.BillingController;
import com.vectree.billing.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpUtils {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final Logger logger = LoggerFactory.getLogger(BillingController.class);

    public static User sendHttpRequestPost(String urlString, String userJSON) throws IOException {
        URL url = new URL(urlString);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(userJSON);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        logger.info("post http request to " + urlString);
        logger.info("with parameters " + userJSON);
        logger.info("response code " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String responseString = response.toString();
        logger.info("response " + responseString);

        Gson gson = new Gson();
        return gson.fromJson(responseString, User.class);
    }
}
