package no.ntnu.idata1001.oblig4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {
    public static final int SILVER_LIMIT = 25000;
    public static final int GOLD_LIMIT = 75000;
    private static final Random randomGenerator = new Random();
    private ArrayList<BonusMember> members;

    public MemberArchive() {
        this.members = new ArrayList<>();

    }

    public ArrayList<BonusMember> getMembers() {
        return members;
    }

    public int findPoints(int memberNo, String password) {
        int points;

        BonusMember bonusMember = findMember(memberNo);

        if (bonusMember == null || !(bonusMember.okPassword(password))) {
            points = -1;
        } else {
            points = bonusMember.getPoints();
        }
        return points;
    }


    public boolean registerPoints(int memberNo, int points){
        boolean successful = false;
        BonusMember bonusMember = findMember(memberNo);

        if(bonusMember != null){
            bonusMember.addPoints(points);
            successful = true;
        }
        return successful;
    }

    public int findAvailableNo() {
        int memberNo = 0;
        boolean numberFound = false;

        while (!numberFound || (memberNo == 0)) {
            memberNo = randomGenerator.nextInt(Integer.MAX_VALUE);
            if (!this.members.contains(memberNo)) {
                numberFound = true;
            }
        }
        return memberNo;
        }

    public int newMember(Personals personals, LocalDate localDate){
        int memberNo = findAvailableNo();
        if(findAvailableNo() != -1){
            members.add(new BasicMember(memberNo, personals, localDate));
        }
        return memberNo;
    }

    public BonusMember findMember(int memberNo){
        for(int i = 0; i < members.size(); i++) {
            if(members.get(i).getMemberNo() == memberNo) {
                return members.get(i);
            }
        }
        return null;
    }

    public void checkMember(){
        members.stream().filter(b -> b.findQualificationPoints() >= SILVER_LIMIT
                && b.findQualificationPoints() < GOLD_LIMIT && !(b instanceof SilverMember)).forEach(b ->
                members.set(members.indexOf(b), new SilverMember(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate(), b.getPoints())));

        members.stream().filter(b -> b.findQualificationPoints() >= GOLD_LIMIT && !(b instanceof GoldMember)).forEach(b ->
                members.set(members.indexOf(b), new GoldMember(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate(), b.getPoints())));
    }

    public int getNumberOfMembers(){
        return members.size();
    }
}

