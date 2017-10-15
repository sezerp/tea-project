package com.pawelzabczynski.mqtt;

import com.pawelzabczynski.messageGenerator.MessageGenerator;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Class provided simply method for connecting to MQTT broker e.g. Mosquitto or Eclipse etc.
 * @author     Paweł Zabczyński
 * @version    0.1
 * @since      24.09.2017
 * */

public class MqttClientSimply {

    private String brokerUrl                        = "";
    private String topic                            = "";
    private int qos                                 = 0;
    private String clientId                         = "";
    private MessageGenerator messageGenerator       = new MessageGenerator();

    private String clientUsername                   = "";
    private String clientPassword                   = "";

    private MemoryPersistence memoryPersistence     = new MemoryPersistence();
    private MqttConnectOptions mqttConnectOptions   = new MqttConnectOptions();
    private MqttClient mqttClient;

    public MqttClientSimply(String brokerUrl, String topic, String clientId, MessageGenerator messageGen) {
        this(brokerUrl, topic, clientId, messageGen, 0);
    }

    public MqttClientSimply(String brokerUrl, String topic, String clientId, MessageGenerator messageGen, int qos) {
        this.brokerUrl = brokerUrl;
        this.topic = topic;
        this.clientId = clientId;
        this.messageGenerator = messageGen;
        this.qos = qos;
    }

    public boolean mqttConnect() {
        this.mqttConnectOptions.setWill(this.topic, "".getBytes(), this.qos, false);
        this.mqttConnectOptions.setUserName(this.clientUsername);
        this.mqttConnectOptions.setPassword(this.clientPassword.toCharArray());
        this.mqttConnectOptions.setCleanSession(true);
        this.mqttConnectOptions.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);

        try {
            this.mqttClient = new MqttClient(this.brokerUrl, this.clientId, this.memoryPersistence);
            this.mqttClient.connect();

            return true;
        } catch (MqttException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean mqttDisconnect() {
        try {
            this.mqttClient.disconnect();
            return true;
        } catch (MqttException mqttEx) {
            mqttEx.printStackTrace();
        }

        return false;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

    public void setMessageGenerator(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
}
