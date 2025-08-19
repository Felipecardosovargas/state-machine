package cardoso.felipe.entities;

import cardoso.felipe.states.CreatedState;
import cardoso.felipe.states.PaymentState;
import lombok.Data;

@Data
public class Transaction {

    private PaymentState state;

    public Transaction() {
        state = new CreatedState(this);
    }

    public void create() {
        state.create(this);
    }

    public void process() {
        state.process(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void complete() {
        state.complete(this);
    }

    public void fail() {
        state.fail(this);
    }

    public String getStatus() {
        return state.getStatus();
    }
}