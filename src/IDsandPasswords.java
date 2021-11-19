import java.util.HashMap;

public class IDsandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDsandPasswords(){
        loginInfo.put("770-895-2197", "April");
        loginInfo.put("770-837-8827", "Cydney");
        loginInfo.put("770-905-3185", "Carla");
        loginInfo.remove("111-222-3333");
    }

    public HashMap getLoginInfo(){
        return loginInfo;
    }
    
    public void addLogin(String phoneNumber, String password){
        loginInfo.put(phoneNumber,password);
    }

    public boolean accountExists(String phoneNumber){
        return loginInfo.containsKey(phoneNumber);
    }
}
