package ydrall.flashcards;

import android.graphics.Color;
import android.os.Build;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import ydrall.flashcards.Utils.Utils;
import ydrall.flashcards.model.DataBase;
import ydrall.flashcards.model.FlashCard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, packageName = "ydrall.flashcards")
public class DatabaseUnitTest {

    DataBase dataBase;

    @Before
    public void setup() {
        dataBase = new DataBase(RuntimeEnvironment.application);
        dataBase.open();
    }

    @After
    public void tearDown() {
        dataBase.clear();
        dataBase.close();
    }

    @Test
    public void testEnvelopeCreation() {
        long id = dataBase.addEnvelope("test001", Color.WHITE);
        assertNotEquals(id,-1);
    }

    @Test
    public void test_FlashCardCreation() {
        long id = dataBase.addEnvelope("test001", Color.WHITE);
        long flashCardId = dataBase.addFlashCard(id,"abcd","defg");
        assertNotEquals(flashCardId,-1);
    }

    @Test
    public void test_AllFlashCardInAnEnvelope_ById_withOneCard() {
        long id = dataBase.addEnvelope("test001", Color.WHITE);
        FlashCard flashCard1 = FlashCard.create(1,"card001frontText","card001backText", Utils.getCurrentDateTime());
        dataBase.addFlashCard(id,flashCard1.frontText(),flashCard1.backText());
        ArrayList<FlashCard> cards = dataBase.getAllFlashCards(id);
        assertEquals(flashCard1,cards.get(0));
    }

    @Test
    public void test_AllFlashCardInAnEnvelope_ById_withMoreThanOneCard() {
        long id = dataBase.addEnvelope("test001", Color.WHITE);
        FlashCard flashCard1 = FlashCard.create(1,"card001frontText","card001backText", Utils.getCurrentDateTime());
        FlashCard flashCard2 = FlashCard.create(2,"card002frontText","card002backText", Utils.getCurrentDateTime());
        FlashCard flashCard3 = FlashCard.create(3,"card003frontText","card003backText", Utils.getCurrentDateTime());

        dataBase.addFlashCard(id,flashCard1.frontText(),flashCard1.backText());
        dataBase.addFlashCard(id,flashCard2.frontText(),flashCard2.backText());
        dataBase.addFlashCard(id,flashCard3.frontText(),flashCard3.backText());

        ArrayList<FlashCard> cards = dataBase.getAllFlashCards(id);

        assertEquals(flashCard1,cards.get(0));
        assertEquals(flashCard2,cards.get(1));
        assertEquals(flashCard3,cards.get(2));
    }

    @Test
    public void test_AllFlashCardInAnEnvelope_AllEnvelopes() {
        long id1 = dataBase.addEnvelope("test001", Color.WHITE);
        long id2 = dataBase.addEnvelope("test002", Color.WHITE);
        ArrayList<FlashCard> testCards = new ArrayList<>();
        testCards.add(FlashCard.create(1,"card001frontText","card001backText", Utils.getCurrentDateTime()));
        testCards.add(FlashCard.create(2,"card002frontText","card002backText", Utils.getCurrentDateTime()));
        testCards.add(FlashCard.create(3,"card003frontText","card003backText", Utils.getCurrentDateTime()));
        testCards.add(FlashCard.create(4,"card004frontText","card004backText", Utils.getCurrentDateTime()));

        dataBase.addFlashCard(id1, testCards.get(0).frontText(),testCards.get(0).backText());
        dataBase.addFlashCard(id2,testCards.get(1).frontText(),testCards.get(1).backText());
        dataBase.addFlashCard(id1,testCards.get(2).frontText(),testCards.get(2).backText());
        dataBase.addFlashCard(id2,testCards.get(3).frontText(),testCards.get(3).backText());

        ArrayList<FlashCard> cards = dataBase.getAllFlashCards();
        assertTrue(testCards.equals(cards));
    }

}
