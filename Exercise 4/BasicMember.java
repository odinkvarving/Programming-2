package no.ntnu.idata1001.oblig4;

import java.time.LocalDate;

public class BasicMember extends BonusMember {
    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        super(memberNo, personals, enrolledDate);
    }
    public void registerPoints(int newPoints){
        super.addPoints(newPoints);
    }
}

