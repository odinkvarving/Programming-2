package no.ntnu.idata1001.oblig4;

import java.time.LocalDate;

public class SilverMember extends BonusMember {

    public static final double FACTOR_SILVER= 1.2;

    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int point) {
        super(memberNo, personals, enrolledDate);
        this.addPoints(point);
    }

    @Override
    public void addPoints(int points) {
        int silverPoints = (int)(points*FACTOR_SILVER);
        super.addPoints(silverPoints);
    }

    @Override
    public String toString () {
        return "SilverMember {"
                + "\nmemberNo: " + this.getMemberNo()
                + "\npersonals: " + this.getPersonals()
                + "\n enrolledDate: " + this.getEnrolledDate()
                + "\nbonusPoints: " + this.getPoints()
                + "}";
    }
}

