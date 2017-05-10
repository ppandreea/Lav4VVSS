package main.java.repository;


public interface Validator<E> {
	
	void validate(E entity) throws ValidationException;

}
