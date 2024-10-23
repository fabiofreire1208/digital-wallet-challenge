package digital.wallet.challenge.core.command;

public interface Command<R> {
    R process(final Context context);
}
