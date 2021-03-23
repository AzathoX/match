package org.match.services.interfaces;

public interface CacheServices {
    void addNo();

    String getNo();

    void addCache(String name, Object value);


    void rmCache(String name);

    Object getCache(String name);
}
