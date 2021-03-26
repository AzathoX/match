package org.match.services.interfaces;

import org.match.domains.bo.MatchTemplateBO;
import org.match.services.ddd.AbstractGroup;

public interface TeamAllocatedGroupServices {

    AbstractGroup group(MatchTemplateBO bo);


}
