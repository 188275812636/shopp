package com.rgy.shopp.util;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * \* User: rgy
 * \* Date: 2019/8/22 11:27
 * \
 */
public class JsonRequest implements Serializable {
    private static final long serialVersionUID = -8213138612130025947L;
    private Map<String, Object> reqData = new ConcurrentHashMap();
    private String handleCode = "";
    private String serviceName;

    public JsonRequest() {
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHandleCode() {
        return this.handleCode;
    }

    public void setHandleCode(String handleCode) {
        this.handleCode = handleCode;
    }

    public Map<String, Object> getReqData() {
        return this.reqData;
    }

    public void setReqData(Map<String, Object> reqData) {
        this.reqData = reqData;
    }
}
