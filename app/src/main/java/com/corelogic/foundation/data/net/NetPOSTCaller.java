/*
 * Copyright (c) 2017. Core Logic
 */

package com.corelogic.foundation.data.net;


import com.corelogic.foundation.data.model.JSONObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import javax.inject.Inject;


/**
 * Created on 3/21/17.
 *
 */

public class NetPOSTCaller<T, R> {

    private final HttpService httpService;
    private final JSONObjectMapperFactory jsonObjectMapperFactory;

    @Inject
    public NetPOSTCaller(final HttpService httpService, final JSONObjectMapperFactory jsonObjectMapperFactory) {
        this.httpService = httpService;
        this.jsonObjectMapperFactory = jsonObjectMapperFactory;
    }

    public R doCall(final String url, T input,final  Class<R> output) throws IOException {
            ObjectMapper om = jsonObjectMapperFactory.call();
            String inputAsString = om.writeValueAsString(input);
            String response = httpService.doSyncPostCall(url, inputAsString);
            return om.readValue(response, output);
    }
}


