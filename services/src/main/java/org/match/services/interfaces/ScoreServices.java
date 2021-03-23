package org.match.services.interfaces;

import java.util.List;

public interface ScoreServices {
    void writeResult(List<String> result);

    void writeResult(Object obj);

    Object resultPolling();

    Object result();
}
