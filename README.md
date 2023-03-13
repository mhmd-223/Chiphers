# **Ciphers**

This package contains three classes that implement different types of substitution ciphers:

- **`SubstitutionCipher`**: A basic substitution cipher that uses a user-defined key.
- **`RandomCipher`**: A substitution cipher that generates a random key.
- **`CesarCipher`**: A substitution cipher that uses a fixed key based on a rotation amount.

## **SubstitutionCipher**

This class implements a basic substitution cipher that uses a user-defined key. The key is a string of 26 uppercase letters, each representing a substitution for the corresponding letter in the alphabet.

### **Constructor**

```java
public SubstitutionCipher(String encoder)
```

Constructs a SubstitutionCipher object with the given encoder string.

- **`encoder`**: the encoder string containing the 26 uppercase letters to be used as the cipher key for encryption and decryption.

### **Public Methods**

```java
public String encode(String plaintext)
```

Encodes a given text using the encoder cipher key.

- **`plaintext`**: the text to be encoded.

```java
public String decode(String ciphertext)
```

Decodes a given text using the decoder cipher key.

- **`ciphertext`**: the text to be decoded.

## **RandomCipher**

This class implements a substitution cipher that generates a random key. The key is a string of 26 uppercase letters, each representing a substitution for the corresponding letter in the alphabet.

### **Constructor**

```java
public RandomCipher()
```

Constructs a RandomCipher object with a randomly generated key.

### **Inherited Public Methods**

This class inherits the **`encode`** and **`decode`** methods from **`SubstitutionCipher`**.

## **CesarCipher**

This class implements a substitution cipher that uses a fixed key based on a rotation amount. The key is a string of 26 uppercase letters, each representing a substitution for the corresponding letter in the alphabet.

### **Constructor**

```java
public CesarCipher(int rotationAmount)
```

Constructs a CesarCipher object with a fixed key based on the rotation amount.

- **`rotationAmount`**: the number of letters to rotate the alphabet.

### **Inherited Public Methods**

This class inherits the **`encode`** and **`decode`** methods from **`SubstitutionCipher`**.
