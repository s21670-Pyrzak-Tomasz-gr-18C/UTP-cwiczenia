/**
 *
 *  @author Pyrzak Tomasz S21670
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {
    private List<T> list;
    private List<T> listTmp;

    public ListCreator(List<T> lsit) {
        super();
        this.list = lsit;
    }

    public static <T> ListCreator<T> collectFrom(List<T> lista){
        ListCreator<T> lc = new ListCreator<>(lista);
        return lc;
    }

    public ListCreator<T> when(Selector<T> s) {
        listTmp = new ArrayList<T>();

        for (int i = 0; i < list.size(); i++) {
            if(s.select(list.get(i))) {
                listTmp.add(list.get(i));
            }
        }

        this.list = listTmp;
        return this;
    }

    public List<T> mapEvery(Mapper m) {
        listTmp = new ArrayList<T>();

        for (T e : list) {
            listTmp.add((T) (m.map(e)));
        }

        this.list = listTmp;
        return list;
    }

}