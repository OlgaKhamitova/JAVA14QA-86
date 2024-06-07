import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {
    @Test
    public void test_removeById() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(5, "колбаса", 100));
        repo.add(new Product(19, "хлеб", 40));
        repo.add(new Product(7, "картошка", 30));
        repo.removeById(5);

        Product[] expected = {new Product(19, "хлеб", 40), new Product(7, "картошка", 30)};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_throwNotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(5, "колбаса", 100));
        repo.add(new Product(19, "хлеб", 40));
        repo.add(new Product(7, "картошка", 30));

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(15);
        });

        String expectedMessage = "Элемент с id: 15 не найден";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
