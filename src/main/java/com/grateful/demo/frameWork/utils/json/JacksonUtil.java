package com.grateful.demo.frameWork.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jackson工具
 */
public class JacksonUtil {
    private final static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private static Class[] source;
    private static Class[] target;

    /**
     * 将java对象----》json字符串    或   将java对象----》字符串
     *
     * javaBean,list,array convert to json string
     */
    public static String obj2json(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String returnStr = null;
        try {
            returnStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("---------------obj2json出错:" + e);
        }
        return returnStr;
    }

//    public static String objectToString(Object obj) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String returnStr = null;
//        try {
//            returnStr = objectMapper.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            logger.error("---------------objectToString出错:" + e);
//        }
//        return returnStr;
//    }

    /**
     * 将json字符串---》java对象
     *
     * json string convert to javaBean
     */
    public static <T> T json2obj(String jsonStr, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T o = null;
        try {
            o = objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            logger.error("---------------json2obj出错:" + e);
        }
        return o;
    }

    /**
     * 将json字符串---》Map<String, String>
     *
     * json string convert to map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> json2map(String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            logger.error("---------------json2map出错:" + e);
        }
        return map;
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
        Map<String, T> result = new HashMap<String, T>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Map<String, Object>> map = objectMapper.readValue(
                    jsonStr, new TypeReference<Map<String, T>>() {
                    });
            for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
                result.put(entry.getKey(), map2obj(entry.getValue(), clazz));
            }
        } catch (IOException e) {
            logger.error("---------------json2map出错:" + e);
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> result = new ArrayList<T>();
        try {
            List<Map<String, Object>> list = objectMapper.readValue(
                    jsonArrayStr, new TypeReference<List<T>>() {
                    });
            for (Map<String, Object> map : list) {
                result.add(map2obj(map, clazz));
            }
        } catch (IOException e) {
            logger.error("---------------json2list出错:" + e);
        }
        return result;
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> json2listS(String jsonArrayStr, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Integer> list = objectMapper.readValue(jsonArrayStr,
                    new TypeReference<List<T>>() {
                    });

        } catch (IOException e) {
            logger.error("---------------json2list出错:" + e);
        }
        return result;
    }

    /**
     * map convert to javaBean
     */
    @SuppressWarnings("rawtypes")
    public static <T> T map2obj(Map map, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(map, clazz);
    }


    /**
     * 将java对象转---》xml字符串
     * @param bean
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public static <T> String beanToXml(T bean) throws JsonProcessingException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        //xml.
        String string = xml.writeValueAsString(bean);
        return string;
    }


    /**
     * 将xml文件---》java对象
     * @param xmlFile
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(File xmlFile, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlFile, cls);
        return obj;
    }

    /**
     * 将指定xmlPath路径的xml文件---》java对象
     * XML To Object
     *
     * @param xmlPath
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlPathToBean(String xmlPath, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(new File(xmlPath), cls);
        return obj;
    }

    /**
     * 将xml输入流---》java对象
     *
     * @param xmlInputStream
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(InputStream xmlInputStream, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlInputStream, cls);
        return obj;
    }


    /**
     * 将xml字符串---》java对象
     * @param xmlStr
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(String xmlStr, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlStr, cls);
        return obj;
    }

    /**
     * 将xml字符串---》java对象---》json字符串
     * @param xmlStr
     * @return
     * @throws IOException
     */
    public static String  xmlToJson(String xmlStr) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        Object obj = xml.readValue(xmlStr, Object.class);
        return obj2json(obj);
    }


    /**
     * json Bean数据转换
     *
     * @param objectBean
     * @param oldClass
     * @param targetClass
     * @return
     * @throws JsonProcessingException
     */
    public static String addMixInAnnotations(Object objectBean,
                                             ArrayList<Class> oldClass, ArrayList<Class> targetClass)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper tempMapper = new ObjectMapper();

        for (int i = 0; i < oldClass.size(); i++) {
            tempMapper.addMixIn(oldClass.get(i), targetClass.get(i));
        }

        String json = tempMapper.writeValueAsString(objectBean);
        return json;
    }

    @SuppressWarnings("rawtypes")
    public static String addMixInAnnotations(Object obj, Class... clazz) throws JsonProcessingException {
        String json = null;
        if (clazz.length % 2 == 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectMapper tempMapper = new ObjectMapper();
            int num = clazz.length / 2;
            for (int i = 0; i < num; i++) {
                tempMapper.addMixIn(clazz[i], clazz[i + num]);
            }
            json = tempMapper.writeValueAsString(obj);
        }
        return json;
    }

    /**
     * json Bean数据转换
     *
     * @param objectBean
     * @param oldClass
     * @param targetClass
     * @return
     * @throws JsonProcessingException
     */
    public static String addMixInAnnotations(Object objectBean, Class oldClass,
                                             Class targetClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper tempMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN, true);

        tempMapper.addMixIn(oldClass, targetClass);
        String json = tempMapper.writeValueAsString(objectBean);
        return json;
    }
}
