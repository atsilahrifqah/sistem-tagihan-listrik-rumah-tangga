/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerRMI;
import ServerRMI.Services;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author apple
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        // TODO code application logic here
        
        Services serv = new Services();
        try {
        Registry register = LocateRegistry.createRegistry(2000);
        register.bind("services", serv);
        System.out.println("Server is connected and ready for operation");
        }
        catch(Exception e){
            e.printStackTrace();
            } 
    }
    
}
