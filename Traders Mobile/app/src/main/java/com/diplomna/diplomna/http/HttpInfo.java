package com.diplomna.diplomna.http;



public class HttpInfo {
    public static final String httpAddress="api.tues.dreamix.eu";
    public static final String httpPort="80";
    public static final String protocolType="http";
    public static final long CONNECT_TIMEOUT_MS=10*1000l;
    public static final long WRITE_TIMEOUT_MS=10*1000l;
    public static final long READ_TIMEOUT_MS=10*1000l;
    public static final String jwtTokenHeaderName = "Authorization";

    public static String getRetrofitUrl(){
        return protocolType+"://"+httpAddress+":"+httpPort;
    }
}
