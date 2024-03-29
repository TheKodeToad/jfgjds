package io.toadlabs.jfgjds;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import io.toadlabs.jfgjds.data.JsonArray;
import io.toadlabs.jfgjds.data.JsonBoolean;
import io.toadlabs.jfgjds.data.JsonNull;
import io.toadlabs.jfgjds.data.JsonNumber;
import io.toadlabs.jfgjds.data.JsonObject;
import io.toadlabs.jfgjds.data.JsonString;
import io.toadlabs.jfgjds.data.JsonValue;
import io.toadlabs.jfgjds.exception.JsonParseException;

final class Parser {

	Reader in;
	int pos;
	int length;
	char[] buffer;

	Parser setup(Reader in) throws IOException {
		this.in = in;
		buffer = null;
		pos = length = 0;
		read();
		return this;
	}

	int character() {
		if (length == -1) {
			return -1;
		}

		return buffer[pos];
	}

	int read() throws IOException {
		if (length == -1) {
			return -1;
		}

		if (buffer == null || pos++ == length - 1) {
			pos = 0;
			buffer = new char[8192];
			length = in.read(buffer);
		}

		return character();
	}

	void assertCharacter(char character) throws JsonParseException {
		if (character() != character) {
			throw new JsonParseException("Expected '" + character + "' but got "
					+ (character() != -1 ? ("'" + (char) character() + "'") : "EOF"));
		}
	}

	void assertNoEOF(String expected) throws JsonParseException {
		if (character() == -1) {
			throw new JsonParseException("Expected " + expected + " but got EOF");
		}
	}

	void skipWhitespace() throws IOException {
		while (isWhitespace()) {
			read();
		}
	}

	boolean isWhitespace() {
		return character() == ' ' || character() == '\n' || character() == '\r' || character() == '\t';
	}

	JsonValue readSingleValue() throws IOException {
		skipWhitespace();
		JsonValue result = readValue();
		if (!(result instanceof JsonNumber)) {
			read();
		}
		skipWhitespace();
		if (character() != -1) {
			throw new JsonParseException("Found trailing non-whitespace characters");
		}
		return result;
	}

	JsonValue readValue() throws IOException {
		assertNoEOF("a value");

		int character = character();

		switch (character) {
		case '{':
			return readObject();
		case '[':
			return readArray();
		case '"':
			return readString();
		case 't':
		case 'f':
			// probably boolean
			JsonBoolean bool = readBoolean();
			if (bool != null) {
				return bool;
			}
			break;
		case 'n':
			// probably null
			if (readNull()) {
				return JsonNull.INSTANCE;
			}
			break;
		}

		if (character == '-' || isDigit()) {
			// probably a number
			return readNumber();
		}

		throw new JsonParseException("Expected a JSON value but got '" + (char) character + "'");
	}

	JsonObject readObject() throws IOException {
		assertCharacter('{');
		JsonObject obj = new JsonObject(new HashMap<>());
		boolean comma = false;

		read();
		skipWhitespace();

		while (character() != '}') {
			if (comma) {
				assertCharacter(',');
				read();
				skipWhitespace();
			}

			String key = readJString();
			read();
			skipWhitespace();
			assertCharacter(':');
			read();
			skipWhitespace();

			JsonValue value = readValue();
			obj.put(key, value);

			if (!(value instanceof JsonNumber)) {
				read();
			}

			skipWhitespace();
			comma = true;
		}

		return obj;
	}

	JsonArray readArray() throws IOException {
		assertCharacter('[');
		JsonArray array = new JsonArray();
		boolean comma = false;

		read();
		skipWhitespace();

		while (character() != ']') {
			if (comma) {
				assertCharacter(',');
				read();
				skipWhitespace();
			}

			JsonValue value = readValue();
			array.add(value);

			if (!(value instanceof JsonNumber)) {
				read();
			}

			skipWhitespace();
			comma = true;
		}

		return array;
	}

