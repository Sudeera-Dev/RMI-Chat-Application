/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.main.ChatClient;
import app.main.Message;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author KrzYoFreaK
 */
public interface Chat extends Remote{
    
    public void send_message(Message msg) throws RemoteException;

    public Message broadcast() throws RemoteException;
    
    public void subscribre(int group_id,ChatClient c) throws RemoteException;
    
    public void unsubscribre(int group_id,ChatClient c) throws RemoteException;
    
    public boolean is_subscribed(int client_id) throws RemoteException;
}
