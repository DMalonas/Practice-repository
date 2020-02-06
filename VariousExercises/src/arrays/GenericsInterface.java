package arrays;

import java.util.List;

interface GenericsInterface<E> {
	public <T> List<T> createAllRules(String testFile);

    // Hey, type variables can have bounds too!
}
