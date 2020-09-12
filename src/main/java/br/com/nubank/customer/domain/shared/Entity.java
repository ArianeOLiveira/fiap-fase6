package br.com.nubank.customer.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
