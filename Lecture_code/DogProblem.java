public class DogProblem {
    public static boolean isValidIndex(Dog[] dogs, int currentDog, int neighborDog){
        return neighborDog >= 0 && neighborDog < dogs.length && currentDog != neighborDog;
    }

    public static boolean isBigEnoughDog(Dog[] dogs, int currentDog){
        for(int i = currentDog -2; i < currentDog+2; i++) {
            if (!isValidIndex(dogs, currentDog, i)) {
                continue;
            }
            if (dogs[currentDog].weightInPounds < dogs[i].weightInPounds){
                return false;
            }
        }
        return true;
    }
    public static Dog[] LargerThanFourNeighbors(Dog[] dogs) {
        Dog[] temp_dog = new Dog[dogs.length];
        int x = 0;

        for(int i = 0; i<dogs.length; i++) {
            if (isBigEnoughDog(dogs, i)) {
                temp_dog[x++] = dogs[i];
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