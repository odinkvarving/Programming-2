package no.ntnu.idata1001.oblig4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class BonusMember implements Comparable<BonusMember> {
    private final int memberNo;
    private final Personals personals;
    private LocalDate enrolledDate;
    private int point = 0;

    /**
     *
     * @param memberNo
     * @param personals
     * @param enrolledDate
     * @throws IllegalArgumentException because we don't want to add negative numbers. IllegalArgumentsException because it fits best
     * @throws NullPointerException because we don't want to add a member with empty values. NullPointerException because we want to check for empty values.
     */

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        if (memberNo < 0) {
            throw new IllegalArgumentException(" Membersnumber can not be negative. ");
        }
        if (personals == null || enrolledDate == null) {
            throw new NullPointerException(" Personals or enrolledDate was null. ");
        }

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

    public int findQualificationPoints() {

        int qualificationpoints;
        if (ChronoUnit.DAYS.between(enrolledDate, LocalDate.now()) <= 365) {
            qualificationpoints = point;
        } else {
            qualificationpoints = -1;
        }

        return qualificationpoints;
    }

    public boolean okPassword(String password) {
        return personals.okPassword(password);
    }

    /**
     *
     * @param points
     * @throws IllegalArgumentException because you should not be able to add an empty value.
     */
    public void addPoints(int points) {
        if(points == 0) {
            throw new IllegalArgumentException("Cannot add 0 points. ");
        }
        else if (points > 0)
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

    public int compareTo(BonusMember arbitraryMember) {
        int result = 0;
        if (this.getPoints() < arbitraryMember.getPoints()) {
            result = -1;
        }

        if (this.getPoints() > arbitraryMember.getPoints()) {
            result = 1;
        }

        if (this.getPoints() == arbitraryMember.getPoints()) {
            result = 0;
        }
        return result;
    }
}
