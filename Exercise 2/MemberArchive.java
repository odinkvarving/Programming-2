import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {
    private final int SILVER_LIMIT = 25000;
    private final int GOLD_LIMIT = 75000;
    private final int MAKS_TRY =10;
    private Random RANDOM_NUMBER;
    private ArrayList<BonusMember> personalListe;
    public MemberArchive() {
        this.personalListe = new ArrayList<>();

    }

    public int findPoints(int medlemsNo, String password) {
        int points = 0;
        int tries = 0;

        for (BonusMember bonusMember : personalListe) {
            if(bonusMember.getMemberNo() == medlemsNo)

            if(!bonusMember.okPassword(password)){
                tries++;
                if(tries == 10){
                    System.out.println(" Maks antall forsøk nådd. ");
                    return -1;
                }
            }
            else if(bonusMember.okPassword(password) && medlemsNo != -1){
                points += bonusMember.getPoints();
            }
        }
        return points;
    }


    public boolean registerPoints(int medlemsNo, int points){
        for(BonusMember b : personalListe){
            if(b.getMemberNo() == medlemsNo){
                b.registerPoints(points);
                return true;
            }
        }
        return false;
    }

    private int findAvailableNo(){
        Random random = new Random();
        int membernr = random.nextInt(100) + 1;
        for (BonusMember bonusmember: personalListe){
            if(bonusmember.getMemberNo() == membernr){
                return -1;
            }
        }
        return membernr;
    }

    public int newMember(Personals personals, LocalDate localDate){
        int memberNo = findAvailableNo();
        if(findAvailableNo() != -1){
            personalListe.add(new BonusMember(memberNo, personals, localDate));
        }
        return memberNo;
    }

    public void checkMember(){
        personalListe.stream().filter(b -> b.findQualificationPoints(b.getEnrolledDate()) >= SILVER_LIMIT
                && b.findQualificationPoints(b.getEnrolledDate()) < GOLD_LIMIT).forEach(b ->
                personalListe.set(personalListe.indexOf(b), new SilverMember(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate(), b.getPoints())));
        personalListe.stream().filter(b -> b.findQualificationPoints(b.getEnrolledDate()) >= GOLD_LIMIT).forEach(b ->
                personalListe.set(personalListe.indexOf(b), new GoldMember(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate(), b.getPoints())));
    }
}
