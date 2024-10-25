import java.io.FileWriter;
import java.util.PriorityQueue;

class Toy {
    static Integer count = 0;

    private int id;
    private String name;
    private int weight;

    public Toy(String name, int weight) {
        this.id = ++count;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

class ToyMarket {
    private PriorityQueue<Toy> toys;


    public ToyMarket() {
        toys = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());
    }

    public void addToy(Toy toy) {
        toys.offer(toy);
    }

    public void play() throws Exception {
        FileWriter writer = new FileWriter("output.txt");

        int size = toys.size();
        if (size < 3) {
            System.err.println("Меньше 3-х игрушек!");
            System.exit(1);
        }

        for (int i = 0; i < size; i++) {
            Toy toy = toys.poll();
            System.out.println("Выпало: " + toy.getName());
            writer.write("Выпало: " + toy.getName() + "\n");
        }
        writer.close();
    }

}


public class Main {
    public static void main(String[] args) throws Exception {
        ToyMarket toyMarket = new ToyMarket();

        toyMarket.addToy(new Toy("Кукла", 5));
        toyMarket.addToy(new Toy("Машинка", 2));
        toyMarket.addToy(new Toy("Мишка", 10));
        toyMarket.addToy(new Toy("Мячик", 1));
        toyMarket.addToy(new Toy("Солдатик", 3));
        toyMarket.addToy(new Toy("Йо-Йо", 7));
        toyMarket.addToy(new Toy("Ведёрко", 2));
        toyMarket.addToy(new Toy("Лопатка", 1));
        toyMarket.addToy(new Toy("Самолётик", 6));
        toyMarket.addToy(new Toy("Кораблик", 9));

        toyMarket.play();

    }
}