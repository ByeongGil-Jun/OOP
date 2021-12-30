public class DogProblemNoHelperMethods {
    public static Dog[] LargerThanFourNeighbors(Dog[] dogs) {
        Dog[] temp_dog = new Dog[dogs.length];
        int x = 0;
        for(int i = 0; i<dogs.length; i++) {
            for(int j = -2; j<3; j++) {
                if ((i + j) > dogs.length) {
                    break;
                } else if (j == 0 || (i + j) < 0) {
                    continue;
                } else if (dogs[i].weightInPounds < dogs[i + j].weightInPounds) {
                    break;
                } else if (j == 2) {
                    temp_dog[x] = dogs[i];
                    x++;
                }
            }
        }
        Dog[] answer = new Dog[x];
        for(int i = 0; i < x; i++){
            answer[i] = temp_dog[i];
        }
        return answer;
    }

    public static void main(String[] args){
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