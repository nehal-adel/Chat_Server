package org.example.Controller;

import org.example.AdminController;
import org.example.App;
import org.example.Interfaces.IChatService;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainController {
    App view ;
    AdminController adminController;
    public MainController(AdminController adminController){
        this.adminController =  adminController;
    }

    public void createRegistry(){
        Registry reg = null;
        try {
            IChatService chatServie = new ChatService();
//            reg = LocateRegistry.getRegistry();
//            reg.rebind("ChatService", chatService);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
