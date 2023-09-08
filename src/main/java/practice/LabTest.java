package practice;


import java.util.*;


class CustomNode {
    int element;
    int freq;

    CustomNode(int freq, int element) {
        this.element = element;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Element: " + this.element + ", Freq: " + this.freq;
    }
}

class CustomNodeComparator implements Comparator<CustomNode> {
    @Override
    public int compare(CustomNode o1, CustomNode o2) {
        if(o1.freq > o2.freq) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class LabTest {
    public static void main(String[] args) {
        //PriorityQueue<CustomNode> maxHeap = new PriorityQueue<>(new CustomNodeComparator());
        List<CustomNode> list = new ArrayList<>();
        list.add(new CustomNode(1, 3));
        list.add(new CustomNode(2, 1));
        list.add(new CustomNode(3, 7));
        list.add(new CustomNode(4, 5));
        list.add(new CustomNode(5, 6));

        Collections.sort(list, new CustomNodeComparator());
        Collections.reverse(list);

        for(CustomNode node: list) {
            System.out.println(node);
        }
    }
}
