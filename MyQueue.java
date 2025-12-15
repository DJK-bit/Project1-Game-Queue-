import java.util.Random;

public class MyQueue {

    private Player[] data = new Player[100];
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
    }
    
    /**
     * Dequeues the first ten players in our original list and adds them to a separate ten player list. 
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the list of ten players we dequeued.
     */
    public Player[] tenPlayers(){    
        if(size < 10){
            return null;
        }

        Player[] dataTen = new Player[10];
        
        for(int i = 0; i < 10; i++){
            Player play = dequeue();
            dataTen[i] = play;
        }

        return dataTen;
    }

    /**
     * Removes and returns the player at the front of the queue.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the player the user wants to remove from the front of the queue, 
     *         or null if the queue is empty.
     */
    public Player dequeue() {
        if(size == 0){
            return null;
        }
        Player player = data[front];
        front = (front + 1) % data.length;
        size--;

        return player;
    }
    /**
     * Adds a player at the rear of the queue.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param player the player that is added to the queue
     */
    public void enqueue(Player player){
        data[rear] = player;
        rear = (rear + 1) % data.length;
        size++;
    }

    /**
     * Prints a single match that is happening between the players.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param dataTen the list of players that will play against each other.
     */
    static int match  = 1;
    
    public void printMatch(Player[] dataTen) {
        System.out.printf("%-1s %d%n","MATCH: ",match);
        System.out.printf("%10s %15s  VS  %-15s %-10s%n", "", "TEAM1", "TEAM2","");
            
        int Team1Total = 0;
        int Team2Total = 0;
        int counter = 1; 

        for (int i = 0; i < 9; i = i+2) {
            if(i != 0 && Team1Total > Team2Total){
                //need to give team 2 better player
                Player temp1 = dataTen[i];
                Player temp2 = dataTen[i+1];   
                
                if(temp1.rating>temp2.rating){
                    Player Player1 = temp2;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp1;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                }
                else{
                    Player Player1 = temp1;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp2;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                }
            }
            else if(i != 0 && Team1Total < Team2Total){
                Player temp1 = dataTen[i];
                Player temp2 = dataTen[i+1];   
                
                if(temp1.rating>temp2.rating){
                    Player Player1 = temp1;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp2;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                }
                else{
                    Player Player1 = temp2;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp1;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                }
            }
            else if(i != 0 && Team1Total == Team2Total){        
                Player temp1 = dataTen[i];
                Player temp2 = dataTen[i+1];   

                if(temp1.rating > temp2.rating){
                    temp1 = dataTen[i];
                    temp2 = dataTen[i+1];
                }
                else{//temp 2 rating is higher or equal
                    Player temp = temp1;
                    temp1 = temp2;
                    temp2 = temp;
                }
                // temp 1 is better than temp 2

                //한번은 처음꺼에 더하고 다음꺼엔 그 다음꺼에 더하고
                if(counter % 2 == 0 ){
                    Player Player1 = temp1;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp2;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                    counter++;
                }   
                else{
                    Player Player1 = temp2;
                    Team1Total = Team1Total + Player1.rating;
                    Player Player2 = temp1;
                    Team2Total = Team2Total + Player2.rating;
                    System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier); 
                    counter++;
                }
            }

            if(i == 0){
                Player Player1 = dataTen[i];
                Team1Total = Team1Total + Player1.rating;
                Player Player2 = dataTen[i+1];
                Team2Total = Team2Total + Player2.rating;
                System.out.printf("%10s %15s  VS  %-15s %-10s%n", Player1.tier, Player1.name+"(" + Player1.waitedTime + "s)", Player2.name+"(" + Player2.waitedTime + "s)", Player2.tier);  
            }
            
        }       
        match++;
    }
    
    /**
     * Prints the left players in the Queue.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     */
    public void print() {
        System.out.println("----------------------------------");
        System.out.printf("%-4s %-10s %-12s %-10s%n", "#","TIER","NAME","WAIT");
        System.out.println("----------------------------------");

        for (int i = 0; i < size; i++) {    
            int index = (front + i) % data.length;
            System.out.printf("%-4s %-10s %-12s %3ds%n", " ", data[index].tier, data[index].name, data[index].waitedTime);
        }
        System.out.println("----------------------------------");
    }

    /**
     * The method mergeSort: Sorts the players by recursively splitting and merging the players.
     * 
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     *
     * @param data the list of players that needs to be sorted
     */
    public void mergeSort(Player[] data) {
       if (data.length <= 1) {
            return;
       }
       
        int length = data.length;
        int mid = length / 2;
        
        Player[] left = new Player[mid];
        Player[] right = new Player[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = data[i];        
        }

        for (int i = mid; i < length; i++) {
            right[i-mid] = data[i];        
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, data);
    
    }   
    /**
     * The method merge: merges the two sorted array of players.
     *
     * @param left the left sorted player array
     * @param right the right sorted player array
     * @param data the final sorted array with left integrated with right array
     */
    public static void merge(Player[] left, Player[] right, Player[] data){
        int i = 0;
        int j = 0; 
        int k = 0; 

        while (i < left.length && j < right.length) {
            if (left[i].rating < right[j].rating) {
                data[k] = left[i];
                i++;
            }
            else if (left[i].rating == right[j].rating) {
                if (left[i].waitedTime > right[j].waitedTime) {
                    data[k] = left[i];
                    i++;
                }
                else{
                     data[k] = right[j];
                    j++;
                }
            }
            else{
                data[k] = right[j];
                j++;
            }
            k++;
        }
    
        while (i<left.length) {
            data[k] = left[i];
            i++;
            k++;
        }

        while (j<right.length) {
            data[k] = right[j];
            j++;
            k++;
        }
    }

}
