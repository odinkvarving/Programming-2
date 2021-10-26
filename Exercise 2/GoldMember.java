import java.time.LocalDate;

public class GoldMember extends BonusMember{

    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int point){
        super(memberNo, personals, enrolledDate, point);

    }
    public void registerPoints(int points) {
        int goldPoints = (int)(points*FACTOR_GOLD);
        super.registerPoints(goldPoints);
    }
}
