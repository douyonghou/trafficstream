package com.litb.vela.pojos;

import java.io.Serializable;

/**
 * Author: dougonghou
 * Date: 2023/7/11 19:02
 */
public class TrackerPojo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ip;
    private String cookie;
    private String sessionChannel;
    private String sessionCookie;
    private String visitorChannel;
    private String visitorCookie;
    private String weekChannel;
    private String weekCookie;
    private String cust_id;
    private int badip=0;
    private String vela_is_first_visit = "-";
    private long visittime;
    private String datestr;

    public TrackerPojo() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getSessionChannel() {
        return sessionChannel;
    }

    public void setSessionChannel(String sessionChannel) {
        this.sessionChannel = sessionChannel;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    public String getVisitorChannel() {
        return visitorChannel;
    }

    public void setVisitorChannel(String visitorChannel) {
        this.visitorChannel = visitorChannel;
    }

    public String getVisitorCookie() {
        return visitorCookie;
    }

    public void setVisitorCookie(String visitorCookie) {
        this.visitorCookie = visitorCookie;
    }

    public String getWeekChannel() {
        return weekChannel;
    }

    public void setWeekChannel(String weekChannel) {
        this.weekChannel = weekChannel;
    }

    public String getWeekCookie() {
        return weekCookie;
    }

    public void setWeekCookie(String weekCookie) {
        this.weekCookie = weekCookie;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public int getBadip() {
        return badip;
    }

    public void setBadip(int badip) {
        this.badip = badip;
    }

    public String getVela_is_first_visit() {
        return vela_is_first_visit;
    }

    public void setVela_is_first_visit(String vela_is_first_visit) {
        this.vela_is_first_visit = vela_is_first_visit;
    }

    public long getVisittime() {
        return visittime;
    }

    public void setVisittime(long visittime) {
        this.visittime = visittime;
    }

    public String getDatestr() {
        return datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "ip='" + ip + '\'' +
                ", cookie='" + cookie + '\'' +
                ", sessionChannel='" + sessionChannel + '\'' +
                ", sessionCookie='" + sessionCookie + '\'' +
                ", visitorChannel='" + visitorChannel + '\'' +
                ", visitorCookie='" + visitorCookie + '\'' +
                ", weekChannel='" + weekChannel + '\'' +
                ", weekCookie='" + weekCookie + '\'' +
                ", cust_id='" + cust_id + '\'' +
                ", badip=" + badip +
                ", vela_is_first_visit='" + vela_is_first_visit + '\'' +
                ", visittime=" + visittime +
                ", datestr='" + datestr + '\'' +
                '}';
    }
}
