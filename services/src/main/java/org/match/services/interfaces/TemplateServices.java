package org.match.services.interfaces;

import org.springframework.transaction.annotation.Transactional;
import org.match.dataassert.datadomain.EventDomain;
import org.match.domains.dto.EventDTO;
import org.match.domains.vo.ViewObject;

public interface TemplateServices {
    ViewObject dataOfCreatePage();


    @Transactional
    EventDomain create(EventDTO dto);

    void saveConfig(EventDTO dto);
}
