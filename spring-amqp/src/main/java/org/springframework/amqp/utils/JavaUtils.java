/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.amqp.utils;

import java.util.function.Consumer;

/**
 * Chained utility methods to simplify some Java repetitive code. Obtain a reference to
 * the singleton {@link #INSTANCE} and then chain calls to the utility methods.
 *
 * @author Gary Russell
 * @since 2.1.4
 *
 */
public final class JavaUtils {

	/**
	 * The singleton instance of this utility class.
	 */
	public static final JavaUtils INSTANCE = new JavaUtils();

	private JavaUtils() {
		super();
	}

	/**
	 * Invoke {@link Consumer#accept(Object)} with the value if the condition is true.
	 * @param condition the condition.
	 * @param value the value.
	 * @param consumer the consumer.
	 * @param <T> the value type.
	 * @return this.
	 */
	public <T> JavaUtils acceptIfCondition(boolean condition, T value, Consumer<T> consumer) {
		if (condition) {
			consumer.accept(value);
		}
		return this;
	}

	/**
	 * Invoke {@link Consumer#accept(Object)} with the value if it is not null.
	 * @param value the value.
	 * @param consumer the consumer.
	 * @param <T> the value type.
	 * @return this.
	 */
	public <T> JavaUtils acceptIfNotNull(T value, Consumer<T> consumer) {
		if (value != null) {
			consumer.accept(value);
		}
		return this;
	}

}
