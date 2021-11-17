import java.util.HashMap;

public class IDsandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDsandPasswords(){
        loginInfo.put("7708952197", "April");
        loginInfo.put("7708378827", "Cydney");
        loginInfo.put("7709053185", "Mom");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
