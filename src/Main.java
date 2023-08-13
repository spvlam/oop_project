import java.util.ArrayList;

import src.vietnam.diTichTrenVietnam;

public class Main {
    // for testing purpose
    public static void main(String[] args) {
        diTichTrenVietnam abc = new diTichTrenVietnam(null, null, null, null, null, null, null);
        ArrayList<diTichTrenVietnam> arr = abc.search("Hà");
        System.out.println(arr.size());
        for(diTichTrenVietnam a: arr){
            System.out.println(a);
            break;
        }
    }
}
