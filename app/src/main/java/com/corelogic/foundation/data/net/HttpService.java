package com.corelogic.foundation.data.net;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author: Seth Bourget
 * Date: 6/10/16
 */
public class HttpService
{
  private static final String TAG = "HTTP_SERVICE";

  private final OkHttpClient okHttpClient;

  public HttpService() {
    okHttpClient = new OkHttpClient.Builder().hostnameVerifier(hostnameVerifier).followRedirects(true).build();
  }

  private HostnameVerifier hostnameVerifier = new HostnameVerifier() {
    @Override
    public boolean verify(String hostname, SSLSession session) {
      return true;
    }
  };

  public OkHttpClient getOkHttpClient() {
    return okHttpClient;
  }


  /**
   * Do a request to an api synchronously.
   * It should not be executed in the main thread of the application.
   *
   * @return A string response
   */
  public String requestSyncGetCall(final String url, final Map<String, String> headers) {
    final Request request = buildGetRequest(url, headers);
    return getRequestResponseBody(request);
  }

  public String requestSyncGetCall(final String url) {
    return requestSyncGetCall(url, new HashMap<String, String>());
  }


  private Request buildGetRequest(final String url, final Map<String, String> headers) {
    final Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headers))
            .get()
            .build();
    return request;
  }




  /**
   * Do a request to an api synchronously.
   * It should not be executed in the main thread of the application.
   *
   * @return A string response
   */
  public String doSyncPostCall(final String url, final Map<String, String> headers, final  String postBody) {
    Log.d(TAG, "HTTP REQUEST: " + url + " " + postBody);
    final Request request = buildPostRequest(url, headers, postBody);
    return getRequestResponseBody(request);
  }

  public String doSyncPostCall(final String url,  final  String postBody) {
    return doSyncPostCall(url, new HashMap<String, String>(), postBody);
  }



  private Request buildPostRequest(final String url,final Map<String, String> headers, final  String postBody) {
    final RequestBody body = RequestBody.create(null, postBody);
    final Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headers))
            .post(body)
            .build();
    return request;
  }


  private String getRequestResponseBody(final Request request) {
    try
    {
      final Response response = okHttpClient.newCall(request).execute();
      return response.body().string();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }


  public String doSyncPostCall(final String url, final ArrayMap<String, String> postParams) {
    final Request request = buildPostRequest(url, new ArrayMap<String, String>(), postParams);
    return getRequestResponseBody(request);
  }

  private Request buildPostRequest(final String url, final ArrayMap<String, String> headers, final ArrayMap<String, String> postParams) {
    FormBody.Builder builder = new FormBody.Builder();
    for(String key : postParams.keySet()) {
      builder.add(key, postParams.get(key));
    }
    final RequestBody body = builder.build();
    final Request request = new Request.Builder()
            .url(url)
            .headers(Headers.of(headers))
            .post(body)
            .build();
    return request;
  }
}
