public class Artist {
   // TODO: Declare private fields - artistName, birthYear, deathYear
   private String artistName;
   private int birthYear;
   private int deathYear;

   // TODO: Define default constructor
   public Artist() {
      this.artistName = "unknown";
      this.birthYear = -1;
      this.deathYear = -1;
   }
   // TODO: Define second constructor to initialize 
   //       private fields (artistName, birthYear, deathYear)
      public Artist(String userArtistName, int userBirthYear, int userDeathYear) {
      this.artistName = userArtistName;
      this.birthYear = userBirthYear;
      this.deathYear = userDeathYear;
      }

   // TODO: Define get methods: getName(), getBirthYear(), getDeathYear()
      public String getName() {
         return artistName;
      }
      public int getBirthYear() {
         return birthYear;
      }
      public int getDeathYear() {
         return deathYear;
      }

   // TODO: Define printInfo() method
   //       If deathYear is entered as -1, only print birthYear
   public void printInfo() {
      if (getBirthYear() != -1) {
         if (getDeathYear() != -1){
         System.out.printf("Artist: %s (%d to %d)\n", getName(), getBirthYear(), getDeathYear());
         }
         else {
          System.out.printf("Artist: %s (%d to present)\n", getName(), getBirthYear());
         }
      }
      else {
         System.out.printf("Artist: %s (unknown)\n", getName());
      }
      
   }

}