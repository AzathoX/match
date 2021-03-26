package org.match.services.ddd;

public abstract class AbstractSchedule {

    private AbstractStage stage;

    private AbstractGroup group;

    public  AbstractSchedule(AbstractGroup group, AbstractStage stage){
        this.stage = stage;
        this.group = group;
    }


    protected abstract void doSchedule(AbstractGroup group, AbstractStage stage);

    public void schedule(){
        doSchedule(group,stage);
    }

}