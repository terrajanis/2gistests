package helpers;

import java.util.Collections;
import java.util.List;

public class NameHelper {

   public boolean compareLists(List<String> one, List<String> two) {

       boolean result = true;

       Collections.sort(one);
       Collections.sort(two);

       return one.equals(two);
   }
}
