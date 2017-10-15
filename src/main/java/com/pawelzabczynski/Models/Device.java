package com.pawelzabczynski.Models;

import java.util.ArrayList;

/**
 * Class represent device connected to mqtt broker
 * @author     Paweł Zabczyński
 * @version    0.1
 * @since      16.10.2017
 * */

public class Device {
    private String deviceId;
    private String deviceSecret;
    private Long dbIndexId;
    private ArrayList<String> mqttChannels;

    public Device(){}

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }

    public Long getDbIndexId() {
        return dbIndexId;
    }

    public void setDbIndexId(Long dbIndexId) {
        this.dbIndexId = dbIndexId;
    }

    public ArrayList<String> getMqttChannels() {
        return mqttChannels;
    }

    public void setMqttChannels(ArrayList<String> mqttChannels) {
        this.mqttChannels = mqttChannels;
    }
}
