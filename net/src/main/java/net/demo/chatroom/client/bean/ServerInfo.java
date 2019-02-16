package net.demo.chatroom.client.bean;

/**
 * @Author lw
 * @Date 2019-01-02 21:43:35
 **/
public class ServerInfo {
    private String sn;
    private int port;
    private String address;

    public ServerInfo(String sn, int port, String address) {
        this.sn = sn;
        this.port = port;
        this.address = address;
    }

    public String getSn() {
        return sn;
    }

    public int getPort() {
        return port;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "sn='" + sn + '\'' +
                ", port=" + port +
                ", address='" + address + '\'' +
                '}';
    }
}
