package org.springframework.cloud.bus.event;

/**
 * Created by saga on 2017/1/7.
 */
public class CustomEvt extends RemoteApplicationEvent {

    private String name;


    public CustomEvt() {
        super();
    }

    public CustomEvt(Object source, String originService, String name) {
        super(source, originService);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
