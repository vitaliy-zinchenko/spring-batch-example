package zinchenko.sb;

import org.springframework.batch.item.ItemWriter;
import zinchenko.sb.dao.ProductDao;
import zinchenko.sb.model.Product;

import java.util.List;

/**
 * Created by zinchenko on 27.08.14.
 */
public class ProductWriter implements ItemWriter<Product> {

    private ProductDao productDao;

    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            System.out.println("write: " + product.toString());
            productDao.save(product);
        }
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
