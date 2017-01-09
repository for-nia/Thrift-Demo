package thrift;

import static junit.framework.Assert.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingSocket;
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
            //TTransport transport = new TSocket("localhost", 1234, 300000000);
            TNonblockingSocket transport = new TNonblockingSocket("localhost", 1234, 300000000);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            String hi = "hi";
            String fromServer = client.hello(hi);
            transport.close();
            assertEquals(hi + " I am server !",fromServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNonHi(){
        try {
            TTransport transport = new TSocket("localhost", 1234, 300000000);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            String hi = "hi";
            String fromServer = client.hello(hi);
            transport.close();
            assertEquals(hi + " I am server !",fromServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
