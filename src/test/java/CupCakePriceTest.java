import FunctionLayer.Bottom;
import FunctionLayer.Cupcake;
import FunctionLayer.Topping;
import Util.CupcakePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Her er en testklasse der benytter JUnit til at teste cupcakeprice metoderne.
 * Inden hver test opsættes nogle variabler som kan benyttes i begge testmetoder.
 * Testen indeholder ingen negative test eller test hvor exceptions er forventede idet input til metodekaldene stammer fra et kontrolleret
 * miljø med data fra DB.
 * @author Thor, Hallur, Josef og Frederik
 */

public class CupCakePriceTest {

    CupcakePrice cp = new CupcakePrice();
    Cupcake cupcake1;
    Cupcake cupcake2;
    Cupcake cupcake3;
    Cupcake cupcake4;
    ArrayList<Cupcake> cupcakeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Topping top1 = new Topping("Chokolade", 5);
        Topping top2 = new Topping("Banan", 7);
        Topping top3 = new Topping("Jordbær", 6);
        Topping top4 = new Topping("Hindbær", 6);
        Bottom bot1 = new Bottom("Chokolade", 5);
        Bottom bot2 = new Bottom("Banan", 5);
        Bottom bot3 = new Bottom("Jordbær", 5);
        Bottom bot4 = new Bottom("Hindbær", 5);
        cupcake1 = new Cupcake(top1, bot1);
        cupcake2 = new Cupcake(top2, bot2);
        cupcake3 = new Cupcake(top3, bot3);
        cupcake4 = new Cupcake(top4, bot4);
        cupcakeList.add(cupcake1);
        cupcakeList.add(cupcake2);
        cupcakeList.add(cupcake3);
        cupcakeList.add(cupcake4);
    }

    @Test
    void calculateCupcakePriceTest() {
        double result = cp.calculateCupcakePrice(cupcake1, 4);
        double expected = 40;
        assertEquals(result, expected);
    }


    @Test
    void calculateBasketPrice() {
        ArrayList<Integer> qtylist = new ArrayList<>();
        qtylist.add(2);
        qtylist.add(1);
        qtylist.add(2);
        qtylist.add(3);

        double expected = 87;
        double result = cp.calculateBasketPrice(cupcakeList, qtylist);

        assertEquals(expected, result);
    }
}

