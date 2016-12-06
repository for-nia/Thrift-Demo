package thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.protocol.Hello;
import thrift.protocol.HelloImpl;

/**
 * Created by fornia on 16/12/7.
 */
public class ThriftSerever {

    public static void main(String[] args){
        try {
            TServerSocket serverTransport = new TServerSocket(1234);
            Hello.Processor process = new Hello.Processor(new HelloImpl());
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            TThreadPoolServer.Args as = new TThreadPoolServer.Args(serverTransport);
            as.processor(process);
            as.protocolFactory(portFactory);
            TServer server = new TThreadPoolServer(as);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
