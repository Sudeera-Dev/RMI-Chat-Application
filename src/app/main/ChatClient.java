/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.main;

import java.io.Serializable;

/**
 *
 * @author KrzYoFreaK
 */
public class ChatClient implements Serializable {
    public int id;
    public String username;
    public String nickname;
   

    public ChatClient(int id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }
}
