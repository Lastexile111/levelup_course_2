package lesson1Git;

public class ChessFigure {

    private String name;
    public String color;

    public void move(){

    }

    private void remove(String param){
        System.out.println("remove with param = " + param +" method invoked");
    }

    @Override
    public String toString() {
        return "ChessFigure{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
