import java.time.LocalDate;

public class SilverMember extends BonusMember {
    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int point) {
        super(memberNo, personals, enrolledDate, point);
    }

    @Override
    public void registerPoints(int points) {
        int silverPoints = (int)(points*FACTOR_SILVER);
        super.registerPoints(silverPoints);
    }
}
