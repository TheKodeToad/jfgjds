package io.toadlabs.jfgjds.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.toadlabs.jfgjds.exception.JsonElementCastException;

public final class JsonArray extends JsonValue implements Iterable<JsonValue> {

	private final List<JsonValue> list;

	public static final Function<String, JsonValue> DEFAULT_COMPUTION = (ignored) -> new JsonArray();

	/**
	 * A helper method to create an array similar to how you would in other
	 * languages. Values will be converted automatically.
	 *
	 * @param values The array.
	 * @return The object.
	 */
	public static @NotNull JsonArray of(@NotNull Object... values) {
		return ofCoerced(Arrays.asList(values));
	}

	public static @NotNull JsonArray ofCoerced(@NotNull List<Object> values) {
		return new JsonArray(values.stream().map(JsonValue::coerce).collect(Collectors.toList()));
	}

	public JsonArray() {
		this(null);
	}

	public JsonArray(@Nullable List<@NotNull JsonValue> list) {
		if (list == null) {
			this.list = new ArrayList<>();
		} else {
			this.list = new ArrayList<>(list);
		}
	}

	@Override
	public @NotNull Iterator<JsonValue> iterator() {
		return list.iterator();
	}

	/**
	 * Gets the value at the specified index, otherwise throws.
	 *
	 * @param index The index.
	 * @return The value.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonValue get(int index) throws IndexOutOfBoundsException {
		return list.get(index);
	}

	/**
	 * Adds a value to the end of the array.
	 *
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(@NotNull JsonValue value) {
		list.add(value);
		return this;
	}

	/**
	 * Adds a string to the end of the array.
	 *
	 * @param string The string.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(@NotNull String string) {
		return add(new JsonString(string));
	}

	/**
	 * Adds a number to the end of the array.
	 *
	 * @param number The number.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(double number) {
		return add(new JsonNumber(number));
	}

	/**
	 * Adds a boolean to the end of the array.
	 *
	 * @param bool The boolean.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(boolean bool) {
		return add(bool ? JsonBoolean.TRUE : JsonBoolean.FALSE);
	}

	/**
	 * Adds JSON null to the end of the array.
	 *
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray addNull() {
		return add(JsonNull.INSTANCE);
	}

	/**
	 * Inserts a value in the array.
	 *
	 * @param index The index.
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(int index, @NotNull JsonValue value) {
		list.add(index, value);
		return this;
	}

	/**
	 * Inserts a string in the array.
	 *
	 * @param index  The index.
	 * @param string The string.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(int index, @NotNull String string) {
		return add(index, new JsonString(string));
	}

	/**
	 * Inserts a number in the array.
	 *
	 * @param index  The index.
	 * @param number The array.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(int index, double number) {
		return add(index, new JsonNumber(number));
	}

	/**
	 * Inserts a boolean in the array.
	 *
	 * @param index The index.
	 * @param bool  The boolean.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray add(int index, boolean bool) {
		return add(index, bool ? JsonBoolean.TRUE : JsonBoolean.FALSE);
	}

	/**
	 * Inserts JSON null in the array.
	 *
	 * @param index The index.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray addNull(int index) {
		return add(index, JsonNull.INSTANCE);
	}

	/**
	 * Merges the array with another.
	 *
	 * @param array The array.
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray addAll(@NotNull JsonArray array) {
		list.addAll(Objects.requireNonNull(array).list);
		return this;
	}

	/**
	 * Removes a value by its index.
	 *
	 * @param index The index.
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray remove(int index) throws IndexOutOfBoundsException {
		list.remove(index);
		return this;
	}

	/**
	 * Removes a value from the array.
	 *
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray remove(@NotNull JsonValue value) throws IndexOutOfBoundsException {
		list.remove(value);
		return this;
	}

	/**
	 * Removes a value from the array.
	 *
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray remove(@NotNull String value) throws IndexOutOfBoundsException {
		return remove(new JsonString(value));
	}

	/**
	 * Removes a value from the array.
	 *
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray remove(@NotNull double value) throws IndexOutOfBoundsException {
		return remove(new JsonNumber(value));
	}

	/**
	 * Removes a value from the array.
	 *
	 * @param value The value.
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray remove(@NotNull boolean value) throws IndexOutOfBoundsException {
		return remove(value ? JsonBoolean.TRUE : JsonBoolean.FALSE);
	}

	/**
	 * Removes the first null in the array.
	 *
	 * @return <code>this</code>, for chaining.
	 * @throws IndexOutOfBoundsException If the index is out of range.
	 */
	public @NotNull JsonArray removeNull() throws IndexOutOfBoundsException {
		return remove(JsonNull.INSTANCE);
	}

	/**
	 * Gets the size of the array.
	 *
	 * @return The size.
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Gets whether the array is empty.
	 *
	 * @return <code>true</code> if the size is <code>0</code>.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Clears the array.
	 *
	 * @return <code>this</code>, for chaining.
	 */
	public @NotNull JsonArray clear() {
		list.clear();
		return this;
	}

	public List<JsonValue> getList() {
		return list;
	}

	@Override
	protected String getPrimaryInterface() {
		return "JsonArray";
	}

	public JsonValue[] toArray() {
		return list.toArray(new JsonArray[0]);
	}

	public Stream<JsonValue> stream() {
		return list.stream();
	}

	public Stream<JsonValue> parellelStream() {
		return list.parallelStream();
	}

	@Override
	public boolean isArray() {
		return true;
	}

	@Override
	public @NotNull JsonArray asArray() throws JsonElementCastException {
		return this;
	}

	@Override
	public int hashCode() {
		return list.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JsonArray)) {
			return false;
		}

		JsonArray other = (JsonArray) obj;
		return list.equals(other.list);
	}

}
