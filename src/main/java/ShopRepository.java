
public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int productId) {
        for (int number = 0; number < products.length; number++) {
            if (productId == products[number].getId()) {
                return products[number];
            }
        }
        return null;
    }


    public void removeById(int productId) {
        if (this.findById(productId) == null) {
            throw new NotFoundException("Элемент с id: " + productId + " не найден");
        } else {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != productId) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        }
    }
}


