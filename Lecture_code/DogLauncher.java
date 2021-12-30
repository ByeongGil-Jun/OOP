public class DogLauncher{
    public static void main(String[] Args) {
        Dog[] dogs = new Dog[]{
                new Dog(10),
                new Dog(15),
                new Dog(20),
                new Dog(15),
                new Dog(10),
                new Dog(5),
                new Dog(10),
                new Dog(15),
                new Dog(22),
                new Dog(15),
                new Dog(20)
        };
        Dog[] bigDogs1 = LargerThanFourNeighbors(dogs);

        for(int k = 0; k < bigDogs1.length; k++)
            System.out.println(bigDogs1[k].weightInPounds + " ");
    }
}