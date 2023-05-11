// Easy way to wait for all videos to load before start playing

var promises = [];
function makePromise(i, video) {
  promises[i] = new $.Deferred();
  // This event tells us video can be played all the way through, without stopping or buffering
  video.oncanplaythrough = function() {
    // Resolve the promise
    promises[i].resolve();
  }
}
// Pause all videos and create the promise array
$('video').each(function(index){
  this.pause();
  makePromise(index, this);
})

// Wait for all promises to resolve then start playing
$.when.apply(null, promises).done(function () {
  $('video').each(function(){
    this.play();
  });
});



const express = require('express');
const bodyParser = require('body-parser');
const app = express();

// Serve static files from the "public" directory
app.use(express.static('public'));

// Use body-parser middleware to parse request bodies
app.use(bodyParser.urlencoded({ extended: false }));

// Handle POST request to /login endpoint
app.post('/login', (req, res) => {
  const username = req.body.username;
  const password = req.body.password;

  // Check if username and password are valid
  if (username === 'admin' && password === 'admin') {
    res.send('Login successful');
  } else {
    res.status(401).send('Invalid username or password');
  }
});

// Start server
app.listen(3000, () => {
  console.log('Server started on port 3000');
});
