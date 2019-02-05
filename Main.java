public class Main {
  public static void main(String[] args) {
    Time timeA = new Time(DayOfWeek.TUESDAY, 14, 30);
    Time timeB = new Time(DayOfWeek.TUESDAY, 16, 30);

    Time timeC = new Time(DayOfWeek.WEDNESDAY, 20, 00);
    Time timeD = new Time(DayOfWeek.THURSDAY, 4, 00);

    Time timeE = new Time(DayOfWeek.SUNDAY, 18, 00);
    Time timeF = new Time(DayOfWeek.MONDAY, 2, 30);

    Time timeG = new Time(DayOfWeek.ANY, 16, 00);
    Time timeH = new Time(DayOfWeek.ANY, 20, 00);
    Time timeI = new Time(DayOfWeek.ANY, 2, 00);

    Time timeJ = new Time(DayOfWeek.nextDay(DayOfWeek.ANY), 4, 00);

    // should work
    System.out.println("rangeA creation");
    TimeRange rangeA = new TimeRange(timeA, timeB);
    System.out.println("rangeB creation");
    TimeRange rangeB = new TimeRange(timeC, timeD);
    System.out.println("rangeC creation");
    TimeRange rangeC = new TimeRange(timeE, timeF);
    System.out.println("rangeE creation");
    TimeRange rangeE = new TimeRange(timeG, timeH);
    System.out.println("rangeG creation");
    TimeRange rangeG = new TimeRange(timeG, timeJ);

    // shouldn't work
    System.out.println("rangeD creation");
    TimeRange rangeD = new TimeRange(timeA, timeF);
    System.out.println("rangeF creation");
    TimeRange rangeF = new TimeRange(timeH, timeI);

    System.out.printf("rangeA passes midnight?: %b\n", rangeA.passesMidnight());
    System.out.printf("rangeB passes midnight?: %b\n", rangeB.passesMidnight());
    System.out.printf("rangeC passes midnight?: %b\n", rangeC.passesMidnight());
    System.out.printf("rangeD passes midnight?: %b\n", rangeD.passesMidnight());
    System.out.printf("rangeE passes midnight?: %b\n", rangeE.passesMidnight());
    System.out.printf("rangeF passes midnight?: %b\n", rangeF.passesMidnight());
    System.out.printf("rangeG passes midnight?: %b\n", rangeG.passesMidnight());

    System.out.println(rangeE.compareTo(rangeG));
  }
}
