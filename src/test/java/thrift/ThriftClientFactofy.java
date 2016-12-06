package thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by fornia on 16/12/7.
 */
public class ThriftClientFactofy implements ThriftClientInterface{
    @Override
    public TProtocol getProtocol(SocketConfig config) {
        TTransport transport = new TSocket(config.getHost(),config.getPort(),config.getTimeout());
        //transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        return null;
    }
}
