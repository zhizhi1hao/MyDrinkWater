package demo.example.com.mydrinkwater.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaa on 15-4-26.
 */
public class AppData {

    public static List<String> list;
    static {
        list=new ArrayList<String>();
        for(int i=0;i<7;i++){
            list.add(12+i+":00");

        }
    }

}
