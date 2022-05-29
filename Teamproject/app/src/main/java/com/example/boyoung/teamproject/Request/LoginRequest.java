package com.example.boyoung.teamproject.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class LoginRequest extends StringRequest {

    final static private String URL = "http://52.79.231.229/login.php";
    private Map<String, String> parameters;
    public LoginRequest(String usernum, String password, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("usernum", usernum);
        parameters.put("password", password);

    }

    protected Map<String, String> getParams(){
        return parameters;
    }
}
