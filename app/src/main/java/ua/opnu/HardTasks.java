package ua.opnu;

import ua.opnu.util.Customer;
import ua.opnu.util.DataProvider;
import ua.opnu.util.Order;
import ua.opnu.util.Product;

import java.util.*;

public class HardTasks {

    private final List<Customer> customers = DataProvider.customers;
    private final List<Order> orders = DataProvider.orders;
    private final List<Product> products = DataProvider.products;

    public static void main(String[] args) {}

    // ---------------------- Task 1 ----------------------
    public List<Product> getBooksWithPrice() {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if ("Books".equals(p.getCategory()) && p.getPrice() > 100) {
                result.add(p);
            }
        }
        return result;
    }

    // ---------------------- Task 2 ----------------------
    public List<Order> getOrdersWithBabyProducts() {
        List<Order> res = new ArrayList<>();

        for (Order ord : orders) {
            for (Product pr : ord.getProducts()) {
                if ("Baby".equals(pr.getCategory())) {
                    res.add(ord);
                    break;
                }
            }
        }
        return res;
    }

    // ---------------------- Task 3 ----------------------
    public List<Product> applyDiscountToToys() {
        List<Product> discounted = new ArrayList<>();

        for (Product p : products) {
            if ("Toys".equals(p.getCategory())) {
                p.setPrice(p.getPrice() * 0.50); // змінюється ціна
                discounted.add(p);
            }
        }
        return discounted;
    }

    // ---------------------- Task 4 ----------------------
    public Optional<Product> getCheapestBook() {
        Product cheapest = null;

        for (Product p : products) {
            if ("Books".equals(p.getCategory())) {
                if (cheapest == null || p.getPrice() < cheapest.getPrice()) {
                    cheapest = p;
                }
            }
        }

        return Optional.ofNullable(cheapest);
    }

    // ---------------------- Task 5 ----------------------
    public List<Order> getRecentOrders() {
        List<Order> sorted = new ArrayList<>(orders);
        sorted.sort((a, b) -> b.getOrderDate().compareTo(a.getOrderDate()));

        if (sorted.size() > 3) {
            return sorted.subList(0, 3);
        }
        return sorted;
    }

    // ---------------------- Task 6 ----------------------
    public DoubleSummaryStatistics getBooksStats() {
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

        for (Product p : products) {
            if ("Books".equals(p.getCategory())) {
                stats.accept(p.getPrice());
            }
        }

        return stats;
    }

    // ---------------------- Task 7 ----------------------
    public Map<Integer, Integer> getOrdersProductsMap() {
        Map<Integer, Integer> out = new HashMap<>();

        for (Order o : orders) {
            out.put(o.getId(), o.getProducts().size());
        }
        return out;
    }

    // ---------------------- Task 8 ----------------------
    public Map<String, List<Integer>> getProductsByCategory() {
        Map<String, List<Integer>> grouped = new HashMap<>();

        for (Product p : products) {
            grouped
                    .computeIfAbsent(p.getCategory(), x -> new ArrayList<>())
                    .add(p.getId());
        }

        // Сортуємо списки ID
        for (List<Integer> lst : grouped.values()) {
            lst.sort(Integer::compareTo);
        }

        return grouped;
    }
}
