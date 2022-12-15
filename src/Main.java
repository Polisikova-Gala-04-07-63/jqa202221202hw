import com.telran.Environment;
import com.telran.NotOwnerException;


public class Main {

    public static void main(String[] args) throws NotOwnerException {

        Environment qa = new Environment(
                0,
                0,
                "https://qa.qa",
                 Environment.QA,
                "1");
        try {
            qa.deploy("2");
        } catch (NotOwnerException e) {
            throw new RuntimeException(e);
        }

        Environment dev = new Environment(
                0,
                0,
                "https://dev.dev",
                Environment.DEV,
                "1");
    try {
        dev.deploy("3");
    } catch (NotOwnerException exception){
        throw new RuntimeException(exception);
    }


        Environment prod = new Environment(0,
                0,
                "https://prod.prod",
                 Environment.PROD,
                "1");
    try {
        prod.deploy("4");
    } catch (NotOwnerException e){
        throw new RuntimeException(e);
    }


    }


}
