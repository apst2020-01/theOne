package application;
import java.sql.Date;
import java.util.*;
import javafx.beans.property.*;

//STEP1:  IMPLEMENT THE base class or parent class (CustomerCashOrder.java)
//Declare Customer Model variables

public class CustomerOrder {
	private IntegerProperty Customer_number; 
	private IntegerProperty Quotation_number; 
	private IntegerProperty Customer_Category;
	private IntegerProperty Product_Code; 
	private IntegerProperty Quantity; 
	private DoubleProperty Price;
	private DoubleProperty Sub_Total_Amount;
	private DoubleProperty VAT;
	private DoubleProperty Order_Discount_Amount;
	private DoubleProperty Total_Amount_Due;
	private SimpleObjectProperty<Date> Order_Date;
	protected double subTotalAmount;
	protected double vatAmount;
	protected double orderDiscountAmount;
	protected double TotalAmountDue;
	
	
	//Constructor
    public CustomerOrder() {
        this.Quotation_number = new SimpleIntegerProperty();
        this.Customer_Category = new SimpleIntegerProperty();
        this.Product_Code = new SimpleIntegerProperty();
        this.Quantity = new SimpleIntegerProperty();
        this.Price = new SimpleDoubleProperty();
        this.Sub_Total_Amount = new SimpleDoubleProperty();
        this.VAT = new SimpleDoubleProperty();
        this.Order_Discount_Amount = new SimpleDoubleProperty();
        this.Total_Amount_Due = new SimpleDoubleProperty();
        this.Order_Date = new SimpleObjectProperty<>();
           }

 
    //get and set methods 
    
    //Customer_number
    public int getcustomerNumber() {
        return Customer_number.get();
    }
       
    public void setcustomerNumber(int customerNumber){
    	Customer_number.set(customerNumber);
    }
 
    public IntegerProperty customerNumberProperty(){
        return Customer_number;
    }
    
    
  //Quotation_number
    public int getquotationNumber() {
        return Quotation_number.get();
    }
       
    public void setQuotationNumber(int quotationNumber){
    	Quotation_number.set(quotationNumber);
    }
 
    public IntegerProperty quotationNumberProperty(){
        return Quotation_number;
    }
 
    
    //Customer_Category
    public int getCustomerCategory() {
        return Customer_Category.get();
    }
       
    public void setCustomerCategory(int customerCategory){
    	Customer_Category.set(customerCategory);
    }
 
    public IntegerProperty customerCategoryProperty(){
        return Customer_Category;
    }
     
    
    
   //product_code
    public int getprodCode() {
        return Product_Code.get();
    }
 
    public void setProdCode(int prodCode){
    	Product_Code.set(prodCode);
    }
 
    public IntegerProperty prodCodeNumberProperty(){
        return Product_Code;
    }
    
    
    //Quantity
    public int getQuantity() {
        return Quantity.get();
    }
 
    public void setQuantity(int quant){
    	Quantity.set(quant);
    }
 
    public IntegerProperty quantProperty(){
        return Quantity;
    }
    
    //price
    public double getPrice() {
        return Price.get();
    }
 
    public void setPrice(double price){
    	Price.set(price);
    }
 
    public DoubleProperty priceProperty(){
        return Price;
    } 
    
    
  //Sub_Total_Amount
    public double getSubTotalAmount() {
        return Sub_Total_Amount.get();
    }
 
    public void setSubTotalAmount(double subTotalAmount){
    	Sub_Total_Amount.set(subTotalAmount);
    }
 
    public DoubleProperty subTotalAmountProperty(){
        return Sub_Total_Amount;
    }
    
    
    
  //VAT
    public double getVat() {
        return VAT.get();
    }
 
    public void setVat(double vat){
    	VAT.set(vat);
    }
 
    public DoubleProperty vatProperty(){
        return VAT;
    }
    
    
    
  //Order_Discount_Amount
    public double getOrderDiscountAmount() {
        return Order_Discount_Amount.get();
    }
 
    public void setOrderDiscountAmount(double orderDiscountAmount){
    	Order_Discount_Amount.set(orderDiscountAmount);
    }
 
    public DoubleProperty orderDiscountAmountProperty(){
        return Order_Discount_Amount;
    }
   

  //Total_Amount_Due
    public double getTotalAmountDue() {
        return Total_Amount_Due.get();
    }
 