	JsonString readString() throws IOException {
		return new JsonString(readJString());
	}

	String readJString() throws IOException {
		assertCharacter('"');

		StringBuilder result = new StringBuilder();

		while (read() != '"') {
			int character = character();

			if (character >= '\u0000' && character <= '\u001F') {
				throw new JsonParseException("Found unescaped control character within string");
			}

			switch (character) {
			case -1:
				throw new JsonParseException("Expected '\"' but got EOF");
			case 0x7F:
				if (read() == '"') {
					return result.toString();
				}
				continue;
			case '\\':
				int seq = read();

				switch (seq) {
				case -1:
					throw new JsonParseException("Expected an escape sequence but got EOF");
				case '\\':
					break;
				case '/':
				case '\"':
					character = seq;
					break;
				case 'b':
					character = '\b';
					break;
				case 'f':
					character = '\f';
					break;
				case 'n':
					character = '\n';
					break;
				case 'r':
					character = '\r';
					break;
				case 't':
					character = '\t';
					break;
				case 'u':
					// char array to allow allocation in advance.
					char[] digits = new char[4];

					for (int index = 0; index < digits.length; index++) {
						character = read();
						if (index == 0 && character() == '-') {
							throw new JsonParseException("Hex sequence may not be negative");
						} else if (character() == -1) {
							throw new JsonParseException("Expected a hex sequence but got EOF");
						}
						digits[index] = (char) character;
					}

					String digitsString = new String(digits);

					try {
						character = Integer.parseInt(digitsString, 16);
					} catch (NumberFormatException error) {
						throw new JsonParseException("Could not parse hex sequence \"" + digitsString + "\"");
					}

					break;
				default:
					throw new JsonParseException("Invalid escape sequence: \\" + (char) seq);
				}
				break;
			}

			result.append((char) character);
		}

		return result.toString();
	}

	boolean isDigit() {
		return character() >= '0' && character() <= '9';
	}

	JsonNumber readNumber() throws IOException {
		StringBuilder result = new StringBuilder();

		if (character() == '-') {
			result.append((char) character());
			read();
		}

		if (character() == '0') {
			result.append((char) character());
			read();
			if (isDigit()) {
				throw new JsonParseException("Found superfluous leading zero");
			}
		} else if (!isDigit()) {
			throw new JsonParseException("Expected digits");
		}

		while (character() != -1 && isDigit()) {
			result.append((char) character());
			read();
		}

		if (character() == '.') {
			result.append('.');

			read();
			assertNoEOF("digits");

			if (!isDigit()) {
				throw new JsonParseException("Expected digits after decimal point");
			}

			while (character() != -1 && isDigit()) {
				result.append((char) character());
				read();
			}
		}

		if (character() == 'e' || character() == 'E') {
			result.append('E');

			read();
			assertNoEOF("digits");

			if (character() == '+' || character() == '-') {
				result.append((char) character());
				read();
			}

			if (!(character() == '+' || character() == '-' || isDigit())) {
				throw new JsonParseException("Expected exponent digits");
			}

			while (character() != -1 && isDigit()) {
				result.append((char) character());
				read();
			}
		}

		String resultStr = result.toString();

		try {
			return new JsonNumber(Double.parseDouble(resultStr));
		} catch (NumberFormatException error) {
			throw new JsonParseException("Failed to parse number '" + resultStr + "'");
		}
	}

	JsonBoolean readBoolean() throws IOException {
		if (character() == 't') {
			if (read() == 'r' && read() == 'u' && read() == 'e') {
				return JsonBoolean.TRUE;
			}
		} else if (character() == 'f') {
			if (read() == 'a' && read() == 'l' && read() == 's' && read() == 'e') {
				return JsonBoolean.FALSE;
			}
		}
		return null;
	}

	boolean readNull() throws IOException {
		return character() == 'n' && read() == 'u' && read() == 'l' && read() == 'l';
	}

}
