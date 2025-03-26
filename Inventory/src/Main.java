import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6. exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("product name: ");
                    String name = scanner.next();
                    System.out.println("product price: ");
                    int price = scanner.nextInt();
                    System.out.println("product description: ");
                    String description = scanner.next();
                    System.out.println("product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name,price,description,quantity);
                    break;
                case 2:
                    System.out.println("Enter product name to remove: ");
                    String removeName = scanner.next();
                    remove(removeName);
                    break;
                case 3:
                    System.out.println("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    update(updateId);

                   
                    break;
                case 4:
                    System.out.println("Enter product ID to search: ");
                    int searchId = scanner.nextInt();
                    for (Product product : listOfProducts) {
                        if (product.getProductId() == searchId) {
                            System.out.println(product.getProductId());
                            System.out.println(product.getProductName());
                            System.out.println(product.getProductPrice());
                            System.out.println(product.getProductDescription());
                            System.out.println(product.getProductQuantity());
                            break;
                        }
                    }
                    break;

                case 5:
                    printList();
                    break;
                case 6:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        }

    }


    private static void printList() {
        for (Product product : listOfProducts) {
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductPrice());
            System.out.println(product.getProductDescription());
            System.out.println(product.getProductQuantity());
        }
    }

    public static void add(String name, int price, String description, int quantity) {
        Product product=new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size()+1);
        listOfProducts.add(product);
    }
    public static void remove(String name) {
        for (Product product : listOfProducts) {
            if (product.getProductName().equals(name)) {
                listOfProducts.remove(product);
                System.out.println("Product removed");
                return;

            }
        }
        System.out.println("Product not found");
        

}
    public static void update(int id) {
        System.out.println("Enter the product Id to Update");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Product product : products) {
            if (product.getId() == id) {
                boolean updating = true;
                while (updating) {
                    System.out.println("Current details of the product:");
                    System.out.println("Name: " + product.getName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Quantity: " + product.getQuantity());
                    System.out.println("Choose the attribute to update:");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("3. Quantity");
                    System.out.println("4. Exit update");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the new name of the product:");
                            String name = scanner.nextLine();
                            product.setName(name);
                            break;
                        case 2:
                            System.out.println("Enter the new price of the product:");
                            float price = scanner.nextFloat();
                            product.setPrice(price);
                            break;
                        case 3:
                            System.out.println("Enter the new quantity of the product:");
                            int quantity = scanner.nextInt();
                            product.setQuantity(quantity);
                            break;
                        case 4:
                            updating = false;
                            
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public static void search(int id) {
        for (Product product : listOfProducts) {
            if (product.getProductId() == id) {
                System.out.println(product.getProductId());
                System.out.println(product.getProductName());
                System.out.println(product.getProductPrice());
                System.out.println(product.getProductDescription());
                System.out.println(product.getProductQuantity());
                break;
            }
        }
    }
    public static void list() {

    }
}













