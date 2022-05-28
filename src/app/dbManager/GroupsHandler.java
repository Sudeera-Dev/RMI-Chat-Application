/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dbManager;

import app.connect.Connect;
import app.pojos.Groups;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
