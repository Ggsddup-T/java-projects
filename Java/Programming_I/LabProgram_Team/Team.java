public class Team {
   // TODO: Declare private fields - name, wins, losses
   private String name;
   private int wins;
   private int losses;
   private double winPercentage;
   
   // TODO: Define mutator methods - 
   //       setName(), setWins(), setLosses()
   public void setName(String name) {
      this.name = name;
   }
   public void setWins(int wins) {
      this.wins = wins;
   }
   public void setLosses(int losses) {
      this.losses = losses;
   }
   
   // TODO: Define accessor methods - 
   //       getName(), getWins(), getLosses()
   public String getName() {
      return name;
   }
   public int getWins() {
      return wins;
   }
   public int getLosses() {
      return losses;
   }
   
   // TODO: Define getWinPercentage()
   public double getWinPercentage() {
      winPercentage = (double)this.getWins() / ((double)this.getWins() + (double)this.getLosses());
      return winPercentage;
   }
   
   // TODO: Define printStanding()
   public void printStanding() {
      System.out.printf("Win percentage: %.2f\n", this.getWinPercentage()); //call method: methodName(),don't forget the ()
      if (getWinPercentage() > 0.5) {
         System.out.println("Congratulations, Team " + this.name + " has a winning average!");
      }
      else {
         System.out.println("Team " + this.name + " has a losing average.");
      }    
   }
}

/* Reflection:
1. Call method: remember the parenthese: ()
2. the Placeholder of format: in the " " of printf()
3. Inside the same class: no need "this" to call methods or use variables;
*/