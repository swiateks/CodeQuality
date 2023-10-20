# 4 - SOLID Principles
In this lab you will implement each of the SOLID Principles and update the code
> Duration: 30-40 minutes

## 4.1 Update the code to comply with Single Responsibility Principle

1. Look at the bad example, or the violation of Principle at [Board.java](../module4/SOLID-main/single_responsibility/bad/src/Board.java)
2. This class is creating all the rows and displaying them.
3. Look at the repetitive nature of its tasks and how its trying to achieve too many activities.
4. Open the file [BoardPresenter.java](../module4/SOLID-main/single_responsibility/good/src/BoardPresenter.java)
5. Edit the file and copy the following code to Display Board after line 12:
  
   ```
   public void displayBoard() {
        String formattedBoard = "";
        for (int i = 0; i < this.board.size*this.board.size; i++) {
            String borderOrNewline = "";
            if ((i+1) % board.size == 0) {
                borderOrNewline += "\n";
            }
            else {
                borderOrNewline += "|";
            }
            formattedBoard += board.spots.get(i);
            formattedBoard += borderOrNewline;
        }
        System.out.print(formattedBoard);
    }

   ```
6. Now the BoardPresenter is resposible only for the Display.
7. Open the java file [BoardShaper.java](../module4/SOLID-main/single_responsibility/good/src/BoardShaper.java)
8. Edit the file and copy the following code after line 17
   ```
    for (int i = 0; i < this.size; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < this.size; j++) {
                row.add((i*size)+(j));
            }
            rowIndexes.add(row);
        }

   ```
9. Save the file and commit the changes.
10. The Board Shaper is responsible for creating and adding new rows.
11. After the changes consider the BoardModified class in the "good" example. The only thing it is responsible for is knowing the values of its spots. It is entirely unconcerned with how those spots are being manipulated per the rules of Tic Tac Toe (rows, columns, diagonals) or displayed to the user (in a console, on the web, etc.). The BoardShaper and BoardPresenter classes are similarly focused on specific tasks. They are also only passed attributes they need; for example, BoardShaper objects are initialized with only a size (they don't need the whole board).

## 4.2 Update the code to comply with Open Closed Principle

1.  Notice how in the bad example, [Greeter.java](../module4/SOLID-main/open_closed/bad/src/Greeter.java) any time we want to add a new style of greeting, we have to change the Greeter class to accept a new type of personality.
2.  We don't want to have to modify our existing, working code to add something new.
3.  Let us make small changes to implement OCP.
4. Open the java file [CasualPersonality.java](../module4/SOLID-main/open_closed/good/src/CasualPersonality.java)
5. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Sup bro?";
        }
    ```
6. Open the java file [FormalPersonality.java](../module4/SOLID-main/open_closed/good/src/FormalPersonality.java)
7. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Good evening, sir.";
        }
    ```
