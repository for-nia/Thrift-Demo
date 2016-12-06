package thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import thrift.protocol.Hello;

/**
 * Created by fornia on 16/12/7.
 */
public class HelloTest {

    @Test
    public void testHi() {
        try {
            TTransport transport = new TSocket("localhost", 1234, 300000000);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            System.out.println(client.hello("hello"));
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
