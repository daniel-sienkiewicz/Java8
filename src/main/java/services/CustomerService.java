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
        return customers.stream().filter(c -> c.getBoughtProducts().stream().filter(pr -> pr.equals(p)).count() > 0).collect(Collectors.toList()).size() > 0;
    }

    @Override
    public List<Product> mostPopularProduct() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countBuys(Product product) {
        return customers.stream().mapToInt( c -> c.getBoughtProducts().stream().filter( p -> p.equals(product) ).collect(Collectors.toList()).size() ).sum();
    }

    @Override
    public int countCustomersWhoBought(Product product) {
        return customers.stream().filter(c -> c.getBoughtProducts().contains(product) ).collect(Collectors.toList()).size();
    }
}