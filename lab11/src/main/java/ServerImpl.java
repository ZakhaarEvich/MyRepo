import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    protected ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String processHouse(House house) throws RemoteException {
        // Here, you can perform operations on the received House object
        return "Received and processed House object: " + house.toString();
    }
}
