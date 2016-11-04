package Example;

/**
 * Created by Yoko on 30.10.2016.
 */
@Service(name = "Lazy11Service")
public class LazyService {
    @Init(name = "LazyInit11")
    public void lazyInit() throws Exception {
        System.out.println("LazyInit");
    }
}
