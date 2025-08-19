package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;
import cardoso.felipe.exceptions.NotAllowedTransactionException;

public record ProcessedState(Transaction transaction) implements PaymentState {

    @Override
    public void create(Transaction transaction) {
        throw new NotAllowedTransactionException("Transaction already created and processed.");
    }

    @Override
    public void process(Transaction transaction) {
        System.out.println("-> Processing transaction...");
        transaction.setState(new ProcessedState(transaction));
    }

    @Override
    public void complete(Transaction transaction) {
        System.out.println("-> Completing transaction...");
        transaction.setState(new CompletedState(transaction));
    }

    @Override
    public void cancel(Transaction transaction) {
        System.out.println("-> Cancelling transaction...");
        transaction.setState(new CancelledState(transaction));
    }

    @Override
    public void fail(Transaction transaction) {
        System.out.println("-> Failing transaction...");
        transaction.setState(new FailedState(transaction));
    }

    @Override
    public String getStatus() {
        return "PROCESSED";
    }
}
