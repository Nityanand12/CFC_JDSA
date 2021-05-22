import java.util.*;

class CustomSet<k> {
    ArrayList<LinkedList<k>> arr;
    static int defaultSize = 20;
    int size;
    static double loadFactor = 0.75;

    CustomSet() {
        this.arr = new ArrayList<>();
        for (int i = 0; i < defaultSize; i++) {
            arr.add(new LinkedList<>());
        }
        this.size = 0;
    }

    private void rehash() {
        ArrayList<LinkedList<k>> old = arr;
        arr = new ArrayList<>();
        for (int i = 0; i < old.size() * 2; i++) {
            arr.add(new LinkedList<>());
        }
        size = 0;
        for (LinkedList<k> list : old) {
            for (k ele : list) {
                add(ele);
            }
        }
    }

    public void add(k data) {
        int hash = data.hashCode();
        int index = hash % arr.size();
        LinkedList<k> list = arr.get(index);
        for (k key : list) {
            if (key.equals(data)) {
                return;
            }
        }
        list.add(data);
        size++;
        if (size / arr.size() > loadFactor) {
            rehash();
        }
    }

    public boolean contains(k data) {
        int hash = data.hashCode();
        int index = hash % arr.size();
        LinkedList<k> list = arr.get(index);
        for (k key : list) {
            if (key.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(k data) {
        int hash = data.hashCode();
        int index = hash % arr.size();
        LinkedList<k> list = arr.get(index);
        for (k key : list) {
            if (key.equals(data)) {
                size--;
                list.remove(data);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<k> list : arr) {
            for (k ele : list) {
                sb.append(ele).append(" ");
            }
        }
        return sb.toString();
    }
}

class CustomHashMap<k, v> {
    class Node {
        k key;
        v value;

        Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<LinkedList<Node>> arr;
    static int defaultSize = 20;
    int size;
    static double loadFactor = 0.75;

    CustomHashMap() {
        this.arr = new ArrayList<>();
        for (int i = 0; i < defaultSize; i++) {
            arr.add(new LinkedList<>());
        }
        this.size = 0;
    }

    public void rehash() {
        ArrayList<LinkedList<Node>> old = arr;
        arr = new ArrayList<>();
        for (int i = 0; i < old.size() * 2; i++) {
            arr.add(new LinkedList<>());
        }
        size = 0;
        for (LinkedList<Node> list : old) {
            for (Node node : list) {
                put(node.key, node.value);
            }
        }
    }

    public void put(k key, v value) {
        int hash = key.hashCode();
        int index = hash % arr.size();
        LinkedList<Node> list = arr.get(index);
        for (Node node : list) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        list.add(new Node(key, value));
        size++;
        if (size / arr.size() > loadFactor) {
            rehash();
        }
    }

    public v get(k key) {
        if (containsKey(key)) {
            int hash = key.hashCode();
            int index = hash % arr.size();
            LinkedList<Node> list = arr.get(index);
            for (Node node : list) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    public v remove(k key) {
        int hash = key.hashCode();
        int index = hash % arr.size();
        LinkedList<Node> list = arr.get(index);
        for (Node node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                size--;
                return node.value;
            }
        }
        return null;
    }

    public boolean containsKey(k key) {
        int hash = key.hashCode();
        int index = hash % arr.size();
        LinkedList<Node> list = arr.get(index);
        for (Node node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(LinkedList<Node> list: arr){
            for(Node node: list){
                sb.append(node.key+" "+node.value+"\n");
            }
        }
        return sb.toString();
    }

}

public class lecture16 {
    public static void main(String[] args) {
        // CustomSet<String> cs1= new CustomSet<>();
        // cs1.toString();
        // cs1.add("10");
        // cs1.add("20");
        // cs1.add("30");
        // cs1.add("40");
        // cs1.add("10");
        // System.out.println(cs1.contains("10"));
        // cs1.remove("10");
        // System.out.println(cs1.contains("10"));
        // System.out.println(cs1);

        // HashSet<String>set= new HashSet<>();
        // set.add("10");
        // set.add("20");
        // set.add("30");
        // set.add("40");
        // System.out.println(set.contains("10"));
        // set.remove("10");
        // System.out.println(set.contains("10"));

        // CustomHashMap<String,Integer>map= new CustomHashMap<>();
        String arr[]={"abc","def","ghi","abc","gh","def"};
        // for(int i=0;i<arr.length;i++){
        //     if(map.containsKey(arr[i])){
        //         int value= map.get(arr[i]);
        //         map.put(arr[i], value+1);
        //     }
        //     else{
        //         map.put(arr[i], 1);
        //     }
        // }
        // System.out.println(map);

        HashMap<String,Integer>map2= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // if(map2.containsKey(arr[i])){
            //     int value= map2.get(arr[i]);
            //     map2.put(arr[i], value+1);
            // }
            // else{
            //     map2.put(arr[i], 1);
            // }
            map2.put(arr[i],map2.getOrDefault(arr[i],0)+1);
        }
        for(String ele: map2.keySet()){
            System.out.println(ele+" "+map2.get(ele));
        }
    }
}
