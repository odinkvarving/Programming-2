import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BonusMember implements Comparable<BonusMember>{
    static final double FACTOR_SILVER = 1.2;
    static final double FACTOR_GOLD = 1.5;
    private final int memberNo;
    private final Personals personals;
    private LocalDate enrolledDate;
    private int point = 0;

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate, int point) {

        if (memberNo < 0) {
            throw new IllegalArgumentException(" Membersnumber can not be negative. ");
        }
        if(personals == null || enrolledDate == null){
            throw new IllegalArgumentException(" Personals or enrolledDate was null. ");
        }

        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
        this.point = point;
    }

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public Personals getPersonals() {
        return personals;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getPoints() {
        return point;
    }

    public int findQualificationPoints(LocalDate Date) {
        LocalDate Date1 = enrolledDate;
        LocalDate Date2 = Date;

        long daysBetween = ChronoUnit.DAYS.between(Date1, Date2);

        if (daysBetween > 365) {
            return 0;
        }
        return point;
    }

    public boolean okPassword(String password) {
        return personals.okPassword(password);
    }

    public void registerPoints(int points) {
        if (points > 0)
            this.point += points;
    }

    @Override
    public String toString() {
        return "Bonusmember {"
                + "\nmemberNo: " + memberNo
                + "\npersonals: " + personals
                + "\n enrolledDate: " + enrolledDate
                + "\nbonusPoints: " + point
                + "}";
    }

    public int compareTo(BonusMember bonusMember) {
        int result = 0;
        if (this.getPoints() < bonusMember.getPoints()) {
            result = -1;
        }

        if (this.getPoints() > bonusMember.getPoints()) {
            result = 1;
        }

        if (this.getPoints() == bonusMember.getPoints()) {
            result = 0;
        }
        return result;
    }

    @Test
    public void testInvalidParametersInConstructor(){
        try {
            BonusMember bonusmember = new BasicMember(12, null, null);
            assertThrows(IllegalArgumentException((event) -> )
        }
    }
}



