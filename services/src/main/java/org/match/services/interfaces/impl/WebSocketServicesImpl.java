package org.match.services.interfaces.impl;

import org.match.services.interfaces.CacheServices;
import org.match.services.interfaces.WebSocketServices;
import org.match.services.utils.AbstractMD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebSocketServicesImpl implements WebSocketServices {

    @Autowired
    private CacheServices cacheServices;

    @Override
    public String sid() {
        cacheServices.addNo();
        final String no = cacheServices.getNo();
        final String sid = AbstractMD5Utils.md516Byte(no);
        return sid;
    }

}
