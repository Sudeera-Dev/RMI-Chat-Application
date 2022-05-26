/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dbManager;

import app.connect.Connect;
import app.pojos.Users;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author KrzYoFreaK
 */
public class UsersHandler {
        
        
        public List userDetails(){
            Session s = Connect.getSessionFactory().openSession();
            List users = s.createQuery("FROM Users").list();
            
            s.close();
            return users;
        }
        
        public Boolean insertUser(byte[] pic,String uname,String upass,String unname){
            Session s = Connect.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            Users usr = new Users();
            usr.setName(uname);
            usr.setNickname(unname);
            usr.setPassword(upass);
            usr.setPic(pic);
            usr.setRole("user");
            
            s.save(usr);
            t.commit();
            s.close();
            return true;
        }
    
}