    public void setTotalAmountDue (double TotalAmountDue){
    	Total_Amount_Due.set(TotalAmountDue);
    }
 
    public DoubleProperty TotalAmountDueProperty(){
        return Total_Amount_Due;
    }
   
  
  //orderDate
    public Date orderDate() {
        return Order_Date.get();
    }
 
    public void setOrderDate(Date orderDate){
    	Order_Date.set(orderDate);
    }
 
    public SimpleObjectProperty<Date>  orderDateProperty(){
        return Order_Date;
    }
        
   public    void CalculateTotalAmountDue  (int customerCategory, int quant, double price) {
	 
	   //private variables that will be returned from the method and passed to the GUI

	   double subTotalAmount;
	   double vatAmount;
	   double orderDiscountAmount;
	   double TotalAmountDue = 0;
	    
	   subTotalAmount = (quant * price); 
	   vatAmount = (subTotalAmount * 0.15);
		if (customerCategory == 1) {orderDiscountAmount = ((subTotalAmount * 0.10) + (subTotalAmount * 0.01));}
			else if (customerCategory == 2) {orderDiscountAmount = ((subTotalAmount * 0.15) + (subTotalAmount * 0.01));}
				else if (customerCategory == 3) {orderDiscountAmount = ((subTotalAmount * 0.20) + (subTotalAmount * 0.01));}
				else  {orderDiscountAmount = 0;}
		//return TotalAmountDue = ((subTotalAmount + vatAmount) - (orderDiscountAmount));
		//return TotalAmountDue;
		
		
		
		System.out.println("TotalAmountDue : " + TotalAmountDue);
		System.out.println("subTotalAmount : " + subTotalAmount);
		System.out.println("customerCategory : " + customerCategory);
		System.out.println("orderDiscountAmount : " + orderDiscountAmount);
		System.out.println("vatAmount : " + vatAmount);
		System.out.println("TotalAmountDue : " + TotalAmountDue);

		// construct return multiple values from method
		this.subTotalAmount = subTotalAmount;
		this.vatAmount = vatAmount;
		this.orderDiscountAmount = orderDiscountAmount;
		this.TotalAmountDue = TotalAmountDue; 
   }
	 

    public double getsubTotalAmountReturnValue () {
    	return subTotalAmount;
    }
    
    public double getvatAmountReturnValue () {
    	return vatAmount;
    }
    
    public double getOrderDiscountAmountReturnValue () {
    	return orderDiscountAmount;
    }
    
    public double getTotalAmountDueReturnValue () {
    	return TotalAmountDue;
    }


  
    
}

class CustomerAccountOrder extends CustomerOrder {
	public  void CalculateTotalAmountDue  (int customerCategory, int quant, double price) {
		 
		   //private variables that will be returned from the method and passed to the GUI

		   double subTotalAmount;
		   double vatAmount;
		   double orderDiscountAmount;
		   double TotalAmountDue;
		    
		   subTotalAmount = (quant * price); 
		   vatAmount = (subTotalAmount * 0.15);
			if (customerCategory == 1) {orderDiscountAmount = ((subTotalAmount * 0.10) + (subTotalAmount * 0.05));}
				else if (customerCategory == 2) {orderDiscountAmount = ((subTotalAmount * 0.15) + (subTotalAmount * 0.05));}
					else if (customerCategory == 3) {orderDiscountAmount = ((subTotalAmount * 0.20) + (subTotalAmount * 0.05));}
					else  {orderDiscountAmount = 0;}
			TotalAmountDue = ((subTotalAmount + vatAmount) - (orderDiscountAmount));
			//return TotalAmountDue;
			
			
			
			System.out.println("TotalAmountDue : " + TotalAmountDue);
			System.out.println("subTotalAmount : " + subTotalAmount);
			System.out.println("customerCategory : " + customerCategory);
			System.out.println("orderDiscountAmount : " + orderDiscountAmount);
			System.out.println("vatAmount : " + vatAmount);
			System.out.println("TotalAmountDue : " + TotalAmountDue);

			// construct return multiple values from method
			this.subTotalAmount = subTotalAmount;
			this.vatAmount = vatAmount;
			this.orderDiscountAmount = orderDiscountAmount;
			this.TotalAmountDue = TotalAmountDue; 
	   }
}
