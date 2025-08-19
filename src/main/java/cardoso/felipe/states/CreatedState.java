package cardoso.felipe.states;

import cardoso.felipe.entities.Transaction;
import cardoso.felipe.exceptions.NotAllowedTransactionException;

public record CreatedState(Transaction transaction) implements PaymentState {

    @Override
    public void create(Transaction transaction) {
        System.out.println("-> Creating transaction...");
        transaction.setState(new CreatedState(transaction));
    }

    @Override
    public void process(Transaction transaction) {
        System.out.println("-> Processing transaction...");
        transaction.setState(new ProcessedState(transaction));
    }

    @Override
    public void complete(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot complete. Transaction is not processed.");
    }

    @Override
    public void cancel(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot cancel a transaction that is only created.");
    }

    @Override
    public void fail(Transaction transaction) {
        throw new NotAllowedTransactionException("Cannot fail. Transaction not processed yet.");
    }

    @Override
    public String getStatus() {
        return "CREATED";
    }
}
