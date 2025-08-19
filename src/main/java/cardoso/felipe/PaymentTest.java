package cardoso.felipe;

import cardoso.felipe.entities.Transaction;

public class PaymentTest {
    public static void main(String[] args) {

        simulate("Success Flow", () -> {
            Transaction tx = new Transaction();
            tx.process();
            tx.complete();
            System.out.println("Status: " + tx.getStatus());
        });

        simulate("Fail after Process", () -> {
            Transaction tx = new Transaction();
            tx.process();
            tx.fail();
            System.out.println("Status: " + tx.getStatus());
        });

        simulate("Invalid: Complete without process", () -> {
            Transaction tx = new Transaction();
            tx.complete(); // Should throw
        });

        simulate("Cancel after process", () -> {
            Transaction tx = new Transaction();
            tx.process();
            tx.cancel();
            System.out.println("Status: " + tx.getStatus());
        });

        simulate("Invalid: Cancel before process", () -> {
            Transaction tx = new Transaction();
            tx.cancel(); // Should throw
        });
    }

    private static void simulate(String name, Runnable test) {
        System.out.println("\n--- " + name + " ---");
        try {
            test.run();
        } catch (Exception e) {
            System.out.println("❌ Exception: " + e.getMessage());
        }
    }
}

