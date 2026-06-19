import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid];
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(103, "Watch", "Accessories"),
            new Product(102, "Phone", "Electronics"),
            new Product(105, "Bag", "Travel")
        };

        int targetId = 102;

        System.out.println("Big O Notation");
        System.out.println("Big O notation describes how the running time grows as input size increases.");
        System.out.println("For searching, best case means the item is found immediately.");
        System.out.println("Average case means the item is found after checking some middle portion of data.");
        System.out.println("Worst case means the item is found at the end or not found at all.");
        System.out.println();

        Product linearResult = linearSearch(products, targetId);
        System.out.println("Linear Search Result");
        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Linear Search Time Complexity: Best O(1), Average O(n), Worst O(n)");
        System.out.println();

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        Product binaryResult = binarySearch(sortedProducts, targetId);
        System.out.println("Binary Search Result");
        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Binary Search Time Complexity: Best O(1), Average O(log n), Worst O(log n)");
        System.out.println();

        System.out.println("Conclusion");
        System.out.println("Binary search is faster for large sorted data.");
        System.out.println("Linear search is simpler, but binary search is more suitable for an e-commerce platform");
        System.out.println("when products are stored in sorted order because it reduces search time.");
    }
}
