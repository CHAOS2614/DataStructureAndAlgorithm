package cn.edu.bjfu.pattern.proxy.jdk;

/**
 * @author chaos
 * @date 2022-10-09 14:24
 */
public class Test {
    public static void main(String[] args) {
        SmsService service = (SmsService) ProxyFactory.getProxy(new SmsServiceImpl());
        System.out.println(service.send("hello"));
    }
}
