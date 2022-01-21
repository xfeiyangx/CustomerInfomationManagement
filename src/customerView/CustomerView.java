package customerView;

import CMUitls.CMUtility;
import customer.Customer;
import customerList.CustomerList;

public class CustomerView {
    private final CustomerList customerList = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("                 1 添 加 客 户");
            System.out.println("                 2 修 改 客 户");
            System.out.println("                 3 删 除 客 户");
            System.out.println("                 4 客 户 列 表");
            System.out.println("                 5    退 出");
            System.out.print("                 请选择(1-5)：");
            char selection = CMUtility.readMenuSelection();
            switch (selection) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出？Y or N: ");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
            }
        }

    }

    private void addNewCustomer() {
        System.out.print("客户姓名：");
        String name = CMUtility.readString(11);
        System.out.print("客户性别：");
        char gender = CMUtility.readChar();
        System.out.print("客户年龄：");
        int age = CMUtility.readInt();
        System.out.print("客户电话：");
        String phone = CMUtility.readString(11);
        System.out.print("客户邮箱：");
        String email = CMUtility.readString(50);
        if (customerList.addCustomer(new Customer(name, gender, age, phone, email))) {
            System.out.println("添加客户成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void modifyCustomer() {
        System.out.print("请选择要修改的客户编号：");
        int modifyIndex = CMUtility.readInt() - 1;
        System.out.print("客户姓名：");
        String name = CMUtility.readString(11, customerList.getCustomer(modifyIndex).getName());
        customerList.getCustomer(modifyIndex).setName(name);
        System.out.print("客户性别：");
        char gender = CMUtility.readChar(customerList.getCustomer(modifyIndex).getGender());
        customerList.getCustomer(modifyIndex).setGender(gender);
        System.out.print("客户年龄：");
        int age = CMUtility.readInt(customerList.getCustomer(modifyIndex).getAge());
        customerList.getCustomer(modifyIndex).setAge(age);
        System.out.print("客户电话：");
        String phone = CMUtility.readString(11, customerList.getCustomer(modifyIndex).getPhone());
        customerList.getCustomer(modifyIndex).setPhone(phone);
        System.out.print("客户邮箱：");
        String email = CMUtility.readString(50, customerList.getCustomer(modifyIndex).getEmail());
        customerList.getCustomer(modifyIndex).setEmail(email);

    }

    public void deleteCustomer() {
        System.out.print("请选择要删除的客户编号：");
        int deleteIndex = CMUtility.readInt() - 1;
        if (customerList.deleteCustomer(deleteIndex)) {
            System.out.println("已成功删除客户");
        }
    }

    public void listAllCustomers() {
        System.out.println("------------ -客户信息----------------");
        int numCustomer = customerList.getNumCustomer();
        if (numCustomer == 0) {
            System.out.println("没有客户记录...");
        } else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t电话\t\t\t\t邮箱");
            Customer[] allCustomer = customerList.getAllCustomer();
            int idNum = 1;
            for (Customer customer : allCustomer) {
                System.out.println(idNum + "\t" + customer.getName() +
                        "\t" + customer.getGender() +
                        "\t" + customer.getAge() +
                        "\t" + customer.getPhone() +
                        "\t\t" + customer.getEmail());
                idNum++;
            }
        }
        System.out.println("------------------------------------");
    }
}
