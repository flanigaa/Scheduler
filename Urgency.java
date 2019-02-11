public class Urgency {
  public static final int NONE = 0;
  public static final int LOW = 1;
  public static final int MEDIUM = 2;
  public static final int HIGH = 3;
  public static final int EXTREME = 4;
  public static final int MIN = 0;
  public static final int MAX = 4;

  public String toString(int urgency) {
    if (urgency >= Urgency.MIN && urgency <= Urgency.MAX) {
      if (urgency == Urgency.NONE) {
        return "NONE";
      } else if (urgency == Urgency.LOW) {
        return "LOW";
      } else if (urgency == Urgency.MEDIUM) {
        return "MEDIUM";
      } else if (urgency == Urgency.HIGH) {
        return "HIGH";
      } else if (urgency == Urgency.EXTREME) {
        return "EXTREME";
      } else {
        return "INVALID URGENCY";
      }
    } else {
      return "INVALID URGENCY";
    }
  }
}
