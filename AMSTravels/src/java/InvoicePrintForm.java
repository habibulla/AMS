
import com.myapp.struts.Invoice.ChargeData;
import com.myapp.struts.Invoice.InvoiceData;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Yatheesh
 */
public class InvoicePrintForm {

    private String customerNamee = "";
    private String address = "";
    private int mobileNo, invoiceNo;
    private String description = "", invoiceDate = "",amountInWords="";
    private int grandTotal;
    ArrayList<InvoiceData> invoiceList = new ArrayList<InvoiceData>();
    ArrayList<ChargeData> chargeDetailsList = new ArrayList<ChargeData>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public ArrayList<ChargeData> getChargeDetailsList() {
        return chargeDetailsList;
    }

    public void setChargeDetailsList(ArrayList<ChargeData> chargeDetailsList) {
        this.chargeDetailsList = chargeDetailsList;
    }

    public String getCustomerNamee() {
        return customerNamee;
    }

    public void setCustomerNamee(String customerNamee) {
        this.customerNamee = customerNamee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceData> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<InvoiceData> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    
    
    
    
}
