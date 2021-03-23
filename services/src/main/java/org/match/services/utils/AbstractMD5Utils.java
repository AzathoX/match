package org.match.services.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;

import java.util.Calendar;
import java.util.UUID;

public abstract  class AbstractMD5Utils {
    private static final MD5 md = MD5.create();

    private static final Calendar data = Calendar.getInstance();
    public static String md532ByteRandom(String origin){
        String fileName = md.digestHex(UUID.nameUUIDFromBytes(
                String.valueOf(data.getTime().getTime()).getBytes()).toString()
                + RandomUtil.randomNumbers(Calendar.DAY_OF_MONTH)
                + data.get(Calendar.DAY_OF_MONTH) + origin);
        return  fileName;
    }

    public static String md516Byte(String origin){
        String shortName = md.digestHex16(origin.getBytes());
        return shortName;
    }
}
