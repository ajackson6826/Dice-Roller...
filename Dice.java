public class Dice{
    public static void main(String[]args) {
        Dice myDice = new Dice();

        int[] stats = myDice.statRoll();

        int skillCheck = myDice.skillCheck(24, stats[0]);

        int roll0 = myDice.roll();
        System.out.println("Roll 0 = " + roll0);

        int roll1 = myDice.roll(6);
        System.out.println("Roll 1 = " + roll1);

        int roll2 = myDice.roll(2, 6);
        System.out.println("Roll 2 = " + roll2);

        int roll3 = myDice.roll(1, 20, stats[0]);
        System.out.println("Roll 3 = " + roll3);

        System.out.println("Stats = " + java.util.Arrays.toString(stats));

        System.out.println("Skill Check = " + skillCheck);

        //System.out.println("Rolling 3d6 = " + myDice.rollDice(3, 6));
    }


    public static int roll() {
        int roll = (int)(Math.random() * 6) + 1;
        System.out.println("0di = " + roll);
        return roll;
    }
    

    public static int roll(int numSides) {
        int roll = (int)(Math.random() * numSides) + 1;
        System.out.println("1di = " + roll);
        return roll;
    }
    

    public static int roll(int numDice, int numSides) {
        int total = 0;

        for (int i = 0; i < numDice; i++) {
            int di = (int)(Math.random() * numSides) + 1;
             System.out.println("2di " + i + " = " + di);
            total += di;
        }
        return total;
    }

    public static int roll(int numDice, int numSides, int stats) {
        int total = 0;

        for (int i = 0; i < numDice; i++) {
            int die = (int)(Math.random() * numSides) + 1;
            System.out.println("3di " + i + " = " + die);
            total += die;
        }
        total += (stats-10)/2;
        return total;
    }

    public static int[] statRoll() {
        int[] stats = new int[6];

        int    str = (int)(Math.random() * 16) + 3;
        int    dex = (int)(Math.random() * 16) + 3;
        int    con = (int)(Math.random() * 16) + 3;
        int    intel = (int)(Math.random() * 16) + 3;
        int    wis = (int)(Math.random() * 16) + 3;
        int    cha = (int)(Math.random() * 16) + 3;

        stats[0] = str;
        stats[1] = dex;
        stats[2] = con;
        stats[3] = intel;
        stats[4] = wis;
        stats[5] = cha;

        return stats;
    }

    public static int skillCheck(int pass) {
        int roll = (int)(Math.random() * 20) + 1;
        System.out.println("Skill Check Roll = " + roll);
        if(roll == 20) {
            System.out.println("Crit Success");
            return 2;
        } else if (roll == 1) {
            System.out.println("Crit Fail");
            return -1;
        } else
        if (roll >= pass) {
            System.out.println("Skill Check Success");
            return 1;
        } else {
            System.out.println("Skill Check Fail");
            return 0;
        }
    }

    public static int skillCheck(int pass, int stat) {
        int roll = (int)(Math.random() * 20) + 1;
        System.out.println("Skill Check Roll = " + roll);
        if(roll == 20) {
            System.out.println("Crit Success");
            return 2;
        } else if (roll == 1) {
            System.out.println("Crit Fail");
            return -1;
        } else
        if (roll + (stat-10)/2 >= pass) {
            System.out.println("Skill Check Success");
            return 1;
        } else {
            System.out.println("Skill Check Fail");
            return 0;
        }
    }
}