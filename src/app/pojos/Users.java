package app.pojos;
// Generated May 26, 2022 11:39:41 AM by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String nickname;
     private String password;
     private byte[] pic;
     private String role;

    public Users() {
    }

    public Users(String name, String nickname, String password, byte[] pic, String role) {
       this.name = name;
       this.nickname = nickname;
       this.password = password;
       this.pic = pic;
       this.role = role;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public byte[] getPic() {
        return this.pic;
    }
    
    public void setPic(byte[] pic) {
        this.pic = pic;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }





}


