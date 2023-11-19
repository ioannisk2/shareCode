import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GiannisListes {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list=new ArrayList<Integer>();
        String pathNumbers="/Users/dimitris/JimProjects/DoraDimitrisProject/dataSamples/sample.txt";
        list=readfileNumbers(pathNumbers);
        System.out.println("Lista"+list);
        System.out.println("List sum="+listSum(list));
        System.out.println("max="+findMaxNumber(list));
        System.out.println("min="+findMinNumber(list));
    }
    private static ArrayList<Integer> readfileNumbers(String path) throws Exception{
        ArrayList<Integer> list=new ArrayList<Integer>();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            list.add(Integer.parseInt(st));
        }
        return list;
    }
    private static Integer listSum(ArrayList<Integer> list){
        Integer temp=0;
        for (Integer i =0;i<list.size();i++){
            temp=temp+list.get(i);
        }
        return  temp;
    }
    private static Integer findMaxNumber(ArrayList<Integer> list){
        Integer temp=0;
        for (Integer i=0;i<list.size();i++){
            if (temp<list.get(i)){
                temp=list.get(i);
            }
        }
        return temp;
    }
    private static Integer findMinNumber(ArrayList<Integer> list){
        Integer temp=list.get(0);
        for (Integer i=0;i<list.size();i++){
            if (temp>list.get(i)){
                temp=list.get(i);
            }
        }
        return temp;
    }
}
