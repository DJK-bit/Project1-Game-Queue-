/**
 * The class Player serves the purpose of giving different aspects to the players or generating them.
 */
import java.util.Random;

public class Player{    
    
    String tier;
    String[] tiers = {
                        "Iron4","Iron3","Iron2","Iron1",
                        "Bronze4","Bronze3","Bronze2","Bronze1",
                        "Silver4","Silver3","Silver2","Silver1",
                        "Gold4","Gold3","Gold2","Gold1",
                        "Platinum4","Platinum3","Platinum2","Platinum1"
                    };

    String name;
    String[] names = {
                        "Abigail","Adam","Adrian","Aiden","Alex","Benjamin","Brandon","Brianna","Brittany","Caleb",
                        "Cameron","Carlos","Catherine","Charlotte","Chris","Daniel","David","Dylan","Dominic","Elijah",
                        "Elizabeth","Emily","Emma","Ethan","Faith","Frank","Fred","Gabriel","Grace","Gavin","George",
                        "Hannah","Henry","Hunter","Ian","Isaac","Isabella","Jack","Jacob","James","Jason","Jennifer",
                        "Jessica","John","Jonathan","Jordan","Joseph","Joshua","Julia","Justin","Kaitlyn","Katherine",
                        "Kayla","Kevin","Kyle","Landon","Laura","Lauren","Liam","Linda","Logan","Lucas","Madison","Mark",
                        "Matthew","Megan","Michael","Michelle","Nathan","Nicholas","Noah","Nicole","Olivia","Owen","Patrick",
                        "Paul","Peter","Rachel","Rebecca","Richard","Robert","Ryan","Samantha","Sarah","Scott","Sophia","Steven",
                        "Taylor","Thomas","Tyler","Victoria","William","Zachary",
                        "Aaron","Bella","Chloe","Daisy","Evan","Fiona","Zoe"
                    };
   
    int waitedTime; 
    int rating;

    Player (int tier, int name, int waitedTime) {
        this.tier = tiers[tier];
        this.name = names[name];
        this.waitedTime = waitedTime;
        this.rating = tier;
    }

    Player () {
        
    }    
    /**
     * Generates 100 new players to the queue.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param match object so that we can call the enqueue method and the clear method in the MyQueue class
     */
    public void genPlayer(MyQueue match) {
        Random ran = new Random();
        match.clear();

        for (int i = 0; i < 100; i++) {
            int tier = ran.nextInt(tiers.length);
            int name = ran.nextInt(names.length);
            int time = i;
            Player player = new Player(tier, name, time);
            match.enqueue(player);        
        }
    }
}