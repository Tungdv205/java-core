import java.sql.SQLOutput;
import java.util.Scanner;

public class Product {
    private String name;
    private String id;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else
            System.out.println("Khong hop le vui long nhap lai");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isBlank() && id.length() == 6) {
            this.id = id;
        } else
            System.out.println("Khong hop le vui long nhap lai");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else
            System.out.println("Khong hop le vui long nhap lai");
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else
            System.out.println("Khong hop le vui long nhap lai");
    }

    Product() {
    }

    // constructor rỗng để truyền vào data
    Product(String name) {
        this(name, "PH1234", 12.000, 2);
    }

    Product(String name, String id) {
        this(name, id, 12.500, 4);
    }

    Product(String name, String id, double price, int quantity) {
        setName(name);
        setId(id);
        setPrice(price);
        setQuantity(quantity);
    }

    public void disPlayinfo() {
        System.out.println("Ten:" + getName());
        System.out.println("ID:" + getId());
        System.out.println("Gia:" + getPrice());
        System.out.println("SL:" + getQuantity());
    }

    public static Product[] inPut(Scanner sc, int n) {
        Product[] prd = new Product[n];
        for (int i = 0; i < prd.length; i++) {
            System.out.println("Nhap vap san pham thu" + (i + 1) + ":");
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("ID: ");
            String id = sc.nextLine();
            System.out.println("Gia: ");
            double price = sc.nextDouble();
            System.out.println("SL: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            prd[i] = new Product(name, id, price, quantity);
        }
        return prd;
    }

    public static void displayList(Product[] products) {
        System.out.println("====Hien thi danh sach san pham===");
        for (Product product : products) { //for (KiểuDữLiệu biến : mảng)
            product.disPlayinfo();
        }
    }

    public static Product maxPrice(Product[] products) {
        Product max = products[0];
        for (int i = 0; i < products.length; i++) {
            if (products[i].getPrice() > max.getPrice()) {
                max = products[i];
            }
        }
        return max;
    }

    public static void searchByName(Product[] products, String tenCanTim) {
        boolean found = false;
        for (Product product : products) {
            if (!tenCanTim.isBlank() && product.getName().equalsIgnoreCase(tenCanTim)) {
                found = true;
                System.out.println("Da tim thay san pham!");
                product.disPlayinfo();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham");
        }
    }

    public static void sort(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].getPrice() < products[j].getPrice()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }

    public double totalValue() {
        return getPrice() * getQuantity();
    }

    public static Product maxtotalValue(Product[] products) {
        Product max = products[0];
        for (Product product : products) {
            if (product.totalValue() > max.totalValue()) {
                max = product;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = null;

        int choice;
        while (true) {
            System.out.println("====MENU====");
            System.out.println("1: Nhap san pham");
            System.out.println("2: In san pham");
            System.out.println("3: Gia cao nhat");
            System.out.println("4: Tim theo ten");
            System.out.println("5: Sap xep giam dan");
            System.out.println("6: Gia tri lon nhat");
            System.out.println("7: Thoat ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Moi nhap so luong san pham:");
                    int n = sc.nextInt();
                    sc.nextLine();
                    products = inPut(sc, n);
                    break;
                case 2:
                    if (products == null) {
                        System.out.println("Chua co du lieu.");
                    } else {
                        displayList(products);
                    }
                    break;
                case 3:
                    if (products == null) {
                        System.out.println("Chua co du lieu.");
                    } else {
                        Product max = maxPrice(products);
                        max.disPlayinfo();
                    }
                    break;
                case 4:
                    if (products == null) {
                        System.out.println("Chua co du lieu.");
                    } else {

                        System.out.println("Nhap ten can tim");
                        String name = sc.nextLine();
                        searchByName(products, name);
                    }
                    break;
                case 5:
                    if (products == null) {
                        System.out.println("Chua co du lieu.");
                    } else {
                        sort(products);
                        System.out.println("Da sao xep");
                        displayList(products);
                    }
                    break;
                case 6:
                    if (products == null) {
                        System.out.println("Chua co du lieu.");
                    } else {
                        displayList(products);
                        Product max1 = maxtotalValue(products);

                        System.out.println("San pham co tong gia tri lon nhat:");
                        max1.disPlayinfo();
                        System.out.println("Tong gia tri: " + max1.totalValue());
                    }
                    break;
                case 7:
                    System.out.println("Xin cam on");
                    sc.close();
                    return;

            }
        }

    }
}
