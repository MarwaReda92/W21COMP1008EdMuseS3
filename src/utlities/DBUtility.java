package utlities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class will simulate getting information from a database
 */
public class DBUtility {

    public static List<String> getAvailableCourseCodes(){
        return Arrays.asList("COMP 1002","COMP 1030","COMP 1035","COMP 1045",
                "COMP 1045","COMP 1003","COMP 1006","COMP 1008",
                "COMP 1098","COMP 2003","ENTR 1002","COMP 1009",
                "COMP 1011","COMP 1073","COMP 2084","COMP 3002","COMP 2068");
    }
}
