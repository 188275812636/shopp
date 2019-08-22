package com.rgy.shopp.util;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * \* User: rgy
 * \* Date: 2019/8/22 11:27
 * \
 */
public class JsonResponse implements Serializable {
    private static final long serialVersionUID = -5988550869557990782L;
    private String code = "0";
    private String msg = "处理成功";
    private Map<String, Object> repData = new ConcurrentHashMap();

    public JsonResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getRepData() {
        return this.repData;
    }

    public void setRepData(Map<String, Object> repData) {
        this.repData = repData;
    }
}
