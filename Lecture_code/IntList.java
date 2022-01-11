public class IntList{
    int first;
    IntList next;

    public int size() {
        if (next == null) {
            return 1;
        }
        return next.size() + 1;
    }

    public int iterativeSize() {
        IntList temp = this;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    int get(int Index) {
        IntList temp = this;
        int count = Index;
        while (count > 0) {
            temp = temp.next;
            count--;
        }
        return temp.first;
    }
    public IntList(int f, IntList n){
        this.first = f;
        this.next = n;
    }
    public static void main(String[] args){
        IntList l = new IntList(5, null);
        l.next = new IntList(10, null);
        l.next.next = new IntList(15, null);

        System.out.println(l.size());
        System.out.println(l.iterativeSize());
        System.out.println(l.get(2));
    }
}