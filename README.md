# 🔐 Password Generator

A Java command-line application that generates strong, random passwords with customizable options for length and character types.

---

## 🚀 Features

- Generate cryptographically strong random passwords using `SecureRandom`
- Customize password **length**
- Choose character types:
  - ✅ Uppercase letters (A–Z)
  - ✅ Lowercase letters (a–z)
  - ✅ Digits (0–9)
  - ✅ Special symbols (!@#$%^&*...)
- Guarantees at least one character from each selected type
- Built-in **password strength indicator** (Weak / Medium / Strong)

---

## 🛠️ Technologies Used

- **Language:** Java
- **Core Concepts:** String manipulation, `SecureRandom`, Collections, CLI I/O

---

## 📁 Project Structure

```
PasswordGenerator/
├── src/
│   └── PasswordGenerator.java
└── README.md
```

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Verify with: `java -version`

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/your-username/password-generator.git
cd password-generator
```

**2. Compile**
```bash
javac src/PasswordGenerator.java
```

**3. Run**
```bash
java -cp src PasswordGenerator
```

---

## 💻 Sample Output

```
============================================
         STRONG PASSWORD GENERATOR         
============================================
Enter desired password length (e.g. 16): 16
Include UPPERCASE letters? (y/n): y
Include LOWERCASE letters? (y/n): y
Include DIGITS (0-9)?       (y/n): y
Include SYMBOLS (!@#...)?   (y/n): y

--------------------------------------------
Generated Password: kR#7mZ!vL2@xQp9&
--------------------------------------------
Password Strength : Strong ✔✔✔
```

---

## 🔒 Password Strength Criteria 

| Strength | Criteria |
|----------|----------|
| ⚠ Weak   | Short length, few character types |
| ★★ Medium | Moderate length, some variety |
| ✔✔✔ Strong | 16+ characters, all types enabled |

---

## 📌 Notes

- At least **one character type** must be selected
- Password length must be **greater than or equal to** the number of selected character types
- Uses `SecureRandom` for cryptographic-grade randomness

---

## 👨‍💻 Author

**Kritika Agrawal**  
[GitHub](https://github.com/kritika660) 
