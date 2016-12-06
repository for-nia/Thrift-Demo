package thrift.protocol;

import org.apache.thrift.TException;

/**
 * Created by fornia on 16/12/7.
 */
public class HelloImpl implements Hello.Iface{
    @Override
    public String hello(String hi) throws TException {
        return hi+" I am server !";
    }
}
