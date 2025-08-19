package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;
import cardoso.felipe.exceptions.NotAllowedTransactionException;

public record FailedState(Transaction transaction) implements PaymentState {

    @Override
    public void create(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction has failed.");
    }

    @Override
    public void process(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction has failed.");
    }

    @Override
    public void complete(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot complete a failed transaction.");
    }

    @Override
    public void cancel(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot cancel a failed transaction.");
    }

    @Override
    public void fail(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction already failed.");
    }

    @Override
    public String getStatus() {
        return "FAILED";
    }
}
