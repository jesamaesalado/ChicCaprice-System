/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system;

/**
 *
 * @author student.admin
 */
class users {
     private int sno;
    private String firstname, lastname,username, password, email, usertype;
    
    public users(int sno, String firstname, String lastname, String username, String password, String email, String usertype){
        this.sno= sno;
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
        this.email=email;
        this.usertype=usertype;
    }
    public int getsno(){
        return sno;
    }
    public String getfirstname(){
        return firstname;
    }
    public String getlastname(){
        return lastname;
    }
    public String getusername(){
        return username;
    }
     public String getpassword(){
        return password;
    }
      public String getemail(){
        return email;
    }
    public String getusertype(){
        return usertype;
    }

}
