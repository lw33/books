package net.captrue;

/**
 * @Author lw
 * @Date 2019-01-05 14:11:58
 **/
public class IP {
    //在标准输出和日志文件中写入捕获的IP包的版本、头长度、服务类型、数据包总长度、数据包标识、分段标志、分段偏移值、生存时间、上层协议类型、头校验和、源IP地址和目的IP地址等内容。
    private byte version;
    private byte priority;
    private boolean t_flag;
    private boolean r_flag;
    private short length;
    private int ident;
    private boolean dont_frag;
    private boolean more_frag;
    private short offset;
    private short hop_limit;
    private String protocol;
    private String check_sum;
    private String src_ip;
    private String dst_ip;

    public IP(byte version, byte priority, boolean t_flag, boolean r_flag, short length, int ident, boolean dont_frag, boolean more_frag, short offset, short hop_limit, String protocol, String check_sum, String src_ip, String dst_ip) {
        this.version = version;
        this.priority = priority;
        this.t_flag = t_flag;
        this.r_flag = r_flag;
        this.length = length;
        this.ident = ident;
        this.dont_frag = dont_frag;
        this.more_frag = more_frag;
        this.offset = offset;
        this.hop_limit = hop_limit;
        this.protocol = protocol;
        this.check_sum = check_sum;
        this.src_ip = src_ip;
        this.dst_ip = dst_ip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("版本号: IPV");
        sb.append(version);
        addSeparator(sb);
        sb.append("优先权: ");
        sb.append(priority);
        addSeparator(sb);
        sb.append("总长度: ");
        sb.append(length);
        addSeparator(sb);
        sb.append("标识: ");
        sb.append(ident);
        addSeparator(sb);
        sb.append("区分服务：最大的吞吐量: ");
        sb.append(t_flag);
        addSeparator(sb);
        sb.append("区分服务：最高的可靠性: ");
        sb.append(r_flag);
        sb.append("\n");
        sb.append("DF:Don't Fragment: ");
        sb.append(dont_frag);
        addSeparator(sb);
        sb.append("MF:More Fragment: ");
        sb.append(more_frag);
        addSeparator(sb);
        sb.append("片偏移: ");
        sb.append(offset);
        addSeparator(sb);
        sb.append("生存时间: ");
        sb.append(hop_limit);
        addSeparator(sb);
        sb.append("上层协议类型: ");
        sb.append(protocol);
        sb.append("\n");
        sb.append("头校验和: ");
        sb.append(check_sum);
        addSeparator(sb);
        sb.append("源IP地址: ");
        sb.append(src_ip);
        addSeparator(sb);
        sb.append("目的IP地址: ");
        sb.append(dst_ip);
        return sb.toString();
    }

    private void addSeparator(StringBuilder sb) {
        sb.append("\t");
    }
}
