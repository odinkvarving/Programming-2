package no.ntnu.idata1001.oblig4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MemberArchiveTest {

    private Personals archivePersonals;
    private MemberArchive testArchive;
    private BonusMember testMember;

    @BeforeEach
    public void BeforeEach() {
        this.testArchive = new MemberArchive();
        this.archivePersonals = new Personals("Odin", "Kvarving", "Odinkvarving@hotmail.com", "banan");
        this.testMember = new BasicMember(132, archivePersonals, LocalDate.of(2019, 4, 23));

        testArchive.newMember(archivePersonals, LocalDate.of(2019, 4, 23));
    }

    @Test
    public void testFindPointsAndRegisterPoints() {
        int memberNo = testArchive.newMember(archivePersonals, LocalDate.now());
        testArchive.registerPoints(memberNo, 26000);
        assertEquals(26000, testArchive.findPoints(memberNo, testMember.getPersonals().getPassword()));
    }

    @Test
    public void testGetMembers() {
        assertEquals(1, testArchive.getMembers().size());
    }

    @Test
    public void testCheckMemberAndFindMember() {
        int memberNo = testArchive.newMember(archivePersonals, LocalDate.now());
        testArchive.registerPoints(memberNo, 26000);
        testArchive.checkMember();
        assertTrue(testArchive.findMember(memberNo) instanceof SilverMember);
    }
}
