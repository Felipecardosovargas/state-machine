package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;
import cardoso.felipe.exceptions.NotAllowedTransactionException;

public record CancelledState(Transaction transaction) implements PaymentState {

    @Override
    public void create(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction is cancelled.");
    }

    @Override
    public void process(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction is cancelled.");
    }

    @Override
    public void complete(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot complete a cancelled transaction.");
    }

    @Override
    public void cancel(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction is already cancelled.");
    }

    @Override
    public void fail(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot fail a cancelled transaction.");
    }

    @Override
    public String getStatus() {
        return "CANCELLED";
    }
}
