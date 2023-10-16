public class Main {

    public static void main(String args[]) {
        Class class1 = Reflection.class;
        System.out.println(class1);

        Reflection produto = new Reflection();
        Class class2 = produto.getClass();
        System.out.println(class2);
    }
}
