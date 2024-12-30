/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ASUS
 */
public class Services extends UnicastRemoteObject implements OperationRMI {

    public Services() throws RemoteException {
        super();
    }

    @Override
    public double calculateElectricityBill(double daya, double lamaGuna, int jumlahHari, String jenisListrik, double ppj) throws RemoteException {
        // Step 1: Determine TarifPerKwh based on jenisListrik
        double TarifPerKwh;
        switch (jenisListrik) {
            case "R-1/TR (900 VA)":
                TarifPerKwh = 1352;
                break;
            case "R-1/TR (1.300 VA)":
            case "R-1/TR (2.200 VA)":
                TarifPerKwh = 1444.70;
                break;
            case "R-2/TR (3.500-5.500 VA)":
            case "R-3/TR (6.600 VA ke atas)":
                TarifPerKwh = 1699.53;
                break;
            default:
                throw new IllegalArgumentException("Jenis listrik tidak valid!");
        }

        // Step 2: Calculate energy consumption in kWh
        double kwh = daya * lamaGuna * jumlahHari / 1000.0; // Convert Watt to kW

        // Step 3: Calculate bill before tax
        double tagihanSebelumPajak = kwh * TarifPerKwh;

        // Step 4: Calculate tax
        double pajak = tagihanSebelumPajak * (ppj / 100.0);

        // Step 5: Calculate total bill
        return tagihanSebelumPajak + pajak;
    }
}
