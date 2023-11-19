import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiannisHumans {
    public static void main(String[] args) throws Exception{

        ArrayList<Human> humans=new ArrayList<Human>();

        humans=createHumans();
        for (Integer i =0;i<humans.size();i++){
            System.out.println((i+1)+" "+humans.get(i).name+", "+humans.get(i).surname+", "+humans.get(i).gender+", "+humans.get(i).age+", "+humans.get(i).mobile);
        }
        System.out.println("Plithos oikogeneiwn="+humans.size());

    }

    private static ArrayList<Human> createHumans() throws Exception{
        ArrayList<String> hu=new ArrayList<String>();
        ArrayList<Human> humans=new ArrayList<Human>();
        String pathHumans="/Users/dimitris/JimProjects/DoraDimitrisProject/dataSamples/humans.txt";
        hu=readfileString(pathHumans);

        for(Integer i=0;i<hu.size();i++){
            Human h=new Human();
            List<String> temp;
            temp= Arrays.stream(hu.get(i).split(";")).toList();
            h.name=temp.get(0);
            h.surname=temp.get(1);
            h.age=Integer.parseInt(temp.get(2));
            h.gender=temp.get(3);
            h.mobile=temp.get(4);
            humans.add(h);
        }
        return humans;
    }

    private static ArrayList<String> readfileString(String path) throws Exception{
        ArrayList<String> list=new ArrayList<String>();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            list.add(st.toString());
        }
        return list;
    }


}
