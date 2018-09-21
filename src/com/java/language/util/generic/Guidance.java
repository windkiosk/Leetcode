package com.java.language.util.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 1/6/15.
 */
public class Guidance {
    public static void main(String[] strings) {
        List<EvenNumber> le = new ArrayList<EvenNumber>();
        List<? extends NaturalNumber> ln = le;
        //ln.add(new NaturalNumber(35));  // compile-time error
        //ln.add(new EvenNumber(35));  // compile-time error

        List<? extends NaturalNumber> natureList = new ArrayList<NaturalNumber>();
        //natureList.add(new EvenNumber(35));
    }
}

class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}
