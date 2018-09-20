package cicada.core;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
    static ObjectMapper mapper = new ObjectMapper();

    public JsonUtil() {
    }

    public static <T> List<T> String2List(String json, Class<T> obj) throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, new Class[]{obj});
        List<T> result = (List)mapper.readValue(json, javaType);
        return result;
    }

    public static <T> T String2Obj(String json, Class<T> obj) throws JsonParseException, JsonMappingException, IOException {
        T result = mapper.readValue(json, obj);
        return result;
    }

    public static <T> String obj2string(T obj) throws JsonProcessingException {
        if (obj == null) {
            return "";
        } else {
            String result = mapper.writeValueAsString(obj);
            return result;
        }
    }

    public static <T> byte[] obj2byte(T obj) throws JsonProcessingException {
        if (obj == null) {
            return null;
        } else {
            byte[] result = mapper.writeValueAsBytes(obj);
            return result;
        }
    }
}