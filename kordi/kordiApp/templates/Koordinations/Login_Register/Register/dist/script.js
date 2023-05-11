const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const bcrypt = require('bcrypt');
const saltRounds = 10;

const app = express();
const port = 3000;

// Create a MySQL connection
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'myapp'
});

// Connect to MySQL
connection.connect();

// Use body-parser middleware to parse JSON requests
app.use(bodyParser.json());

// Route for registering a new user
app.post('/register', (req, res) => {
  // Hash the password using bcrypt
  bcrypt.hash(req.body.password, saltRounds, (err, hash) => {
    // Insert the user into the database
    connection.query('INSERT INTO users (username, email, password) VALUES (?, ?, ?)', [req.body.username, req.body.email, hash], (error, results, fields) => {
      if (error) throw error;
      res.json({ message: 'User registered successfully!' });
      window.location.href = "./../Login/dist/index.html";
    });
  });
});

// Start the server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
