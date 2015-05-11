import entities.Customer;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import services.CustomerService;
import services.CustomerServiceInterface;

/**
 *
 * @author Daniel
 */
public class CustomerTests {
    
    public CustomerTests() {
        cust1.addProduct(pr1);
        cust1.addProduct(pr1);
        cust1.addProduct(pr2);
        cust1.addProduct(pr3);
        cust2.addProduct(pr1);
        cust2.addProduct(pr2);
        cust2.addProduct(pr3);
        cust2.addProduct(pr4);
        cust2.addProduct(pr5);
        cust3.addProduct(pr1);
        cust3.addProduct(pr2);
        cust3.addProduct(pr3);
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
    }

    // Some data
    Product pr1 = new Product(1, "Pierwszy", 10);
    Product pr2 = new Product(2, "Drugi", 100);
    Product pr3 = new Product(3, "Trzeci", 15);
    Product pr4 = new Product(4, "Czwarty", 90);
    Product pr5 = new Product(5, "Piąty", 5);

    Customer cust1 = new Customer(1, "Pierwszy");
    Customer cust2 = new Customer(2, "Drugi");
    Customer cust3 = new Customer(3, "Trzeci");
    Customer cust4 = new Customer(4, "Czwarty");

    ArrayList<Customer> customers = new ArrayList<>();

    @Test
    public void testFindByName() {
        CustomerServiceInterface cs = new CustomerService(customers);

        List<Customer> res = cs.findByName("Pierwszy");

        assertNotNull("Result can't be nullddd", res);
        assertEquals(1, res.size());
    }
    
    @Test
    public void testFindByField(){
        
    }
    
    @Test
    public void testCustomersWhoBoughtMoreThan(){
        CustomerServiceInterface cs = new CustomerService(customers);

        List<Customer> res = cs.customersWhoBoughtMoreThan(3);
        assertEquals(2, res.size());
    }
    
    @Test
    public void testCustomersWhoSpentMoreThan(){
        CustomerServiceInterface cs = new CustomerService(customers);

        List<Customer> res = cs.customersWhoSpentMoreThan(125);
        assertEquals(2, res.size());
    }
    
    @Test
    public void testCustomersWithNoOrders(){
        CustomerServiceInterface cs = new CustomerService(customers);

        List<Customer> res = cs.customersWithNoOrders();
        assertEquals(1, res.size());
    }
    
    @Test
    public void testAddProductToAllCustomers(){
        int count = 0;
        CustomerServiceInterface cs = new CustomerService(customers);
        
        cs.addProductToAllCustomers(pr5);
        
        for(Customer c : customers){
            if(c.getBoughtProducts().get(c.getBoughtProducts().size() - 1).getId() == pr5.getId())
                count++;
        }
        
        assertEquals(count, customers.size());
    }
    
    @Test
    public void testAvgOrders(){
        CustomerServiceInterface cs = new CustomerService(customers);
        
        double avr = 0;
        for(Customer e : customers){
            for(Product p : e.getBoughtProducts()){
                avr += p.getPrice();
            }
        }
        
        avr = avr/customers.size();
        assert(avr == cs.avgOrders(true));
    }
    
    @Test
    public void testWasProductBought(){
        
    }
    
    @Test
    public void testMostPopularProduct(){
        
    }
    
    @Test
    public void testCountBuys(){
        
    }
    
    @Test
    public void testCountCustomersWhoBought(){
        
    }
}
