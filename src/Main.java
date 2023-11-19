import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Human> humans=new ArrayList<Human>();
        String pathNumbers="/Users/dimitris/JimProjects/DoraDimitrisProject/dataSamples/sample.txt";
        list=readfileNumbers(pathNumbers);

        System.out.println("Lista"+list);
        System.out.println("List sum="+listSum(list));
        System.out.println("max="+findMaxNumber(list));
        System.out.println("min="+findMinNumber(list));

        humans=createHumans();
        for (Integer i =0;i<humans.size();i++){
            System.out.println((i+1)+" "+humans.get(i).name+", "+humans.get(i).surname+", "+humans.get(i).gender+", "+humans.get(i).age+", "+humans.get(i).mobile);
        }
        System.out.println("Plithos oikogeneiwn="+humans.size());
        System.out.println("Aριθμός πάνω απο 4="+howManyNamesMoreThanX(humans,5));
        System.out.println("Aριθμός πάνω απο 4="+howManyNamesMoreThanX(humans,6));
    }

    private static ArrayList<Human> createHumans() throws Exception{
        ArrayList<String> hu=new ArrayList<String>();
        ArrayList<Human> humans=new ArrayList<Human>();
        String pathHumans="/Users/dimitris/JimProjects/DoraDimitrisProject/dataSamples/humans.txt";
        hu=readfileString(pathHumans);

        for(Integer i=0;i<hu.size();i++){
            Human h=new Human();
            List<String> temp;
            temp=Arrays.stream(hu.get(i).split(";")).toList();
            h.name=temp.get(0);
            h.surname=temp.get(1);
            h.age=Integer.parseInt(temp.get(2));
            h.gender=temp.get(3);
            h.mobile=temp.get(4);
            humans.add(h);
        }
        return humans;
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

    private static Integer listSum(ArrayList<Integer> list){
        Integer listSum=0;
        for (Integer i =0;i<list.size();i++){
            listSum=listSum+list.get(i);
        }
        return  listSum;
    }

    private static Integer findMaxNumber(ArrayList<Integer> list){
        Integer maxNumber=0;
        for (Integer i=0;i<list.size();i++){
            if (maxNumber<list.get(i)){
                maxNumber=list.get(i);
            }
        }
        return maxNumber;
    }

    private static Integer findMinNumber(ArrayList<Integer> list){
        Integer minNumber=list.get(0);
        for (Integer i=0;i<list.size();i++){
            if (minNumber>list.get(i)){
                minNumber=list.get(i);
            }
        }
        return minNumber;
    }

    private static Integer howManyNamesMoreThanX(ArrayList<Human> list,Integer x){
        Integer counter=0;
        for (Integer i=0;i<list.size();i++){
            if (list.get(i).name.length()>x){
                counter=counter+1;
            }
        }
        return counter;
    }

}