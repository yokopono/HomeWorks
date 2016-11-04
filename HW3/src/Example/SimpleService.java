package Example;

/**
 * Created by Yoko on 30.10.2016.
 */
@Service(name = "Simple11Service")
public class SimpleService {
    @Init(name = "InitService11")
    public void initService() {
        System.out.println("InitService");
    }
    public void ruhaha() {
        System.out.println("ruhaha");
    }
}
