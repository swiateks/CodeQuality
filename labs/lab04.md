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
10. Instead, as demonstrated in the good example, we have a high-level Greeter class that is instantiated with some Personality... we don't know which yet, just that it will be some object that implements the Personality interface. Now we can add new objects like FormalPersonality, CasualPersonality, and IntimatePersonality, and just make sure they correctly implement the Personality interface (in this case that means they must have a `greet()` method). The Greeter class is now open for future extension, while remaining closed for modification.

## 4.3 Update the code to comply with  Liskov's Substitution Principle

1. Open the java file [StudioModified.java](../module4/SOLID-main/liskov_substitution/good/src/StudioModified.java)
2. Edit the file and copy the following code after line 7.
    ```
        public StudioModified() {
            this.numberOfRooms = 0;
        }

        public void setSquareFootage(int sqft) {
            this.squareFootage = sqft;
        }
    ```

3. Open the java file [BedroomAdder.java](../module4/SOLID-main/liskov_substitution/good/src/BedroomAdder.java)
4. Edit the file and copy the following code after line 5.
    ```
        public void addBedroom(PenthouseSuiteModified penthouse) {
        penthouse.numberOfBedrooms += 1;
    }
    ```

5. Open the java file [PenthouseSuiteModified.java](../module4/SOLID-main/liskov_substitution/good/src/PenthouseSuiteModified.java)
6. Edit the file and copy the following code after line 5.
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
7. The key to understanding the Liskov Substitution Principle is thinking about _processes that use_ (sub)classes, rather than the (sub)classes themselves. In the bad example here, the UnitUpgrader purports to accept any Apartment (an abstract class) and upgrade it. However, once the UnitUpgrader starts upgrading the apartment (`upgrade(Apartment)`), it checks the specific class/subtype of the Apartment object to make sure it doesn't add a bedroom to a Studio (which by definition has zero bedrooms). A Studio object therefore cannot be substituted in for any Apartment.

If you don't follow the LSP, external processes will either break, behave improperly, or need to know too much information

## 4.4 Update the code to comply with  Interface Segregation Principle
1. Open the java file [EagleModified.java](../module4/SOLID-main/interface_segregation/good/src/EagleModified.java)
2. Edit the file and copy the following code after line 5.
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
3. Open the interface [FeatheredCreature.java](../module4/SOLID-main/interface_segregation/good/src/FeatheredCreature.java)
4. Edit the file and copy the following code after line 5.
    ```
     public void molt();
    ```
5. Open the interface [FlyingCreature.java](../module4/SOLID-main/interface_segregation/good/src/FlyingCreature.java)
6. Edit the file and copy the following code after line 5.
    ```
     public void fly();
    ```
7. Open the interface [SwimmingCreature.java](../module4/SOLID-main/interface_segregation/good/src/SwimmingCreature.java)
8. Edit the file and copy the following code after line 5.
    ```
    public void swim();
    ```
9. Open the java file [PenguinModified.java](../module4/SOLID-main/interface_segregation/good/src/PenguinModified.java)
10. Edit the file and copy the following code after line 5.
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
11. You have now implemented interface segregation.
12.  It may seem reasonable to create a Bird interface that outlines the basic features of birds--they can fly and they can shed their feathers. It works for plenty of birds (like an eagle), but then we want to add penguins to our code. The penguin is technically a bird, but if we set it to implement our Bird interface, we have to throw an exception for the `fly()` method. The penguin should not be forced to depend on an action it cannot perform.

Instead, make interfaces more abstract. It helps adhere to both the SRP (the interface is only responsible for one particular behavior) and this Interface Segregation Principle because specific objects (like eagles and penguins) only implement the functionality they need.

## 4.5 Update the code to comply with  Dependency Inversion Principle
1. Open the java file [EmailClient.java](../module4/SOLID-main/dependency_inversion/good/src/EmailClient.java)
2. Edit the file and copy the following code after line 5.
    ```
    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions == "sunny");
            System.out.print("It is sunny");
    }
    ```
3. Open the java file [MobileDevice.java](../module4/SOLID-main/dependency_inversion/good/src/MobileDevice.java)
4. Edit the file and copy the following code after line 5.
    ```
    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions == "rainy")
            System.out.print("It is rainy");
    }
    ```
5. Open the interface  [Notifier.java](../module4/SOLID-main/dependency_inversion/good/src/Notifier.java)
6. Edit the file and copy the following code after line 5.
    ```
        public void alertWeatherConditions(String weatherConditions);
    ```
7. Open the java file [WeatherTrackerModified.java](../module4/SOLID-main/dependency_inversion/good/src/WeatherTrackerModified.java)
8. Edit the file and copy the following code after line 5.
    ```
    String currentConditions;
    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
    }

    public void notify(Notifier notifier) {
        notifier.alertWeatherConditions(currentConditions);
    }
    ```
9. Notice in the bad example here, the WeatherTracker depends on the low-level details of the different notification systems (a phone, an emailer, etc.). These should instead be depending on some abstraction. The good example introduces this abstraction--a "Notifier" interface.
