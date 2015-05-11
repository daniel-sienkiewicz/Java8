package services;

import java.util.List;

import entities.Customer;
import entities.Product;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomerService implements CustomerServiceInterface {

    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customersFind = customers.stream().filter(u -> u.getName().equals(name)).collect(Collectors.toList());
        return customersFind;
    }

    @Override
    public List<Customer> findByField(String fieldName, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> customersWhoBoughtMoreThan(int number) {
        List<Customer> customersFind = customers.stream().filter(u -> u.getBoughtProducts().size() > number).collect(Collectors.toList());
        return customersFind;
    }

    @Override
    public List<Customer> customersWhoSpentMoreThan(double price) {
        return customers.stream().filter(x -> x.getBoughtProducts().stream().mapToDouble(u -> u.getPrice()).sum() > price).collect(Collectors.toList());
    }

    @Override
    public List<Customer> customersWithNoOrders() {
        List<Customer> customersFind = customers.stream().filter(u -> u.getBoughtProducts().isEmpty()).collect(Collectors.toList());
        return customersFind;
    }

    @Override
    public void addProductToAllCustomers(Product p) {
        customers.stream().forEach(x -> x.addProduct(p));
    }

    @Override
    public double avgOrders(boolean includeEmpty) {
        return customers.stream().mapToDouble(x -> x.getBoughtProducts().stream().mapToDouble(u -> u.getPrice()).sum()).average().getAsDouble();
    }

    @Override
    public boolean wasProductBought(Product p) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public List<Product> mostPopularProduct() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countBuys(Product p) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countCustomersWhoBought(Product p) {
        // TODO Auto-generated method stub
        return 0;
    }
}
