package com.rgy.shopp.util;

import java.util.UUID;

/**
 * \* User: rgy
 * \* Date: 2019/8/22 11:27
 * \
 */
public class UuidUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

}