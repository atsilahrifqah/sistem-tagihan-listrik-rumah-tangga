/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServerRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author ASUS
 */
public interface OperationRMI extends Remote {
    double calculateElectricityBill(double daya, double lamaGuna, int jumlahHari, String jenisListrik, double ppj) throws RemoteException;
}
