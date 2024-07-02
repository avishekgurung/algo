package backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem008 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        permutation(list, new ArrayList<>());
    }
    private static void permutation(List<Integer> list, List<Integer> aux) {
        if(list.isEmpty()) {
            System.out.println(aux);
            return;
        }

        for(int i=0; i < list.size(); i++) {
            List<Integer> aux1 = new ArrayList<>(aux);
            aux1.add(list.get(i));

            List<Integer> sub1 = list.subList(0, i);
            List<Integer> sub2 = list.subList(i+1, list.size());
            List<Integer> subFinal = new ArrayList<>();
            subFinal.addAll(sub1);
            subFinal.addAll(sub2);
            permutation(subFinal, aux1);
        }


    }

}
