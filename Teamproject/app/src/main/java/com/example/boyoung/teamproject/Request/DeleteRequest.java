package com.example.boyoung.teamproject.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class DeleteRequest extends StringRequest {
    final static private String URL = "http://52.79.231.229/delete.php";
    private Map<String, String> parameters;

    public DeleteRequest(String usernum, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener,null);
        parameters = new HashMap<>();
        parameters.put("usernum", usernum);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
