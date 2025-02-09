
//This program maintains LISKOV Principle 

public class AssignmentTwo{
    public static void main(String[] args) {
    
        Bird bird1 = new Duck();	//Creating an var which can be used by Duck() acc.to their ability 
        bird1.eat();			
                
        Bird bird2 = new Penguin();	//Creating an var which can be used by Penguin() acc.to their ability
        bird2.eat();
	
	Duck d = new Duck();		//Bcoz Duck() implements FlyBird() so it call the fly() method
	d.fly();

        Penguin p = new Penguin();
        p.cannotfly(); 
    }
    
    interface FlyBird {		//Interface that allows OCP principle 
      void fly();
    }
    
    static class Bird {
    void eat() {
        System.out.println("Bird is eating.");
      }
  }

    static class Duck extends Bird implements FlyBird {		//Using Interface it use the function (...also follows OCP)
      @Override		//This is a method to use the functions of parent classes
      public void fly() {
          System.out.println("Duck is flying.");
      }
  }

    static class Penguin extends Bird { //If Penguin also implements FlyBird than it will violate the Liskov principle
      void cannotfly() {
          System.out.println("Penguin cannot fly.");
      }
  }
}
