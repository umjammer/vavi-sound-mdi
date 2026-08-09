package musicDriverInterface;

import java.util.ArrayList;
import java.util.List;

import vavi.util.compat.Tuple3;


abstract class Information {
    public final List<Tuple3<Integer, Integer, String>> warningList = new ArrayList<>();
    public final List<Tuple3<Integer, Integer, String>> errorList = new ArrayList<>();
}
