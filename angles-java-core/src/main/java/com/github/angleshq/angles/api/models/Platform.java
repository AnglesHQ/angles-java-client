package com.github.angleshq.angles.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter @NoArgsConstructor
public class Platform implements Serializable {

    private String platformName;
    private String platformVersion;
    private String browserName;
    private String browserVersion;
    private String deviceName;
    private String userAgent;
    private Integer screenHeight;
    private Integer screenWidth;
    private Float pixelRatio;

    public Platform(String platformName, String platformVersion, String browserName, String browserVersion) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }

    public Platform(String platformName, String platformVersion, String browserName, String browserVersion, String deviceName) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.deviceName = deviceName;
    }

    public Platform(String platformName, String platformVersion, String browserName, String browserVersion, String deviceName, String userAgent, Integer screenHeight, Integer screenWidth, Float pixelRatio) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.deviceName = deviceName;
        this.userAgent = userAgent;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.pixelRatio = pixelRatio;
    }
}
