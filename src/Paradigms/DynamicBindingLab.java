package Paradigms;

public class DynamicBindingLab {

    public static void main(String[] args) {

        BindingSuper X = new BindingSuper();
        Binding Y = new Binding();

        X.print();
        Y.print();

    }

    public static class BindingSuper {

        public void print() {
            System.out.println("This is BindingSuper");
        }

    }

    public static class Binding extends BindingSuper {

        @Override
        public void print() {
            System.out.println("This is the BindingSuper subclass");
        }

    }

}
