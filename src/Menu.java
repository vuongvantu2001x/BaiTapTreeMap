import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    CustomManager manager = new CustomManager();
    WriterCustom writer = new WriterCustom();
    public void case1() throws IOException {
        int key;
        do {
            System.out.print("Nhập key : ");
            key = sc.nextInt();
            sc.nextLine();
            if (manager.getMap().containsKey(key)) {
                System.out.println("Key đã tồn tại yêu cầu nhập lại !");
            }
        }
        while (manager.getMap().containsKey(key));
        manager.addCus(key, themCus());
        manager.printFile();
    }
    public void case2(){
        manager.display(manager.getMap());
    }
    public void case3(){
        System.out.println("====================");
        System.out.println("1. Tìm theo tên ");
        System.out.println("2. Tìm theo tuổi ");
        System.out.println("3. Tìm theo địa chỉ ");
        System.out.println("4. Tìm theo ID ");
        System.out.print("Nhập lựa chọn : ");
        int find = sc.nextInt();
        sc.nextLine();
        switch (find) {
            case 1:
                System.out.print("Nhập tên cần tìm kiếm :");
                String findName = sc.nextLine();
                if (manager.findByName(findName) == null) {
                    System.out.println("Không tìm thấy");
                } else {
                    manager.display(manager.findByName(findName));
                }
                break;
            case 2:
                System.out.println("Nhập khoảng tuổi cần tìm ");
                System.out.print("Nhập đầu : ");
                int findAgeFirst = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhập đuôi : ");
                int findAgeLast = sc.nextInt();
                sc.nextLine();
                if (manager.findByAge(findAgeFirst,findAgeLast) == null) {
                    System.out.println("Không tìm thấy");
                } else {
                    manager.display(manager.findByAge(findAgeFirst,findAgeLast));
                }
                break;
            case 3:
                System.out.print("Nhập địa chỉ cần tìm : ");
                String findAddress = sc.nextLine();
                if (manager.findByAddress(findAddress) == null) {
                    System.out.println("Không tìm thấy");
                } else {
                    manager.display(manager.findByAddress(findAddress));
                }
                break;
            case 4:
                System.out.print("Nhập ID cần tìm : ");
                String findID = sc.nextLine();
                if (manager.findByID(findID) == null) {
                    System.out.println("Không tìm thấy");
                } else {
                    manager.display(manager.findByID(findID));
                }
                break;
        }
    }
    public void case4() throws IOException {
        System.out.print("Nhập key của khách hàng cần xóa :");
        int deleteId = sc.nextInt();
        if (manager.findCusKey(deleteId) == -1) {
            System.out.println("Không tìm thấy key");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int check = sc.nextInt();
            switch (check){
                case 1:
                    manager.deleteCus(deleteId);
                    manager.printFile();
                    manager.display(manager.getMap());
                    break;
                case 2:
                    manager.display(manager.getMap());
                    break;
            }
        }
    }
    public void case5() throws IOException {
        System.out.println("===================");
        System.out.println("1. Sắp xếp theo tên ");
        System.out.println("2. Sắp xếp theo tuổi ");
        System.out.println("3. Sắp xếp theo tên và tuổi ");
        System.out.print("Nhập lựa chọn :");
        int sort = sc.nextInt();
        switch (sort) {
            case 1:
                manager.sortByName();
                manager.display(manager.getMap());
                manager.printFile();
                break;
            case 2:
                manager.sortByAge();
                manager.display(manager.getMap());
                manager.printFile();
                break;
            case 3:
                manager.sortByNameAndAge();
                manager.display(manager.getMap());
                manager.printFile();
                break;
        }
    }
    public void case6() throws IOException {
        int editKey;
        do {
            System.out.print("Nhập key cần sửa thông tin:");
            editKey = sc.nextInt();
            sc.nextLine();
            if (!manager.getMap().containsKey(editKey)) {
                System.out.println("Key không tồn tại yêu cầu nhập lại !");
            }
        }
        while (!manager.getMap().containsKey(editKey));
        manager.editCus(editKey, themCus());
        manager.display(manager.getMap());
        manager.printFile();
    }

    public static Customer themCus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập khách hàng ");
        System.out.print("Nhập tên : ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = sc.nextLine();
        System.out.print("Nhập id :");
        String id = sc.nextLine();
        return new Customer(name, age, address, id);
    }
}
