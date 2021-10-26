package no.ntnu.idata1001.oblig4;

import java.time.LocalDate;

public class GoldMember extends BonusMember{

    public static final double FACTOR_GOLD = 1.5;

    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int point){
        super(memberNo, personals, enrolledDate);
        this.addPoints(point);

    }
    @Override
    public void addPoints(int points) {
        int goldPoints = (int)(points*FACTOR_GOLD);
        super.addPoints(goldPoints);
    }

    public String toString() {
        return "GOLD MEMBER: MemberNo: " + this.getMemberNo() + " Enrolled date: " + this.getEnrolledDate() + " Points: " + this.getPoints() + " " + this.getPersonals().toString();
    }
}

