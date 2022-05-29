package com.example.boyoung.teamproject.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class PostRequest extends StringRequest {

    final static private String URL = "http://52.79.231.229/post.php";
    private Map<String, String> parameters;
    public PostRequest(String postnum, String name, String title, String content,String date, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("postnum", postnum);
        parameters.put("name", name);
        parameters.put("title", title);
        parameters.put("content",content);
        parameters.put("date",date);

    }

    protected Map<String, String> getParams(){
        return parameters;
    }
}
