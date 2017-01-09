package thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.protocol.Hello;
import thrift.protocol.HelloImpl;

/**
 * Created by fornia on 1/10/17.
 */
public class NonBlockingServer {
    public static void main(String[] args){
        try {
            TServerTransport serverTransport = new TNonblockingServerSocket(1234);
            Hello.Processor process = new Hello.Processor(new HelloImpl());
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            TThreadedSelectorServer.Args as = new TThreadedSelectorServer.Args((TNonblockingServerSocket)serverTransport);
            as.processor(process);
            as.protocolFactory(portFactory);
            TServer server = new TThreadedSelectorServer(as);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
