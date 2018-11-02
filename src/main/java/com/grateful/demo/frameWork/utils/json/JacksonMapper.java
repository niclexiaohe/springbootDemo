package com.grateful.demo.frameWork.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * DESC:
 * USER:hmily
 * DATE:2017/10/10
 * TIME:13:03
 */
public class JacksonMapper {

    /**
     * can reuse, share globally
     */
    private static final ObjectMapper object = new ObjectMapper();

    /**
     * can reuse, share globally
     */
    private static final XmlMapper xml = new XmlMapper();

    /**
     * private constructor
     */
    private JacksonMapper() {
    }

    /**
     * return a ObjectMapper that is singleton
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return object;
    }

    /**
     * return a XmlMapper that is singleton
     * @return
     */
    public static XmlMapper getXmlMapper() {
        return xml;
    }
}
