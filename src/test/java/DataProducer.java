/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Customer;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class DataProducer {
    
    public DataProducer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public static List<Customer> getTestData(int count) {
		List<Customer> result = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Customer c = new Customer(i, "Customer: " + i);
			for (int j = count - i; j > 3; j--) {
				c.addProduct(new Product(j, "Product: " + j, (double) j * 0.1));
			}
			result.add(c);
		}
		return result;

    }
}