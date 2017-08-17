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

public class NetGETCaller<R> {

    private final HttpService httpService;
    private final JSONObjectMapperFactory jsonObjectMapperFactory;

    @Inject
    public NetGETCaller(final HttpService httpService, final JSONObjectMapperFactory jsonObjectMapperFactory) {
        this.httpService = httpService;
        this.jsonObjectMapperFactory = jsonObjectMapperFactory;
    }

    public R doCall(final String url, final Class<R> output) throws IOException {
        ObjectMapper om = jsonObjectMapperFactory.call();
        String response = httpService.requestSyncGetCall(url);
        return om.readValue(response, output);
    }
}
