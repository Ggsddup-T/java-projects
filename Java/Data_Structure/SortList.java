import java.util.*;
import java.util.stream.*;
//Write your code here...

class Sorter{

   public static List<String> sortList(List<String> slist){
       List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());
       return sortedList;
   }
}

public class SortList extends Sorter{
    public static void main(String[] args){
        List<String> slist = Arrays.asList("Triangle", "Square", "Spline", "Circle", "Rectangle", "Cone");
        System.out.println("Elements of the list: " + slist);
        slist = sortList(slist);
        System.out.println("Elements of the list after sorting: " + slist);
    }
}