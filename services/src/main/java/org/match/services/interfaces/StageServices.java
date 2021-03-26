package org.match.services.interfaces;

import org.match.domains.bo.MatchTemplateBO;
import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.AbstractStage;

public interface StageServices {
    AbstractStage create(AbstractGroup group);

    void schedule(MatchTemplateBO bo, AbstractStage stage, AbstractGroup group);
}
