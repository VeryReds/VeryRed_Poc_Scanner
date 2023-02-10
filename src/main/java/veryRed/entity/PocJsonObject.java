package veryRed.entity;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Map;

public class PocJsonObject {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Req")
    private Req req;
    @JsonProperty("Characteristic")
    private String characteristic;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setReq(Req req) {
        this.req = req;
    }
    public Req getReq() {
        return req;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
    public String getCharacteristic() {
        return characteristic;
    }
}
class Req {
    @JsonProperty("Request")
    private String request;
    @JsonProperty("Header")
    private Map<String,String> header;
    @JsonProperty("Body")
    private String body;
    public void setRequest(String request) {
        this.request = request;
    }
    public String getRequest() {
        return request;
    }

    public void setHeader(Map<String,String> header) {
        this.header = header;
    }
    public Map<String,String> getHeader() {
        return header;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

}