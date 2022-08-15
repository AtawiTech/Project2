package service;
import Modules.*;
import com.example.amazon.Modules.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class AmazonService {

    private ArrayList<Product> arrProduct=new ArrayList();
    private ArrayList<Category  > arrCategory=new ArrayList();
    private ArrayList<Merchant  > arrMerchant=new ArrayList();
    private ArrayList<MerchantStock  > arrMerchantStock=new ArrayList();
    private ArrayList<User  > arrUser=new ArrayList();


    public ArrayList<Product  > getProduct() {
        return arrProduct;
    }

    public void addProduct(Product   product  ) {
        arrProduct.add(product  );
    }

    public void updateProduct(int index, Product   product  ) {
        arrProduct.set(index,product  );
    }

    public void deleteProduct(int index) {
        arrProduct.remove(index);
    }

    public ArrayList getCategory() {
        return arrCategory;
    }

    public void addCategory(Category   category  ) {
        arrCategory.add(category  );
    }

    public void updateCategory(int index, Category   category  ) {
        arrCategory.set(index,category  );
    }

    public void deleteCategory(int index) {
        arrCategory.remove(index);
    }

    public ArrayList getMerchant() {
        return arrMerchant;
    }

    public void addMerchant(Merchant   merchant  ) {
        arrMerchant.add(merchant  );
    }

    public void updateMerchant(int index, Merchant   merchant  ) {
        arrMerchant.set(index,merchant  );
    }

    public void deleteMerchant(int index) {
        arrMerchant.remove(index);
    }



    public ArrayList getMerchantStock() {
        return arrMerchantStock;
    }

    public void addMerchantStock(MerchantStock   merchantStock  ) {
        arrMerchantStock.add(merchantStock  );
    }

    public void updateMerchantStock(int index, MerchantStock   merchantStock  ) {
        arrMerchantStock.set(index,merchantStock  );
    }

    public void deleteMerchantStock(int index) {
        arrMerchant.remove(index);
    }

    public ArrayList getUser() {
        return arrUser;
    }

    public void addUser(User   user  ) {
        arrUser.add(user  );
    }

    public void updateUser(int index, User   user  ) {
        arrUser.set(index,user  );
    }

    public void deleteUser(int index) {
        arrUser.remove(index);
    }

    public void addAddProduct(MerchantStock   merchantStock  ) {
        arrMerchantStock.add(merchantStock  );
    }

    public void addProductmMrchantStock(String Product,int Stock,int Merchantid) {
        for (int i = 0; i < arrMerchantStock.size(); i++) {
            if (arrMerchantStock.get(i).getProductId().equals(Product) ){
                MerchantStock   merchantStock  =arrMerchantStock.get(i);
                merchantStock  .setStock(10);
            }

        }
    }
    public int buyProduct(String userId, String productId, String merchantId) {
        for (int i = 0; i < arrUser.size(); i++) {
            User   user=arrUser.get(i);
            Product   product=arrProduct.get(i);
            Merchant   merchant=arrMerchant.get(i);
            MerchantStock   Stock=arrMerchantStock.get(i);
            if (arrUser.get(i).getId()==userId && arrProduct.get(i).getId()==productId && arrMerchant.get(i).getId()==merchantId){
                if (Stock.getProductId()==productId){
                    if (user.getBalance()-product.getPrice()>=0) {
                        user.setBalance(user.getBalance()-product.getPrice());
                        arrMerchantStock.remove(productId);

                        return 1;
                    }
                } else {
                    return 2;
                }

            }
        }
        return 3;
    }


}