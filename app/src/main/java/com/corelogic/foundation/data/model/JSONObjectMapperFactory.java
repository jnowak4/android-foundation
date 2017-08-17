/*
 * Copyright (c) 2017. Core Logic
 */

package com.corelogic.foundation.data.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.inject.Inject;

import rx.functions.Func0;

/**
 * Created on 3/21/17.
 */

public class JSONObjectMapperFactory implements Func0<ObjectMapper> {


    @Inject
    public JSONObjectMapperFactory() {}

    @Override
    public ObjectMapper call() {
        ObjectMapper OM = new ObjectMapper();
        OM.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OM.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        OM.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OM.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        return OM;
    }
}
