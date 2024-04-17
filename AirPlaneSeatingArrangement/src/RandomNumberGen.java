import java.util.Random;

public class RandomNumberGen {

  private Random random = new Random();
  /**
   * Generates random inclusive int from min to max
   * @param min int
   * @param max int
   * @return random int
   */
  public int RandomInt(int min, int max){
    return (random.nextInt((max-min)+1)+min);
  }
}
