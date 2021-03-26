package org.match.services.ddd.support;

import org.match.services.ddd.AbstractGroup;
import org.match.services.ddd.AbstractSchedule;
import org.match.services.ddd.AbstractStage;

public class OriginSchedule extends AbstractSchedule {

    public OriginSchedule(AbstractGroup group, AbstractStage stage) {
        super(group, stage);
    }

    @Override
    protected void doSchedule(AbstractGroup group, AbstractStage stage) {

    }

}
