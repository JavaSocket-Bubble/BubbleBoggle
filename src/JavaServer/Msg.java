package JavaServer;

public class Msg {

    public String code; // 100:로그인, 200:동작정보, 300:아이템정보, 400:end점수데이터, 500: Logout
    public String UserName;
    public String data;

    public Msg(String UserName, String code, String msg) {
        this.code = code;
        this.UserName = UserName;
        this.data = msg;
    }

}
