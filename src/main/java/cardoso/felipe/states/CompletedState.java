package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;
import cardoso.felipe.exceptions.NotAllowedTransactionException;

public record CompletedState(Transaction transaction) implements PaymentState {

    @Override
    public void create(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction is already completed.");
    }

    @Override
    public void process(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction is already completed.");
    }

    @Override
    public void complete(Transaction transaction) {
        System.out.println("-> Completing transaction...");
        transaction.setState(new CompletedState(transaction));
    }

    @Override
    public void cancel(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot cancel a completed transaction.");
    }

    @Override
    public void fail(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot fail a completed transaction.");
    }

    @Override
    public String getStatus() {
        return "COMPLETED";
    }
}
