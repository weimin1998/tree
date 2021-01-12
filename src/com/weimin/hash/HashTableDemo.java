package com.weimin.hash;

public class HashTableDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        for (int i = 0; i < 8; i++) {
            hashTable.add(new HashTable.Employee(i,"wm"+i));
        }

        hashTable.show();

        HashTable.Employee employee = hashTable.find(9);
        System.out.println(employee);
    }
}





// 数组+链表
class HashTable{
    int size;
    EmployeeList[] employeeLists;

    public HashTable(int size){
        this.size = size;
        employeeLists = new EmployeeList[size];

        for (int i = 0; i < size; i++) {
            employeeLists[i] = new EmployeeList();
        }
    }


    // 应该在哈希表的哪个链表中
    private int hashCode(Employee employee) {
        return employee.id % size;
    }

    private int hashCode(int id){
        return id % size;
    }

    public void add(Employee employee){
        int i = hashCode(employee);
        employeeLists[i].add(employee);
    }

    // 遍历整个哈希表
    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.println("第"+i+"条链表:");
            employeeLists[i].show();
        }
    }

    // 查找
    public Employee find(int id){

        int i = hashCode(id);
        return employeeLists[i].find(id);
    }


    static class Employee{
        private int id;
        private String name;
        private Employee next;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    // 链表
    static class EmployeeList{
        private Employee head;

        // 加到链表最后
        private void add(Employee employee){
            if(head==null){
                head = employee;
                return;
            }
            Employee temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = employee;
        }

        // 遍历
        private void show(){
            if(head == null){
                System.out.println("链表为空");
                return;
            }
            Employee temp = head;
            while (temp.next!=null){
                System.out.println(temp);
                temp = temp.next;
            }
            System.out.println(temp);
        }

        // 查找这条链表上的元素
        private Employee find(int id){

            Employee temp = head;
            while (temp!=null){
                if(temp.id==id){
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
    }
}