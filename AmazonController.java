package Controllers;

import lombok.RequiredArgsConstructor;
import models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.AmazonService;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/Api/v1/amazon")
@RequiredArgsConstructor
public class AmazonController {

    private final AmazonService amazonService;


    @GetMapping("/Product")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(amazonService.getProduct());
    }
    @PostMapping("/Product")
    public ResponseEntity setProduct(@RequestBody @Valid Product  product  , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addProduct(product );
        return ResponseEntity.status(201).body(new ApiResponse("New Product added", 201));
    }
    @PutMapping("/Product/{index}")
    public ResponseEntity updateProduct (@RequestBody @Valid Product  product
            ,@PathVariable int index, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        amazonService.updateProduct(index, product );
        return ResponseEntity.status(201).body(new ApiResponse("Product updated", 201));
    }
    @DeleteMapping("/Product/{index}")
    public ResponseEntity deleteProduct(@PathVariable @Valid int index){
        amazonService.deleteProduct(index);
        return ResponseEntity.status(201).body(new ApiResponse("Product deleted", 201));
    }
    @GetMapping("/Category")
    public ResponseEntity getCategory(){
        ArrayList Category=amazonService.getCategory();
        return ResponseEntity.status(200).body(Category);
    }
    @PostMapping("/Category")
    public ResponseEntity setCategory(@RequestBody @Valid Category  category , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addCategory(category );
        return ResponseEntity.status(201).body(new ApiResponse("New Category added", 201));
    }
    @PutMapping("/Category/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category  category
            ,@PathVariable int index,Errors errors ){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.updateCategory(index,category );
        return ResponseEntity.status(201).body(new ApiResponse("New Category updated", 201));
    }
    @DeleteMapping("/Product/{index}")
    public ResponseEntity deleteCategory(@PathVariable @Valid int index){
        amazonService.deleteCategory(index);
        return ResponseEntity.status(201).body(new ApiResponse("Product deleted", 201));
    }
    @GetMapping("/Merchant")
    public ResponseEntity getMerchant(){
        ArrayList Merchant=amazonService.getMerchant();
        return ResponseEntity.status(200).body(Merchant);
    }
    @PostMapping("/Merchant/")
    public ResponseEntity setCategory(@RequestBody @Valid Merchant  merchant , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addMerchant(merchant );
        return ResponseEntity.status(201).body(new ApiResponse("New Merchant added", 201));
    }
    @PutMapping("/Merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant  merchant
            , @PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        amazonService.updateMerchant(index, merchant );
        return ResponseEntity.status(201).body(new ApiResponse("New Merchant updated", 201));
    }
    @DeleteMapping("/Merchant/{index}")
    public ResponseEntity deleteMerchant(@PathVariable @Valid int index){
        amazonService.deleteMerchant(index);
        return ResponseEntity.status(201).body(new ApiResponse("Merchant deleted", 201));
    }

    @GetMapping("/MerchantStock")
    public ResponseEntity getMerchantStock(){
        ArrayList MerchantStock=amazonService.getMerchantStock();
        return ResponseEntity.status(200).body(MerchantStock);
    }
    @PostMapping("/MerchantStock/")
    public ResponseEntity setMerchantStock(@RequestBody @Valid MerchantStock  merchantStock , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addMerchantStock(merchantStock );
        return ResponseEntity.status(201).body(new ApiResponse("New MerchantStock added", 201));
    }
    @PutMapping("/MerchantStock/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock  merchantStock
            , @PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        amazonService.updateMerchantStock(index, merchantStock );
        return ResponseEntity.status(201).body(new ApiResponse("New MerchantStock updated", 201));
    }
    @DeleteMapping("/MerchantStock/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable @Valid int index){
        amazonService.deleteMerchantStock(index);
        return ResponseEntity.status(201).body(new ApiResponse("MerchantStock deleted", 201));
    }
    @GetMapping("/User")
    public ResponseEntity getUser(){
        ArrayList User=amazonService.getUser();
        return ResponseEntity.status(200).body(User);
    }
    @PostMapping("/User/")
    public ResponseEntity setUser(@RequestBody @Valid User  user , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addUser(user );
        return ResponseEntity.status(201).body(new ApiResponse("New user added", 201));
    }
    @PutMapping("/User/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User  user
            ,@PathVariable int index,Errors errors) {
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.updateUser(index, user );
        return ResponseEntity.status(201).body(new ApiResponse("New User updated", 201));
    }
    @DeleteMapping("/User/{index}")
    public ResponseEntity deleteUser(@PathVariable @Valid int index){
        amazonService.deleteUser(index);
        return ResponseEntity.status(201).body(new ApiResponse("User deleted", 201));
    }
    @PostMapping ("/addProduct")
    public ResponseEntity addProduct(@RequestBody @Valid MerchantStock  merchantStock  , Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addAddProduct(merchantStock );
        return ResponseEntity.status(201).body(new ApiResponse("New Product added", 201));

    }
    @PostMapping("/addProduct/merchantStock/{Stock}")
    public ResponseEntity addProductmMrchantStock(@RequestBody @Valid String Product,@RequestBody int Merchantid,@PathVariable int Stock
            ,Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        amazonService.addProductmMrchantStock(Product,Stock,Merchantid);
        return ResponseEntity.status(201).body(new ApiResponse("Product added",201));

    }
    @PostMapping("/buyProduct")
    public ResponseEntity buyProduct (@RequestParam String userId,@RequestParam String productId,@RequestParam String merchantId,Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        int isValid=amazonService.buyProduct(userId,productId,merchantId);
        if (isValid==1){
            return ResponseEntity.status(201).body(new ApiResponse("merchant has been completed", 201));

        } else if (isValid==2){
            return ResponseEntity.status(201).body(new ApiResponse("bad request", 201));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Invalid id", 201));
    }

}