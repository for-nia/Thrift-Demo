package thrift;

import org.apache.thrift.protocol.TProtocol;

/**
 * Created by fornia on 16/12/7.
 */
public interface ThriftClientInterface {
    TProtocol getProtocol(SocketConfig config);
}
