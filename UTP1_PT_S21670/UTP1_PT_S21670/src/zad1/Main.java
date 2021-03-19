/**
 *
 *  @author Pyrzak Tomasz S21670
 *
 */

package zad1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector<Boolean>(){

      @Override
      public boolean select(Object e) {
        if((Integer)e < 10) {
          return true;
        }else {
          return false;
        }
      }
    };

    Mapper map = new Mapper<Integer,Integer>() {

      @Override
      public Integer map(Integer e) {
        int x = e;
        x += 10;
        return x;
      }
    };

    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector sel = new Selector<Boolean>() {

      @Override
      public boolean select(Object e) {
        String x = (String)e;
        if(x.length() > 3){
          return true;
        }else {
          return false;
        }
      }
    };

    Mapper map = new Mapper<String, Integer>() {

      @Override
      public Integer map(String e) {
        int x = e.length() + 10;
        return x;
      }

    };
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
