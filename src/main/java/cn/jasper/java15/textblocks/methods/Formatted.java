package cn.jasper.java15.textblocks.methods;

public class Formatted {

    public static void main(String[] args) {
        String name = "jasper";
        String phone = "13691382110";
        String address = "北京市昌平区";
        double salary = 42_000.0 * 16;
        String output = """
            Name: %s
            Phone: %s
            Address: %s
            Salary: $%.2f
            """.formatted(name, phone, address, salary);

        System.out.println(output);
    }
}
