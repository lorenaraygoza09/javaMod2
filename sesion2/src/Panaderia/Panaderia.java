package Panaderia;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Panaderia {
    // [] es un array
    public static String[] catalogo = new String[] {"🥞", "🥯", "🫓", "🥖", "🥐", "🍞"};
    public static List<String> canasta =  new LinkedList<>();
    public static ReentrantLock candado = new ReentrantLock();
}
