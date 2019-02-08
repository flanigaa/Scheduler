public class Urgency {
  public static final int LOW = 0;
  public static final int MEDIUM = 1;
  public static final int HIGH = 2;
  public static final int EXTREME = 3;
  public static final int MIN = 0;
  public static final int MAX = 3;

  public String toString(int urgency) {
    if (urgency >= Urgency.MIN && urgency <= Urgency.MAX) {
      if (urgency == 0) {
        return "LOW";
      } else if (urgency == 1) {
        return "MEDIUM";
      } else if (urgency == 2) {
        return "HIGH";
      } else if (urgency == 3) {
        return "EXTREME";
      } else {
        return "INVALID URGENCY";
      }
    } else {
      return "INVALID URGENCY";
    }
  }
}
