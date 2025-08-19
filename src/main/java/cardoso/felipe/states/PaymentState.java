package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;

public interface PaymentState {
    void create(Transaction transaction);
    void process(Transaction transaction);
    void cancel(Transaction transaction);
    void complete(Transaction transaction);
    void fail(Transaction transaction);

    String getStatus();
}
