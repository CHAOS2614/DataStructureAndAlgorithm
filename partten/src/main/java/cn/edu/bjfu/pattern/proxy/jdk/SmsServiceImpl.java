package cn.edu.bjfu.pattern.proxy.jdk;

/**
 * @author chaos
 * @date 2022-10-09 14:24
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        return "send " + message;
    }
}
