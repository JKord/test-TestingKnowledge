package jkor.testing_knowledge.model;

import java.util.HashMap;
import java.util.Map;

import jkor.testing_knowledge.entities.BaseEntity;

public class ResponseModel
{
    public int code;
    public String message;
    public Object data;
    
    public ResponseModel(int code)
    {
        this.code = code;
        switch (code) {
            case 0:  message = "Помилка"; break;
            case 1:  message = "OK"; break;
            case 2:  message = "Тест пройдено"; break;
        }
    }
    
    public static ResponseModel create(int code, Object obj)
    {
        ResponseModel response = new ResponseModel(code);
        response.data = obj;
        
        return response;
    }

    public static ResponseModel create(int code)
    {
        return create(code, null);
    }

    public static ResponseModel create(int code, String nameValue, BaseEntity value)
    {
        Map<String, Object> obj = new HashMap<String, Object>() {};
        obj.put(nameValue, value.responseObj());

        return create(code, obj);
    }
}