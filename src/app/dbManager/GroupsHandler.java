/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dbManager;

import app.connect.Connect;
import app.main.ChatClient;
import app.pojos.Groups;
import app.pojos.Users;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author KrzYoFreaK
 */
public class GroupsHandler {
    
    private Date currentDate(){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now();
            
            Date date=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(now.format(dtf));
            
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(GroupsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Date currentTime(){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            
            Date date=(Date) new SimpleDateFormat("HH:mm:ss").parse(now.format(dtf));
            
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(GroupsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List groupDetails(){
            Session s = Connect.getSessionFactory().openSession();
            List groups = s.createQuery("FROM Groups").list();
            
            s.close();
            return groups;
        }
    
    public Boolean createGroup(String name,String desc){
        Session s = Connect.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Groups grp = new Groups();
        grp.setName(name);
        grp.setStatus(0);
        grp.setDescription(desc);
        grp.setCdate(currentDate());
        grp.setCtime(currentTime());
        
        s.save(grp);
        t.commit();
        s.close();
        return true;
    }
    
    public Boolean updateGroupStat(int id,int stat){
        Session s = Connect.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        
        Groups grp = (Groups) s.load(Groups.class, id);
        
        grp.setStatus(stat);
        s.save(grp);
        t.commit();
        s.close();
        return null;
        
    }
    
    public void put_offline(int id) {
        Session s = Connect.getSessionFactory().openSession();
        Transaction tran = s.beginTransaction();

        Groups groups = (Groups) s.load(Groups.class, id);
        groups.setStatus(0);

        s.update(groups);
        tran.commit();
        System.out.println(id + "offline...");
        s.close();
    }
    
    public boolean is_online(int chat_id) {
        Session s = Connect.getSessionFactory().openSession();
        
        List groups = s.createQuery("FROM Groups").list();
        
        for (Iterator it = groups.iterator(); it.hasNext();) {
                Groups temp = (Groups) it.next();
                if(chat_id==temp.getId()){
                    if(temp.getStatus()== 1){
                        return true;
                    }
                    return false;
                }
                  
        }
        return false;
        
    }
    
     public boolean put_online(int chat_id) {

        if (check_all_offline()) {

            Session s =  Connect.getSessionFactory().openSession();
            Transaction tran = s.beginTransaction();

            Groups group = (Groups) s.load(Groups.class, chat_id);
            group.setStatus(1);

            s.save(group);
            tran.commit();
            System.out.println(chat_id + "online...");
            s.close();

            return true;
        } else {
            return false;
        }
    }

    private boolean check_all_offline() {
        List groups= groupDetails();
        
        for (Iterator it = groups.iterator(); it.hasNext();) {
                Groups temp = (Groups) it.next();
                if(temp.getStatus()==1){
                    return false;
                }
                  
        }
        return true;
    }
}