8. Open the java file [IntimatePersonality.java](../module4/SOLID-main/open_closed/good/src/IntimatePersonality.java)
9. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Hello Dear!";
        }
     ```
10. Now, as demonstrated in the good example, we have a high-level Greeter class that is instantiated with some Personality... we don't know which yet, just that it will be some object that implements the Personality interface. Now we can add new objects like FormalPersonality, CasualPersonality, and IntimatePersonality, and just make sure they correctly implement the Personality interface (in this case that means they must have a `greet()` method). The Greeter class is now open for future extension, while remaining closed for modification.

## 4.3 Update the code to comply with  Liskov's Substitution Principle

1. The key to understanding the Liskov Substitution Principle is thinking about _processes that use_ (sub)classes, rather than the (sub)classes themselves.
2. In the bad example here, the [UnitUpgrader](../module4/SOLID-main/liskov_substitution/bad/src/UnitUpgrader.java) purports to accept any Apartment (an abstract class) and upgrade it.
3. However, once the UnitUpgrader starts upgrading the apartment (`upgrade(Apartment)`), it checks the specific class/subtype of the Apartment object to make sure it doesn't add a bedroom to a Studio (which by definition has zero bedrooms).
4. A Studio object therefore cannot be substituted in for any Apartment.
5. Open the java file [StudioModified.java](../module4/SOLID-main/liskov_substitution/good/src/StudioModified.java)
6. Edit the file and copy the following code after line 7.
    ```
        public StudioModified() {
            this.numberOfRooms = 0;
        }

        public void setSquareFootage(int sqft) {
            this.squareFootage = sqft;
        }
    ```

7. Open the java file [BedroomAdder.java](../module4/SOLID-main/liskov_substitution/good/src/BedroomAdder.java)
8. Edit the file and copy the following code after line 5.
    ```
        public void addBedroom(PenthouseSuiteModified penthouse) {
        penthouse.numberOfBedrooms += 1;
    }
    ```

9. Open the java file [PenthouseSuiteModified.java](../module4/SOLID-main/liskov_substitution/good/src/PenthouseSuiteModified.java)
10. Edit the file and copy the following code after line 5.
    ```
        int squareFootage;
        int numberOfBedrooms;

        public PenthouseSuiteModified() {
            this.numberOfBedrooms = 4;
        }

        public void setSquareFootage(int sqft) {
            this.squareFootage = sqft;
        }
    ```
11. What is done here now is that the BedroomAdder only adds bedroom to a PenthouseSuite object.
12. You can have a Unit Upgrader further to keep adding square foot while adding bedrooms is for Penhouses only.
13. That way Functions usings references should be able to use objects without thorough knowledge of all the inheritance internally.
14. If you don't follow the LSP, external processes will either break, behave improperly, or need to know too much information

## 4.4 Update the code to comply with  Interface Segregation Principle
1. Notice in the bad example the interface [Bird.java](../module4/SOLID-main/interface_segregation/bad/src/Bird.java) is implemented by 2 classes [Eagle.java](../module4/SOLID-main/interface_segregation/bad/src/Eagle.java) and [Penguin.java](../module4/SOLID-main/interface_segregation/bad/src/Penguin.java).
2. It may seem reasonable to create a Bird interface that outlines the basic features of birds--they can fly and they can shed their feathers.
3. It works for plenty of birds (like an eagle), but then we want to add penguins to our code. The penguin is technically a bird, but it doesn't fly.
4. So if we set it to implement our Bird interface, we have to throw an exception for the `fly()` method.
5. The penguin should not be forced to depend on an action it cannot perform and is in violation of ISP.
6. Let's implement ISP by Opening the java file [EagleModified.java](../module4/SOLID-main/interface_segregation/good/src/EagleModified.java)
7. Edit the file and copy the following code after line 5.
    ```
           String currentLocation;
            int numberOfFeathers;

            public EagleModified(int initialNumberOfFeathers) {
                this.numberOfFeathers = initialNumberOfFeathers;
            }

            public void fly() {
                this.currentLocation = "in the air";
            }

            public void molt() {
                this.numberOfFeathers -= 1;
            }
    ```
8. Open the interface [FeatheredCreature.java](../module4/SOLID-main/interface_segregation/good/src/FeatheredCreature.java)
9. Edit the file and copy the following code after line 5.
    ```
     public void molt();
    ```
10. Open the interface [FlyingCreature.java](../module4/SOLID-main/interface_segregation/good/src/FlyingCreature.java)
11. Edit the file and copy the following code after line 5.
    ```
     public void fly();
    ```
12. Open the interface [SwimmingCreature.java](../module4/SOLID-main/interface_segregation/good/src/SwimmingCreature.java)
13. Edit the file and copy the following code after line 5.
    ```
    public void swim();
    ```
14. Open the java file [PenguinModified.java](../module4/SOLID-main/interface_segregation/good/src/PenguinModified.java)
15. Edit the file and copy the following code after line 5.
    ```
        String currentLocation;
        int numberOfFeathers;

        public PenguinModified(int initialFeatherCount) {
            this.numberOfFeathers = initialFeatherCount;
        }

        public void swim() {
            this.currentLocation = "in the water";
        }

        public void molt() {
            this.numberOfFeathers -= 4;
        }
    ```
16. You have now implemented interface segregation.
17. Notice how each class, EagleModified and PenguinModified only implements the interfaces relevant to its function - Penguin being a swimming creature and Eagle a flying creature.

Making interfaces more abstract helps adhere to both the SRP (the interface is only responsible for one particular behavior) and this Interface Segregation Principle because specific objects (like eagles and penguins) only implement the functionality they need.

## 4.5 Update the code to comply with  Dependency Inversion Principle
1. Notice in the bad example here, the [WeatherTracker.java](../module4/SOLID-main/dependency_inversion/bad/src/WeatherTracker.java) depends on the low-level details of the different notification systems (a phone, an emailer, etc.).
2. Its contructor is creating new objects of phone and emailer and depending on weather conditions sending the alerts.
3. These should instead be depending on some abstraction.
4. The good example introduces this abstraction--a "Notifier" interface.
5. Open the java file [EmailClient.java](../module4/SOLID-main/dependency_inversion/good/src/EmailClient.java)
6. Edit the file and copy the following code after line 5.
    ```
    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions == "sunny");
            System.out.print("It is sunny");
    }
    ```
7. Open the java file [MobileDevice.java](../module4/SOLID-main/dependency_inversion/good/src/MobileDevice.java)
8. Edit the file and copy the following code after line 5.
    ```
    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions == "rainy")
            System.out.print("It is rainy");
    }
    ```
9. Open the interface  [Notifier.java](../module4/SOLID-main/dependency_inversion/good/src/Notifier.java)
10. Edit the file and copy the following code after line 5.
    ```
        public void alertWeatherConditions(String weatherConditions);
    ```
11. Open the java file [WeatherTrackerModified.java](../module4/SOLID-main/dependency_inversion/good/src/WeatherTrackerModified.java)
12. Edit the file and copy the following code after line 5.
    ```
    String currentConditions;
    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
    }

    public void notify(Notifier notifier) {
        notifier.alertWeatherConditions(currentConditions);
    }
    ```
13. The good example introduces this abstraction--a "Notifier" interface which the EmailClient and MobileDevice can implement.
