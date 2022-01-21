package customerList;

import customer.Customer;

public class CustomerList {
    private final Customer[] customers;
    private int numCustomer;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        boolean flag = false;
        if (numCustomer < customers.length) {
            customers[numCustomer++] = customer;
            flag = true;
        }
        return flag;
    }

    public boolean deleteCustomer(int index) {
        boolean flag = false;
        if (index >= 0 || index < numCustomer) {
            for (int i = index; i < numCustomer - 1; i++) {
                customers[i] = customers[i + 1];
            }
            numCustomer--;
            flag = true;
        }
        return flag;
    }

    public Customer[] getAllCustomer() {
        Customer[] custs = new Customer[numCustomer];
        for (int i = 0; i < numCustomer; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }


    public Customer getCustomer(int index) {
        if (index >= 0 || index < numCustomer) {
            return customers[index];
        }
        return null;
    }

    public int getNumCustomer() {
        return numCustomer;
    }

}
