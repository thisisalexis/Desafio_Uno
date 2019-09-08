package cl.previred.recruiting.periods.util;

public interface ObjectParser<S, R> {
    R parse(S source);
}
