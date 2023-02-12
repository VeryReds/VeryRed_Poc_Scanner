package veryRed.entity;

import java.util.Map;

public class PocJsonObject {
    private String Name;
    private Req[] Req;
    private String Characteristic;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Req[] getReq() {
        return Req;
    }

    public void setReq(Req[] req) {
        Req = req;
    }

    public String getCharacteristic() {
        return Characteristic;
    }

    public void setCharacteristic(String characteristic) {
        Characteristic = characteristic;
    }

    public static class Req {
        private String Request;
        private String Url;
        private Map<String, String> Header;
        private String Body;

        public String getRequest() {
            return Request;
        }

        public void setRequest(String request) {
            Request = request;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        public Map<String, String> getHeader() {
            return Header;
        }

        public void setHeader(Map<String, String> header) {
            Header = header;
        }

        public String getBody() {
            return Body;
        }

        public void setBody(String body) {
            Body = body;
        }

        @Override
        public String toString() {
            return "Req{" +
                    "Request='" + Request + '\'' +
                    ", Url='" + Url + '\'' +
                    ", Header=" + Header +
                    ", Body='" + Body + '\'' +
                    '}';
        }
    }
}